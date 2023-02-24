
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
public class GroupConversation implements Comparable<GroupConversation> {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "group_id")
    private String groupId;

    @Column(name = "name")
    private String name;

    @Column(name = "group_type", nullable = false)
    private int groupType;

    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "owner_uin", nullable = false)
    private String ownerUin;

    @Column(name = "creator_uin", nullable = false)
    private String creatorUin;

    @Transient
    private List<String> members;

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
