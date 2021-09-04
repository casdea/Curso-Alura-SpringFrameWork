package br.com.alura.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		
		Sort sort = Sort.by("dataEntrega").descending();
		PageRequest paginacao = PageRequest.of(0, 5, sort);
		
		model.addAttribute("pedidos", pedidoRepository.findByStatus(StatusPedido.entregue,paginacao));

		return "home";
	}

}
