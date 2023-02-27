package com.ae_chat.aechatapi.service.message.media;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ae_chat.aechatapi.entity.Audio;
import com.ae_chat.aechatapi.entity.Image;
import com.ae_chat.aechatapi.entity.Video;
import com.ae_chat.aechatapi.repositories.AudioRepository;
import com.ae_chat.aechatapi.repositories.ImageRepository;
import com.ae_chat.aechatapi.repositories.VideoRepository;
import com.ae_chat.aechatapi.util.FileUtils;

@Service
public class MediaServiceIml implements MediaService {
    @Autowired
    private ImageRepository imageAttRepository;
    @Autowired
    private AudioRepository audioAttRepository;
    @Autowired
    private VideoRepository videoAttRepository;

    @Override
    public void saveImage(MultipartFile file, String messageId) throws FileNotFoundException, IOException {

        Image img = new Image();

        img.setMessageId(messageId);
        img.setType(file.getContentType());
        img.setHeight(FileUtils.getHeightFile(file));
        img.setWidth(FileUtils.getWidthFile(file));
        img.setImageData(FileUtils.compressImage(file.getBytes()));

        imageAttRepository.save(img);

    }

    @Override
    public byte[] downloadImage(String imgId) {
        Image dbImgData = imageAttRepository.findById(imgId).get();
        byte[] imageByte = FileUtils.decompressImage(dbImgData.getImageData());
        return imageByte;
    }

    @Override
    public void saveAudio(MultipartFile file, String messageId)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Audio audio = new Audio();
        audio.setAudioData(FileUtils.compressImage(file.getBytes()));
        audio.setMessageId(messageId);
        audio.setType(file.getContentType());
        // audio.setDuration(FileUtils.getDuration(file));
        audioAttRepository.save(audio);
    }

    @Override
    public byte[] downloadAudio(String audioName) {
        Audio dbAudio = audioAttRepository.findById(audioName).get();
        byte[] audioByte = FileUtils.decompressImage(dbAudio.getAudioData());
        return audioByte;
    }

    @Override
    public void saveVideo(MultipartFile file)
            throws FileNotFoundException, IOException, UnsupportedAudioFileException, LineUnavailableException {
        Video video = new Video();
        video.setVideoData(FileUtils.compressImage(file.getBytes()));
        video.setType(file.getContentType());
        // video.setDuration(FileUtils.getDuration(file));
        // video.setHeight(FileUtils.getWidthMP4File(file));
        // video.setWidth(FileUtils.getWidthMP4File(file));

        videoAttRepository.save(video);
    }

    @Override
    public byte[] downloadVideo(String fileName) {
        Video dbVideo = videoAttRepository.findById(fileName).get();
        byte[] videoByte = FileUtils.decompressImage(dbVideo.getVideoData());
        return videoByte;
    }
}
