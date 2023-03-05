package com.ae_chat.aechatapi.service.group;

import java.util.List;

import com.ae_chat.aechatapi.entity.GroupConversation;

public interface GroupService {
    void createGroup(GroupConversation group);

    GroupConversation getGroupById(String id);

    List<GroupConversation> getListGroupOfMember(String userId);
    
    /**
     * @param listMember
     * @return
     * TRẢ VỀ GROUP NẾU TRƯỚC ĐÓ ĐÃ CÓ GROUP CỦA CÁC MEMBER
     */
    GroupConversation getPublicGroupWithMember(List<String> listMember);
}
