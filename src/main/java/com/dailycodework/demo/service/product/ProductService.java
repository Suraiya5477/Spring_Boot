package com.dailycodework.demo.service.product;

import org.springframework.stereotype.Service;

import com.dailycodework.demo.exceptions.ProductNotFoundException;
import com.dailycodework.demo.model.Category;
import com.dailycodework.demo.model.Product;
import com.dailycodework.demo.repository.CategoryRepository;
import com.dailycodework.demo.repository.ProductRepository;
import com.dailycodework.demo.request.AddProductRequest;
import com.dailycodework.demo.request.ProductUpdateRequest;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product addProduct(AddProductRequest request) {

        // check if the category is found in the database; if not, create & save it
        final String categoryName = Optional.ofNullable(request.getCategory())
                .map(c -> c.getName())
                .orElseThrow();

        final Category category = categoryRepository.findByName(categoryName)
                .orElseGet(() -> {
                    final Category newCategory = new Category();
                    newCategory.setName(categoryName);
                    return categoryRepository.save(newCategory);
                });

        final Product product = createProduct(request, category);
        return productRepository.save(product);

    }

    private Product createProduct(AddProductRequest request, Category category) {

        return new Product(
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.getInventory(),
                request.getBrand(),
                category);

    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found!"));
    }

    @Override
    public void deleteProduct(Long id) {

        productRepository.findById(id).ifPresentOrElse(productRepository::delete, () -> {
            throw new ProductNotFoundException("Product not found!");
        });

    }

    // @Override
    // public void updateProduct(Product product, Long productId) {

    // }

    @Override
    public Product updateProduct(ProductUpdateRequest request, Long productId) {

        return productRepository.findById(productId)
                .map(existingProduct -> {
                    Product updatedProduct = updateExistingProduct(existingProduct, request);
                    return productRepository.save(updatedProduct);
                })
                .orElseThrow(() -> new ProductNotFoundException("Product not found!"));

    }

    

    private Product updateExistingProduct(Product existingProduct, ProductUpdateRequest request) {

        existingProduct.setName(request.getName());
        existingProduct.setBrand(request.getBrand());
        existingProduct.setDescription(request.getDescription());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setInventory(request.getInventory());

        Optional<Category> category = categoryRepository.findByName(request.getCategory().getName());
        existingProduct.setCategory(category.orElse(null));

        return existingProduct;

    }

    // @Override
    // public List<Product> getAllProducts() {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'getAllProducts'");
    // }

    @Override
    public List<Product> getProductsByCategory(Long category) {

        return productRepository.findByCategoryName(category);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {

        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {

        return productRepository.findByCategoryNameAndBrand(category, brand);

    }

    @Override
    public List<Product> getProductsByName(String name) {

        return productRepository.findByName(name);

    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {

        return productRepository.findByBrandAndName(brand, name);
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {

        return productRepository.countByBrandAndName(brand, name);

    }

    @Override
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    }

    
}
