package com.adifferentcolour.starter.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long dbId = 0L;

    @Size(max = 32)
    @NotNull
    private String id;

    @Size(max = 100)
    @NotNull
    private String name;

    @NotNull
    private int usdPrice;
}
