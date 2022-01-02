package com.shop.puppyshop.controller;

import com.shop.puppyshop.member.dto.MemberFormDto;
import com.shop.puppyshop.member.entity.Member;
import com.shop.puppyshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
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
@RequestMapping("/member")
@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/join")
    public String join(Model model){
        model.addAttribute("memberFormDto",new MemberFormDto());
        return "members/register";
    }


    @PostMapping("/join")
    public String join(@Valid MemberFormDto memberFormDto, BindingResult error,Model model){

        if (error.hasErrors()){
            return "members/register";
        }
        try{
            Member member = Member.createMember(memberFormDto,passwordEncoder);
            memberService.saveMember(member);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage",e.getMessage());
            return "members/register";
        }
        return "redirect:/";
    }
}
