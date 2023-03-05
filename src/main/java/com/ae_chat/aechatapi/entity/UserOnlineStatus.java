package com.ae_chat.aechatapi.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "users_online_status")
@Getter
@Setter
public class UserOnlineStatus {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "last_time_online", nullable = false)
    private Date lastTimeOnline;
}
