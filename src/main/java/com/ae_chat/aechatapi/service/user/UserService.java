package com.ae_chat.aechatapi.service.user;

import com.ae_chat.aechatapi.model.User;

public interface UserService {
    User findUserByPhone(String phone);
    void updateStateUser(int state);
    void updateOtpUser(String otp);
    void registerNewUser(User user);
    void updateUserProfile(User user);
    void deleteUserByPhone(String phone);
    User findUserByID(Long id);
}
