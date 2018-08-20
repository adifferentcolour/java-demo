package com.adifferentcolour.starter.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "packages")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 250)
    private String description;

    @NotNull
    private int totalPrice;

    @OneToMany(cascade = CascadeType.ALL)
    @ElementCollection(targetClass = Product.class)
    @JoinColumn(name = "products_id")
    private List<Product> products = new ArrayList<>();

}
