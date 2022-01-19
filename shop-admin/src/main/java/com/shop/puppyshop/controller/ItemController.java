package com.shop.puppyshop.controller;

import com.shop.puppyshop.item.ItemFormDto;
import com.shop.puppyshop.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Log
@RequestMapping("/admin")
@RequiredArgsConstructor
@Controller
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/item/new")
    public String itemForm(Model model){
        model.addAttribute("itemFormDto", new ItemFormDto());
        return "adminItem/itemForm";
    }

    @PostMapping("/item/new")
    public String itemNew(@Valid ItemFormDto itemFormDto, BindingResult bindingResult,
                          Model model, @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList){
        if (bindingResult.hasErrors())  {
            System.out.println("실패!!!!!!!!!!");
            log.info("여기서 실패???");
            return "adminItem/itemForm";
        }
        if (itemImgFileList.get(0).isEmpty() && itemFormDto.getId() == null){
            model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력 값 입니다.");
            System.out.println("이미지???실패!!!!!!!!!!");
            log.info(" 이미지 ??여기서 실패???");
            return "adminItem/itemForm";
        }
        try {
            itemService.saveItem(itemFormDto, itemImgFileList);
        }catch (Exception e){
            model.addAttribute("errorMessage","상품등록 중 에러가 발생하였습니다");
            System.out.println("저장 실패!!!!!!!!!!");
            log.info("저장 여기서 실패???");
            return "adminItem/itemForm";
        }
        return "redirect:/admin";

    }
}
