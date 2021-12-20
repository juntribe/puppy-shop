package com.shop.puppyshop.domain.member;

import lombok.*;

import javax.persistence.*;


@Setter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;


    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
