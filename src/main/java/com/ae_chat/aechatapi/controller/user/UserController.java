package com.ae_chat.aechatapi.controller.user;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ae_chat.aechatapi.helper.IncredibleResponse;
import com.ae_chat.aechatapi.route.RouteConstant;
import com.ae_chat.aechatapi.service.user.UserService;
import com.ae_chat.aechatapi.storage.UserStorage;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = RouteConstant.USER_PROFILE, method = RequestMethod.GET)
    public ResponseEntity<?> getUserProfile(@RequestParam("id") String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new IncredibleResponse(true, null, null, userService.findUserByID(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new IncredibleResponse(false, e.toString(), e, null));
        }
    }

    // TEST WEB SOCKET

    @GetMapping("/registration/{userName}")
    public ResponseEntity<Void> register(@PathVariable String userName) {
        System.out.println("handling register user request: " + userName);
        try {
            UserStorage.getInstance().setUser(userName);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetchAllUsers")
    public Set<String> fetchAll() {
        return UserStorage.getInstance().getUsers();
    }

}
