package com.ey.usersystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ey.usersystem.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    User findById(int id);

    User findByEmail(String email);
    
}
