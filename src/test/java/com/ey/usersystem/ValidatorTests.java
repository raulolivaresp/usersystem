package com.ey.usersystem;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ey.usersystem.Utils.ValidException;
import com.ey.usersystem.Utils.Validator;

public class ValidatorTests {

    private Validator validator;


    @BeforeEach
    void setup(){
        validator = new Validator();
    }

    @Test
    void testValidEmail(){
        String email = "rau122l@raul.cl";

        assertDoesNotThrow(() -> validator.validEmail(email));
    }

    @Test
    void testBadEmail(){
        String email = "rau122l@23234";

        assertThrows(ValidException.class, () -> validator.validEmail(email));
    }

    @Test
    void testValidPassword(){
        String password = "Raul123";

        assertDoesNotThrow(() -> validator.validPassword(password));
    }

    @Test
    void testBadPassword(){
        String password = "raul";

        assertThrows(ValidException.class, () -> validator.validPassword(password));
    }

}
