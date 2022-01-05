package com.shop.puppyshop.admin.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AdminFormDto {

    private String userId;

    private String password;

    private String name;

    private int phone;
}
