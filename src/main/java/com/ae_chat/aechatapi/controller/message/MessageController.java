package com.ae_chat.aechatapi.controller.message;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.ae_chat.aechatapi.entity.Message;
import com.ae_chat.aechatapi.route.RouteConstant;
import com.ae_chat.aechatapi.service.message.MessageService;
import com.ae_chat.aechatapi.storage.UserStorage;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping(RouteConstant.CHAT_SOCKET + "/")
    public void sendMessage(@DestinationVariable String to, Message message) {
        log.info("Handlind send message: {} to {}", message, to);
        boolean isExists = UserStorage.getInstance().getUsers().contains(to);
        if (isExists) {
            simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
        }
    }
}
