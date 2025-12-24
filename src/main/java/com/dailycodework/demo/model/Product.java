package com.dailycodework.demo.model;

import java.math.BigDecimal;
import java.util.List;

import com.mysql.cj.jdbc.Blob;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Product {



    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int inventory;
    private String brand; 


    private Category category;
    

    private List<Image> images;

    public class Image {

        private Long id; 
        private String fileName; 
        private String fileType; 
        private Blob image;
        private String downloadUrl; 


        @ManyToOne 
        // many images belong to one product ref in doc spring boot 
        @JoinColumn(name = "product_id")
        //Yes the relationship is maintained through one single product_id column in the database table



        private Product product; 



    
        
    }








}
