package com.depro.mogakomap.repository;

import com.depro.mogakomap.dto.ChatMessageResponseDto;
import com.depro.mogakomap.entity.ChatMessage;
import com.depro.mogakomap.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByChatRoom(ChatRoom chatRoom);
}
