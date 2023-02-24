package com.ae_chat.aechatapi.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ae_chat.aechatapi.entity.User;
import com.ae_chat.aechatapi.repositories.UserRepository;

@Service
public class UserServiceIml implements UserService {

    @Autowired
    private UserRepository userReponsitory;

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

    public UserRepository getUserReponsitory() {
        return userReponsitory;
    }

    public void setUserReponsitory(UserRepository userReponsitory) {
        this.userReponsitory = userReponsitory;
    }

    @Override
    public User findUserByID(String id) {
        User user = userReponsitory.findUserById(id);
        return user;
    }

}
