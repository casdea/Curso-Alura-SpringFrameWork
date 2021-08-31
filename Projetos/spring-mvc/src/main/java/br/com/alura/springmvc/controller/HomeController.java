package br.com.alura.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.springmvc.repository.PedidoRepository;
import br.com.alura.springmvc.repository.PedidoRepositoryJpa;

@Controller
public class HomeController {

	@Autowired
	private PedidoRepositoryJpa PedidoRepositoryJpa;

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("/home")
	public String home(Model model) 
	{
		//model.addAttribute("pedidos",PedidoRepositoryJpa.findAll());
		model.addAttribute("pedidos",pedidoRepository.findAll());
		
		return "home";
	}
	
}
