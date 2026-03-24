package com.ariel.curso.springboot.webapp.springboot_web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ariel.curso.springboot.webapp.springboot_web.models.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    // Este controlador toma un valor desde la URL (ruta), lo convierte en variable y lo devuelve en un objeto.
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto params = new ParamDto();
        params.setMessage(message);
        return params;
    }
    // @RequestParam: toma datos desde la URL (?param=valor) de forma automática.
    // http://localhost:8080/api/var/baz/hola%20este%20es%20un%20mensaje%20muy%20importante
}


