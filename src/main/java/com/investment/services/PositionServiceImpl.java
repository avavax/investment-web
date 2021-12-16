package com.investment.services;

import com.investment.models.Bond;
import com.investment.models.Position;
import com.investment.models.Paper;
import com.investment.models.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс сервиса для работы с позициями портфеля (Position)
 * @author Илья Петров
 * @version 1.0
 */
@Component
public class PositionServiceImpl implements PositionService {

    /** Константа, показывающая число знаков после запятой при округлении double-типов */
    private static final int ROUND_PARAM = 100;

    /** Сервис для работы с ценами */
    @Autowired
    private PriceService priceService;

    /**
     * Метод возвращает список позиций на основе списка ценных бумаг
     * @param paperList список ценных бумаг
     * @param <T> - принимаемый тип (Bond или Stock), наследники Paper
     * @return - список позиций
     */
    public <T extends Paper> List<Position<T>> getListPosition(List<T> paperList) {
        double sum = 0.0;
        List<Position<T>> positions = new ArrayList<>();
        for (T secure : paperList) {
            Position<T> position = getOnePosition(secure);
            positions.add(position);
            sum += position.getValue();
        }
        for (Position<T> position : positions) {
            position.setShare(getPrettifyNumberView(position.getValue() * 100 / sum));
        }
        return positions;
    }

    /**
     * Метод возвращает одну позицию на основе одной ценной бумаги
     * @param paper - ценная бумага
     * @param <T> - принимаемый тип (Bond или Stock), наследники Paper
     * @return - позиция
     */
    private <T extends Paper> Position<T> getOnePosition(T paper) {
        String symbol = paper.getSymbol();
        double currentPrice = getPrettifyNumberView(priceService.getPaperPrice(symbol));
        if (currentPrice == 0.0) {
            currentPrice = paper.getPrice();
        }
        if (paper instanceof Bond) {
            currentPrice *= 10.0;
        }
        double value = getPrettifyNumberView(currentPrice * paper.getCount());
        double diffCost = getPrettifyNumberView((currentPrice - paper.getPrice()) * paper.getCount());
        double diffPercent = getPrettifyNumberView(diffCost * 100 / value);
        double share = 100.0;
        return new Position<>(paper, currentPrice, value, diffCost, diffPercent, share);
    }

    /**
     * Метод для округления double-числа до ROUND_PARAM знаков после запятой
     * @param num - входное число
     * @return - округлённое число
     */
    private static double getPrettifyNumberView(Double num) {
        return Math.round(num * ROUND_PARAM) / ROUND_PARAM;
    }
}
