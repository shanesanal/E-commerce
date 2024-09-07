package com.ecommerce.productservice.commons;

import com.ecommerce.productservice.config.AppConfig;
import com.ecommerce.productservice.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationCommons {

    private RestTemplate restTemplate;

    public AuthenticationCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public UserDto validateToken(String token) {
        UserDto responseEntity = restTemplate.getForObject("http://localhost:8081/users/validate-token" + token, UserDto.class);


        return responseEntity;
    }
}







