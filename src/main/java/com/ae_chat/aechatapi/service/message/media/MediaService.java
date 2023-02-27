package com.ae_chat.aechatapi.service.message.media;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.springframework.web.multipart.MultipartFile;

public interface MediaService {
    void saveImage(MultipartFile file, String messageId) throws FileNotFoundException, IOException;

    void saveVideo(MultipartFile file) throws FileNotFoundException, IOException, UnsupportedAudioFileException, LineUnavailableException;

    void saveAudio(MultipartFile file, String messageId)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException;

    byte[] downloadAudio(String audioName);

    byte[] downloadImage(String fileName);

    byte[] downloadVideo(String fileName);
}
