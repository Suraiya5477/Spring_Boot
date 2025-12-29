package com.dailycodework.demo.request;

import java.math.BigDecimal;
import java.util.List;

import com.dailycodework.demo.model.Category;
import com.dailycodework.demo.model.Image;

import lombok.Data;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;

@Data

public class AddProductRequest {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int inventory;
    private String brand; 
    private List<Image> images;
    public Category getCategory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategory'");
    }


}
