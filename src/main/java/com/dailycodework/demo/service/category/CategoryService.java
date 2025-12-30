package com.dailycodework.demo.service.category;

import java.util.Locale.Category;

import org.springframework.stereotype.Service;

import com.dailycodework.demo.repository.CategoryRepository;
import com.dailycodework.demo.service.product.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public com.dailycodework.demo.model.Category getCategoryById(Long id) {


        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found!"));     
    }

    

    @Override
    public Category getCategoryByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategoryByName'");
    }

    @Override
    public List<Category> getAllCategories() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCategories'");
    }

    @Override
    public Category addCategory(Category category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addCategory'");
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCategory'");
    }

    @Override
    public void deleteCategory(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCategory'");
    }

}
