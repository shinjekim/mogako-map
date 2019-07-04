package com.depro.mogakomap.repository;

import com.depro.mogakomap.dto.ChatRoomRequestDto;
import com.depro.mogakomap.dto.ChatRoomResponseDto;
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
public class ChatRoomRepositoryTest {

    @Autowired
    ChatRoomRepository chatRoomRepository;

    @After
    public void cleanup(){
        /**
         * 이후 테스트 코드에 영향을 주지 않기 위해
         * 테스트 메소드가 끝날때 마다 repository 전체를 비우는 코드
         */
        chatRoomRepository.deleteAll();
    }

    @Test
    public void createChatRoom(){
        // given: 테스트 기반 환경을 구축하는 단계
        chatRoomRepository.save(ChatRoom.builder()
                            .chatRoomTitle("채팅방 생성")
                            .mapMarkerLocation("locationTEst")
                            .build());

        // when: 테스트하고자 하는 행위 선언
        List<ChatRoom> chatRoomList = chatRoomRepository.findAll();
        ChatRoomResponseDto chatRoomResponseDto = new ChatRoomResponseDto(chatRoomRepository.findByMapMarkerLocation("locationTEst"));

        // then: 테스트 결과 검증
        ChatRoom chatRoom = chatRoomList.get(0);
        assertThat(chatRoom.getChatRoomTitle(), is("채팅방 생성"));
        assertThat(chatRoom.getMapMarkerLocation(), is("locationTEst"));
        assertThat(chatRoomResponseDto.getChatRoomId(), is(1L));
    }


}