package com.dailycodework.demo.service.category;

import java.util.Optional;
import java.util.Locale.Category;

// import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.dailycodework.demo.exceptions.ResourceNotFoundException;
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
                .orElseThrow(() -> new ResourceNotFoundException("Category not found!"));
    }

    @Override
    public Optional<com.dailycodework.demo.model.Category> getCategoryByName(String name) {

        return categoryRepository.findByName(name);
          
    }

    @Override
    public List<Category> getAllCategories() {

        return (List<Category>) categoryRepository.findAll();


    }

    @Override
    public Category addCategory(Category category) {

        return Optional.of(category).filter(c -> !categoryRepository.exists(c.name()))
                .map(categoryRepository :: save)
                .orElseThrow(() -> new AlreadyExistsException(category.getName()+"Category already exists!"));

    }




    @Override
    public com.dailycodework.demo.model.Category updateCategory(Category category, Long id) {

        return Optional.ofNullable(getCategoryById(id)).map(oldCategory -> {
            oldCategory.setName(category.name());
            return categoryRepository.save(oldCategory);
        }).orElseThrow(() -> new ResourceNotFoundException("Category not found!"));

    }




    @Override
    public void deleteCategory(Long id) {

        categoryRepository.findById(id)
                .ifPresentOrElse(categoryRepository::delete, () -> {
                    throw new ResourceNotFoundException("Category not found!");
                });




    }

    private Object save(Category category1, Object object1) {
        return null;
    }

    private Object save(Category category1, Object object1) {
        return null;
    }

    private Object save(Category category1, Object object1) {
        return null;
    }

    private Object save(Category category1, Object object1) {
        return null;
    }

}
