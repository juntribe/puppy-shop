package com.shop.puppyshop.member.repository;

import com.shop.puppyshop.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findByUserId(String userId);

    Member findByEmailAndUserId(String email,String userId);
}
