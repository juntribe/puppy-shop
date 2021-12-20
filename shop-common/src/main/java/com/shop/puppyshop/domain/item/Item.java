package com.shop.puppyshop.domain.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Setter
@Getter
@Table(name = "item")
@Entity
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 50)
    private String itemNm; // 상품명
//
//    @Column(nullable = false)
//    private int price; // 가격
//
//    @Column(nullable = false)
//    private int stockNumber; // 재고수량
//
//    @Lob
//    @Column(nullable = false)
//    private String itemDetail;
//
//    @Enumerated(EnumType.STRING)
//    private ItemSellStatus itemSellStatus;
}
