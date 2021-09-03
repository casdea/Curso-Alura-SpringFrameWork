package br.com.alura.springmvc.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.springmvc.model.StatusPedido;
import br.com.alura.springmvc.repository.PedidoRepository;
import br.com.alura.springmvc.repository.PedidoRepositoryJpa;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoRepositoryJpa pedidoRepositoryJpa;

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public String home(Model model, Principal principal) 
	{
		model.addAttribute("pedidos",pedidoRepository.findAllByUsuario(principal.getName()));
		
		return "home";
	}

	@GetMapping("/{status}")
	public String aguardando(@PathVariable("status") String status, Model model) 
	{
		model.addAttribute("pedidos",pedidoRepository.findByStatus(StatusPedido.valueOf(status)));
		model.addAttribute("status",status);
		
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError()
	{

		return "redirect:/home";
	}

}
