package com.investment.repositories;

import com.investment.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM account WHERE email = ?1")
    Optional<User> findOneByLogin(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM account id WHERE visible = 1 ORDER BY id")
    List<User> findAllVisible();

    @Query(nativeQuery = true, value = "UPDATE account SET visible = 0 WHERE id = ?1")
    void softDelete(Integer userId);
}


