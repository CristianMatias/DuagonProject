package com.duagon.back.prueba.repository;

import com.duagon.back.prueba.model.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Prices, Long> {
    Optional<List<Prices>> findByStartDateAndProductIDAndBrandID(LocalDate startDate, Long productID, Long brandID);
}
