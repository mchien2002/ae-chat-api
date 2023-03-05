package com.ae_chat.aechatapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ae_chat.aechatapi.entity.UserOnlineStatus;

public interface UserOnlineStatusRepository extends JpaRepository<UserOnlineStatus, String> {

}
