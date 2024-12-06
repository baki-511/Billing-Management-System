package com.billing.stystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetailedBillingReportDTO {
    private Long billId;
    private LocalDateTime date;
    private String clientName;
    private String productName;
    private Integer quantity;
    private Double subtotal;
    private Double totalAmount;
}
