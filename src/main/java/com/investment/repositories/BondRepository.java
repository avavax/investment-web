package com.investment.repositories;

import com.investment.models.Bond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BondRepository extends JpaRepository<Bond, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM bond b LEFT JOIN country con ON b.country_id = con.id WHERE b.user_id = ?1")
    List<Bond> findAllByUserId(Integer UserId);
}