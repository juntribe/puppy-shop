package com.shop.puppyshop.controller;

import com.shop.puppyshop.admin.AdminFormDto;
import com.shop.puppyshop.member.MemberFormDto;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    @GetMapping("")
    public String login(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "adminMember/login";
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String main(Model model){
        model.addAttribute("adminFormDto",new MemberFormDto());
        return "main";
    }
}
