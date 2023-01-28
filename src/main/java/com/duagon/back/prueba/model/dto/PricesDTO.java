package com.duagon.back.prueba.model.dto;

import lombok.Data;

@Data
public class PricesDTO {

    private String brand;
    private String productID;
    private String priceList;
    private String startDate;
    private String endDate;
    private String price;
}