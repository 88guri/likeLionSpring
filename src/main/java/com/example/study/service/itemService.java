package com.example.study.service;

import com.example.study.entity.item;
import com.example.study.model.AddItemInput;
import com.example.study.repository.itemRepository;
import org.springframework.stereotype.Service;

@Service
public class itemService {

    private final itemRepository itemRepository;

    public itemService(itemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public long add(AddItemInput input) {
        item newItem = item.builder()
                .name(input.getItemName())
                .description(input.getItemDescription())
                .price(input.getItemPrice())
                .build();
        item saved = itemRepository.save(newItem);
        return saved.getId();
    }
}
