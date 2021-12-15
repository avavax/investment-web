package com.investment.models;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "stock")
public class Stock implements Paper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String symbol;
    private String company;
    private Integer count;
    private Double price;

    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sector_id")
    private Sector sector;

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
