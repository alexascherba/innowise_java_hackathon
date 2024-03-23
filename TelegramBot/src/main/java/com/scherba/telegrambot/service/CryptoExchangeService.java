package com.scherba.telegrambot.service;

import com.scherba.telegrambot.model.Currency;
import org.json.JSONObject;
import org.springframework.expression.ParseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

//public class CryptoExchangeService {
//    private final RestTemplate restTemplate;
//
//    public CryptoExchangeService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//    public String getBitcoinPrice() {
//        String apiUrl = "https://api.coindesk.com/v1/bpi/currentprice/BTC.json";
//        return restTemplate.getForObject(apiUrl, String.class);
//    }
//}

public class CryptoExchangeService {
    public static String getCurrencyRate(String message, Currency model) throws IOException, ParseException {
        URL url = new URL("https://api.mexc.com/api/v3/ticker/price");
        Scanner scanner = new Scanner((InputStream) url.getContent());
        String result = "";
        while (scanner.hasNext()){
            result +=scanner.nextLine();
        }
        JSONObject object = new JSONObject(result);

        model.setSymbol(object.getString("symbol"));
        model.setPrice(object.getDouble("price"));

        return "Crypto " + model.getSymbol() + "\n" +
                "is: " + model.getPrice();
    }

}
