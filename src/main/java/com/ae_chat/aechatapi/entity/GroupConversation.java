
package com.ae_chat.aechatapi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "group_conversation")
@Getter
@Setter
public class GroupConversation {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "group_id")
    private String groupId;

    @Column(name = "name")
    private String name;

    @Column(name = "group_type", nullable = false)
    private int groupType;

    @Column(name = "theme")
    private int theme;

    @Column(name = "emojiGroup")
    private String emojiGroup;

    @Column(name = "last_active_time")
    private Date lastActiceTime;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "groupStatus")
    private int groupStatus;

    @Column(name = "owner_uin", nullable = false)
    private String ownerUin;

    @Column(name = "creator_uin", nullable = false)
    private String creatorUin;

    @Transient
    private List<String> members;

    @Transient
    private List<?> removedMember;

    @Transient
    private List<?> mediaFiles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "last_message", referencedColumnName = "message_id", nullable = true)
    private Message lastMessage;

}
