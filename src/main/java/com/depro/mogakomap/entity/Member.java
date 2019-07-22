package com.depro.mogakomap.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "MEMBER")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "MEMBER_EMAIL")
    private String memberEmail;

    @Column(name = "MEMBER_USERNAME")
    private String memberUsername;

    @Column(name = "MEMBER_PHOTOURL")
    private String memberPhotoUrl;

    @Column(name = "MEMBER_CURRENT_GEOLOCATION")
    private String memberGeolocation;

    @Column(name = "MEMBER_SKILL")
    private String memberSkill;

    @Builder
    public Member(Long memberId, String memberEmail, String memberUsername, String memberPhotoUrl, String memberGeolocation, String memberSkill){
        this.memberId = memberId;
        this.memberEmail = memberEmail;
        this.memberUsername = memberUsername;
        this.memberPhotoUrl = memberPhotoUrl;
        this.memberGeolocation = memberGeolocation;
        this.memberSkill = memberSkill;
    }
}
