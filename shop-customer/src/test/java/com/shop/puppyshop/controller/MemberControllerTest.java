package com.shop.puppyshop.controller;

import com.shop.puppyshop.member.dto.MemberFormDto;
import com.shop.puppyshop.member.entity.Member;
import com.shop.puppyshop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class MemberControllerTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Member createMember(String userId, String password){
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setUserId(userId);
        memberFormDto.setEmail("test2@test.com");
        memberFormDto.setName("teset");
        memberFormDto.setPhone(010);
        memberFormDto.setAddress("dkdk");
        memberFormDto.setAddressDetail("dddd");
        memberFormDto.setPassword(password);
        memberFormDto.setZipcode("222");
        Member member = Member.createMember(memberFormDto,passwordEncoder);
        return memberService.saveMember(member);


    }









}