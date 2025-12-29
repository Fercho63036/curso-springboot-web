package com.ariel.curso.springboot.webapp.springboot_web.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserRestController {
    
    @GetMapping("/details2")
    public Map<String, Object> details() {
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Spring Boot");
        body.put("name", "Ariel");
        body.put("lastname", "Paricagua");
        return body;
    }
    

}
