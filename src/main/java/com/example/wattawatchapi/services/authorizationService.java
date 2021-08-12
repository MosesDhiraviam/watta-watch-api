package com.example.wattawatchapi.services;

import com.example.wattawatchapi.models.usersModel;
import com.example.wattawatchapi.repositories.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class authorizationService implements UserDetailsService {

    @Autowired
    private usersRepository userRepository;

    public Optional<usersModel> findUserByEmail(String email) {
        return userRepository.findUserByEmailIgnoreCase(email);
    }

    public usersModel createUser(usersModel user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<usersModel> oUser = userRepository.findUserByEmailIgnoreCase(s);
        if (oUser.isPresent()) {
            return oUser.get();
        }
        throw new UsernameNotFoundException(s);
    }
}
