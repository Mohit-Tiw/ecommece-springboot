package com.mohit.ecommercedemo.controller;

import com.mohit.ecommercedemo.dto.ProductRequestDto;
import com.mohit.ecommercedemo.entity.Product;
import com.mohit.ecommercedemo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.saveProduct(productRequestDto);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    //http://localhost:8080/api/products?name=Levis Shirt
    @GetMapping
    public Product getProductByName(@RequestParam String name) {
        return productService.getProductByName(name);
    }

    @GetMapping("/all")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
