package com.ae_chat.aechatapi.service.user;

import java.util.List;

import com.ae_chat.aechatapi.entity.User;

public interface UserService {
    List<User> searchUser(String value);
    User findUserByID(String id);
    void updateProfile(User newUser);
}
