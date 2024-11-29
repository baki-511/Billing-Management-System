package com.billing.stystem.controller;

import com.billing.stystem.dto.ProductDto;
import com.billing.stystem.entity.Category;
import com.billing.stystem.entity.Product;
import com.billing.stystem.service.CategoryService;
import com.billing.stystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping({"/", "/home"})
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
        productService.addProduct(productDto, imageFile);
        return "redirect:/create-product";
    }
    
    @GetMapping("product/edit/{productId}")
    public String editProduct(@PathVariable Integer productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "/pages/edit-product";
    }
    
    @PostMapping("/product/edit")
    public String editProduct(@ModelAttribute ProductDto productDto,
                             @RequestParam("imageFile") MultipartFile imageFile) {
        System.out.println("Product ID : "+productDto.getProductId());
        productService.updateProduct(productDto, imageFile);
        return "redirect:/product/all";
    }
    
    @GetMapping("/product/delete/{productId}")
    public String deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
        return "redirect:/product/all";
    }
    
    @GetMapping("/product/all")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "/pages/all-product";
    }
    
    @GetMapping("/category/all")
    public String getAllCategory(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "/pages/all-category";
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
    
    @GetMapping("/category/edit/{categoryId}")
    public String editCategory(@PathVariable Integer categoryId, Model model) {
        model.addAttribute("category", categoryService.getCategoryById(categoryId));
        return "/pages/edit-category";
    }
    
    @PostMapping("/category/edit")
    public String editCategory(@ModelAttribute Category category) {
        categoryService.updateCategory(category);
        return "redirect:/category/all";
    }
    
    @GetMapping("/category/delete/{categoryId}")
    public String deleteCategory(@PathVariable Integer categoryId) {
        categoryService.deleteCategoryById(categoryId);
        return "redirect:/category/all";
    }
    
}
