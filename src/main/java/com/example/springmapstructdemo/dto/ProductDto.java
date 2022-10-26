package com.example.springmapstructdemo.dto;

import com.example.springmapstructdemo.model.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
public class ProductDto {

    @Id
    private int id;
    private String name;
    private String description;
    private String quantity;
    private long price;
    private String itemId;

    private List<Item> itemsList;


}
