package com.ink.authentication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/health")
@RequiredArgsConstructor
public class HealthTestController {
    @GetMapping
    public ResponseEntity<String> check(){
        return ResponseEntity.ok("Ok");
    }
}
