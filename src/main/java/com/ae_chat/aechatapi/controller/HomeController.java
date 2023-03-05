package com.ae_chat.aechatapi.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ae_chat.aechatapi.entity.enum_model.Locale;
import com.ae_chat.aechatapi.res.Strings;

@RestController
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() throws IOException {
        return new Strings(Locale.VI).trans("welcome.title");
    }
}
