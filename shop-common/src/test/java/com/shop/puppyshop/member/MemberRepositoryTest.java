package com.shop.puppyshop.member;

import com.shop.puppyshop.constant.Role;
import com.shop.puppyshop.member.dto.MemberFormDto;
import com.shop.puppyshop.member.entity.Member;
import com.shop.puppyshop.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
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
        Member member = new Member();
        member.setEmail("test2@test.com");
        member.setUserId("test2");
        member.setName("테스트1");
        member.setPhone(01012341234);
        member.setZipcode("012345");
        member.setAddress("서울시 마포구 합정동");
        member.setAddressDetail("상세주소");
        member.setPassword(passwordEncoder.encode(password));
        member.setRole(Role.USER);
        memberRepository.save(member);

    }
    @Test
    @DisplayName("어드민 생성 테스트")
    public void createAdmin(){
        String password ="admin";
        Member member = new Member();
        member.setUserId("admin");
        member.setPassword(passwordEncoder.encode(password));
        member.setName("관리자");
        member.setRole(Role.ADMIN);
        memberRepository.save(member);
    }

}