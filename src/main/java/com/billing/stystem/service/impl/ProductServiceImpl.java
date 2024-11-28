package com.billing.stystem.service.impl;

import com.billing.stystem.dto.ProductDto;
import com.billing.stystem.entity.Category;
import com.billing.stystem.entity.Product;
import com.billing.stystem.exception.ProductNotFoundException;
import com.billing.stystem.repository.ProductRepository;
import com.billing.stystem.service.CategoryService;
import com.billing.stystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryService categoryService;
    
    @Override
    public Product addProduct(ProductDto productDto, MultipartFile file) {
        Product product = new Product();
        product.setProdName(productDto.getProdName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setDescription(productDto.getDescription());
        Category categoryById = categoryService.getCategoryById(productDto.getCategoryId());
        product.setCategory(categoryById);
        String image = "";
        try {
            image = Base64.getEncoder().encodeToString(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setImage(image);
        return productRepository.save(product);
    }
    
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    @Override
    public Product getProductById(Integer prodId) {
        return productRepository.findById(prodId)
                .orElseThrow(() -> new ProductNotFoundException(prodId));
    }
    
    @Override
    public String deleteProduct(Integer prodId) {
        Product productById = getProductById(prodId);
        productRepository.delete(productById);
        return "Product Deleted Successfully!";
    }
    
    @Override
    public Product updateProduct(ProductDto productDto, MultipartFile file) {
        Product product = getProductById(productDto.getProductId());
        product.setProdName(productDto.getProdName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setDescription(productDto.getDescription());
        Category categoryById = categoryService.getCategoryById(productDto.getCategoryId());
        product.setCategory(categoryById);
        String image = "";
        if (file.isEmpty()) {
            product.setImage(product.getImage());
        } else {
            try {
                image = Base64.getEncoder().encodeToString(file.getBytes());
                product.setImage(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return productRepository.save(product);
    }
    
    @Override
    public Product updateStocks(Integer productId, Integer qty) {
        Product product = getProductById(productId);
        product.setStock(product.getStock() - qty);
        return productRepository.save(product);
    }
    
    @Override
    public List<ProductDto> allProducts(){
        List<Product> all = productRepository.findAll();
        List<ProductDto> result = new ArrayList<>();
        for (Product p : all) {
            ProductDto dto = new ProductDto();
            dto.setProductId(p.getProductId());
            dto.setProdName(p.getProdName());
            dto.setPrice(p.getPrice());
            dto.setStock(p.getStock());
            dto.setDescription(p.getDescription());
            result.add(dto);
        }
        return result;
    }
    
    @Override
    public ProductDto findProductById(Integer id) {
        Product p = getProductById(id);
        ProductDto dto = new ProductDto();
        dto.setProductId(p.getProductId());
        dto.setProdName(p.getProdName());
        dto.setPrice(p.getPrice());
        dto.setStock(p.getStock());
        dto.setDescription(p.getDescription());
        return dto;
    }
    
}
