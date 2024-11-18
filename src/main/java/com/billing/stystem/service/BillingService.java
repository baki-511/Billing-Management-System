package com.billing.stystem.service;

import com.billing.stystem.entity.Bill;
import com.billing.stystem.entity.BillItem;
import com.billing.stystem.entity.Client;

import java.util.List;

public interface BillingService {
    public Bill createBill(Client client, List<BillItem> items);

}
