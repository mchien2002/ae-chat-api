package com.ae_chat.aechatapi.service.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ae_chat.aechatapi.model.User;
import com.ae_chat.aechatapi.repositories.UserReponsitory;

@Service
public class UserServiceIml implements UserService {

    @Autowired
    private UserReponsitory userReponsitory;

    @Override
    public User findUserByPhone(String phone) {
        return null;
    }

    @Override
    public void updateStateUser(int state) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateOtpUser(String otp) {
        // TODO Auto-generated method stub

    }

    @Override
    public void registerNewUser(User user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateUserProfile(User user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteUserByPhone(String phone) {
        // TODO Auto-generated method stub

    }

}
