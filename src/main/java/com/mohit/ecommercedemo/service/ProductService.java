package com.mohit.ecommercedemo.service;

import com.mohit.ecommercedemo.dto.ProductRequestDto;
import com.mohit.ecommercedemo.entity.Category;
import com.mohit.ecommercedemo.entity.Product;
import com.mohit.ecommercedemo.repository.CategoryRepository;
import com.mohit.ecommercedemo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Product saveProduct(ProductRequestDto productRequestDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(productRequestDto.getCategoryId());
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            Product product = new Product();
            product.setCategory(category);
            product.setName(productRequestDto.getName());
            product.setDescription(productRequestDto.getDescription());
            product.setPrice(productRequestDto.getPrice());
            product.setStockQuantity(productRequestDto.getStockQuantity());
            return productRepository.save(product);
        }
        throw new RuntimeException("Category not found for id: " + productRequestDto.getCategoryId());
    }

    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        throw new RuntimeException("Product not found for id: " + id);
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product updateProduct(Long id, Product product){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product productFromDB = optionalProduct.get();
            productFromDB.setName(product.getName());
            productFromDB.setDescription(product.getDescription());
            return productRepository.save(productFromDB);
        }
        throw new RuntimeException("Product not found for id: " + id);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
