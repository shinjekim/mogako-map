package com.depro.mogakomap.controller;

import com.depro.mogakomap.dto.ChatDto;
import com.depro.mogakomap.entity.Chat;
import com.depro.mogakomap.repository.ChatRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate template;
    private ChatRepository chatRepository;

    @Autowired
    public ChatController(SimpMessagingTemplate template){
        this.template = template;
    }

    @GetMapping("/")
    public String hello(){
        return "프로젝트 메인화면!!!";
    }

//    @PostMapping("/chat")
//    public void saveChatMessages(@RequestBody ChatDto dto){
//        chatRepository.save(dto.toEntity());
//    }

    @MessageMapping("/chatmessage")
    public void setAndGetChatMessage(@PathVariable Long chatRoomId, Chat chatMessage){
//        ChatDto chatDto = new ChatDto();
//        chatDto.setChatMessage(chatMessage);
        this.template.convertAndSend("/chatroom/"+chatRoomId, chatMessage);
    }
}
