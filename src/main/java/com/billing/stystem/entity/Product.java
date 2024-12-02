package com.billing.stystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String prodName;
    private Double price;
    private Integer stock;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    @JsonIgnore
    private String image;
    
//    @Override
//    public String toString() {
//        return "Product{" +
//                "productId=" + productId +
//                ", prodName='" + prodName + '\'' +
//                ", price=" + price +
//                ", stock=" + stock +
//                ", description='" + description + '\'' +
//                '}';
//    }
}
