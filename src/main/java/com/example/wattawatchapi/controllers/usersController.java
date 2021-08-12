package com.example.wattawatchapi.controllers;

import com.example.wattawatchapi.controller;
import com.example.wattawatchapi.models.usersModel;
import com.example.wattawatchapi.services.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class usersController extends controller {

    @Autowired
    private usersService userService;

    @GetMapping("/")
    public ResponseEntity<usersModel> getUser(Authentication authentication) {
        return success((usersModel) authentication.getPrincipal());
    }

    @GetMapping("/{id}")
    public ResponseEntity<usersModel> login(@PathVariable("id") String id) {
        Optional<usersModel> userData = userService.findById(id);
        if (userData.isPresent()) {
            return success(userData.get());
        }
        return notFound();
    }
}