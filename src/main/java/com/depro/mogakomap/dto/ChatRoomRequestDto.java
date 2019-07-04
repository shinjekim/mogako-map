package com.depro.mogakomap.dto;

import com.depro.mogakomap.entity.ChatRoom;
import lombok.*;

/**
 * Created by shinjekim on 2019.07.04
 * shinjehere@gmail.com
 */
@Getter
@Setter
@NoArgsConstructor
public class ChatRoomRequestDto {
    private Long chatRoomId;
    private String chatRoomTitle;
    private String mapMarkerLocation;

    @Builder
    public ChatRoomRequestDto(Long chatRoomId, String chatRoomTitle, String mapMarkerLocation){
        this.chatRoomId = chatRoomId;
        this.chatRoomTitle = chatRoomTitle;
        this.mapMarkerLocation = mapMarkerLocation;
    }

    public ChatRoom toEntity(){
        return ChatRoom.builder()
                .chatRoomId(chatRoomId)
                .chatRoomTitle(chatRoomTitle)
                .mapMarkerLocation(mapMarkerLocation)
                .build();
    }
}
