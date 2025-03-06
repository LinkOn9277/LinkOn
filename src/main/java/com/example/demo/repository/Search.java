package com.example.demo.repository;

import com.example.demo.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Search {

    public Page<Item> search(String[] types, String keyword, String email, Pageable pageable);

    public Page<Item> mainList(String[] types, String keyword, String searchDateType, Pageable pageable);
}
