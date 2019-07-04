package com.depro.mogakomap.controller;

import com.depro.mogakomap.dto.ChatRequestDto;
import com.depro.mogakomap.dto.ChatResponseDto;
import com.depro.mogakomap.dto.ChatRoomResponseDto;
import com.depro.mogakomap.entity.Chat;
import com.depro.mogakomap.entity.ChatRoom;
import com.depro.mogakomap.repository.ChatRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

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
        return "ChatController";
    }

    @MessageMapping("/chatmessage")
    public void setAndGetChatMessage(ChatRequestDto chatRequestDto){
        chatRepository.save(chatRequestDto.toEntity());
        Long chatRoomId = chatRequestDto.getChatRoom().getChatRoomId();
        //TODO: Optional에 엔터티 타입을 넣는게 맞는건지?
        Optional<Chat> chatResponseDto = chatRepository.findById(chatRoomId);
        this.template.convertAndSend("/chatroom/"+chatRoomId, chatResponseDto);
    }
}
