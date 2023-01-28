package com.duagon.back.prueba.helper;

import com.duagon.back.prueba.model.dto.PricesDTO;
import com.duagon.back.prueba.model.entity.Prices;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class PriceHelper {

    public Long parseLongID(String id){
        return Long.parseLong(id);
    }

    public LocalDate parseDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDate.parse(date, formatter);
    }

    public PricesDTO parsePriceModel2DTO(Prices model){
        PricesDTO dto = new PricesDTO();
        String brand = model.getBrandID().intValue() == 1 ? "Zara" : "Other";

        dto.setBrand(brand);
        dto.setPrice(String.valueOf(model.getPrice()));
        dto.setPriceList(model.getPriceList());
        dto.setEndDate(String.valueOf(model.getEndDate()));
        dto.setProductID(String.valueOf(model.getProductID()));
        dto.setStartDate(String.valueOf(model.getStartDate()));

        return dto;
    }

}
