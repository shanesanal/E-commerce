package com.ecommerce.productservice.controllers;


import com.ecommerce.productservice.commons.AuthenticationCommons;
import com.ecommerce.productservice.dtos.GetProductDto;
import com.ecommerce.productservice.dtos.UserDto;
import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private ProductService productService;
    private AuthenticationCommons authenticationCommons;
    public ProductController(ProductService productService, AuthenticationCommons authenticationCommons) {
        this.productService = productService;
        this.authenticationCommons = authenticationCommons;
    }


    @GetMapping("/{id}/{token}")
    public @ResponseBody GetProductDto getProductById(@PathVariable("id") Long id,@PathVariable("token") String token) throws Exception
    {
       UserDto userDto = authenticationCommons.validateToken(token);

       if (userDto == null) {
           throw new Exception("Invalid Token");     }
        return productService.getProductById(id);
    }

    @GetMapping({"{token}"})
    public @ResponseBody List<GetProductDto> getAllProducts(@PathVariable("token") String token) throws Exception
    {
        UserDto userDto = authenticationCommons.validateToken(token);

        if (userDto == null) {
            throw new Exception("Invalid Token");     }
        return productService.getAllProducts();
    }


    //@RequestBody Product product => converts the recieved json to a Product java object
    @PostMapping("")
    public String createProducts(@RequestBody Product product)
    {

        System.out.println(product.getCategory());
        System.out.println(product.getTitle());
        System.out.println(product.getPrice());

        return "Product Created";
    }
}
