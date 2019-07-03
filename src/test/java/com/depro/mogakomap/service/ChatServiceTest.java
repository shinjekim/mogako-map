package com.depro.mogakomap.service;

import com.depro.mogakomap.entity.Chat;
import com.depro.mogakomap.repository.ChatRepository;
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
public class ChatServiceTest {
    @Autowired
    ChatService chatService;

    @Autowired
    ChatRepository chatRepository;

    @After
    public void cleanup(){
        /**
         * 이후 테스트 코드에 영향을 주지 않기 위해
         * 테스트 메소드가 끝날때 마다 repository 전체를 비우는 코드
         */
        chatRepository.deleteAll();
    }

//    @Test
//    public void setChatMessage(){
//        // given
//        chatService.setChatMessage(Chat.builder()
//                            .chatMessage("chatService 테스트")
//                            .build());
//
//        //when
//        List<Chat> chatList = chatRepository.findAll();
//
//        //then
//        Chat chat = chatList.get(0);
//        assertThat(chat.getChatMessage(), is("chatService 테스트"));
//    }
}