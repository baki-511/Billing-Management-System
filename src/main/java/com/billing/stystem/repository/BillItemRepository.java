package com.billing.stystem.repository;

import com.billing.stystem.entity.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillItemRepository extends JpaRepository<BillItem,Long> {
}
