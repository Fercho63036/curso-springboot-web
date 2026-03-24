package com.ariel.curso.springboot.webapp.springboot_web.models;

public class User {
    private String name;
    private String lastname;
    private String email;

    // Si llamas a un constructor que no existe con esos parámetros, tendrás un error.    
    public User( String name, String lastname){
        this.name = name;
        this.lastname = lastname;
    }
    // Leer es igual a get
    // Siempre usa mayúscula después de get y set
    public String getName(){
        return name;
    }
    // Escribir con a set
    public void setName(String name){
        this.name = name;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

// Un POJO es una clase de Java "pura" que sirve únicamente como un contenedor de datos.
// En resumen: Es una caja organizada para mover tus datos de un lado a otro en Spring Boot.