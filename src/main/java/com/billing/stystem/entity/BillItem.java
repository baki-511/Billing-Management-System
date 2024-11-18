package com.billing.stystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BillItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billItem;
    private Integer qty;
    private Double totalPrice;
    
    @ManyToOne
    private Product product;
    
    @ManyToOne
    private Bill bill;
    
}
