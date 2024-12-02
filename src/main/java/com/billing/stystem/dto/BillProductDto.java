package com.billing.stystem.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BillProductDto {
    private Integer productId;
    private Integer qty;
}
