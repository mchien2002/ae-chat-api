package com.ae_chat.aechatapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ae_chat.aechatapi.entity.AudioAttachment;

public interface AudioAttRepository extends JpaRepository<AudioAttachment, Long>{
    
}
