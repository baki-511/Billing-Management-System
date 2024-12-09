package com.billing.stystem.dto;

import com.billing.stystem.entity.BillItem;
import com.billing.stystem.entity.Client;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BillDateDto {
    private Long billId;
    private String date;
    private Double subTotal;
    private Double tax;
    private Double totalPrice;
    
    private Client client;
    
    private List<BillItem> billItems;
}
