package com.ae_chat.aechatapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Table;
import javax.persistence.Transient;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private int type;

    @Column(name = "status")
    private int status;

    @Column(name = "groupType")
    private int groupType;

    @Column(name = "groupId")
    private Long groupId;

    @Column(name = "message")
    private String message;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updateAt")
    private Date updateAt;

    @Column(name = "senderName")
    private String senderName;

    @Column(name = "senderUin")
    private String senderUin;

    @Column(name = "senderAvatar")
    private String senderAvatar;

    @Column(name = "nonce")
    private String nonce;

    @Transient
    private List<String> seenUins;

    @Transient
    private List<String> deletedUins;

    @Transient
    private Object attachments;

    public Long get_id() {
        return id;
    }

    public void set_id(Long _id) {
        this.id = _id;
    }

    public int getType() {
        return type;
    }

    public void setType(int _type) {
        this.type = _type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int _status) {
        this.status = _status;
    }

    public int getGroupType() {
        return groupType;
    }

    public void setGroupType(int _groupType) {
        this.groupType = _groupType;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long _groupId) {
        this.groupId = _groupId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String _message) {
        this.message = _message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date _createdAt) {
        this.createdAt = _createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date _updateAt) {
        this.updateAt = _updateAt;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String _senderName) {
        this.senderName = _senderName;
    }

    public String getSenderUin() {
        return senderUin;
    }

    public void setSenderUin(String _senderUin) {
        this.senderUin = _senderUin;
    }

    public String getSenderAvatar() {
        return senderAvatar;
    }

    public void setSenderAvatar(String _senderAvatar) {
        this.senderAvatar = _senderAvatar;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String _nonce) {
        this.nonce = _nonce;
    }

    public List<String> getSeenUins() {
        return seenUins;
    }

    public void setSeenUins(List<String> _seenUins) {
        this.seenUins = _seenUins;
    }

    public List<String> getDeletedUins() {
        return deletedUins;
    }

    public void setDeletedUins(List<String> _deletedUins) {
        this.deletedUins = _deletedUins;
    }

    public Object getAttachments() {
        return attachments;
    }

    public void setAttachments(Object attachments) {
        this.attachments = attachments;
    }
}

/**
 * MessageType
 * text: 0
 * call: 1
 * image: 2
 * audio: 3
 * video: 4
 * firstMessage: 5
 * groupUpdate: 6
 * leaveGroup: 7
 * rely: 8
 * forward: 9
 * sticker: 10
 * file: 12
 * screenshot: 13
 * location: 14
 * liveLocation: 15
 * groupCall: 16
 */

/*
 * MessageStatus
 * unknown: 0
 * sent: 1
 * received: 2
 * seen: 3
 * deleted: 4
 * sending: 5
 */

/**
 * GroupType
 * unknown: 0
 * private: 1
 * group: 2
 * public: 3
 * channel: 4
 * official: 5
 */
