package com.quizza.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UserType {
    ADMIN("admin"),
    USER("user");

    @Getter
    private String value;


}