package com.depro.mogakomap.repository;

import com.depro.mogakomap.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    ChatRoom findByChatRoomLocation(String mapMarkerLocation);
}
