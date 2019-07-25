package com.depro.mogakomap.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "CHATROOMS")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHATROOM_ID")
    private Long chatRoomId;

    @Column(name = "CHATROOM_TITLE", nullable = false)
    private String chatRoomTitle;

    @Column(name = "CHATROOM_LOCATION", nullable = false)
    private String chatRoomLocation;

    @Builder
    public ChatRoom(Long chatRoomId, String chatRoomTitle, String chatRoomLocation){
        this.chatRoomId = chatRoomId;
        this.chatRoomTitle = chatRoomTitle;
        this.chatRoomLocation = chatRoomLocation;
    }
}

