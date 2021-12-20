package com.shop.puppyshop.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@SpringBootTest
@TestPropertySource(locations = "classpath:application1.properties")
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void add () {
        Member member = new Member();
        member.setEmail("test@test.com");
        member.setName("test");
        Member savedMember = memberRepository.save(member);
        System.out.println(savedMember.toString());

    }

}