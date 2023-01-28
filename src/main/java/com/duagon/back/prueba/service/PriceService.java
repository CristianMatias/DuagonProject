package com.duagon.back.prueba.service;

import com.duagon.back.prueba.model.dto.PricesDTO;

import java.util.List;

public interface PriceService {
    List<PricesDTO> findPrices(String starDate, String productID, String brandID);
}
