package com.ey.usersystem.Api;


import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Requests {
    
    private String name;
    private String email;
    private String password;
    private List<RequestsPhones> phones;

}
