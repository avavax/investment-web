package com.investment.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = {"stocks", "bonds"})
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private List<Stock> stocks;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private List<Stock> bonds;
}
