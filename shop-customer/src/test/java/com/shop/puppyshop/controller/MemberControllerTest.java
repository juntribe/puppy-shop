package com.shop.puppyshop.controller;

import com.shop.puppyshop.member.dto.MemberFormDto;
import com.shop.puppyshop.member.entity.Member;
import com.shop.puppyshop.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
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

    @Test
    @DisplayName("로그인 성공 테스트")
    public void loginSuccessTest() throws Exception{
        String userId = "dd";
        String password = "dd";
        this.createMember(userId,password);
        mockMvc.perform(formLogin().userParameter("userId")
                .loginProcessingUrl("/members/login")
                .user(userId).password(password))
                .andExpect(SecurityMockMvcResultMatchers.authenticated());

    }
    @Test
    @DisplayName("로그인 실패 테스트")
    public void loginFailTest() throws Exception{
        String userId="dd";
        String password = "d";
        this.createMember(userId,password);
        mockMvc.perform(formLogin().userParameter("userId")
                        .loginProcessingUrl("/members/login")
                        .user(userId).password(password))
                .andExpect(SecurityMockMvcResultMatchers.authenticated());


    }









}