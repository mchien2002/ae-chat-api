package com.ae_chat.aechatapi.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "audio_attachment")
@Getter
@Setter
public class AudioAttachment {
    @Id
    @Column(name = "message_id")
    private Long id;

    @Column(name = "url", nullable = false, length = 1000)
    private String url;

    @Column(name = "local_url")
    private String localUrl;

    @Column(name = "duration")
    private int duration;

    @Lob
    @Column(name = "audio_data", nullable = false, length = 1000)
    private byte[] audioData;

}
