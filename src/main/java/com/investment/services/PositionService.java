package com.investment.services;

import com.investment.models.Paper;
import com.investment.models.Position;

import java.util.List;

public interface PositionService {
    //<T extends Paper> Position<T> getOnePosition(T paper);
    <T extends Paper> List<Position<T>> getListPosition(List<T> paperList);
}
