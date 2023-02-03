package com.ae_chat.aechatapi.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ae_chat.aechatapi.helper.Response;
import com.ae_chat.aechatapi.model.User;
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

    @RequestMapping(value = RouteConstant.REGISTER_MOBILE, method = RequestMethod.POST)
    public ResponseEntity<Object> sendOTP(@RequestParam("phone") String phone) {
        try {
            registerService.genrateOTPAndSendOnMobile(phone);
            return ResponseEntity.status(HttpStatus.OK).body(new Response(true, "Mã OTP đang được gửi", null, null));
        } catch (Exception e) {
            log.error(e.toString(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response(false, "Mã OTP chưa được gửi", e.toString(), null));
        }
    }

    @RequestMapping(value = RouteConstant.VERIFY_OTP_MOBILE, method = RequestMethod.POST)
    public ResponseEntity<Object> verifyOTPLogin(@RequestParam("phone") String phone, @RequestParam("otp") String otp) {
        try {
            if (registerService.verifyOTP(phone, otp) == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                        new Response(false, "Xác thực tài khoản không thành công", null,
                                registerService.verifyOTP(phone, otp)));
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(true, "Xác thực tài khoản thành công", null, registerService.verifyOTP(phone, otp)));
        } catch (Exception e) {
            log.error(e.toString(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response(false, e.toString(), e, null));
        }
    }

    @RequestMapping(value = RouteConstant.REGISTER_EMAIL, method = RequestMethod.POST)
    public ResponseEntity<Object> sendOTPOnMail(@RequestParam("email") String email) {
        try {
            registerService.genrateOTPAndSendOnEmail(email);
            return ResponseEntity.status(HttpStatus.OK).body(new Response(true, "Đã gửi mail xác nhận", null, null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(false, "Có lỗi", e, null));
        }
    }

    @RequestMapping(value = RouteConstant.VERIFY_OTP_EMAIL, method = RequestMethod.POST)
    public ResponseEntity<Object> verifyOTPLoginOnMail(@RequestParam("email") String email,
            @RequestParam("otp") String otp) {
        try {
            User user = registerService.verifyOTPMail(email, otp);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                        new Response(false, "Xác thực tài khoản không thành công", null,
                                null));
            }
            user.setToken(jwtService.generateToken(user));
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(true, "Xác thực tài khoản thành công", null, user));
        } catch (Exception e) {
            log.error(e.toString(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response(false, e.toString(), e, null));
        }
    }
}
