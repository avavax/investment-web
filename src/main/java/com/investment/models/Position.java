package com.investment.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Position<T extends Paper> {
    private T paper;
    private double currentPrice;
    private double value;
    private double diffCost;
    private double diffPercent;
    private double share;
}
