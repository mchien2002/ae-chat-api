package com.ae_chat.aechatapi.controller.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.ae_chat.aechatapi.helper.IncredibleResponse;
import com.ae_chat.aechatapi.model.Group;
import com.ae_chat.aechatapi.route.RouteConstant;
import com.ae_chat.aechatapi.service.group.GroupService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class GroupController {
    @Autowired
    private GroupService groupService;

    @RequestMapping(value = RouteConstant.CREATE_GROUP, method = RequestMethod.POST)
    public ResponseEntity<?> createGroup(@RequestBody Group group) {

        try {
            groupService.createGroup(group);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new IncredibleResponse(true, "Tạo group thành công", null, group));
        } catch (Exception e) {
            log.error(e.toString(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new IncredibleResponse(false, e.toString(), e, group));
        }
    }

}
