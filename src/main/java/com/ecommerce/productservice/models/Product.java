package com.ecommerce.productservice.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    public String name;
    private String description;
    public Double price;
    private String imageUrl;
    private String category;

}