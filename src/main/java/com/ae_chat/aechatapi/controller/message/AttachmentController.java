package com.ae_chat.aechatapi.controller.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ae_chat.aechatapi.helper.IncredibleResponse;
import com.ae_chat.aechatapi.route.RouteConstant;
import com.ae_chat.aechatapi.service.message.attachment.AttachmentService;

@RestController
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;

    @GetMapping(RouteConstant.IMAGE_URL + "/{fileImg}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileImg) {
        try {
            byte[] imageData = attachmentService.downloadImage(fileImg);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new IncredibleResponse(false, e.toString(), e, null));
        }
    }

    @GetMapping(RouteConstant.AUDIO_URL + "/{fileAudio}")
    public ResponseEntity<?> downloadAudio(@PathVariable String fileAudio) {
        try {
            byte[] audioData = attachmentService.downloadAudio(fileAudio);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("audio/mp3")).body(audioData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new IncredibleResponse(false, e.toString(), e, null));
        }
    }
}
