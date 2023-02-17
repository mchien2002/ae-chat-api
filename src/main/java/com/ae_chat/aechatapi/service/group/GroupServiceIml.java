package com.ae_chat.aechatapi.service.group;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ae_chat.aechatapi.entity.GroupConversation;
import com.ae_chat.aechatapi.repositories.GroupRepository;
import com.ae_chat.aechatapi.repositories.MemberOfGroupRepository;

@Service
public class GroupServiceIml implements GroupService {

    @Autowired
    private GroupRepository groupReponsitory;
    @Autowired
    private MemberOfGroupRepository memberOfGroupRepository;

    @Override
    public void createGroup(GroupConversation group) {
        groupReponsitory.saveAndFlush(group);
        for (Long item : group.getMembers()) {
            groupReponsitory.addMemberToGroup(group.getGroupId(), item);
        }
    }

    @Override
    public GroupConversation getGroupById(Long id) {
        GroupConversation group = groupReponsitory.findById(id).get();
        group.setMembers(memberOfGroupRepository.getMemberByGroupId(group.getGroupId()));
        return group;
    }

    @Override
    public List<GroupConversation> getListGroupOfMember(Long userId) {
        var listGroupOfMemner = groupReponsitory.getListGroupOfMember(userId);
        Collections.sort(listGroupOfMemner, Collections.reverseOrder());
        return listGroupOfMemner;
    }
}
