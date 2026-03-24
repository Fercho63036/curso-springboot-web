package com.ariel.curso.springboot.webapp.springboot_web.controller;
/***************************** IMPORTACIONES AGRUPADAS ***********************************/
// 1. Importaciones de Java estándar (java.*)
// import java.util.Map;
// 2. Importaciones de Spring Framework (org.springframework.*)
// import org.springframework.ui.ModelMap;
// import org.springframework.web.servlet.ModelAndView;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ariel.curso.springboot.webapp.springboot_web.models.User;

// Es la clase que recibe las peticiones HTTP (GET, POST, etc.) y devuelve una respuesta (HTML o JSON).
@Controller
public class UserController {
    /***************************** OPCIÓN 1: Model (Interface) ***********************************/
    // Es la interfaz más común y recomendada de Spring MVC
    // Permite agregar atributos que estarán disponibles en la vista
    // Sintaxis limpia y específica para Spring MVC
    
    // CARACTERISTICAS
    // MVC (@Controller)
    // Devuelve HTML
    // Usa Model
    // Para páginas web
    @GetMapping("/details") // Ruta
    public String details(Model model) {
        User user = new User("Ariel", "Paricagua");
        user.setEmail("arielfparicaguav@gmail.com");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("title", "Lista de Usuarios");
        return "list";
    }

    // Ese @ModelAttribute sirve para evitar repetir código,
    // ya que define datos globales del modelo que estarán disponibles automáticamente en todas las vistas del controlador.
    @ModelAttribute("users")
    public List<User> userModel(){
        List<User> users = Arrays.asList(
            new User("Pepa", "Gonzales"),
            new User("Lalo", "Perez", "lalo.perez@gmail.com"),
            new User("Juanita", "Roe"),
            new User("Andres", "Doe", "andres.doe@gmail.com"),
            new User("Ariel", "Paricagua")
        );
        return users;
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
    // Patron MVC
    // Modelo => El obejto User
    // Vista => El archivo details.html
    // Controlador => Tu metodo details
}