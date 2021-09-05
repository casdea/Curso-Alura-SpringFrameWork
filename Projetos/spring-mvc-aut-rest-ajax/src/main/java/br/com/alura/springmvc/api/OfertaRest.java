package br.com.alura.springmvc.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.springmvc.dto.RequisicaoNovaOferta;
import br.com.alura.springmvc.model.Oferta;
import br.com.alura.springmvc.model.Pedido;
import br.com.alura.springmvc.repository.PedidoRepository;

@RestController
@RequestMapping("/api/oferta")
public class OfertaRest {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@PostMapping
	public Oferta criarOfeta(@Valid @RequestBody RequisicaoNovaOferta requisicaoNovaOferta)
	{
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicaoNovaOferta.getPedidoId());
		
		if(!pedidoBuscado.isPresent()) {
			return null;
		}

		Pedido pedido = pedidoBuscado.get();
		
		Oferta nova = requisicaoNovaOferta.toOferta();
		nova.setPedido(pedido);
		pedido.getOfertas().add(nova);
		pedidoRepository.save(pedido);
		
		return nova;
	}

}
