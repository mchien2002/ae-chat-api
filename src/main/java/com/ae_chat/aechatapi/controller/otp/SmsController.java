package com.ae_chat.aechatapi.controller.otp;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ae_chat.aechatapi.model.SmsPojo;
import com.ae_chat.aechatapi.route.RouteConstant;

@RestController
public class SmsController {
    @PostMapping(RouteConstant.MOBILE_NUMBER)
    public String sendOtp(@RequestBody SmsPojo sPojo){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Successfully OTP send your Mobile Number";
    }
}
