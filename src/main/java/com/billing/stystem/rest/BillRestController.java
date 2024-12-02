package com.billing.stystem.rest;

import com.billing.stystem.dto.BillDto;
import com.billing.stystem.dto.BillProductDto;
import com.billing.stystem.entity.Bill;
import com.billing.stystem.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/bill")
public class BillRestController {
    @Autowired
    private BillingService billingService;
    
    @PostMapping("/save")
    public ResponseEntity<?> saveBillProducts(@RequestBody BillDto billDto) {
        System.out.println("Bill :- " + billDto);
        Bill bill = billingService.createBill(billDto);
        System.out.println("---------------------------: Final Bill Print :---------------------------");
        System.out.println(bill);
        return new ResponseEntity<>("Saved Successfully", HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> getAllBills() {
        return new ResponseEntity<>(billingService.getAllBills(), HttpStatus.OK);
    }
}
