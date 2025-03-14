package com.example.demo.repository;

import com.example.demo.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    public List<Image> findByItemId(Long id);

    public Image findByItemIdAndRepimgYn(Long id , String y);


}
