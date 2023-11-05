package com.ey.usersystem.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EYUSER")
public class User {
    
    @Id
    private int id;
    
    private String name;
    private String email;
    private String password;
    private String token;


    private String created;
    private String modified;
    private String last_login;

    private String isactive;
    

}
