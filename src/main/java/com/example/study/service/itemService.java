package com.example.study.service;

import com.example.study.entity.item;
import com.example.study.entity.itemUpdateHistory;
import com.example.study.model.AddItemInput;
import com.example.study.model.UpdateItemInput;
import com.example.study.repository.itemRepository;
import com.example.study.repository.itemUpdateHistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class itemService {

    private final itemRepository itemRepository;
    private final itemUpdateHistoryRepository itemUpdateHistoryRepository;

    public itemService(itemRepository itemRepository, itemUpdateHistoryRepository itemUpdateHistoryRepository) {
        this.itemRepository = itemRepository;
        this.itemUpdateHistoryRepository = itemUpdateHistoryRepository;
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

    @Transactional
    public void update(Long id, UpdateItemInput input) {
        item existingItem = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("아이템을 찾을 수 없습니다."));

        if (input.getItemPrice() <= existingItem.getPrice()) {
            throw new RuntimeException("새 가격은 현재 가격보다 커야 합니다.");
        }

        // 업데이트 기록 저장
        itemUpdateHistory history = itemUpdateHistory.builder()
                .item(existingItem)
                .prevDescription(existingItem.getDescription())
                .prevPrice(existingItem.getPrice())
                .newDescription(input.getItemDescription())
                .newPrice(input.getItemPrice())
                .updatedAt(LocalDateTime.now())
                .build();
        itemUpdateHistoryRepository.save(history);

        existingItem.setDescription(input.getItemDescription());
        existingItem.setPrice(input.getItemPrice());
        itemRepository.save(existingItem);
    }
}