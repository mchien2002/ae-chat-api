package com.ae_chat.aechatapi.util;

import java.util.Random;

public class FormatString {
    static public String customPhoneVNRegion(String phone) {
        String phoneRegister = phone;
        if (phone == null) {
            return null;
        }
        if (phone.charAt(0) == '0') {
            phoneRegister = phone.replaceFirst("0", "+84");
        }
        return phoneRegister;
    }

    static public String getRandomNumberOtp() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }

}
