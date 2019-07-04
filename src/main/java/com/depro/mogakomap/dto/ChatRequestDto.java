package com.depro.mogakomap.dto;

import com.depro.mogakomap.entity.Chat;
import com.depro.mogakomap.entity.ChatRoom;
import lombok.*;

import java.util.Date;

/**
 * Created by shinjekim on 2019.07.04
 * shinjehere@gmail.com
 */
@Getter
@Setter
@NoArgsConstructor
public class ChatRequestDto {
    private Long chatId;
    private String chatMessage;
    private Date chatTimestamp;
    private ChatRoom chatRoom;

    @Builder
    public ChatRequestDto(Long chatId, String chatMessage, Date chatTimestamp, ChatRoom chatRoom){
        this.chatId = chatId;
        this.chatMessage = chatMessage;
        this.chatTimestamp = chatTimestamp;
        this.chatRoom = chatRoom;
    }

    public Chat toEntity(){
        return Chat.builder()
                .chatId(chatId)
                .chatMessage(chatMessage)
                .chatTimestamp(chatTimestamp)
                .chatRoom(chatRoom)
                .build();
    }
}