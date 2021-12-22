package com.investment.services;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Класс сервиса для получения курса ценной бумаги из внешних ресурсов
 * @author Илья Петров
 * @version 1.0
 */
@Component
public class PriceServiceImpl implements PriceService {

    /** Константа - url-адрес API БКС */
    private static final String BASE_BCS_API_URL = "https://api.bcs.ru/udfdatafeed/v1/quotes?symbols=";

    /** Константа - url-адрес API ЦБ РФ */
    private static final String CBRF_API_URL = "https://www.cbr-xml-daily.ru/daily_json.js";

    /** Константа для идентификации цен в рублях */
    private static final String RUB_ZONE_EXCHANGE = "MOEX";

    /** Точка входа в API, для создания и выполнения клиентских запросов */
    private final Client client;

    /**
     * Конструктор объекта
     */
    public PriceServiceImpl() {
        client = ClientBuilder.newClient();
    }

    /**
     * Метод получения текущей цены ценной бумаги
     * @param symbol - тикер акции или облигации
     * @return - значение текущей цены
     */
    public Double getPaperPrice(String symbol) {
        Response response = client.target(BASE_BCS_API_URL + symbol.toLowerCase())
                .request(MediaType.TEXT_PLAIN_TYPE)
                .get();

        if (response.getStatus() != 200) {
            return 0.0;
        }

        Double finalPrice;
        try {
            JSONObject priceJsonObject = (JSONObject) JSONValue.parseWithException(response.readEntity(String.class));
            JSONObject priceJsonObjectD = (JSONObject) priceJsonObject.get("d");
            JSONObject priceJsonObjectV = (JSONObject) priceJsonObjectD.get("v");
            Double price = ((Number) priceJsonObjectV.get("bid")).doubleValue();
            String exchange = (String) priceJsonObjectV.get("exchange");
            finalPrice = getPriceWithCurrency(price, exchange);
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
        return finalPrice;
    }

    /**
     * Метод расчёта цены бумаги с учётом валюты
     * @param price - исходная цена
     * @param payZone - валютная зона
     * @return - цена бумаги, приведённая к рублям
     */
    private Double getPriceWithCurrency(Double price, String payZone) {
        Double course;
        if (payZone.equals(RUB_ZONE_EXCHANGE)) {
            return price;
        }
        course = getCurrencyCourse("USD");
        return price * course;
    }

    /**
     * Метод для получения текущего курса рубля к иностранной валюте
     * @param symbol - обозначение валюты
     * @return - курс рубля
     */
    private Double getCurrencyCourse(String symbol) {
        Response response = client.target(CBRF_API_URL)
                .request(MediaType.TEXT_PLAIN_TYPE)
                .get();

        if (response.getStatus() != 200) {
            return 0.0;
        }

        Double course;
        try {
            JSONObject priceJsonObject = (JSONObject) JSONValue.parseWithException(response.readEntity(String.class));
            JSONObject priceJsonObjectValute = (JSONObject) priceJsonObject.get("Valute");
            JSONObject priceJsonObjectCurrency = (JSONObject) priceJsonObjectValute.get(symbol);
            course = (Double) priceJsonObjectCurrency.get("Value");
        } catch (Exception e) {
            e.printStackTrace();
            return 1.0;
        }
        return course;
    }
}
