package com.ae_chat.aechatapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ae_chat.aechatapi.entity.Image;

public interface ImageRepository extends JpaRepository<Image, String> {
}
