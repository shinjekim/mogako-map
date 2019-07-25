package com.depro.mogakomap.controller;

import com.depro.mogakomap.dto.ChatMessageResponseDto;
import com.depro.mogakomap.dto.ChatRoomRequestDto;
import com.depro.mogakomap.dto.ChatRoomResponseDto;
import com.depro.mogakomap.repository.ChatMessageRepository;
import com.depro.mogakomap.repository.ChatRoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by shinjekim on 2019.07.04
 * shinjehere@gmail.com
 */
@RestController
@AllArgsConstructor
public class ChatRoomController {
    private ChatRoomRepository chatRoomRepository;

    @PostMapping("/chatroom/create")
    public ChatRoomResponseDto createChatRoom(@RequestBody ChatRoomRequestDto chatRoomRequestDto){
        chatRoomRepository.save(chatRoomRequestDto.toEntity());
        ChatRoomResponseDto chatRoomResponseDto = new ChatRoomResponseDto(chatRoomRepository.findByChatRoomLocation(chatRoomRequestDto.getChatRoomLocation()));
        System.out.println("채팅방생성: "+chatRoomResponseDto.getChatRoomTitle());
        return chatRoomResponseDto;
    }
}
