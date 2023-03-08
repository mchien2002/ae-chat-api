package com.ae_chat.aechatapi.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ae_chat.aechatapi.entity.User;
import com.ae_chat.aechatapi.helper.MyResponse;
import com.ae_chat.aechatapi.route.RouteConstant;
import com.ae_chat.aechatapi.service.user.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(RouteConstant.USER_PROFILE)
    public ResponseEntity<?> getUserProfile(@RequestParam("id") String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new MyResponse(true, null, null, userService.findUserByID(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyResponse(false, e.toString(), e, null));
        }
    }

    @RequestMapping(value = RouteConstant.SEARCH_USER, method = RequestMethod.GET)
    public ResponseEntity<?> searchUser(@RequestParam("searchValue") String value) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new MyResponse(true, null, null, userService.searchUser(value)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyResponse(false, e.toString(), e, null));
        }
    }

    @RequestMapping(value = RouteConstant.UPDATE_PROFILE_USER, method = RequestMethod.POST)
    public ResponseEntity<?> updateProfileUser(@RequestBody User user) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new MyResponse(true, "Sửa thông tin người dùng thành công", null, null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyResponse(false, e.toString(), e, null));
        }
    }

}
