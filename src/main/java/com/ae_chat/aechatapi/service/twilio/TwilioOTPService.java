package com.ae_chat.aechatapi.service.twilio;

import org.springframework.stereotype.Component;
import com.ae_chat.aechatapi.model.SmsPojo;

@Component
public interface TwilioOTPService {
    void sendOTPMobilePhone(SmsPojo sms);
}
