package com.depro.mogakomap.dto;

import com.depro.mogakomap.entity.Chat;
import com.depro.mogakomap.entity.ChatRoom;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ChatDto {
    private Long chatId;
    private String chatMessage;
    private Date chatTimestamp;
    private ChatRoom chatRoom;

    public Chat toEntity(){
        return Chat.builder()
                .chatId(chatId)
                .chatMessage(chatMessage)
                .chatTimestamp(chatTimestamp)
                .chatRoom(chatRoom)
                .build();
    }
}