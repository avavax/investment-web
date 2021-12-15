package com.investment.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bond")
public class Bond implements Paper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String symbol;
    private String company;
    private String title;
    private Integer count;
    private Double price;
    private Double cupon;
    private Double yield;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate maturity;

    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public Integer getCount() {
        return count;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
