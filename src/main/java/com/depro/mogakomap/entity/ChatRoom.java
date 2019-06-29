package com.depro.mogakomap.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "CHATROOM")
public class ChatRoom {
    @Id
    @GeneratedValue
    private Long chatRoomId;

    private String chatRoomTitle;

    @Builder
    public ChatRoom(Long chatRoomId, String chatRoomTitle){
        this.chatRoomId = chatRoomId;
        this.chatRoomTitle = chatRoomTitle;
    }
}

