package com.depro.mogakomap.entity;

import com.depro.mogakomap.dto.ChatDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "CHAT")
public class Chat {

    @Id
    @GeneratedValue
    private Long chatId;

    @Column(nullable = false)
    private String chatMessage;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date chatTimestamp;

    @ManyToOne
    @JoinColumn(name = "CHAT_ROOM_ID")
    private ChatRoom chatRoom;

    @Builder
    public Chat(Long chatId, String chatMessage, Date chatTimestamp, ChatRoom chatRoom) {
        this.chatId = chatId;
        this.chatMessage = chatMessage;
        this.chatTimestamp = chatTimestamp;
        this.chatRoom = chatRoom;
    }
}
