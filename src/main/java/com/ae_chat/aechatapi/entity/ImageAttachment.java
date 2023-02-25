package com.ae_chat.aechatapi.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.*;

@Entity
@Table(name = "image_attachment")
@Getter
@Setter
public class ImageAttachment {
    @Id
    @Column(name = "url")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String url;

    @Column(name = "sub_index")
    private int subIndex;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

    @Lob
    @Column(name = "image_data", length = 1000)
    private byte[] imageData;

    @Column(name = "type")
    private String type;
    
    @Column(name = "message_id")
    private String messageId;
}
