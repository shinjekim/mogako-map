package com.depro.mogakomap.dto;

import com.depro.mogakomap.entity.ChatRoom;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatRoomDto {
    private Long chatRoomId;
    private String chatRoomTitle;
    private String mapMarkerLocation;

    public ChatRoom toEntity(){
        return ChatRoom.builder()
                .chatRoomId(chatRoomId)
                .chatRoomTitle(chatRoomTitle)
                .mapMarkerLocation(mapMarkerLocation)
                .build();
    }
}
