package com.ariel.curso.springboot.webapp.springboot_web.models;

public class User {
    private String name;
    private String lastname;

    public User( String name, String lastname ){
        this.name = name;
        this.lastname = lastname;
    }

    // Siempre usa mayúscula después de get y set
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }
}

// Un POJO es una clase de Java "pura" que sirve únicamente como un contenedor de datos.
// En resumen: Es una caja organizada para mover tus datos de un lado a otro en Spring Boot.