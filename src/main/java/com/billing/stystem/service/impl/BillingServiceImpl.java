package com.billing.stystem.service.impl;

import com.billing.stystem.entity.Bill;
import com.billing.stystem.entity.BillItem;
import com.billing.stystem.entity.Client;
import com.billing.stystem.repository.BillRepository;
import com.billing.stystem.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {
    @Autowired
    private BillRepository billRepository;
    
    @Override
    public Bill createBill(Client client, List<BillItem> items) {
        Bill bill = new Bill();
        bill.setClient(client);
        bill.setDate(LocalDateTime.now());
        bill.setBillItems(items);
        return null;
    }
}
