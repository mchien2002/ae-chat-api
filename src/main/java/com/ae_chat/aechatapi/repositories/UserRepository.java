package com.ae_chat.aechatapi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ae_chat.aechatapi.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByPhone(String phone);
    User findByEmail(String email);
    @Transactional
    @Modifying
    @Query(value = "UPDATE `aechat-db`.users SET otp = :otp WHERE phone = :phone", nativeQuery = true)
    void updateOTP(@Param("otp") String otp, @Param("phone") String phone);

    @Transactional
    @Modifying
    @Query(value = "UPDATE `aechat-db`.users SET otp = :otp WHERE email = :email", nativeQuery = true)
    void updateOTPByMail(@Param("otp") String otp, @Param("email") String email);

    @Transactional
    @Query(value = "SELECT * FROM users WHERE user_id = :id", nativeQuery = true)    
    User findUserById(@Param("id") String id);
}
