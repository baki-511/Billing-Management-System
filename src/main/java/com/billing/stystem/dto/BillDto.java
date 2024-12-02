package com.billing.stystem.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BillDto {
    private String clientMob;
    private List<BillProductDto> billProducts;
}
