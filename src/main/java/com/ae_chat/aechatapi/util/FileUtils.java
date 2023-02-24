package com.ae_chat.aechatapi.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.sound.sampled.*;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
    public static byte[] compressImage(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4 * 1024];
        while (!deflater.finished()) {
            int size = deflater.deflate(tmp);
            outputStream.write(tmp, 0, size);
        }
        try {
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }

    public static byte[] decompressImage(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4 * 1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }

    // public static int getDuration(MultipartFile file) throws UnsupportedAudioFileException, IOException {
    //     File fileFile = new File(file);
    //     file.transferTo(fileFile);
    //     AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(fileFile);
    //     AudioFormat format = audioInputStream.getFormat();
    //     String frames = audioInputStream.getFrameLength();
    //     int durationInSeconds = (int) ((frames + 0.0) / format.getFrameRate());
    //     return durationInSeconds;
    // }
}
