package com.ariel.curso.springboot.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
// Configuracion para el manejo de dos o mas archivos de properties, en este caso el application.properties y el values.properties
@PropertySources({
	@PropertySource("classpath:application.properties"),
	@PropertySource("classpath:values.properties")
})
// Si solo tuvieras un archivo de properties, no es necesario usar @PropertySource
// @PropertySource("classpath:values.properties")
public class ValuesConfig {
    
}
