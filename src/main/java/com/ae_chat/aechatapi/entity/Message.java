package com.ae_chat.aechatapi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.ae_chat.aechatapi.entity.enum_model.MessageStatus;
import com.ae_chat.aechatapi.entity.enum_model.MessageType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;

@Entity
@Table(name = "messages")
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @Column(name = "type")
    private int type;

    @Column(name = "status")
    private int status;

    @Column(name = "group_type")
    private int groupType;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "message")
    private String message;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "sender_name")
    private String senderName;

    @Column(name = "sender_uin")
    private Long senderUin;

    @Column(name = "sender_avatar")
    private String senderAvatar;

    @Column(name = "nonce")
    private String nonce;

    @Transient
    private List<String> seenUins;

    @Transient
    private List<String> deletedUins;

    @Transient
    private Object attachments; 

    @OneToOne(mappedBy = "lastMessage")
    @JsonBackReference
    private GroupConversation groupConversation;

    public Message createFirstMessage(Long senderUin, int groupType){
        var firstMessage = new Message();
        firstMessage.setCreatedAt(new Date());
        firstMessage.setType(MessageType.firstMessage.ordinal());
        firstMessage.setMessage("");
        firstMessage.setGroupType(groupType);
        firstMessage.setSenderUin(senderUin);
        firstMessage.setStatus(MessageStatus.sent.ordinal());
        return firstMessage;
    }
}
