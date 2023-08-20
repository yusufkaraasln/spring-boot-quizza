package com.quizza.api.request;


import lombok.Data;

@Data
public class SignUpRequest {


    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;


}
