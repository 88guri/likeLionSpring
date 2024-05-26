package com.example.study.controller.item;

import com.example.study.entity.item;
import com.example.study.model.AddItemInput;
import com.example.study.repository.itemRepository;
import com.example.study.service.itemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class itemController {

    private final itemService itemService;
    private final itemRepository itemRepository;

    public itemController(itemService itemService, itemRepository itemRepository) {
        this.itemService = itemService;
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    public List<item> getItems() {
        return itemRepository.findAll();
    }

    @PostMapping("/items")
    public void addItem(@RequestBody @Valid AddItemInput input) {
        itemService.add(input);
    }
}
