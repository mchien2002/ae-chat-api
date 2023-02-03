package com.ae_chat.aechatapi.util;

public class FormatString {
    static public String customPhoneVNRegion(String phone) {
        String phoneRegister = phone;
        if (phone.charAt(0) == '0') {
            phoneRegister = phone.replaceFirst("0", "+84");
        }
        return phoneRegister;
    }


}
