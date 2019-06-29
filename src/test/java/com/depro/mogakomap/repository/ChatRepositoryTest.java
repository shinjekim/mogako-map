package com.depro.mogakomap.repository;

import com.depro.mogakomap.entity.Chat;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatRepositoryTest {

    @Autowired
    ChatRepository chatRepository;

    // @After
    public void cleanup(){
        /**
         * 이후 테스트 코드에 영향을 주지 않기 위해
         * 테스트 메소드가 끝날때 마다 repository 전체를 비우는 코드
         */
        chatRepository.deleteAll();
    }

    @Test
    public void sendAndGetChatMessage(){
        // given: 테스트 기반 환경을 구축하는 단계
        chatRepository.save(Chat.builder()
                .chatMessage("채팅 메시지")
                .build());

        // when: 테스트하고자 하는 행위 선언
        List<Chat> chatList = chatRepository.findAll();

        // then: 테스트 결과 검증
        Chat chat = chatList.get(0);
        assertThat(chat.getChatMessage(), is("채팅 메시지"));
    }
}