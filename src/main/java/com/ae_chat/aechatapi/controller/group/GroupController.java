package com.ae_chat.aechatapi.controller.group;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ae_chat.aechatapi.entity.GroupConversation;
import com.ae_chat.aechatapi.entity.Message;
import com.ae_chat.aechatapi.helper.IncredibleResponse;
import com.ae_chat.aechatapi.route.RouteConstant;
import com.ae_chat.aechatapi.service.group.GroupService;
import com.ae_chat.aechatapi.service.message.MessageService;
import com.ae_chat.aechatapi.websocket.SocketRequestType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private MessageService messageService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping(value = RouteConstant.CREATE_GROUP)
    public ResponseEntity<?> createGroup(@RequestBody GroupConversation group,
            @RequestParam("senderUin") Long senderUin) {
        try {
            Message firstMessage = new Message().createFirstMessage(senderUin, group.getGroupType());
            messageService.saveMessage(firstMessage);
            group.setUpdateAt(new Date());
            group.setLastMessage(firstMessage);
            groupService.createGroup(group);
            firstMessage.setGroupId(group.getGroupId());
            messageService.saveMessage(firstMessage);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new IncredibleResponse(true, "Tạo group thành công", null, group));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new IncredibleResponse(false, e.toString(), e, null));
        }
    }

    @GetMapping(value = RouteConstant.GROUP_PROFILE)
    public ResponseEntity<?> getGoupByID(@RequestParam("id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new IncredibleResponse(true, null, null, groupService.getGroupById(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new IncredibleResponse(false, e.toString(), e, null));
        }
    }

    @MessageMapping(SocketRequestType.SOCKET_REQUEST_LIST_GROUP + "/to")
    public void getListGroupMember(@DestinationVariable Long id) {
        var listGroupOf = groupService.getListGroupOfMember(id);
        simpMessagingTemplate.convertAndSend(SocketRequestType.SOCKET_REQUEST_LIST_GROUP + id.toString(), listGroupOf);
    }
}
