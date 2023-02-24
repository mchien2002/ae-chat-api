package com.ae_chat.aechatapi.controller.message;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.ae_chat.aechatapi.entity.Message;
import com.ae_chat.aechatapi.helper.IncredibleResponse;
import com.ae_chat.aechatapi.route.RouteConstant;
import com.ae_chat.aechatapi.service.message.MessageService;
import com.ae_chat.aechatapi.websocket.SocketRequestType;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    // Khi user gửi tin nhắn, logic sẽ dc xử lý ở đây
    @MessageMapping(RouteConstant.CONNECT_SOCKET_ENDPOINT + "/{groupId}")
    public void sendMessage(@DestinationVariable String groupId, Message message) {
        log.info("Handlind send message: {} to {}", message, groupId);
        message.setCreatedAt(new Date());
        message.setGroupId((String) groupId);
        try {
            messageService.saveMessage(message);
            simpMessagingTemplate.convertAndSend(SocketRequestType.SOCKET_REQUEST_CREATE_MESSAGE + groupId, message);
        } catch (Exception e) {
            log.error(e.toString(), e);
        }
    }

    @GetMapping(RouteConstant.IMAGE_URL + "/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
        try {
            byte[] imageData = messageService.downloadImage(fileName);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new IncredibleResponse(false, e.toString(), e, null));
        }
    }

    @GetMapping("/audio/{fileAudio}")
    public ResponseEntity<?> downloadAudio(@PathVariable String fileAudio) {
        try {
            byte[] audioData = messageService.downloadAudio(fileAudio);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("audio/mp3")).body(audioData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new IncredibleResponse(false, e.toString(), e, null));
        }
    }

    @PostMapping("/test_audio")
    public String uploadAudio(@RequestBody MultipartFile file) {
        try {
            messageService.saveAudio(file);
            return "Thành công rồi anh trai";
        } catch (Exception e) {
            return e.toString();
        }
    }
}
