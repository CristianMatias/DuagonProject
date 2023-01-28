package com.duagon.back.prueba.helper;

import com.duagon.back.prueba.model.dto.PricesDTO;
import com.duagon.back.prueba.model.entity.Prices;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class PriceHelper {

    public Long parseLongID(String id){
        return Long.parseLong(id);
    }

    public Timestamp parseDate(String date){
        return Timestamp.valueOf(date);
    }

    public PricesDTO parsePriceModel2DTO(Prices model){
        PricesDTO dto = new PricesDTO();
        String brand = model.getBrandID().intValue() == 1 ? "Zara" : "Other";

        dto.setBrand(brand);
        dto.setPrice(model.getPrice() + " " + model.getCurr());
        dto.setPriceList(model.getPriceList());
        dto.setEndDate(String.valueOf(model.getEndDate()));
        dto.setProductID(String.valueOf(model.getProductID()));
        dto.setStartDate(String.valueOf(model.getStartDate()));

        return dto;
    }

}
