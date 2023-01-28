package com.duagon.back.prueba.service.impl;

import com.duagon.back.prueba.helper.PriceHelper;
import com.duagon.back.prueba.model.dto.PricesDTO;
import com.duagon.back.prueba.model.entity.Prices;
import com.duagon.back.prueba.repository.PriceRepository;
import com.duagon.back.prueba.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService  {
    @Autowired
    private PriceRepository repository;

    @Autowired
    private PriceHelper priceHelper;

    @Override
    public List<PricesDTO> findPrices(String starDate, String productID, String brandID) {
        List<PricesDTO> formattedPrices = new ArrayList<>();

        Long formattedBrandID = priceHelper.parseLongID(brandID);
        Long formattedProductID = priceHelper.parseLongID(productID);
        LocalDate formattedDate = priceHelper.parseDate(starDate);

        Optional<List<Prices>> prices = repository.findByStartDateAndProductIDAndBrandID(formattedDate, formattedProductID, formattedBrandID);
        prices.ifPresent(foundPrices -> foundPrices.forEach(price -> formattedPrices.add(priceHelper.parsePriceModel2DTO(price))));

        return formattedPrices;
    }
}
