package com.depro.mogakomap.service;

import com.depro.mogakomap.dto.ChatRoomDto;
import com.depro.mogakomap.entity.ChatRoom;
import com.depro.mogakomap.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

//    public ChatRoomDto createChatRoom(ChatRoom chatRoom){
//        chatRoomRepository.save(chatRoom);
//
//        return chatRoom.toDto();
//    }
}
