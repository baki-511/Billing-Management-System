package com.billing.stystem.service;

import com.billing.stystem.dto.ProductDto;
import com.billing.stystem.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    public Product addProduct(ProductDto ProductDto, MultipartFile file);
    
    public List<Product> getAllProducts();
    
    public Product getProductById(Integer prodId);
    
    public String deleteProduct(Integer prodId);
    
    public Product updateProduct(ProductDto productDto, MultipartFile file);
    
    public Product updateStocks(Integer productId, Integer qty);
    
//    public ProductDto addProduct(ProductDto product);
    
    public List<ProductDto> allProducts();
    public ProductDto findProductById(Integer id);
}
