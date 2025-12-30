package com.dailycodework.demo.service.category;

import java.util.Locale.Category;

import com.dailycodework.demo.service.product.List;

public interface ICategoryService {


    com.dailycodework.demo.model.Category getCategoryById(Long id); 
    Category getCategoryByName(String name);

    List<Category> getAllCategories();
    Category addCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);



}
