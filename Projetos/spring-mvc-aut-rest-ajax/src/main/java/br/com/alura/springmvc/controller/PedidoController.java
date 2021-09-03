package br.com.alura.springmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.springmvc.dto.RequisicaoNovoPedido;
import br.com.alura.springmvc.model.Pedido;
import br.com.alura.springmvc.repository.PedidoRepository;
import br.com.alura.springmvc.repository.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;   

	@Autowired
	private UserRepository userRepository;   

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicaoNovoPedido)
	{
		return "pedido/formulario";
	}

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicaoNovoPedido, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			return "pedido/formulario";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Pedido pedido = requisicaoNovoPedido.toPedido();
		pedido.setUser(userRepository.findByUsername(username));
		
		pedidoRepository.save(pedido);
		
		return "redirect:/home";
	}

}
