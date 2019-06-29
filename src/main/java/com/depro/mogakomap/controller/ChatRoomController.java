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

    @PostMapping("/createChat")
    public void createChatRoom(@RequestBody ChatRoomDto dto){
        chatRoomRepository.save(dto.toEntity());
    }
}
