package com.ariel.curso.springboot.webapp.springboot_web.controller;
import java.util.HashMap;
import java.util.List;
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
    // Inyecta un valor simple (Integer) desde application.properties
    @Value("${config.code}")
    private Integer code;

    // Inyecta un String
    @Value("${config.username}")
    private String username;

    // Convierte automáticamente un string separado por comas en una lista
    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    // Inyecta otro valor tipo String
    @Value("${config.message}")
    private String message;

    // Usa SpEL (Spring Expression Language)
    // 1. Toma el valor del properties
    // 2. Lo convierte a mayúsculas
    // 3. Lo separa por coma
    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valueList;

    // Usa SpEL para transformar el valor a mayúsculas sin convertir a lista
    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String valueString;
    
    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap; 

    @Value("#{${config.valuesMap}.product}")
    private String product; 

    @Value("#{${config.valuesMap}.price}")
    private Long price; 

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

    // Endpoint REST que devuelve los valores del properties en formato JSON
    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.message}") String message) {
        // Se crea un Map para construir el JSON de respuesta
        Map<String, Object> json = new HashMap<>();
        // Valores inyectados a nivel de clase
        json.put("code", code);
        json.put("username", username);
        // También puedes inyectar directamente en parámetros del método
        json.put("message", message);
        // Lista original desde properties
        json.put("listOfValues", listOfValues);
        // Lista transformada con SpEL (mayúsculas + split)
        json.put("valueList", valueList);
        // String transformado con SpEL (solo mayúsculas)
        json.put("valueString", valueString);
        // Retorna el Map → Spring automáticamente lo convierte a JSON
        json.put("valuesMap", valuesMap);

        json.put("product", product);
        
        json.put("price", price);

        return json;
    }
        
}
