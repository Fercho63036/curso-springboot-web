package com.ariel.curso.springboot.webapp.springboot_web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ariel.curso.springboot.webapp.springboot_web.models.ParamDto;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola, No hay nada", name= "mensaje") String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }
    // La manera de usar de pasar parmetros es con la URL: http://localhost:8080/api/params/foo?message=Hola%20Mundo

}
