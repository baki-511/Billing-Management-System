package com.billing.stystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString
public class BillItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billItem;
    private Integer qty;
    
    @ManyToOne
    private Product product;
    
    @JsonIgnore
    @ManyToOne
    private Bill bill;
    
}
