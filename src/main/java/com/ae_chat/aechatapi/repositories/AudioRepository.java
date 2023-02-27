package com.ae_chat.aechatapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ae_chat.aechatapi.entity.Audio;

public interface AudioRepository extends JpaRepository<Audio, String> {
    
}
