package com.ae_chat.aechatapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ae_chat.aechatapi.util.FormatString;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String userName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "email")
    private String email;

    @Column(name = "local_name")
    private String localName;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "otp")
    private String otp;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = true, referencedColumnName = "group_id")
    @JsonBackReference
    private Group memberOfGroup;

    @Transient
    private String token;

    public Group getMemberOfGroup() {
        return memberOfGroup;
    }

    public void setMemberOfGroup(Group memberOfGroup) {
        this.memberOfGroup = memberOfGroup;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String _otp) {
        this.otp = _otp;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date _createdAt) {
        this.createdAt = _createdAt;
    }

    public Long getId() {
        return userId;
    }

    public void setId(Long _id) {
        this.userId = _id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String _userName) {
        this.userName = _userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String _token) {
        this.token = _token;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String _fullName) {
        this.fullName = _fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = FormatString.customPhoneVNRegion(phone);
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String _avatar) {
        this.avatar = _avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String _email) {
        this.email = _email;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String _localName) {
        this.localName = _localName;
    }
}
