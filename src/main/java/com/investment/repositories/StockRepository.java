package com.investment.repositories;

import com.investment.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM stock s LEFT JOIN country con ON s.country_id = con.id LEFT JOIN sector sec ON s.sector_id = sec.id WHERE s.user_id = ?1")
    List<Stock> findAllByUserId(Integer UserId);
}
