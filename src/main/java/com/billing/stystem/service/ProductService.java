package com.billing.stystem.service;

import com.billing.stystem.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product, MultipartFile file);
    
    public List<Product> getAllProducts();
    
    public Product getProductById(Integer prodId);
    
    public String deleteProduct(Integer prodId);
    
    public Product updateProduct(Product product, MultipartFile file);
    
    public Product updateStocks(Integer productId, Integer qty);
}
