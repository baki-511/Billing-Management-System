package com.billing.stystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;
    private LocalDateTime date;
    private Double subTotal;
    private Double tax;
    private Double totalPrice;
    
    @ManyToOne
    private Client client;
    
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<BillItem> billItems;
}
