package com.depro.mogakomap.dto;

import com.depro.mogakomap.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by shinjekim on 2019.07.22
 * shinjehere@gmail.com
 */
@Getter
@Setter
@NoArgsConstructor
public class MemberRequestDto {
    private Long memberId;
    private String memberEmail;
    private String memberUsername;
    private String memberPhotoUrl;
    private String memberGeolocation;
    private String memberSkill;

    @Builder
    public MemberRequestDto(Long memberId, String memberEmail, String memberUsername, String memberPhotoUrl, String memberGeolocation, String memberSkill){
        this.memberId = memberId;
        this.memberEmail = memberEmail;
        this.memberUsername = memberUsername;
        this.memberPhotoUrl = memberPhotoUrl;
        this.memberGeolocation = memberGeolocation;
        this.memberSkill = memberSkill;
    }

    public Member toEntity(){
        return Member.builder()
                .memberId(memberId)
                .memberEmail(memberEmail)
                .memberUsername(memberUsername)
                .memberPhotoUrl(memberPhotoUrl)
                .memberGeolocation(memberGeolocation)
                .memberSkill(memberSkill)
                .build();
    }
}
