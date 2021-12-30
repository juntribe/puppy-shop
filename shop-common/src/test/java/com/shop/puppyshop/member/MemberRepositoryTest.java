package com.shop.puppyshop.member;

import com.shop.puppyshop.constant.Role;
import com.shop.puppyshop.member.dto.MemberFormDto;
import com.shop.puppyshop.member.entity.Member;
import com.shop.puppyshop.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void createMember(){
        String password ="1234";
        Member member = Member.builder()
        .email("test@test.com")
        .userId("test")
        .name("테스트")
        .phone(01012341234)
        .zipcode("012345")
        .address("서울시 마포구 합정동")
        .addressDetail("상세주소")
        .password(passwordEncoder.encode(password))
        .role(Role.USER)
        .build();
        memberRepository.save(member);

    }

}