package com.ae_chat.aechatapi.service.group;

import java.util.List;

import com.ae_chat.aechatapi.model.Group;
import com.ae_chat.aechatapi.model.User;

public interface GroupService {
    List<Group> getListGroupOfUser(User user);
    void createGroup(Group group);
}
