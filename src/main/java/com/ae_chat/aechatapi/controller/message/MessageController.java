package com.ae_chat.aechatapi.controller.message;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.ae_chat.aechatapi.model.Message;
import com.ae_chat.aechatapi.route.RouteConstant;
import com.ae_chat.aechatapi.service.message.MessageService;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    @MessageMapping(RouteConstant.MESSAGE)
    @SendTo(RouteConstant.RETURN_TOPIC)
    public Message getContent(@RequestBody Message message) {
        try {
            // processing
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return message;
    }

}
