package com.billing.stystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    private String clientName;
    private String email;
    private String mobile;
    
//    @JsonIgnore
//    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
//    private List<Bill> bills;
}
