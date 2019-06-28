package com.depro.mogakomap.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/hello")
public class ChatController {
    @GetMapping
    public String hello(){
        return "프로젝트 시작";
    }
}
