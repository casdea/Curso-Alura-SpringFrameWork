package br.com.alura.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.springmvc.dto.RequisicaoNovoPedido;
import br.com.alura.springmvc.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;   
	
	@GetMapping("formulario")
	public String formulario()
	{
		return "pedido/formulario";
	}

	@PostMapping("novo")
	public String novo(RequisicaoNovoPedido requisicaoNovoPedido)
	{
		pedidoRepository.save(requisicaoNovoPedido.toPedido());
		
		return "pedido/formulario";
	}

}
