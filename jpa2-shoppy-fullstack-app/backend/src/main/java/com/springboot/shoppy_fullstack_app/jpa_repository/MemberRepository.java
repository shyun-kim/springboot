package com.springboot.shoppy_fullstack_app.jpa_repository;

import com.springboot.shoppy_fullstack_app.dto.MemberDto;
import com.springboot.shoppy_fullstack_app.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Member save(Member member);
    Long countById(String id);
    Optional<Member> findById(@Param("id") String id);
}
