package com.ae_chat.aechatapi.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ae_chat.aechatapi.service.register.UserService;

@Controller
public class UserController {
    @Autowired 
    private UserService userService;
}
