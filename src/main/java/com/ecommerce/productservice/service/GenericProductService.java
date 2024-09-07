package com.ecommerce.productservice.service;

import com.ecommerce.productservice.models.GenericProduct;
import com.ecommerce.productservice.repository.GenericProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GenericProductService {
    private final GenericProductRepository genericProductRepository;

    public GenericProductService(GenericProductRepository genericProductRepository){
        this.genericProductRepository = genericProductRepository;
    }



    private static final String[] PRODUCT_NAMES ={
            "TV", "Laptop", "Mobile", "Tablet",
            "Smart Watch", "Headphones", "Camera",
            "Printer", "Monitor", "Keyboard", "Mouse"
            ,"Speaker", "Projector", "Router", "Modem",
            "Smart Home Device", "Smart Bulb", "Smart Plug",
            "Smart Switch", "Smart Thermostat", "Smart Lock"
    };

    public boolean generateProductData(){
        List<GenericProduct> productList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < PRODUCT_NAMES.length; i++) {
            String productName = PRODUCT_NAMES[i];
            int price = random.nextInt(10000);
            GenericProduct genericProduct = new GenericProduct(productName, price);
            productList.add(genericProduct);
        }

        genericProductRepository.saveAll(productList);
        return true;
    }

    public List<GenericProduct> searchProducts(String query) {
        return genericProductRepository.findByNameContainingIgnoreCase(query);
    }

    public Page<GenericProduct> searchProductsByPagination(String query, int pageNumber, int pageSize) {
        return genericProductRepository.findByNameContainingIgnoreCase(query, PageRequest.of(pageNumber, pageSize));
    }

}
