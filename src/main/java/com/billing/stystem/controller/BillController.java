package com.billing.stystem.controller;

import com.billing.stystem.dto.BillDateDto;
import com.billing.stystem.entity.Bill;
import com.billing.stystem.entity.Client;
import com.billing.stystem.service.BillingService;
import com.billing.stystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    
    @GetMapping("/billing-report")
    public String billingReport(Model model) {
        List<Bill> allBills = billingService.getAllBills();
        model.addAttribute("billingReport", allBills);
        return "/pages/billing-report";
    }
    
    @GetMapping("/all-bills")
    public String getAllBills(Model model) {
        List<BillDateDto> allBills = billingService.getAllBillDateString();
        model.addAttribute("bills", allBills);
        return "/pages/all-bills";
    }
    
    @GetMapping("/client/{clientId}")
    public String getAllBillsByClient(@PathVariable Integer clientId, Model model) {
        Client clientById = clientService.getClientById(clientId);
        model.addAttribute("client", clientById);
        model.addAttribute("bills", billingService.getBillByClient(clientById));
        return "/pages/client-billing-report";
    }
    
    @GetMapping("/all-clients")
    public String getAllClients(Model model) {
        List<Client> allClients = clientService.getAllClients();
        model.addAttribute("clients", allClients);
        return "/pages/all-client-reports";
    }
    
    @GetMapping("/get-bills")
    public String getAllBills(@Param("start") LocalDate start,
                              @Param("end") LocalDate end,
                              Model model) {
        List<Bill> billReportsFromTo = new ArrayList<>();
        if (start == null && end == null) {
            billReportsFromTo = billingService.getAllBills();
        } else if (start == null) {
            billReportsFromTo = billingService.getBillReportsFromTo(start, end);
        } else if (end == null) {
            billReportsFromTo = billingService.getBillReportsFromTo(start, end);
        } else {
            billReportsFromTo = billingService.getBillReportsFromTo(start, end);
        }
        model.addAttribute("billingReport", billReportsFromTo);
        return "/pages/billing-report";
    }
}
