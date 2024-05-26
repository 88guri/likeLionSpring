package com.example.study.repository;

import com.example.study.entity.item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface itemRepository extends JpaRepository<item, Long>{
}
