package com.ae_chat.aechatapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ae_chat.aechatapi.entity.GroupConversation;

public interface GroupRepository extends JpaRepository<GroupConversation, String> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `aechat-db`.member_of_group (group_id, user_id) VALUE (:groupId, :userId)", nativeQuery = true)
    void addMemberToGroup(@Param("groupId") String groupId, @Param("userId") String userId);

    @Transactional
    @Query(value = "SELECT * FROM `aechat-db`.group_conversation WHERE group_id = :groupId", nativeQuery = true)
    GroupConversation findGroupById(@Param("groupId") String groupId);

    @Transactional
    @Query(value = "SELECT * FROM `aechat-db`.group_conversation JOIN `aechat-db`.member_of_group ON member_of_group.user_id = :userId WHERE  group_conversation.group_id = member_of_group.group_id", nativeQuery = true)
    List<GroupConversation> getListGroupOfMember(@Param("userId") String userId);
}
