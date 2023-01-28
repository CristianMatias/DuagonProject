package com.duagon.back.prueba.controller;

import com.duagon.back.prueba.model.dto.PricesDTO;
import com.duagon.back.prueba.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/search")
    public PricesDTO findPrices(@RequestParam("startDate") String startDate,
                                      @RequestParam("productId") String productId,
                                      @RequestParam("brandId") String brandId){
        return priceService.findPrices(startDate, productId, brandId);
    }

    @GetMapping()
    public String main(){
        return "Start";
    }
}
