package com.example.demo.repository;

import com.example.demo.dto.UsersDTO;
import com.example.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    public Users findByEmail(String email);


}
