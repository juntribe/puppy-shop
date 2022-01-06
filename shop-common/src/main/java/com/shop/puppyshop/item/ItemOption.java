package com.shop.puppyshop.item;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class ItemOption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "op_name")
    private String name;


    private String value;
}
