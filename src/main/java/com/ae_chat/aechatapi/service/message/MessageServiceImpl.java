package com.ae_chat.aechatapi.service.message;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ae_chat.aechatapi.entity.ImageAttachment;
import com.ae_chat.aechatapi.entity.Message;
import com.ae_chat.aechatapi.repositories.AudioAttRepository;
import com.ae_chat.aechatapi.repositories.ImageAttRepository;
import com.ae_chat.aechatapi.repositories.MessageRepository;
import com.ae_chat.aechatapi.util.ImageUtils;

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
    public void saveImage(MultipartFile file) throws FileNotFoundException, IOException {
        InputStream inputStream = file.getInputStream();
        BufferedImage image = ImageIO.read(inputStream);
        ImageAttachment img = new ImageAttachment();

        img.setType(file.getContentType());
        img.setHeight(image.getHeight());
        img.setWidth(image.getWidth());
        img.setUrl(StringUtils.cleanPath(file.getOriginalFilename()));
        img.setImageData(ImageUtils.compressImage(file.getBytes()));

        imageAttRepository.save(img);

    }

    @Override
    public byte[] downloadImage(String fileName) {
        ImageAttachment dbImgData = imageAttRepository.findByUrl(fileName);
        byte[] imageByte = ImageUtils.decompressImage(dbImgData.getImageData());
        return imageByte;
    }

}
