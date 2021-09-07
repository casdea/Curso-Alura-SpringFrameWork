package br.com.alura.springboot.apispringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
//Esse parametro da suporte ao parametro de paginacao na query de pesquisa
@EnableSpringDataWebSupport 
public class ApispringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApispringbootApplication.class, args);
	}

}
