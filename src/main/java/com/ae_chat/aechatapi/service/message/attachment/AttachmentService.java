package com.ae_chat.aechatapi.service.message.attachment;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    void saveImage(MultipartFile file, String messageId) throws FileNotFoundException, IOException;

    void saveAudio(MultipartFile file, String messageId)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException;

    byte[] downloadAudio(String audioName);

    byte[] downloadImage(String fileName);
}
