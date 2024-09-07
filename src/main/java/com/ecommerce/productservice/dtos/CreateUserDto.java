package com.ecommerce.productservice.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CreateUserDto {
    private String name;
    private String email;

    public CreateUserDto() {}

    public CreateUserDto(String name, String email) {
        this.name = name;
        this.email = email;
    }


}
