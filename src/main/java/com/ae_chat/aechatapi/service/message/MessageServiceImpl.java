package com.ae_chat.aechatapi.service.message;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ae_chat.aechatapi.entity.AudioAttachment;
import com.ae_chat.aechatapi.entity.ImageAttachment;
import com.ae_chat.aechatapi.entity.Message;
import com.ae_chat.aechatapi.repositories.AudioAttRepository;
import com.ae_chat.aechatapi.repositories.ImageAttRepository;
import com.ae_chat.aechatapi.repositories.MessageRepository;
import com.ae_chat.aechatapi.util.FileUtils;

import java.awt.image.BufferedImage;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ImageAttRepository imageAttRepository;
    @Autowired
    private AudioAttRepository audioAttRepository;

    @Override
    public Message getMessageDetail(String messageID) {
        return null;
    }

    @Override
    public List<Message> getMessagesByGroupID(String groupID) {
        return messageRepository.findAll();
    }

    @Override
    public void saveMessage(Message mess) {
        messageRepository.saveAndFlush(mess);
    }

    @Override
    public void saveImage(MultipartFile file, String messageId) throws FileNotFoundException, IOException {
        InputStream inputStream = file.getInputStream();
        BufferedImage image = ImageIO.read(inputStream);
        ImageAttachment img = new ImageAttachment();

        img.setId(messageId);
        img.setType(file.getContentType());
        img.setHeight(image.getHeight());
        img.setWidth(image.getWidth());
        img.setUrl(StringUtils.cleanPath(file.getOriginalFilename()));
        img.setImageData(FileUtils.compressImage(file.getBytes()));

        imageAttRepository.save(img);

    }

    @Override
    public byte[] downloadImage(String imgId) {
        ImageAttachment dbImgData = imageAttRepository.findById(imgId).get();
        byte[] imageByte = FileUtils.decompressImage(dbImgData.getImageData());
        return imageByte;
    }

    @Override
    public void saveAudio(MultipartFile file) throws FileNotFoundException, IOException, UnsupportedAudioFileException {
        AudioAttachment audio = new AudioAttachment();
        audio.setAudioData(FileUtils.compressImage(file.getBytes()));
        // audio.setDuration(FileUtils.getDuration(file));
        audioAttRepository.save(audio);
    }

    @Override
    public byte[] downloadAudio(String audioName) {
        AudioAttachment dbAudio = audioAttRepository.findById(audioName).get();
        byte[] audioByte = FileUtils.decompressImage(dbAudio.getAudioData());
        return audioByte;
    }

}
