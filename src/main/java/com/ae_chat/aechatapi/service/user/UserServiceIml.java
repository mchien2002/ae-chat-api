package com.ae_chat.aechatapi.service.user;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ae_chat.aechatapi.entity.User;
import com.ae_chat.aechatapi.repositories.UserRepository;
import com.ae_chat.aechatapi.util.FormatString;

@Service
public class UserServiceIml implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> searchUser(String value) {
        return userRepository.findUserByKey(FormatString.filterSQLMiddle(value));
    }

    @Override
    public User findUserByID(String id) {
       return userRepository.findById(id).get();
    }

}
