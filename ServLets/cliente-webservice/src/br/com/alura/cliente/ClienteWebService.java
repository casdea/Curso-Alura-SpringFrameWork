package br.com.alura.cliente;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class ClienteWebService {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		String conteudo = Request.Post("http://localhost:808/gerenciador/empresas")
		.addHeader("accept","application/json")		
		.execute()
		.returnContent()
		.asString();		
		
		System.out.println(conteudo);
	}
}
