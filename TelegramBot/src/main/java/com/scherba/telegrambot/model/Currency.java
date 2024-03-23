package com.scherba.telegrambot.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
//public class Currency {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private double price;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public Currency() {
//    }
//
//    public Currency(Long id, String name, double price) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//    }
//
//    @Override
//    public String toString() {
//        return "Currency{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                '}';
//    }
//}

@Data
public class Currency {
    String symbol;
    Double price;

}
