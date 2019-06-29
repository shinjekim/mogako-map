package com.depro.mogakomap.controller;

import com.depro.mogakomap.dto.ChatDto;
import com.depro.mogakomap.repository.ChatRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ChatController {

    private ChatRepository chatRepository;

    @GetMapping("/hello")
    public String hello(){
        return "프로젝트 시작";
    }

    @PostMapping("/chat")
    public void saveChatMessages(@RequestBody ChatDto dto){
        chatRepository.save(dto.toEntity());
    }
}
