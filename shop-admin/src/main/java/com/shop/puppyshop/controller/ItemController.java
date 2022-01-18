package com.shop.puppyshop.controller;

import com.shop.puppyshop.item.ItemFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@RequiredArgsConstructor
@Controller
public class ItemController {

    @GetMapping("/item/new")
    public String itemForm(Model model){
        model.addAttribute("itemFormDto", new ItemFormDto());
        return "adminItem/itemForm";
    }
}
