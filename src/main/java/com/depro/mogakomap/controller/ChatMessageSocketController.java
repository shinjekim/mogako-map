package com.depro.mogakomap.controller;

import com.depro.mogakomap.dto.ChatMessageRequestDto;
import com.depro.mogakomap.entity.ChatMessage;
import com.depro.mogakomap.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class ChatMessageSocketController {
    private final SimpMessagingTemplate template;
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatMessageSocketController(SimpMessagingTemplate template){
        this.template = template;
    }

    @MessageMapping("/chatmessage")
    public String setAndGetChatMessage(ChatMessageRequestDto chatMessageRequestDto){
        System.out.println("로그: "+ chatMessageRequestDto);
        chatMessageRepository.save(chatMessageRequestDto.toEntity());
        Long chatRoomId = chatMessageRequestDto.getChatRoom().getChatRoomId();
        Optional<ChatMessage> chatResponseDto = chatMessageRepository.findById(chatRoomId);
        this.template.convertAndSend("/chatroom/"+chatRoomId, chatResponseDto);
        return chatMessageRequestDto +"반환";
    }
}
