package com.shop.puppyshop.member;

import com.shop.puppyshop.constant.Role;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;


@ToString
@Getter @Setter
@Entity
public class Member  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String userId;

    private String password;

    private String name;

    @Column(unique = true)
    private String email;

    private int phone;

    private String zipcode;

    private String address;

    private String addressDetail;

    @Enumerated(EnumType.STRING)
    private Role role;


    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){


       Member member = new Member();
       member.setUserId(memberFormDto.getUserId());
       member.setEmail(memberFormDto.getEmail());
       member.setAddress(memberFormDto.getAddress());
       member.setAddressDetail(memberFormDto.getAddressDetail());
       member.setName(memberFormDto.getName());
       member.setPhone(memberFormDto.getPhone());
       member.setZipcode(memberFormDto.getZipcode());
       member.setRole(Role.USER);
       String password = passwordEncoder.encode(memberFormDto.getPassword());
       member.setPassword(password);
       return member;


    }



}
