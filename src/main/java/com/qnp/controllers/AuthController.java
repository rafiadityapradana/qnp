package com.qnp.controllers;

import java.util.HashMap;


import com.qnp.configs.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/auth/v1")

public class AuthController {
     @Autowired
     JwtTokenProvider jwtTokenProvider;

     @GetMapping("/token")
     public ResponseEntity<Object> getToken() {
          String Token =  jwtTokenProvider.generateToken("uuidString", 520000);
          HashMap<String, Object> finalMap = new HashMap<>();
          finalMap.put("data", Token);
          return new ResponseEntity<>(finalMap, HttpStatus.OK);
     }
}
