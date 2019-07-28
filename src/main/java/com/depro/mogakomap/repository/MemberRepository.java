package com.depro.mogakomap.repository;

import com.depro.mogakomap.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository <Member, Long>{
    // Member findByMemberId(Long memberId);
}
