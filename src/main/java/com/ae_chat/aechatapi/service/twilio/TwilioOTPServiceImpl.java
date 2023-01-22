package com.ae_chat.aechatapi.service.twilio;

import com.ae_chat.aechatapi.model.SmsPojo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioOTPServiceImpl implements TwilioOTPService {
    private final String ACCOUNT_SID = "ACdfb0d069b551c3bb92541b4d7536ea92";
    private final String AUTH_TOKEN = "a1d2ed5246b37c8225d1496b51e492c1";
    private final String TRIAL_NUMBER = "+18126132180";

    @Override
    public void sendOTPMobilePhone(SmsPojo sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        int min = 100000;
        int max = 999999;

        int number = (int) (Math.random() * (max - min + 1) + min);
        String msg = "AE-CHAT Your OTP is - " + number;
        Message message = Message.creator(new PhoneNumber(sms.get_phoneNumber()), new PhoneNumber(TRIAL_NUMBER), msg).create();

    }

}
