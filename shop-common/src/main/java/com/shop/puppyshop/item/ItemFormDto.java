package com.shop.puppyshop.item;

import com.shop.puppyshop.constant.BaseEntityTime;
import com.shop.puppyshop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ItemFormDto extends BaseEntityTime {

    private Long id;

//    @NotNull(message = "상품명은 필수 입력 값입니다")
    private String itemNm;

//    @NotNull(message = "가격은 필수 입력 값입니다.")
    private Integer price;

    private String code;

    private String maker; //제조사

    private String origin; //원산지

    private String brand; // 브랜드

    private String model; // 모델

//    @NotNull(message = "옵션은 필수 입력 값입니다")
    private String optionSubject; // 선택옵션명

    private String supplySubject; //추가옵션명

    private Byte type1; //상품유형 히트

    private Byte type2; // 상품유형 추천

    private Byte type3; // 상품유형 신상품

    private Byte type4; // 상품유형 인기

    private Byte type5; // 상품유형 할인

//    @NotNull(message = "재고는 필수 입력 값입니다")
    private int stockNumber; // 재고수량

    private String itemDetail;

    private ItemSellStatus itemSellStatus;

    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();

    private List<Long> itemImgIds = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    public Item crateItem(){
        return modelMapper.map(this, Item.class);
    }

    public static ItemFormDto of(Item item){
        return modelMapper.map(item,ItemFormDto.class);
    }


}
