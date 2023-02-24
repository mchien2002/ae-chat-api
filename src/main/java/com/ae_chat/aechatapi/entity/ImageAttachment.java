package com.ae_chat.aechatapi.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "image_attachment")
@Getter
@Setter
public class ImageAttachment {
    @Id
    @Column(name = "message_id")
    private String id;

    @Column(name = "sub_index")
    private int subIndex;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

    @Lob
    @Column(name = "image_data",length = 1000)
    private byte[] imageData;

    @Column(name = "url", nullable = false, length = 1000)
    private String url;

    @Column(name = "type")
    private String type;
}
