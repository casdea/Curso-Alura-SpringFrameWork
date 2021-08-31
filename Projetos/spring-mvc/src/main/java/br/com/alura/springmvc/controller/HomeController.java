package br.com.alura.springmvc.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.springmvc.model.Pedido;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) 
	{
		Pedido pedido = new Pedido();
		pedido.setDataEntrega(LocalDate.parse("12/01/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		pedido.setDescricaoProduto("Notebook Dell Inspiron 3501-M46P 15.6\" HD 10ª Geração Intel Core i5 8GB 256GB SSD Windows Preto");
		pedido.setNomeProduto("Notebook Dell Inspiron 3501");
		pedido.setUrlImagem("https://images-americanas.b2w.io/produtos/01/00/img/3714683/1/3714683114_1SZ.jpg");
		pedido.setUrlProduto("https://www.americanas.com.br/produto/3714683077?chave=dk_hm_bn_8_1_ge&cor=Preto&voltagem=100%20-%20240%20Volts%20AC%20(Bivolt)%20%7C%20Bateria%20de%203%20c%C3%A9lulas%20e%2042%20Wh%20(integrada)");
		pedido.setValorNegociado(new BigDecimal("1200.00"));
		
		List<Pedido> pedidos = Arrays.asList(pedido, pedido, pedido);
		model.addAttribute("pedidos",pedidos);
		
		return "home";
	}
	
}
