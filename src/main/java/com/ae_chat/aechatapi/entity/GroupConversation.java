
package com.ae_chat.aechatapi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "group_conversation")
@Getter
@Setter
public class GroupConversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "name")
    private String name;

    @Column(name = "group_type")
    private int groupType;

    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "owner_uin")
    private Long ownerUin;

    @Column(name = "creator_uin")
    private Long creatorUin;

    @Transient
    private List<Long> members;
}
