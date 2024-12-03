package com.billing.stystem.service.impl;

import com.billing.stystem.dto.BillDto;
import com.billing.stystem.dto.BillProductDto;
import com.billing.stystem.entity.Bill;
import com.billing.stystem.entity.BillItem;
import com.billing.stystem.entity.Client;
import com.billing.stystem.entity.Product;
import com.billing.stystem.exception.BillNotFoundException;
import com.billing.stystem.repository.BillItemRepository;
import com.billing.stystem.repository.BillRepository;
import com.billing.stystem.service.BillingService;
import com.billing.stystem.service.ClientService;
import com.billing.stystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {
    @Autowired
    private BillRepository billRepository;
    
    @Autowired
    private BillItemRepository billItemRepository;
    
    @Autowired
    private ClientService clientService;
    
    @Autowired
    private ProductService productService;
    
    @Override
    public Bill createBill(Client client, List<BillItem> items) {
        Bill bill = new Bill();
        bill.setClient(client);
        bill.setDate(LocalDateTime.now());
        bill.setBillItems(items);
        return null;
    }
    
    @Override
    public Bill createBill(BillDto billDto) {
//        Get Client By ID
        Client clientByMobile = clientService.getClientByMobile(billDto.getClientMob());
        Double subTotal = 0.0;
        List<BillItem> billItems = new ArrayList<>();
        Bill bill = new Bill();
        for (BillProductDto p : billDto.getBillProducts()) {
            Product productById = productService.getProductById(p.getProductId());
            subTotal += (productById.getPrice() * p.getQty());
            
            BillItem billItem = new BillItem();
            billItem.setQty(p.getQty());
            billItem.setProduct(productById);
            billItem.setBill(bill);
            billItems.add(billItem);
        }
        Double tax = subTotal * 0.18;
        Double total = subTotal + tax;
//        Bill Section
        bill.setDate(LocalDateTime.now());
        bill.setSubTotal(subTotal);
        bill.setTax(tax);
        bill.setTotalPrice(total);
        bill.setBillItems(billItems);
        bill.setClient(clientByMobile);
        
        billRepository.save(bill);
        return bill;
    }
    
    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }
    
    @Override
    public Bill getBillById(Long billId) {
        return billRepository.findById(billId)
                .orElseThrow(() -> new BillNotFoundException(billId));
    }
    
    @Override
    public List<Bill> getBillByClient(Client client) {
        return billRepository.findByClient(client);
    }
    
    @Override
    public List<BillItem> getBillItemsByBill(Bill bill) {
        return billItemRepository.findByBill(bill);
    }
}
