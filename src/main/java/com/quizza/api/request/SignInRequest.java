package com.quizza.api.request;

import lombok.*;

@Data
public class SignInRequest {
    private String email;
    private String password;

}