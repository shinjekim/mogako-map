package com.depro.mogakomap.controller;

import com.depro.mogakomap.dto.MemberRequestDto;
import com.depro.mogakomap.dto.MemberResponseDto;
import com.depro.mogakomap.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shinjekim on 2019.07.22
 * shinjehere@gmail.com
 */
@RestController
@AllArgsConstructor
public class MemberController {
    private MemberRepository memberRepository;

    //TODO: 아래의 createUser는 로그인 만들기 전에 테스트를 하기 위한 코드. 테스트 후 삭제할것.
    @PutMapping("/members/create")
    public MemberResponseDto createUser(@RequestBody MemberRequestDto memberRequestDto){
        memberRepository.save(memberRequestDto.toEntity());
        MemberResponseDto memberResponseDto = new MemberResponseDto(memberRequestDto.toEntity());
        return memberResponseDto;
    }

    //TODO:update할 때 전체 dto를 set하는게 맞는가? 그렇게 되면 update, save의 코드가 모두 같아지는데 그게 맞나?

    @PutMapping("/members/{userid}/update")
    public MemberResponseDto updateUsername(@RequestBody MemberRequestDto memberRequestDto){
        memberRepository.save(memberRequestDto.toEntity());
        MemberResponseDto memberResponseDto = new MemberResponseDto(memberRequestDto.toEntity());
        return memberResponseDto;
    }

    @PutMapping("/members/{userid}/profile/update")
    public void updateMemberPhoto(){
        //TODO: photo 파일을 받아 S3에 저장.(url리턴해야하나?)
    }

    @PutMapping("/members/{userid}/skill")
    public MemberResponseDto createMemberSkill(@RequestBody MemberRequestDto memberRequestDto){
        memberRepository.save(memberRequestDto.toEntity());
        MemberResponseDto memberResponseDto = new MemberResponseDto(memberRequestDto.toEntity());
        return memberResponseDto;
    }

    @PutMapping("/members/{userid}/skill/update")
    public MemberResponseDto updateMemberSkill(@RequestBody MemberRequestDto memberRequestDto){
        memberRepository.save(memberRequestDto.toEntity());
        MemberResponseDto memberResponseDto = new MemberResponseDto(memberRequestDto.toEntity());
        return memberResponseDto;
    }
}
