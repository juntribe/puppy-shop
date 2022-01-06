package com.shop.puppyshop.member;

import com.shop.puppyshop.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findByUserId(String userId);

    Member findByEmailAndUserId(String email,String userId);
}
