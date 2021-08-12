package com.example.wattawatchapi.services;

import com.example.wattawatchapi.models.usersModel;
import com.example.wattawatchapi.repositories.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class usersService {

    @Autowired
    private usersRepository userRepository;

    public Optional<usersModel> findById(String id) {
        return userRepository.findById(id);
    }

}
