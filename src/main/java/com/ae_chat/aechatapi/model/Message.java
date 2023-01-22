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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long _id;

    @Column(name = "type")
    private int _type;

    @Column(name = "status")
    private int _status;

    @Column(name = "groupType")
    private int _groupType;

    @Column(name = "groupId")
    private Long _groupId;

    @Column(name = "message")
    private String _message;

    @Column(name = "createdAt")
    private Date _createdAt;

    @Column(name = "updateAt")
    private Date _updateAt;

    @Column(name = "senderName")
    private String _senderName;

    @Column(name = "senderUin")
    private String _senderUin;

    @Column(name = "senderAvatar")
    private String _senderAvatar;

    @Column(name = "nonce")
    private String _nonce;

    @Transient
    private List<String> _seenUins;

    @Transient
    private List<String> _deletedUins;

    @Transient
    private Object attachments;

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public int get_type() {
        return _type;
    }

    public void set_type(int _type) {
        this._type = _type;
    }

    public int get_status() {
        return _status;
    }

    public void set_status(int _status) {
        this._status = _status;
    }

    public int get_groupType() {
        return _groupType;
    }

    public void set_groupType(int _groupType) {
        this._groupType = _groupType;
    }

    public Long get_groupId() {
        return _groupId;
    }

    public void set_groupId(Long _groupId) {
        this._groupId = _groupId;
    }

    public String get_message() {
        return _message;
    }

    public void set_message(String _message) {
        this._message = _message;
    }

    public Date get_createdAt() {
        return _createdAt;
    }

    public void set_createdAt(Date _createdAt) {
        this._createdAt = _createdAt;
    }

    public Date get_updateAt() {
        return _updateAt;
    }

    public void set_updateAt(Date _updateAt) {
        this._updateAt = _updateAt;
    }

    public String get_senderName() {
        return _senderName;
    }

    public void set_senderName(String _senderName) {
        this._senderName = _senderName;
    }

    public String get_senderUin() {
        return _senderUin;
    }

    public void set_senderUin(String _senderUin) {
        this._senderUin = _senderUin;
    }

    public String get_senderAvatar() {
        return _senderAvatar;
    }

    public void set_senderAvatar(String _senderAvatar) {
        this._senderAvatar = _senderAvatar;
    }

    public String get_nonce() {
        return _nonce;
    }

    public void set_nonce(String _nonce) {
        this._nonce = _nonce;
    }

    public List<String> get_seenUins() {
        return _seenUins;
    }

    public void set_seenUins(List<String> _seenUins) {
        this._seenUins = _seenUins;
    }

    public List<String> get_deletedUins() {
        return _deletedUins;
    }

    public void set_deletedUins(List<String> _deletedUins) {
        this._deletedUins = _deletedUins;
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
