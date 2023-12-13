package org.example.product_shop.entities;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private BigDecimal price;

    @ManyToOne
    private User seller;

    @ManyToOne
    private User buyer;


}
