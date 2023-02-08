package com.ae_chat.aechatapi.service.group;

import com.ae_chat.aechatapi.entity.GroupConversation;

public interface GroupService {
    void createGroup(GroupConversation group);
    GroupConversation getGroupById(Long id);
}
