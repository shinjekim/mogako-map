package com.depro.mogakomap.repository;

import com.depro.mogakomap.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository <Member, Long>{
}
