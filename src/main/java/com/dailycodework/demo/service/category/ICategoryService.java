package com.dailycodework.demo.service.category;

import java.util.Locale.Category;
import java.util.Optional;

import com.dailycodework.demo.service.product.List;

public interface ICategoryService {


    com.dailycodework.demo.model.Category getCategoryById(Long id); 
    Optional<com.dailycodework.demo.model.Category> getCategoryByName(String name);

    List<Category> getAllCategories();
    Category addCategory(Category category);
    com.dailycodework.demo.model.Category updateCategory(Category category, Long id);
    void deleteCategory(Long id);



}
