package com.depro.mogakomap.controller;

import com.depro.mogakomap.dto.ChatRoomDto;
import com.depro.mogakomap.repository.ChatRoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ChatRoomController {
    private ChatRoomRepository chatRoomRepository;

    @PostMapping("/chatroom/create")
    public void createChatRoom(@RequestBody ChatRoomDto dto){
//        String chatRoomTitle = "소켓테스트용";
//        ChatRoomDto newChatRoom = chatRoomService.save(chatRoomTitle);
        chatRoomRepository.save(dto.toEntity());
    }
}
