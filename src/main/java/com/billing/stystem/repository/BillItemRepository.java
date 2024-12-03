package com.billing.stystem.repository;

import com.billing.stystem.entity.Bill;
import com.billing.stystem.entity.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillItemRepository extends JpaRepository<BillItem, Long> {
    //    Fetch all BillItem for a Specific bill
//    List<BillItem> findByBillId(Long billId);
    List<BillItem> findByBill(Bill bill);
}
