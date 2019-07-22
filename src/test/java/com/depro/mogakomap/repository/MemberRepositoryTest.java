package com.depro.mogakomap.repository;

import com.depro.mogakomap.entity.Member;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @After
    public void cleanup(){
        /**
         * 이후 테스트 코드에 영향을 주지 않기 위해
         * 테스트 메소드가 끝날때 마다 repository 전체를 비우는 코드
         */
        memberRepository.deleteAll();
    }

    @Test
    public void memberCreateTest(){
        // given: 테스트 기반 환경을 구축하는 단계
        memberRepository.save(Member.builder()
                .memberEmail("apple@gmail.com")
                .memberUsername("apple")
                .memberPhotoUrl("photourl")
                .memberGeolocation("(32.234123, 43.234123)")
                .memberSkill("Java")
                .build());

        // when: 테스트하고자 하는 행위 선언
        List<Member> memberList = memberRepository.findAll();

        // then: 테스트 결과 검증
        Member member = memberList.get(0);
        assertThat(member.getMemberEmail(), is("apple@gmail.com"));
    }
}