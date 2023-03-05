package com.ae_chat.aechatapi.service.register;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ae_chat.aechatapi.entity.User;
import com.ae_chat.aechatapi.entity.UserOnlineStatus;
import com.ae_chat.aechatapi.entity.enum_model.UserStatus;
import com.ae_chat.aechatapi.repositories.UserOnlineStatusRepository;
import com.ae_chat.aechatapi.repositories.UserRepository;
import com.ae_chat.aechatapi.util.FormatString;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RegisterServiceIml implements RegisterService {
    @Autowired
    private UserRepository userReponsitory;
    @Autowired
    private UserOnlineStatusRepository userOnlineStatusRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    static final String Account_Sid = "ACdfb0d069b551c3bb92541b4d7536ea92";
    static final String Auth_Token = "c471fc354bd3883fa337dc51e0603468";
    static final String Trial_Phone = "+18126132180";
    static final String From_Mail = "minhchien77777@gmail.com";

    @Override
    public Boolean genrateOTPAndSendOnMobile(String phone) {
        Twilio.init(Account_Sid, Auth_Token);
        int otp = (int) (Math.random() * 9000) + 1000;
        User newUser = new User();
        newUser.setPhone(phone);
        newUser.setOtp(Integer.toString(otp));
        Message message = Message
                .creator(new PhoneNumber(newUser.getPhone()), new PhoneNumber(Trial_Phone),
                        "Mã OTP của bạn là: " + otp + ".Xin hãy xác thực")
                .create();
        if (message.getErrorCode() == null) {
            save(newUser);
            return true;
        } else
            return false;
    }

    @Override
    public User verifyOTP(String phone, String otp) {
        User user = userReponsitory.findByPhone(FormatString.customPhoneVNRegion(phone));
        if (user.getOtp().equals(otp)) {
            return user;
        }
        return null;
    }

    @Override
    public void genrateOTPAndSendOnEmail(String email) {
        if (FormatString.getAccountTest(email)) {
            User newUser = new User().setFirstRegisterByMail(email, "000000");
            saveByEmail(newUser);
            return;
        }
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        try {
            String otp = FormatString.getRandomNumberOtp();
            simpleMailMessage.setFrom(From_Mail);
            simpleMailMessage.setTo(email);
            simpleMailMessage.setSubject("AppChat - Verify your email");
            simpleMailMessage.setText("Mã OTP của bạn là: " + otp + ". Xin hãy xác minh");
            javaMailSender.send(simpleMailMessage);
            User newUser = new User().setFirstRegisterByMail(email, otp);
            saveByEmail(newUser);
        } catch (MailException e) {
            throw e;
        }
    }

    @Override
    public User verifyOTPMail(String email, String otp) {
        User user = userReponsitory.findByEmail(email);
        if (user.getOtp().equals(otp)) {
            userReponsitory.updateOTPByMail(null, email);
            return user;
        }
        return null;
    }

    public void save(User user) {
        try {
            userReponsitory.updateOTP(user.getOtp().toString(), user.getPhone());
        } catch (Exception e) {
            userReponsitory.save(user);
        }
    }

    public void saveByEmail(User user) {
        try {
            userReponsitory.saveAndFlush(user);
            UserOnlineStatus newUserStatus = new UserOnlineStatus();
            newUserStatus.setUserId(user.getUserId());
            newUserStatus.setStatus(UserStatus.OFFLINE.ordinal());
            newUserStatus.setLastTimeOnline(new Date());
            userOnlineStatusRepository.save(newUserStatus);
        } catch (Exception e) {
            log.error(e.toString());
            userReponsitory.updateOTPByMail(user.getOtp().toString(), user.getEmail());
        }
    }
}
