package com.depro.mogakomap.repository;

import com.depro.mogakomap.dto.ChatMessageResponseDto;
import com.depro.mogakomap.entity.ChatMessage;
import com.depro.mogakomap.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByChatRoom(ChatRoom chatRoom);

    // 테스트 완료된 쿼리
    @Query("select c from ChatMessage c where c.chatRoom.chatRoomId = :chatRoomId")
    List<ChatMessage> findAllByChatRoomId(@Param("chatRoomId") Long chatRoomId);

    // 테스트 완료된 쿼리
//    @Query("select c from ChatMessage c where c.chatRoom = :chatRoom")
//    List<ChatMessage> findByChatRoomId(@Param("chatRoom") ChatRoom chatRoom);
}
