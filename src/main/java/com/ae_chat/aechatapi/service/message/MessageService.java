package com.ae_chat.aechatapi.service.message;

import java.util.List;

import com.ae_chat.aechatapi.entity.Message;

public interface MessageService {
    Message getMessageDetail(String messageID);
    void saveMessage(Message mess);
    List<Message> getMessagesByGroupID(String groupID);
}
