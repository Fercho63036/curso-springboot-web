package com.ariel.curso.springboot.webapp.springboot_web.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ariel.curso.springboot.webapp.springboot_web.models.ParamDto;
import com.ariel.curso.springboot.webapp.springboot_web.models.User;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {
    // Trae un valor del properties y lo guarda en una variable
    @Value("${config.code}")
    private Integer code;
    @Value("${config.username}")
    private String username;
    @Value("${config.listOfValues}")
    private String[] listOfValues;
    // baz → 1 dato → devuelve un objeto (DTO)
    // Toma un valor desde la URL (path), lo convierte en variable y lo retorna en un objeto.
    // http://localhost:8080/api/var/baz/hola%20este%20es%20un%20mensaje%20muy%20importante
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto params = new ParamDto();
        params.setMessage(message);
        return params;
    }
    // mix → varios datos → devuelve un JSON (Map)
    // @RequestParam: toma datos desde la URL (?param=valor) de forma automática.
    // Devuelve un JSON armado “a mano” con un Map
    // http://localhost:8080/api/var/mix/teclado/1212
    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mix(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    // Paso por cuerpo del objeto (JSON) y lo devuelve transformado (DTO)
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        // user.setName(user.getName().toUpperCase());
        return user;
    }

    // Manejo del controlador para pasar datos desde application.properties y devolverlos en un JSON
    @GetMapping("/values")
    public Map<String, Object> values( @Value("${config.message}") String message ) {

        Map<String, Object> json = new HashMap<>();
        json.put("code", code);
        json.put("username", username);
        json.put("message", message);
        json.put("listOfValues", listOfValues);
        return json;

    }
    
}
