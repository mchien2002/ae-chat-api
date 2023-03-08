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
    @Query(value = "SELECT gr_con.group_id, gr_con.name, gr_con.group_type, gr_con.avatar, gr_con.last_message, gr_con.last_active_time, gr_con.group_status, gr_con.is_mute FROM `aechat-db`.group_conversation gr_con JOIN `aechat-db`.messages mess ON gr_con.last_message = mess.message_id JOIN `aechat-db`.member_of_group mem ON mem.user_id = :userId WHERE gr_con.group_id = mem.group_id ORDER BY mess.created_at ASC", nativeQuery = true)
    List<GroupConversation> getListGroupOfMember(@Param("userId") String userId);
}
