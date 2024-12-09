package com.billing.stystem.service;

import com.billing.stystem.dto.BillDateDto;
import com.billing.stystem.dto.BillDto;
import com.billing.stystem.dto.BillProductDto;
import com.billing.stystem.dto.DetailedBillingReportDTO;
import com.billing.stystem.entity.Bill;
import com.billing.stystem.entity.BillItem;
import com.billing.stystem.entity.Client;

import java.time.LocalDate;
import java.util.List;

public interface BillingService {
    public Bill createBill(Client client, List<BillItem> items);
    
    public Bill createBill(BillDto billDto);
    
    public List<Bill> getAllBills();
    
    public List<BillDateDto> getAllBillDateString();
    
    public Bill getBillById(Long billId);
    
    public List<Bill> getBillByClient(Client client);
    
    public List<BillItem> getBillItemsByBill(Bill bill);
    
    List<DetailedBillingReportDTO> getDetailedBillingReport();
    
    List<Bill> getBillReportsFromTo(LocalDate start, LocalDate end);

}
