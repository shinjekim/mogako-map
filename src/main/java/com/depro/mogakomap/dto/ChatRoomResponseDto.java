package com.depro.mogakomap.dto;

import com.depro.mogakomap.entity.ChatRoom;
import lombok.Getter;

/**
 * Created by shinjekim on 2019.07.04
 * shinjehere@gmail.com
 */
@Getter
public class ChatRoomResponseDto {
    private Long chatRoomId;
    private String chatRoomTitle;
    private String chatRoomLocation;

    public ChatRoomResponseDto(ChatRoom entity){
        chatRoomId = entity.getChatRoomId();
        chatRoomTitle = entity.getChatRoomTitle();
        chatRoomLocation = entity.getChatRoomLocation();
    }
}
