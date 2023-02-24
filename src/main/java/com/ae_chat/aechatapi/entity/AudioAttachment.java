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
    @Column(name = "message_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "local_url")
    private String localUrl;

    @Column(name = "duration")
    private int duration;

    @Lob
    @Column(name = "audio_data", nullable = false, length = 1000)
    private byte[] audioData;

}
