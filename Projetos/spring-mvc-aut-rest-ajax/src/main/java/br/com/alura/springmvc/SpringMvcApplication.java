package br.com.alura.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

}
