package com.shop.puppyshop.item;

import lombok.Getter;

import javax.persistence.*;


@Getter
@Entity
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "category_name")
    private String name;

    
}
