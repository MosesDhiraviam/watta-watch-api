package com.example.wattawatchapi.repositories;

import com.example.wattawatchapi.models.usersModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface usersRepository extends MongoRepository<usersModel, String> {
    Optional<usersModel> findUserByEmailIgnoreCase(String email);
}
