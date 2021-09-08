package br.com.alura.springboot.apispringboot.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.springboot.apispringboot.forum.dto.LoginInput;
import br.com.alura.springboot.apispringboot.forum.security.tokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginInput loginInput) {
		UsernamePasswordAuthenticationToken dadosLogin = loginInput.to();
		
		try {
			Authentication authenticate = authenticationManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authenticate); 
			
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}

}
