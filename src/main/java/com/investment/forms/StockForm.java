package com.investment.forms;

import lombok.Data;

import javax.validation.constraints.Min;
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
    @Min(1)
    private Integer count;
    @NotNull
    @Min(0)
    private Double price;
    @NotNull
    private Integer country;
    @NotNull
    private Integer sector;
}
