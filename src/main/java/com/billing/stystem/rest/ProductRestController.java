package com.billing.stystem.rest;


import com.billing.stystem.entity.Product;
import com.billing.stystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/product")
public class ProductRestController {
    @Autowired
    private ProductService productService;
    
   
    
    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productService.allProducts(), HttpStatus.OK);
    }
    
    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Integer productId) {
        return new ResponseEntity<>(productService.findProductById(productId), HttpStatus.OK);
    }
    
//    @DeleteMapping("/{productId}")
//    public ResponseEntity<?> deleteProductById(@PathVariable Integer productId) {
//        return new ResponseEntity<>(productService.deleteProductById(productId), HttpStatus.OK);
//    }
//
//    @PutMapping("/edit")
//    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
//        return new ResponseEntity<>(productService.editProduct(product), HttpStatus.OK);
//    }
}
