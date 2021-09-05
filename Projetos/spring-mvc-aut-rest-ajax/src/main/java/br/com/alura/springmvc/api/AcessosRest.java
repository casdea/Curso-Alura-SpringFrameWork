package br.com.alura.springmvc.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.springmvc.interceptor.InterceptadorAcessos;
import br.com.alura.springmvc.interceptor.InterceptadorAcessos.Acesso;

@RequestMapping("acessos")
@RestController
public class AcessosRest {
	
	@GetMapping
	public List<Acesso> getAcessos()
	{
		return InterceptadorAcessos.acessos;
	}

}
