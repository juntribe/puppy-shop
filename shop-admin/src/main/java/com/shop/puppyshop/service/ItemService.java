package com.shop.puppyshop.service;

import com.shop.puppyshop.item.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ItemService {

    private final ItemImgRepository itemImgRepository;
    private final ItemImgService itemImgService;
    private final ItemRepository itemRepository;

    public Long saveItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList)throws Exception{

        // 상품등록
        Item item = itemFormDto.crateItem();
        itemRepository.save(item);

        //이미지 등록
        for (int i=0; i<itemImgFileList.size(); i++){
            ItemImg itemImg = new ItemImg();
            itemImg.setItem(item);
            if (i == 0){
                itemImg.setRepimgYn("Y");
            }else{
                itemImg.setRepimgYn("N");

            }
            itemImgService.saveItemImg(itemImg,itemImgFileList.get(i));
        }
        return item.getId();
    }
}
