package br.com.alura.springboot.apispringboot.forum.dto;

public class TokenModel {

	private String token;
	private String tipoAutenticacao;

	public TokenModel(String token, String tipoAutenticacao) {
		// TODO Auto-generated constructor stub
		this.token = token;
		this.tipoAutenticacao = tipoAutenticacao;

	}

	public String getToken() {
		return token;
	}

	public String getTipoAutenticacao() {
		return tipoAutenticacao;
	}

}
