package com.ae_chat.aechatapi.service.message.attachment;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ae_chat.aechatapi.entity.AudioAttachment;
import com.ae_chat.aechatapi.entity.ImageAttachment;
import com.ae_chat.aechatapi.repositories.AudioAttRepository;
import com.ae_chat.aechatapi.repositories.ImageAttRepository;
import com.ae_chat.aechatapi.util.FileUtils;
@Service
public class AttachmentServiceIml implements AttachmentService {
    @Autowired
    private ImageAttRepository imageAttRepository;
    @Autowired
    private AudioAttRepository audioAttRepository;

    @Override
    public void saveImage(MultipartFile file, String messageId) throws FileNotFoundException, IOException {

        ImageAttachment img = new ImageAttachment();

        img.setMessageId(messageId);
        img.setType(file.getContentType());
        img.setHeight(FileUtils.getHeightFile(file));
        img.setWidth(FileUtils.getWidthFile(file));
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
    public void saveAudio(MultipartFile file, String messageId)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioAttachment audio = new AudioAttachment();
        audio.setAudioData(FileUtils.compressImage(file.getBytes()));
        audio.setMessageId(messageId);
        audio.setType(file.getContentType());
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
