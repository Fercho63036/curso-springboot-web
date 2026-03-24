package com.ariel.curso.springboot.webapp.springboot_web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ariel.curso.springboot.webapp.springboot_web.models.ParamDto;
import com.ariel.curso.springboot.webapp.springboot_web.models.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola, No hay nada") String message) {
        ParamDto params = new ParamDto();
        params.setMessage(message);
        return params;
    }

    // La manera de usar de pasar parmetros es con la URL: http://localhost:8080/api/params/foo?message=Hola%20Mundo

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code) {
        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        return params;    
    }

    // La manera de usar de pasar parmetros es con la URL: http://localhost:8080/api/params/bar?text=Hola%20Mundo&code=200

    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request) {
        Integer code= 10;
        
        try{
            code = Integer.valueOf(request.getParameter("code"));
        } catch(NumberFormatException e){}

        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;
    }
    // Está validando manualmente los parámetros de la URL y asegurando que code siempre tenga un valor válido (aunque sea por defecto).
    // La manera de usar de pasar parmetros es con la URL: http://localhost:8080/api/params/request?code=1234567890&message=algun%20mensaje

}
