package com.depro.mogakomap.controller;

import com.depro.mogakomap.dto.ChatMessageRequestDto;
import com.depro.mogakomap.dto.ChatMessageResponseDto;
import com.depro.mogakomap.dto.ChatRoomRequestDto;
import com.depro.mogakomap.dto.ChatRoomResponseDto;
import com.depro.mogakomap.entity.ChatMessage;
import com.depro.mogakomap.entity.ChatRoom;
import com.depro.mogakomap.repository.ChatMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ChatMessageController {

    private final SimpMessagingTemplate template;
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatMessageController(SimpMessagingTemplate template){
        this.template = template;
    }

    @GetMapping("/")
    public String hello(){
        return "ChatController";
    }

    @MessageMapping("/chatmessage")
    public String setAndGetChatMessage(ChatMessageRequestDto chatMessageRequestDto){
        System.out.println("로그: "+ chatMessageRequestDto);
        chatMessageRepository.save(chatMessageRequestDto.toEntity());
        Long chatRoomId = chatMessageRequestDto.getChatRoom().getChatRoomId();
        //TODO: Optional에 엔터티 타입을 넣는게 맞는건지?
        Optional<ChatMessage> chatResponseDto = chatMessageRepository.findById(chatRoomId);
        this.template.convertAndSend("/chatroom/"+chatRoomId, chatResponseDto);
        return chatMessageRequestDto +"반환";
    }

    @PostMapping(value = "/chatrooms/{chatRoomId}")
    public List<ChatMessage> getChatMessageList(@RequestBody ChatRoomRequestDto chatRoomRequestDto){
        //TODO: 레파지토리의 findByChatRoom 파라미터를 ChatRoomId로 바꿀 것(바꾸니 에러가 났었는데 아직 고치지 못해서 일단은 entity형태를 넣음)
        List<ChatMessage> resultList = chatMessageRepository.findByChatRoom(chatRoomRequestDto.toEntity());
        return resultList;
    }

//    @MessageMapping("/member_list")
//    public List<String> getChatRoomMemberList(Long chatRoomId){
//        List<String>
//    }
}