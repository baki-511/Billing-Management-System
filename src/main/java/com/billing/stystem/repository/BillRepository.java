package com.billing.stystem.repository;

import com.billing.stystem.entity.Bill;
import com.billing.stystem.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    @Query("select b from Bill b where b.date between :startDate and :endDate")
    List<Bill> findBillsBetweenDates(@Param("startDate") LocalDateTime startDate,
                                     @Param("endDate") LocalDateTime endDate);
    
    List<Bill> findByClient(Client client);
//    List<Bill> findClientId(Long clientId);
}
