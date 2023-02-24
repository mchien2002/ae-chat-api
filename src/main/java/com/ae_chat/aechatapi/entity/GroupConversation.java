
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
public class GroupConversation implements Comparable<GroupConversation> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "name")
    private String name;

    @Column(name = "group_type", nullable = false)
    private int groupType;

    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "owner_uin", nullable = false)
    private Long ownerUin;

    @Column(name = "creator_uin", nullable = false)
    private Long creatorUin;

    @Transient
    private List<Long> members;

    @Transient
    private List<?> removedMember;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "last_message", referencedColumnName = "message_id", nullable = true)
    private Message lastMessage;

    @Override
    public int compareTo(GroupConversation gr) {
        return lastMessage.getCreatedAt().compareTo(gr.lastMessage.getCreatedAt());
    }
}
