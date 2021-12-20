package com.shop.puppyshop.repository;


import com.shop.puppyshop.item.Item;
import com.shop.puppyshop.item.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest(){

        Item item = new Item();
        item.setItemNm("테스트 작성");
        Item savedItem = itemRepository.save(item);
        System.out.println(savedItem);
    }


}
