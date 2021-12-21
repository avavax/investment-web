package com.investment.forms;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class BondForm {
    private Integer id;
    @NotEmpty
    private String symbol;
    @NotEmpty
    private String title;
    @NotEmpty
    private String company;
    @NotNull
    @Min(1)
    private Integer count;
    @NotNull
    @Min(0)
    private Double price;
    @NotNull
    private Double cupon;
    @NotNull
    private Double yield;
    @NotNull
    private LocalDate maturity;
    @NotNull
    private Integer country;

}
