package com.duagon.back.prueba.service;

import com.duagon.back.prueba.model.dto.PricesDTO;

public interface PriceService {
    PricesDTO findPrices(String starDate, String productID, String brandID);
}
