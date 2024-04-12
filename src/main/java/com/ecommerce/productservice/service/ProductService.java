package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dtos.GetProductDto;
import com.ecommerce.productservice.exceptions.NotFoundException;
import com.ecommerce.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProductService {

    public GetProductDto getProductById(Long id) throws NotFoundException {


        RestTemplate restTemplate = new RestTemplate();

        String url = "https://fakestoreapi.com/products/" + id;
        Product product = restTemplate.getForObject(url, Product.class);

        System.out.println(product);
        if(product==null)
        {
            throw new NotFoundException();
        }


        GetProductDto obj = convertToDto(product);

        return obj;
    }

    private static GetProductDto convertToDto(Product product) {
        GetProductDto obj = new GetProductDto();
        obj.setName(product.getTitle());
        obj.setPrice(product.getPrice());
        obj.setImageUrl(product.getImage());
        return obj;
    }

    public List<GetProductDto> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products";
        Product[] products = restTemplate.getForObject(url, Product[].class);

        List<GetProductDto> returnedProducts = new ArrayList<>();

        for(Product product : products) {

            returnedProducts.add(convertToDto(product));
        }
        return returnedProducts;

    }
}
