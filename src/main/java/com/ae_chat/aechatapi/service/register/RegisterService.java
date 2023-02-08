package com.ae_chat.aechatapi.service.register;

import com.ae_chat.aechatapi.entity.User;

public interface RegisterService {
    Boolean genrateOTPAndSendOnMobile(String phone);
    User verifyOTP(String phone, String otp);
    void genrateOTPAndSendOnEmail(String email);
    User verifyOTPMail(String email, String otp);
}
