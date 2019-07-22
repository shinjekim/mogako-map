package com.depro.mogakomap.dto;

import com.depro.mogakomap.entity.Member;
import lombok.Getter;

/**
 * Created by shinjekim on 2019.07.22
 * shinjehere@gmail.com
 */
@Getter
public class MemberResponseDto {
    private Long memberId;
    private String memberEmail;
    private String memberUsername;
    private String memberPhotoUrl;
    private String memberGeolocation;
    private String memberSkill;

    public MemberResponseDto(Member entity){
        memberId = entity.getMemberId();
        memberEmail = entity.getMemberEmail();
        memberUsername = entity.getMemberUsername();
        memberPhotoUrl = entity.getMemberPhotoUrl();
        memberGeolocation = entity.getMemberGeolocation();
        memberSkill = entity.getMemberSkill();
    }
}
