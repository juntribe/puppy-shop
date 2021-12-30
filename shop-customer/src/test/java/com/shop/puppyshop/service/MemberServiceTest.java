package com.shop.puppyshop.service;

import com.shop.puppyshop.member.dto.MemberFormDto;
import com.shop.puppyshop.member.entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember(){
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setEmail("test@test.com");
        memberFormDto.setUserId("test");
        memberFormDto.setName("테스트");
        memberFormDto.setPhone(01012341234);
        memberFormDto.setZipcode("012345");
        memberFormDto.setAddress("서울시 마포구 합정동");
        memberFormDto.setAddressDetail("상세주소");
        memberFormDto.setPassword("1234");
        return Member.createMember(memberFormDto,passwordEncoder);

    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest(){
        Member member = createMember();
        Member saveMember =memberService.saveMember(member);

        Assertions.assertEquals(member.getEmail(),saveMember.getEmail());
        Assertions.assertEquals(member.getUserId(),saveMember.getUserId());
        Assertions.assertEquals(member.getName(),saveMember.getName());
        Assertions.assertEquals(member.getPhone(),saveMember.getPhone());
        Assertions.assertEquals(member.getZipcode(),saveMember.getZipcode());
        Assertions.assertEquals(member.getAddress(),saveMember.getAddress());
        Assertions.assertEquals(member.getAddressDetail(),saveMember.getAddressDetail());
        Assertions.assertEquals(member.getPassword(),saveMember.getPassword());
        Assertions.assertEquals(member.getRole(),saveMember.getRole());


    }
}
