package com.depro.mogakomap.controller;

import com.depro.mogakomap.dto.ChatRoomRequestDto;
import com.depro.mogakomap.dto.ChatRoomResponseDto;
import com.depro.mogakomap.repository.ChatRoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shinjekim on 2019.07.04
 * shinjehere@gmail.com
 */
@RestController
@AllArgsConstructor
public class ChatRoomController {
    private ChatRoomRepository chatRoomRepository;

    /**
     * 채팅방을 생성합니다.
     * @param chatRoomRequestDto
     * @return
     */
    @PostMapping("/chatroom/create")
    public ChatRoomResponseDto createChatRoom(@RequestBody ChatRoomRequestDto chatRoomRequestDto){
        chatRoomRepository.save(chatRoomRequestDto.toEntity());
        ChatRoomResponseDto chatRoomResponseDto = new ChatRoomResponseDto(chatRoomRepository.findByChatRoomLocation(chatRoomRequestDto.getChatRoomLocation()));
        //TODO: 개발 완료 후 삭제할것
        System.out.println("채팅방생성: "+chatRoomResponseDto.getChatRoomTitle());
        return chatRoomResponseDto;
    }
}
