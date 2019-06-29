package com.depro.mogakomap.dto;

import com.depro.mogakomap.entity.ChatRoom;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatRoomDto {
    private Long chatRoomId;
    private String chatRoomTitle;

    public ChatRoom toEntity(){
        return ChatRoom.builder()
                .chatRoomId(chatRoomId)
                .chatRoomTitle(chatRoomTitle)
                .build();
    }
}
