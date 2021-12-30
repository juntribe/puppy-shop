package com.shop.puppyshop.member.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class MemberFormDto {


    private String userId;

    private String password;

    private String name;

    private String email;

    private int phone;

    private String zipcode;

    private String address;

    private String addressDetail;



}
