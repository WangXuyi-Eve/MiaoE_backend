package com.example.wrdemo.repository;
import com.example.wrdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer>{
    List<User> findByUsername(String username);
    User findByUserId(int userId);
}
