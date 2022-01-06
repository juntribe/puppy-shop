package com.shop.puppyshop.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberFormDto {


    @NotBlank(message = "아이디 필수 입력 값입니다.")
    private String userId;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    private String password;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    private String email;

    @NotEmpty(message = "휴대폰은 필수 입력 값입니다.")
    private int phone;

    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String zipcode;

    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String address;
    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String addressDetail;



}
