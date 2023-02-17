package com.ae_chat.aechatapi.controller.message;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.ae_chat.aechatapi.entity.Message;
import com.ae_chat.aechatapi.route.RouteConstant;
import com.ae_chat.aechatapi.service.message.MessageService;
import com.ae_chat.aechatapi.storage.UserStorage;
import com.ae_chat.aechatapi.websocket.SocketRequestType;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    // Khi user gửi tin nhắn, logic sẽ dc xử lý ở đây
    @MessageMapping(RouteConstant.CONNECT_SOCKET_ENDPOINT + "/{groupId}")
    public void sendMessage(@DestinationVariable Long groupId, Message message) {
        log.info("Handlind send message: {} to {}", message, groupId);
        message.setCreatedAt(new Date());
        message.setGroupId((long) groupId);
        try {
            messageService.saveMessage(message);
            simpMessagingTemplate.convertAndSend(SocketRequestType.SOCKET_REQUEST_CREATE_MESSAGE + groupId, message);
        } catch (Exception e) {
            log.error(e.toString(), e);
        }

    }
}
