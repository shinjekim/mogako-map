package com.depro.mogakomap.dto;

import com.depro.mogakomap.entity.ChatMessage;
import com.depro.mogakomap.entity.ChatRoom;
import com.depro.mogakomap.entity.Member;
import lombok.*;

import java.util.Date;

/**
 * Created by shinjekim on 2019.07.04
 * shinjehere@gmail.com
 */
@Getter
@Setter
@NoArgsConstructor
public class ChatMessageRequestDto {
    private Long chatMessageId;
    private String chatMessageContent;
    private Date chatMessageTimestamp;
    private Member member;
    private ChatRoom chatRoom;

    @Builder
    public ChatMessageRequestDto(Long chatMessageId, String chatMessageContent, Date chatMessageTimestamp, Member member, ChatRoom chatRoom){
        this.chatMessageId = chatMessageId;
        this.chatMessageContent = chatMessageContent;
        this.chatMessageTimestamp = chatMessageTimestamp;
        this.member = member;
        this.chatRoom = chatRoom;
    }

    public ChatMessage toEntity(){
        return ChatMessage.builder()
                .chatMessageId(chatMessageId)
                .chatMessageContent(chatMessageContent)
                .chatMessageTimestamp(chatMessageTimestamp)
                .member(member)
                .chatRoom(chatRoom)
                .build();
    }
}