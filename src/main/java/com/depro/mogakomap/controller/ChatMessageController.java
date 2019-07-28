package com.depro.mogakomap.controller;

import com.depro.mogakomap.dto.ChatRoomRequestDto;
import com.depro.mogakomap.entity.ChatMessage;
import com.depro.mogakomap.entity.ChatRoom;
import com.depro.mogakomap.repository.ChatMessageRepository;
import lombok.AllArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
public class ChatMessageController {
    private ChatMessageRepository chatMessageRepository;

    @GetMapping("/")
    public String hello(){
        return "ChatController";
    }

    /**
     * 채팅방의 기존 채팅 메시지 정보를 불러옵니다.
     * @param chatRoomRequestDto
     * @return jsonChatMessageList
     */
    @PostMapping(value = "/chatrooms/{chatRoomId}")
    public JSONObject getChatMessageList(@RequestBody ChatRoomRequestDto chatRoomRequestDto){
        List<ChatMessage> resultList = chatMessageRepository.findAllByChatRoomId(chatRoomRequestDto.getChatRoomId());
        JSONObject jsonChatMessageList = new JSONObject();
        try{
            jsonChatMessageList.put("type", "chatRoomList");
            jsonChatMessageList.put("datas", resultList);
        }catch (JSONException e){
            e.getMessage();
        }
        return jsonChatMessageList;
    }

//    @MessageMapping("/member_list")
//    public List<String> getChatRoomMemberList(Long chatRoomId){
//        List<String>
//    }
}