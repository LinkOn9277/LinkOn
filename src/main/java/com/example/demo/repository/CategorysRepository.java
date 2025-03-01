package com.example.demo.repository;

import com.example.demo.entity.Categorys;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorysRepository extends JpaRepository<Categorys, Long> {
}
