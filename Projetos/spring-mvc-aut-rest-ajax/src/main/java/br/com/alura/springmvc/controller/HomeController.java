package br.com.alura.springmvc.controller;

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
	public String home(Model model) {
		model.addAttribute("pedidos", pedidoRepository.findByStatus(StatusPedido.entregue));

		return "home";
	}

}
