package com.dailycodework.demo.request;

import java.math.BigDecimal;
import java.util.List;

import com.dailycodework.demo.model.Category;
import com.dailycodework.demo.model.Image;

import lombok.Data;



@Data
public class ProductUpdateRequest {


    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int inventory;
    private String brand; 
    private List<Image> images;
    public Category getCategory() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getCategory'");
    }









}
