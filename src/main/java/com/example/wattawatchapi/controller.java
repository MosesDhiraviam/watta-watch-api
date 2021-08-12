package com.example.wattawatchapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class controller {

    protected <T> ResponseEntity<T> success(T data) {
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    protected <T> ResponseEntity<T> notFound() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    protected <T> ResponseEntity<T> unAuthorized() {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    protected <T> ResponseEntity<T> badRequest() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    protected <T> ResponseEntity<T> duplicate() {
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}