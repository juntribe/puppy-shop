package com.shop.puppyshop.member;

import com.shop.puppyshop.domain.member.Member;
import com.shop.puppyshop.domain.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void add () {
        Member member = new Member();
        member.setEmail("test@BaseEntity.com");
        member.setName("test");
        Member savedMember = memberRepository.save(member);
        System.out.println(savedMember.toString());

    }

}