package com.billing.stystem.controller;

import com.billing.stystem.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private BillingService billingService;
    
    @GetMapping("/show-all")
    public String showReports() {
        return "/pages/reports";
    }
    
}
