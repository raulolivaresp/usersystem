package com.ey.usersystem.Utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidException extends RuntimeException{

    private String message;

    public ValidException(String message){
        this.message = message;
    }
    
}
