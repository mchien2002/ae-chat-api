package com.ae_chat.aechatapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ae_chat.aechatapi.entity.ImageAttachment;

public interface ImageAttRepository extends JpaRepository<ImageAttachment, String> {
}
