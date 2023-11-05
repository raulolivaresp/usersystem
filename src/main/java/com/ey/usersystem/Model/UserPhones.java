package com.ey.usersystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class UserPhones {

    @Id
    private String id;
    private String number;
    private String citycode;
    private String contrycode;
    
}
