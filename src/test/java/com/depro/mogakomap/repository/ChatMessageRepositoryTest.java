package com.depro.mogakomap.repository;

import com.depro.mogakomap.dto.ChatMessageResponseDto;
import com.depro.mogakomap.dto.ChatRoomRequestDto;
import com.depro.mogakomap.entity.ChatMessage;
import com.depro.mogakomap.entity.ChatRoom;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatMessageRepositoryTest {

    @Autowired
    ChatMessageRepository chatMessageRepository;

    @Autowired
    ChatRoomRepository chatRoomRepository;

    @After
    public void cleanup(){
        /**
         * 이후 테스트 코드에 영향을 주지 않기 위해
         * 테스트 메소드가 끝날때 마다 repository 전체를 비우는 코드
         */
        chatMessageRepository.deleteAll();
    }

    @Test
    public void sendAndGetChatMessage(){
        // given: 테스트 기반 환경을 구축하는 단계
        chatMessageRepository.save(ChatMessage.builder()
                .chatMessageContent("채팅 메시지")
                .build());

        // when: 테스트하고자 하는 행위 선언
        List<ChatMessage> chatMessageList = chatMessageRepository.findAll();

        // then: 테스트 결과 검증
        ChatMessage chatMessage = chatMessageList.get(0);
        assertThat(chatMessage.getChatMessageContent(), is("채팅 메시지"));
    }

    @Test
    public void getChatMessageList(){
        // given
        ChatRoom chatRoom = ChatRoom.builder()
                .chatRoomId(1L)
                .chatRoomTitle("로케이션")
                .chatRoomLocation("되나요되나요")
                .build();
        chatRoomRepository.save(chatRoom);
        chatMessageRepository.save(ChatMessage.builder()
                .chatMessageContent("채팅 메시지")
                .chatRoom(chatRoom)
                .build());
        chatMessageRepository.save(ChatMessage.builder()
                .chatMessageContent("채팅 메시지222")
                .chatRoom(chatRoom)
                .build());

        // when
        List<ChatMessage> chatMessages = chatMessageRepository.findByChatRoom(chatRoom);
        // List<ChatMessage> chatMessages = chatMessageRepository.findByChatRoomId(1L);

        // get
        assertThat(chatMessages.size(), is(2));
        assertThat(chatMessages.get(1).getChatMessageContent(), is("채팅 메시지222"));
    }
}