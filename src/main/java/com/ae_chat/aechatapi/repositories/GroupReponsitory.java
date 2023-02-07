package com.ae_chat.aechatapi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ae_chat.aechatapi.model.Group;

public interface GroupReponsitory extends JpaRepository<Group, Long>{
    
}
