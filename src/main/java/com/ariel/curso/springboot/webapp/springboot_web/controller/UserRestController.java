package com.ariel.curso.springboot.webapp.springboot_web.controller;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ariel.curso.springboot.webapp.springboot_web.models.User;
import com.ariel.curso.springboot.webapp.springboot_web.models.UserDto;

// Un servicio RESTful es una API que permite comunicar aplicaciones usando HTTP y siguiendo reglas del estilo REST.
// GET → Obtener datos
// POST → Crear
// PUT → Actualizar
// DELETE → Eliminar

// JSON en objeto de JS es para compartir informacion al  client3e desde el backend

/******************************************************************************************
 * OPCIÓN 1: @RestController + @GetMapping (FORMA MODERNA Y RECOMENDADA)
 ******************************************************************************************/
// CARACTERISTICAS
// REST (@RestController)
// Devuelve el JSON
// Devuelve objeto directamente
// Para Apis
@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping(path="/details")
    public UserDto details(){
        User user = new User("Ariel",   "Paricagua");
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring Boot");
        return userDto;
    }

    @GetMapping( path = "/details-map" )
    public Map<String, Object> detailsMap() {
        User user = new User("Ariel",  "Paricagua"); // Creando el objeto y inicializando
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Hola Mundo Spring Boot");
        body.put("user", user);
        return body;
    }

    @GetMapping( path = "/list" )
    public List<User> list() {
        // Esta la logica del negocio lo manejamos directamente al servicios y al repository
        User user = new User("Ariel",  "Paricagua");
        User user2 = new User("John",  "Doe");
        User user3 = new User("Jane",  "Smith");

        // List<User>  users = new ArrayList<>();
        List<User> users = Arrays.asList(user, user2, user3); // Forma inmutable y más concisa de crear una lista
        // users.add(user);
        // users.add(user2);
        // users.add(user3);
        return users;
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
