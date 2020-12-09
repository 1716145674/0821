package com.atguigu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
public class Book {
    private Integer id;

    private String name;

    private String author;

    private BigDecimal price;

    private Integer sales;

    private Integer stock;
}
