package com.shop.puppyshop.item;

import com.shop.puppyshop.constant.BaseEntityTime;
import com.shop.puppyshop.constant.ItemSellStatus;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;


@Setter
@Getter
@Table(name = "item")
@Entity
public class Item extends BaseEntityTime {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_code")
    private String code;

//    @Column(nullable = false,length = 50)
    private String itemNm; // 상품명

    private String maker; //제조사

    private String origin; //원산지

    private String brand; // 브랜드

    private String model; // 모델

    @Column(name = "option_subject")
    private String optionSubject; // 선택옵션명

    @Column(name = "supply_subject")
    private String supplySubject; //추가옵션명

    @ColumnDefault("0")
    private Byte type1; //상품유형 히트
    @ColumnDefault("0")
    private Byte type2; // 상품유형 추천
    @ColumnDefault("0")
    private Byte type3; // 상품유형 신상품
    @ColumnDefault("0")
    private Byte type4; // 상품유형 인기
    @ColumnDefault("0")
    private Byte type5; // 상품유형 할인

//    @Column(nullable = false)
    private int price; // 가격


//    @Column(nullable = false)
    private int stockNumber; // 재고수량

    @Lob
//    @Column(nullable = false)
    private String itemDetail;

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; //상품 판매 상태


}
