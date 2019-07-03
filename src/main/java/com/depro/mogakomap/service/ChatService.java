package com.depro.mogakomap.service;

import com.depro.mogakomap.entity.Chat;
import com.depro.mogakomap.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    /**
     * 채팅 메시지 저장
     * @param chat
     */
    public void setChatMessage(Chat chat){
        chatRepository.save(chat);
    }
}
