package com.example.study.controller.book;

import com.example.study.entity.Book;
import com.example.study.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/items")
    public List<Book> getBooks(){
        List<com.example.study.entity.Book> books = bookRepository.findAll();
        return books;
    }

    @PostMapping("/items")
    public Book addBook(@RequestBody Book book){
        return bookRepository.save(book);
    }
}