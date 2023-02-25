package com.ae_chat.aechatapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ae_chat.aechatapi.entity.VideoAttachment;

public interface VideoAttRepository extends JpaRepository<VideoAttachment, String> {

}
