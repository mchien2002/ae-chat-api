package com.ae_chat.aechatapi.service.message;

import java.util.List;

import com.ae_chat.aechatapi.model.Message;

public interface MessageService {
    Message getMessageDetail(String messageID);

    List<Message> getMessagesByGroupID(String groupID);
}
