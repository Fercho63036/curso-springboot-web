package com.ariel.curso.springboot.webapp.springboot_web.controller;

/***************************** IMPORTACIONES AGRUPADAS ***********************************/

// 1. Importaciones de Java estándar (java.*)
import java.util.Map;

// 2. Importaciones de Spring Framework (org.springframework.*)
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    /***************************** OPCIÓN 1: Model (Interface) ***********************************/
    // Es la interfaz más común y recomendada de Spring MVC
    // Permite agregar atributos que estarán disponibles en la vista
    // Sintaxis limpia y específica para Spring MVC
    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("name", "Ariel");
        model.addAttribute("lastname", "Paricagua");
        return "details";
    }

    /***************************** OPCIÓN 2: Map<String, Object> ***********************************/
    // Es un Map genérico de Java, más flexible pero menos específico
    // Spring automáticamente lo convierte en un modelo
    // Útil cuando ya trabajas con Maps en tu lógica de negocio
    // @GetMapping("/details")
    // public String details(Map<String, Object> model){
    //     model.put("title", "Hola Mundo Spring Boot");
    //     model.put("name", "Ariel");
    //     model.put("lastname", "Paricagua");
    //     return "details";
    // }

}