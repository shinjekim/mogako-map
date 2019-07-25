package com.depro.mogakomap.dto;

import com.depro.mogakomap.entity.ChatMessage;
import lombok.Getter;

import java.util.Date;

/**
 * Created by shinjekim on 2019.07.04
 * shinjehere@gmail.com
 */
@Getter
public class ChatMessageResponseDto {
    private Long chatMessageId;
    private String chatMessageContent;
    private Date chatMessageTimestamp;
    private String memberUsername;
    private Long chatRoomId;

    public ChatMessageResponseDto(ChatMessage entity){
        chatMessageId = entity.getChatMessageId();
        chatMessageContent = entity.getChatMessageContent();
        chatMessageTimestamp = entity.getChatMessageTimestamp();
        memberUsername = entity.getMember().getMemberUsername();
        chatRoomId = entity.getChatRoom().getChatRoomId();
    }
}
