package com.ariel.curso.springboot.webapp.springboot_web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ariel.curso.springboot.webapp.springboot_web.models.ParamDto;
import com.ariel.curso.springboot.webapp.springboot_web.models.ParamMixDto;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola, No hay nada") String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }
    // La manera de usar de pasar parmetros es con la URL: http://localhost:8080/api/params/foo?message=Hola%20Mundo

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code) {

        ParamMixDto paramDto = new ParamMixDto();
        paramDto.setMessage(text);
        paramDto.setCode(code);
        return paramDto;
    
    }
    // La manera de usar de pasar parmetros es con la URL: http://localhost:8080/api/params/bar?text=Hola%20Mundo&code=200
}
