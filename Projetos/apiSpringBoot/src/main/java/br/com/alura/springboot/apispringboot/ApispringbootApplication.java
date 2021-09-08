package br.com.alura.springboot.apispringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//Esse parametro da suporte ao parametro de paginacao na query de pesquisa
@EnableSpringDataWebSupport 
@EnableCaching
@EnableSwagger2
public class ApispringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApispringbootApplication.class, args);
	}

}
