package com.billing.stystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Integer productId;
    private String prodName;
    private Double price;
    private Integer stock;
    private String description;
    private Integer categoryId;
}
