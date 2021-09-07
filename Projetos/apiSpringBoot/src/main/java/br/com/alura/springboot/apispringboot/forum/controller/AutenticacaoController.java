package br.com.alura.springboot.apispringboot.forum.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.springboot.apispringboot.forum.dto.LoginInput;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginInput loginInput)
	{
		System.out.println(loginInput.getEmail());
		System.out.println(loginInput.getSenha());
		
		return ResponseEntity.ok().build();
	}

}
