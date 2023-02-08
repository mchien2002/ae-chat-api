package com.ae_chat.aechatapi.repositories;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ae_chat.aechatapi.entity.MemberOfGroup;

public interface MemberOfGroupRepository extends JpaRepository<MemberOfGroup, Long> {
    @Transactional
    @Query(value = "SELECT user_id FROM member_of_group WHERE group_id = :groupId", nativeQuery = true)
    List<Long> getMemberByGroupId(@Param("groupId") Long groupId);
}