package com.duagon.back.prueba.repository;

import com.duagon.back.prueba.model.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Prices, Long> {
    Optional<Prices> findByStartDateAndProductIDAndBrandID(Timestamp startDate, Long productID, Long brandID);
}
