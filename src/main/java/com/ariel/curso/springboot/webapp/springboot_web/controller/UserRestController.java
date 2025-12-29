package com.ariel.curso.springboot.webapp.springboot_web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ariel.curso.springboot.webapp.springboot_web.models.User;

/******************************************************************************************
 * OPCIÓN 1: @RestController + @GetMapping (FORMA MODERNA Y RECOMENDADA)
 ******************************************************************************************/

@RestController
@RequestMapping("/api")
public class UserRestController {
    @GetMapping( path = "/details" )
    public Map<String, Object> details() {
        User user = new User("Ariel",  "Paricagua");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Spring Boot");
        body.put("user", user);
        return body;
    }
}
/******************************************************************************************
 * OPCIÓN 2: @Controller + @ResponseBody (FORMA CLÁSICA MVC)
 ******************************************************************************************/

// @Controller indica que esta clase es un controlador MVC tradicional
// Por defecto intenta devolver vistas (HTML)
// @Controller
// @RequestMapping("/api") // Prefijo común de rutas
// class UserController {
//     // @GetMapping define una ruta GET
//     // URL final: /api/details
//     @GetMapping("/details")
//     // @ResponseBody indica que el valor retornado
//     // NO es una vista, sino datos que deben convertirse a JSON
//     @ResponseBody
//     public Map<String, Object> details() {
//         // Se construye la respuesta en un Map
//         Map<String, Object> body = new HashMap<>();
//         // Datos que se enviarán al cliente
//         body.put("title", "Hola Mundo Spring Boot");
//         body.put("name", "Ariel");
//         body.put("lastname", "Paricagua");
//         // Spring convierte el Map a JSON
//         return body;
//     }
// }

/******************************************************************************************
 * OPCIÓN 3: @RestController + @RequestMapping (FORMA CLÁSICA REST)
 ******************************************************************************************/

// @RestController indica que es un controlador REST
// Devuelve JSON sin necesidad de @ResponseBody
// @RestController
// @RequestMapping("/api") // Ruta base del controlador
// class UserRestController {
//     // @RequestMapping permite definir la ruta y el método HTTP
//     // path = "/details" → URL final: /api/details
//     // method = RequestMethod.GET → solo acepta peticiones GET
//     @RequestMapping(path = "/details", method = RequestMethod.GET)
//     public Map<String, Object> details() {
//         // Se crea el Map que contendrá la respuesta
//         Map<String, Object> body = new HashMap<>();
//         // Información retornada al cliente
//         body.put("title", "Hola Mundo Spring Boot");
//         body.put("name", "Ariel");
//         body.put("lastname", "Paricagua");
//         // Se devuelve el Map convertido automáticamente a JSON
//         return body;
//     }
// }
