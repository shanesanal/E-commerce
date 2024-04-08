package com.ecommerce.productservice.controllers;


import com.ecommerce.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {


    @GetMapping("/{id}/{temp}")
    public String getProductById(@PathVariable("id") Long id,@PathVariable("temp") String x)
    {
        return "The product id is " + id + x;
    }
    //@RequestBody Product product => converts the recieved json to a Product java object
    @PostMapping("")
    public String createProducts(@RequestBody Product product)
    {

        System.out.println(product.getCategory());
        System.out.println(product.getName());
        System.out.println(product.getId());

        return "Product Created";
    }
}
