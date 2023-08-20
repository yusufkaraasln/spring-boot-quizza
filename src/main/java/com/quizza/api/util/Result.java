package com.quizza.api.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Result<T> {
    private boolean success;
    private String message;
    private T data;


}


