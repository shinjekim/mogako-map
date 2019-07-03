package com.depro.mogakomap.entity;

import com.depro.mogakomap.dto.ChatRoomDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "CHATROOM")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHATROOM_ID")
    private Long chatRoomId;

    @Column(name = "CHATROOM_TITLE", nullable = false)
    private String chatRoomTitle;

    @Column(name = "MAP_MARKER_LOCATION", nullable = false)
    private String mapMarkerLocation;

    @Builder
    public ChatRoom(Long chatRoomId, String chatRoomTitle, String mapMarkerLocation){
        this.chatRoomId = chatRoomId;
        this.chatRoomTitle = chatRoomTitle;
        this.mapMarkerLocation = mapMarkerLocation;
    }
}

