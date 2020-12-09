package com.atguigu.pojo;

public class CriteriaBook {
    private Double minPrice;
    private Double maxPrice;
    private String name;
    private String author;
    private Integer sales;
    private Integer stock;

    @Override
    public String toString() {
        return "CriteriaBook{" +
                "minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", sales=" + sales +
                ", stock=" + stock +
                '}';
    }

    public String getName() {
        if (name==null||name.length()==0){
            return "%%";
        }
        return "%"+name+"%";
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getAuthor() {
        if (author==null||author.length()==0){
            return "%%";
        }
        return "%"+author+"%";
    }

    public void setAuthor(String author) {
        this.author = author.trim();
    }

    public Integer getSales() {
        if (sales == null) {
            return 0;
        }
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public CriteriaBook(Double minPrice, Double maxPrice, String name, String author, Integer sales, Integer stock) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.name = name;
        this.author = author;
        this.sales = sales;
        this.stock = stock;
    }

    public Double getMinPrice() {
        if (minPrice == null) {
            return 0.0;
        }
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        if (maxPrice == null||maxPrice==0.0) {
            return Double.MAX_VALUE;
        }
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public CriteriaBook(Double minPrice, Double maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public CriteriaBook() {
    }
}
