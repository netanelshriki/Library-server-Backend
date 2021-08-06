package com.net.demoTokenLib.exceptions;

import lombok.Getter;

@Getter
public enum ErrorMsg {
    ID_ALREADY_EXIST("sorry this id is already exist"),
    UNAUTHORIZED("email or password are wrong..."),
    EMAIL_ALREADY_EXIST("email already exist"),
    CONTROLLER_NOT_ALLOWED("you have not permission to play here"),
    INVALID_EMAIL_OR_PASS("Invalid email or password");


    private String description;


    ErrorMsg(String description) {
        this.description = description;
    }
}
