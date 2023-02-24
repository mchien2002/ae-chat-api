package com.ae_chat.aechatapi.service.message;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.springframework.web.multipart.MultipartFile;

import com.ae_chat.aechatapi.entity.Message;

public interface MessageService {
    Message getMessageDetail(String messageID);

    void saveMessage(Message mess);

    List<Message> getMessagesByGroupID(String groupID);

    void saveImage(MultipartFile file, String messageId) throws FileNotFoundException, IOException;

    void saveAudio(MultipartFile file) throws UnsupportedAudioFileException, IOException, LineUnavailableException;

    byte[] downloadAudio(String audioName);

    byte[] downloadImage(String fileName);
}
