package com.ae_chat.aechatapi.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.*;

@Entity
@Table(name = "audio_attachment")
@Getter
@Setter
public class AudioAttachment {
    @Id
    @Column(name = "url")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String url;

    @Column(name = "local_url")
    private String localUrl;

    @Column(name = "duration")
    private int duration;

    @Column(name = "message_id")
    private String messageId;

    @Column(name = "type")
    private String type;

    @Lob
    @Column(name = "audio_data", nullable = false, length = 1000)
    private byte[] audioData;

}
