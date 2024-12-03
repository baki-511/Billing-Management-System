package com.billing.stystem.controller;

import com.billing.stystem.entity.Bill;
import com.billing.stystem.entity.Client;
import com.billing.stystem.service.BillingService;
import com.billing.stystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private ClientService clientService;
    
    @Autowired
    private BillingService billingService;
    
    @GetMapping("/generate-bill")
    public String generateBill() {
        return "/pages/generate-bill";
    }
    
    @GetMapping("/client-bill/{billId}")
    public String clientBill(@PathVariable Long billId, Model model) {
        Bill billById = billingService.getBillById(billId);
        model.addAttribute("bill", billById);
        String format = billById.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        model.addAttribute("date", format);
        return "/pages/client-bill";
    }
    
}
