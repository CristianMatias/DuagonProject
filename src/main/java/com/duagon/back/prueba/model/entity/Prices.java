package com.duagon.back.prueba.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;


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
    private Timestamp startDate;

    @Column(name = "END_DATE")
    private Timestamp endDate;

    @Column(name = "PRICE_LIST", nullable = false)
    private String priceList;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productID;

    @Column(name = "PRIORITY", nullable = false)
    private String priority;

    @Column(name = "PRICE", nullable = false)
    private Float price;

    @Column(name = "CURR", nullable = false)
    private String curr;
}
