package com.ariel.curso.springboot.webapp.springboot_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Define un controlador MVC que retorna vistas
public class HomeController {

    @GetMapping({"", "/", "/home"}) // Mapea la ruta raíz y /home
    public String home() {
        return "redirect:/list"; // redirect: cambia URL y hace nueva petición
        // return "forward:/list";  // forward: no cambia URL y usa la misma petición
    }
    
    
}