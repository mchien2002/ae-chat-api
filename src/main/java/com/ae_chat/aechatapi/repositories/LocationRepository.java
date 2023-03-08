package com.ae_chat.aechatapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ae_chat.aechatapi.entity.Location;

public interface LocationRepository extends JpaRepository<Location, String> {
}
