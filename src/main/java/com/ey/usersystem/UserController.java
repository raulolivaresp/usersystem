package com.ey.usersystem;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ey.usersystem.Api.Requests;
import com.ey.usersystem.Api.Response;
import com.ey.usersystem.Model.User;
import com.ey.usersystem.Module.UserModule;
import com.ey.usersystem.Utils.ValidException;
import com.ey.usersystem.Utils.Validator;

@RestController
public class UserController {

    private Validator validator;

    private UserModule userModule;

    public UserController(UserModule userModule){
        this.validator = new Validator();
        this.userModule = userModule;
    }

    @PostMapping("/user/create")
    public Response createUser(@RequestBody Requests requests){

        validator.validEmail(requests.getEmail());
        validator.validPassword(requests.getPassword());

        User previousUser = userModule.getUser(requests.getEmail());

        if (previousUser!=null) {
            throw new ValidException("El correo ya registrado");
        } 
            
        // create user
        User user = User.builder()
                    .email(requests.getEmail())
                    .password(requests.getPassword())
                    .name(requests.getName())
                    .build();

        user.setToken(UUID.randomUUID().toString());
        user.setIsactive("True");
        user.setCreated(Date.from(Instant.now()).toString());
        user.setModified(user.getCreated());
        user.setLast_login(Date.from(Instant.now()).toString());

        userModule.saveUser(user);
                
        return Response.builder()
                .id(String.valueOf(user.getId()))
                .created(user.getCreated())
                .modified(user.getModified())
                .last_login(user.getLast_login())
                .token(user.getToken())
                .isactive(user.getIsactive())
            .build();
                

    }


    @GetMapping("/user/get")
    public User getUser(@Param("email") String email){

        User user = userModule.getUser(email);

        return user;
    }

    


}
