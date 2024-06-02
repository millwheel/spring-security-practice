package com.example.security_scratch.repository;

import com.example.security_scratch.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
