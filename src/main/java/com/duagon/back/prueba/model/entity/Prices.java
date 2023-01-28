package com.duagon.back.prueba.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
@Table(name = "prices")
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long priceID;

    @Column(name = "BRAND_ID", nullable = false)
    private Long brandID;

    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "PRICE_LIST", nullable = false)
    private String priceList;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productID;

    @Column(name = "PRIORITY", nullable = false)
    private String priority;

    @Column(name = "PRICE", nullable = false)
    private Integer price;

    @Column(name = "CURR", nullable = false)
    private String curr;
}
