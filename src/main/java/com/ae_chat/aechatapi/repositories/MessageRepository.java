package com.ae_chat.aechatapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ae_chat.aechatapi.model.Message;
public interface MessageRepository extends JpaRepository<Message, Long>{
    
}
