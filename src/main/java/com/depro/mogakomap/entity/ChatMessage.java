package com.depro.mogakomap.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "CHAT_MESSAGES")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHAT_MESSAGE_ID")
    private Long chatMessageId;

    @Column(name = "CHAT_MESSAGE_CONTENT", nullable = false)
    private String chatMessageContent;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CHAT_MESSAGE_TIMESTAMP")
    private Date chatMessageTimestamp;

    // @ManyToOne(cascade = {CascadeType.ALL})
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    // @ManyToOne(cascade = {CascadeType.ALL})
    @ManyToOne
    @JoinColumn(name = "CHATROOM_ID")
    private ChatRoom chatRoom;

    @Builder
    public ChatMessage(Long chatMessageId, String chatMessageContent, Date chatMessageTimestamp, Member member, ChatRoom chatRoom) {
        this.chatMessageId = chatMessageId;
        this.chatMessageContent = chatMessageContent;
        this.chatMessageTimestamp = chatMessageTimestamp;
        this.member = member;
        this.chatRoom = chatRoom;
    }
}
