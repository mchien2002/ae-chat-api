package com.ae_chat.aechatapi.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.ae_chat.aechatapi.helper.IncredibleResponse;
import com.ae_chat.aechatapi.route.RouteConstant;
import com.ae_chat.aechatapi.service.user.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = RouteConstant.USER_PROFILE, method = RequestMethod.GET)
    public ResponseEntity<?> getUserProfile(@RequestParam("id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new IncredibleResponse(true, null, null, userService.findUserByID(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new IncredibleResponse(false, e.toString(), e, null));
        }
    }

}
