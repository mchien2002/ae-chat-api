package com.ae_chat.aechatapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ae_chat.aechatapi.util.FormatString;

// STATE:
//     0: Not authorized
//     1: Authorized

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "userName")
    private String userName;


    @Column(name = "fullName")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "email")
    private String email;

    @Column(name = "localName")
    private String localName;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "state")
    private int state;

    @Column(name = "otp")
    private String otp;

    private String token;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String _otp) {
        this.otp = _otp;
    }

    public int getState() {
        return state;
    }

    public void setState(int _state) {
        this.state = _state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date _createdAt) {
        this.createdAt = _createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long _id) {
        this.id = _id;
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
