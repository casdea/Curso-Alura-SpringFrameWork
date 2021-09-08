package br.com.alura.springboot.apispringboot.forum.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

@Service
public class tokenService {

	public String gerarToken(Authentication authentication)
	{
		return Jwts.builder().setIssuer(arg0)
	}
}
