package com.duagon.back.prueba.service.impl;

import com.duagon.back.prueba.helper.PriceHelper;
import com.duagon.back.prueba.model.dto.PricesDTO;
import com.duagon.back.prueba.model.entity.Prices;
import com.duagon.back.prueba.repository.PriceRepository;
import com.duagon.back.prueba.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService  {
    @Autowired
    private PriceRepository repository;

    @Autowired
    private PriceHelper priceHelper;

    @Override
    public PricesDTO findPrices(String starDate, String productID, String brandID) {

        Long formattedBrandID = priceHelper.parseLongID(brandID);
        Long formattedProductID = priceHelper.parseLongID(productID);
        Timestamp formattedDate = priceHelper.parseDate(starDate);

        Optional<Prices> prices = repository.findByStartDateAndProductIDAndBrandID(formattedDate, formattedProductID, formattedBrandID);
        return prices.map(value -> priceHelper.parsePriceModel2DTO(value)).orElse(null);
    }
}
