package br.com.alura.springboot.apispringboot.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.springboot.apispringboot.forum.dto.LoginInput;
import br.com.alura.springboot.apispringboot.forum.dto.TokenModel;
import br.com.alura.springboot.apispringboot.forum.security.TokenService;

@RestController
@RequestMapping("/auth")
@Profile(value = "prod")
public class AutenticacaoController {

	private static final String TIPO_AUTENTICACAO_BEARER = "Bearer";

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenModel> autenticar(@RequestBody @Valid LoginInput loginInput) {
		UsernamePasswordAuthenticationToken dadosLogin = loginInput.to();
		
		try {
			Authentication authenticate = authenticationManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authenticate); 
			
			return ResponseEntity.ok(new TokenModel(token,TIPO_AUTENTICACAO_BEARER));
			
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}

}
