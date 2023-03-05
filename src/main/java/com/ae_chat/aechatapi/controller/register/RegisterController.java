package com.ae_chat.aechatapi.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ae_chat.aechatapi.entity.User;
import com.ae_chat.aechatapi.helper.IncredibleResponse;
import com.ae_chat.aechatapi.route.RouteConstant;
import com.ae_chat.aechatapi.service.register.JwtService;
import com.ae_chat.aechatapi.service.register.RegisterService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private JwtService jwtService;

    @PostMapping(RouteConstant.REGISTER_MOBILE)
    public ResponseEntity<Object> sendOTP(@RequestParam("phone") String phone) {
        try {
            registerService.genrateOTPAndSendOnMobile(phone);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new IncredibleResponse(true, "Mã OTP đang được gửi", null, null));
        } catch (Exception e) {
            log.error(e.toString(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new IncredibleResponse(false, "Mã OTP chưa được gửi", e.toString(), null));
        }
    }

    @PostMapping(RouteConstant.VERIFY_OTP_MOBILE)
    public ResponseEntity<Object> verifyOTPLogin(@RequestParam("phone") String phone, @RequestParam("otp") String otp) {
        try {
            if (registerService.verifyOTP(phone, otp) == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                        new IncredibleResponse(false, "Xác thực tài khoản không thành công", null,
                                registerService.verifyOTP(phone, otp)));
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new IncredibleResponse(true, "Xác thực tài khoản thành công", null,
                            registerService.verifyOTP(phone, otp)));
        } catch (Exception e) {
            log.error(e.toString(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new IncredibleResponse(false, e.toString(), e, null));
        }
    }

    @PostMapping(RouteConstant.REGISTER_EMAIL)
    public ResponseEntity<Object> sendOTPOnMail(@RequestParam("email") String email) {
        try {
            registerService.genrateOTPAndSendOnEmail(email);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new IncredibleResponse(true, "Đã gửi mail xác nhận", null, null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new IncredibleResponse(false, e.toString(), e, null));
        }
    }

    @PostMapping(RouteConstant.VERIFY_OTP_EMAIL)
    public ResponseEntity<Object> verifyOTPLoginOnMail(@RequestParam("email") String email,
            @RequestParam("otp") String otp) {
        try {
            User user = registerService.verifyOTPMail(email, otp);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                        new IncredibleResponse(false, "Bạn đã nhập sai OTP", null,
                                user));
            }
            user.setToken(jwtService.generateToken(user));
            return ResponseEntity.status(HttpStatus.OK).body(
                    new IncredibleResponse(true, "Xác thực tài khoản thành công", null, user));
        } catch (Exception e) {
            log.error(e.toString(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new IncredibleResponse(false, e.toString(), e, null));
        }
    }
}
