package com.shop.puppyshop.repository;


import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shop.puppyshop.constant.ItemSellStatus;
import com.shop.puppyshop.item.Item;
import com.shop.puppyshop.item.ItemRepository;
import com.shop.puppyshop.item.QItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.IntStream;

@WebAppConfiguration
@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;
    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest(){

        IntStream.rangeClosed(1,10).forEach(i ->{
            Item item = Item.builder()
                    .itemNm("테스트 상품" +i)
                    .price(10000+i)
                    .itemDetail("테스트 상품 상세 설명" +i)
                    .itemSellStatus(ItemSellStatus.SELL)
                    .stockNumber(100)
                    .build();
            itemRepository.save(item);

        });

    }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void ListTest() {
        List<Item> itemList = itemRepository.findByItemNm("테스트 상품1");
        for (Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("상품명, 상품상세설명 OR 테스트")
    public void ItemDetailTest(){
        List<Item> itemList =
                itemRepository.findByItemNmOrItemDetail("테스트 상품1","테스트 상품 상세 설명1");
        for (Item item : itemList){
            System.out.println(item.toString());
        }

    }
    @Test
    @DisplayName("가격 LessThan 테스트")
    public void PriceTest(){
        List<Item> itemList = itemRepository.findByPriceLessThan(10005);
        for (Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("가격 LessThan 테스트")
    public void PriceDescTest(){
        this.createItemTest();
        List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(10005);
        for (Item item : itemList){
            System.out.println(item.toString());
        }
    }
    @Test
    @DisplayName("Querydsl 조회 테스트")
    public void queryDslTest(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QItem qItem = QItem.item;
        JPAQuery<Item> query = queryFactory.selectFrom(qItem)
                .where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
                .where(qItem.itemDetail.like("%"+"테스트 상품 상세 설명1" +"%"))
                .orderBy(qItem.price.desc());

        List<Item> itemList = query.fetch();
        for (Item item : itemList){
            System.out.println(item.toString());
        }
    }

}
