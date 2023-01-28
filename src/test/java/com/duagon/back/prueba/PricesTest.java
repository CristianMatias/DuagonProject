package com.duagon.back.prueba;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.duagon.back.prueba.controller.MainController;
import com.duagon.back.prueba.model.dto.PricesDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PricesTest {
    @Autowired
    MainController controller;

    PricesDTO expectedResult;

    @Before
    public void prepareExpectedResult() {
        expectedResult = new PricesDTO();
        expectedResult.setBrand("Zara");
        expectedResult.setProductID("35455");
    }

    @Test
    public void firstTest() {
        System.out.println("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)");

        expectedResult.setStartDate("2020-06-14 10:00:00.0");
        expectedResult.setPriceList("4");
        expectedResult.setPrice("38.95 EUR");
        expectedResult.setEndDate("2020-12-31 23:59:59.0");
        PricesDTO actualResult = controller.findPrices("2020-06-14 10:00:00","35455","1");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void secondTest(){
        System.out.println("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)");

        expectedResult.setStartDate("2020-06-14 16:00:00.0");
        expectedResult.setPriceList("1");
        expectedResult.setPrice("35.5 EUR");
        expectedResult.setEndDate("2020-12-31 23:59:59.0");

        PricesDTO actualResult = controller.findPrices("2020-06-14 16:00:00","35455","1");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void thirdTest(){
        System.out.println("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)");

        expectedResult.setStartDate("2020-06-14 21:00:00.0");
        expectedResult.setPriceList("2");
        expectedResult.setPrice("25.45 EUR");
        expectedResult.setEndDate("2020-06-14 18:30:00.0");
        PricesDTO actualResult = controller.findPrices("2020-06-14 21:00:00","35455","1");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void fourthTest(){
        System.out.println("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)");

        expectedResult.setStartDate("2020-06-15 10:00:00.0");
        expectedResult.setPriceList("3");
        expectedResult.setEndDate("2020-06-15 11:00:00.0");
        expectedResult.setPrice("30.5 EUR");
        PricesDTO actualResult = controller.findPrices("2020-06-15 10:00:00","35455","1");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void fifthTest(){
        System.out.println("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)");

        PricesDTO actualResult = controller.findPrices("2020-06-16 21:00:00","35455","1");

        //There is no record in the DB with this date
        assertNull(actualResult);
    }
}
