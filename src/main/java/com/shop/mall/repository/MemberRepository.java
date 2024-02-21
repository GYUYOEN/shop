package com.shop.mall.repository;

import com.shop.mall.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email);
}
