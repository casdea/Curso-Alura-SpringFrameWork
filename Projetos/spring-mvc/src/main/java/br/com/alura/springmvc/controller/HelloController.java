package br.com.alura.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/hellox")
	public String hello(Model model) {
		model.addAttribute("nome","carlos");
		
		return "hello";
	}

}
