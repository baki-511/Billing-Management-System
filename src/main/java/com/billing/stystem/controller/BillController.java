package com.billing.stystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bill")
public class BillController {
    
    
    @GetMapping("/generate-bill")
    public String generateBill() {
        return "/pages/generate-bill";
    }
}
