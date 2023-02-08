package com.ae_chat.aechatapi.service.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ae_chat.aechatapi.entity.Message;
import com.ae_chat.aechatapi.repositories.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message getMessageDetail(String messageID) {
        return null;
    }

    @Override
    public List<Message> getMessagesByGroupID(String groupID) {
        return messageRepository.findAll();
    }

}
