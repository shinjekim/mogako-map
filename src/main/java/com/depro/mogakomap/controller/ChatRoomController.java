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
    public ChatRoomDto createChatRoom(@RequestBody ChatRoomDto dto){
        ChatRoomDto newChatRoom = new ChatRoomDto();
        chatRoomRepository.save(dto.toEntity());
        //TODO: Dto에 엔터티를 set하는 바람직한 방법으로 바꿀것.
        newChatRoom.setChatRoomId(chatRoomRepository.findByMapMarkerLocation(dto.getMapMarkerLocation()).getChatRoomId());
        newChatRoom.setChatRoomTitle(chatRoomRepository.findByMapMarkerLocation(dto.getMapMarkerLocation()).getChatRoomTitle());
        newChatRoom.setMapMarkerLocation(chatRoomRepository.findByMapMarkerLocation(dto.getMapMarkerLocation()).getMapMarkerLocation());
        return newChatRoom;
    }
}
