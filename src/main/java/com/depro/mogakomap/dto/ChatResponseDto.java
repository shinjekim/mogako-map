package com.depro.mogakomap.dto;

import com.depro.mogakomap.entity.Chat;
import com.depro.mogakomap.entity.ChatRoom;
import lombok.Getter;

import java.util.Date;

/**
 * Created by shinjekim on 2019.07.04
 * shinjehere@gmail.com
 */
@Getter
public class ChatResponseDto {
    private Long chatId;
    private String chatMessage;
    private Date chatTimestamp;
    private ChatRoom chatRoom;

    public ChatResponseDto(Chat entity){
        chatId = entity.getChatId();
        chatMessage = entity.getChatMessage();
        chatTimestamp = entity.getChatTimestamp();
        chatRoom = entity.getChatRoom();
    }
}
