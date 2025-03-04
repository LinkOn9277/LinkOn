package com.example.demo.dto;

import com.example.demo.entity.Item;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {


    private Long id;

    private String imgName;

    private String orimgName;

    private String iurl;

    private String repimgYn;

    private ItemDTO itemDTO;

}
