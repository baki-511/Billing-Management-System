package com.billing.stystem.controller;

import com.billing.stystem.dto.ProductDto;
import com.billing.stystem.entity.Category;
import com.billing.stystem.entity.Product;
import com.billing.stystem.service.CategoryService;
import com.billing.stystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;
    
    @Autowired
    private CategoryService categoryService;
    
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/create-product")
    public String addProduct(Model model) {
        model.addAttribute("product", new ProductDto());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "/pages/add-product";
    }
    
    @PostMapping("/product/add")
    public String addProduct(@ModelAttribute ProductDto productDto,
                             @RequestParam("imageFile") MultipartFile imageFile) {
        System.out.println("1");
        System.out.println("Category ID : " + productDto.getCategoryId());
        System.out.println("Stock : " + productDto.getStock());
        productService.addProduct(productDto, imageFile);
        return "redirect:/create-product";
    }
    
    @GetMapping("/create-category")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "/pages/add-category";
    }
    
    @PostMapping("/category/add")
    public String addCategory(@ModelAttribute Category category) {
        categoryService.createCategory(category);
        return "redirect:/create-category";
    }
    
}
