package com.ae_chat.aechatapi.service.group;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ae_chat.aechatapi.model.Group;
import com.ae_chat.aechatapi.model.User;
import com.ae_chat.aechatapi.repositories.GroupReponsitory;

@Service
public class GroupServiceIml implements GroupService {
    @Autowired
    private GroupReponsitory groupReponsitory;
    @Override
    public List<Group> getListGroupOfUser(User user) {
        return null;
    }
    @Override
    public void createGroup(Group group) {
        groupReponsitory.save(group);
    }

}
