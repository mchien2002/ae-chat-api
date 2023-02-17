package com.ae_chat.aechatapi.service.group;

import java.util.List;

import com.ae_chat.aechatapi.entity.GroupConversation;

public interface GroupService {
    void createGroup(GroupConversation group);
    GroupConversation getGroupById(Long id);
    List<GroupConversation> getListGroupOfMember(Long userId);
}
