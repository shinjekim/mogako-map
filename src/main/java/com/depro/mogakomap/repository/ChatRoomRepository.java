package com.depro.mogakomap.repository;

import com.depro.mogakomap.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    ChatRoom findByMapMarkerLocation(String mapMarkerLocation);
}
