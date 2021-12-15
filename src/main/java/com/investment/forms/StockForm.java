package com.investment.forms;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class StockForm {
    private Integer id;
    @NotEmpty
    private String symbol;
    @NotEmpty
    private String company;
    @NotNull
    private Integer count;
    @NotNull
    private Double price;
    @NotNull
    private Integer country;
    @NotNull
    private Integer sector;
}
