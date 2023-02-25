package com.ae_chat.aechatapi.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.*;

@Entity
@Table(name = "video_attachment")
@Getter
@Setter
public class VideoAttachment {
    @Id
    @Column(name = "url")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String url;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

    @Lob
    @Column(name = "video_data", length = 1000)
    private byte[] videoData;

    @Column(name = "type")
    private String type;

    @Column(name = "duration")
    private int duration;

}
