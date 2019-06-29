package com.depro.mogakomap.repository;

import com.depro.mogakomap.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
