package com.shop.puppyshop.controller;

import com.shop.puppyshop.member.dto.MemberFormDto;
import com.shop.puppyshop.member.entity.Member;
import com.shop.puppyshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/members")
@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/new")
    public String join(Model model){
        model.addAttribute("memberFormDto",new MemberFormDto());
        System.out.println("New Start");
        return "members/register";
    }


    @PostMapping("/join")
    public String join(@Valid MemberFormDto memberFormDto, BindingResult error,Model model){

        System.out.println("Join Start");
        if (error.hasErrors()){
            log.info("Error");
            return "members/register";
        }
        try{
            Member member = Member.createMember(memberFormDto,passwordEncoder);
            System.out.println("Success Create!!");
            memberService.saveMember(member);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage",e.getMessage());
            System.out.println("Faild Create");
            return "members/register";
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "members/loginForm";
    }

    @GetMapping("/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg","아이디 또는 비밀번호를 확인해주세요");
        return "members/loginForm";
    }


}
