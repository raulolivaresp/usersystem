package com.ey.usersystem.Api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Response {

    private String id;
    private String created;
    private String modified;
    private String last_login;

    private String token;
    private String isactive;



}
