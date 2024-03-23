package com.scherba.telegrambot.repository;

import com.scherba.telegrambot.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//@Repository
//public class CurrencyRep {
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public CurrencyRep(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//    public void save(Currency currency) {
//        jdbcTemplate.update("INSERT INTO crypto_currency (name, price) VALUES (?,?)",
//        currency.getName(), currency.getPrice());
//    }
//
//    public Currency findById(Long id) {
//        return jdbcTemplate.queryForObject("SELECT * FROM crypto_currency WHERE id = ?",
//                new Object[]{id},
//                (rs, rowNum) ->
//                        new Currency(rs.getLong("id"),rs.getString("name"), rs.getDouble("price")));
//    }
//}
