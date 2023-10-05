package com.uam.apiUsuario.apiUsuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.uam.apiUsuario")
public class ApiUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiUsuarioApplication.class, args);
	}

}
