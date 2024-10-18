package com.unam.poo.dto;
 
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto { 
    
    private String mail;

    private String telephone;

    private String description;

    private Long dni;   

    private String name;

    private String lastname;

    private String password;

    private Long city;
}
