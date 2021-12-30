package com.shop.puppyshop.member.entity;

import com.shop.puppyshop.constant.BaseEntityTime;
import com.shop.puppyshop.constant.Role;
import com.shop.puppyshop.member.dto.MemberFormDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


        return Member.builder()
                .userId(memberFormDto.getUserId())
                .password(passwordEncoder.encode(memberFormDto.getPassword()))
                .name(memberFormDto.getName())
                .email(memberFormDto.getEmail())
                .phone(memberFormDto.getPhone())
                .zipcode(memberFormDto.getZipcode())
                .address(memberFormDto.getAddress())
                .addressDetail(memberFormDto.getAddressDetail())
                .role(Role.USER)
                .build();
    }



}
