package br.com.alura.springmvc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.springmvc.model.Pedido;
import br.com.alura.springmvc.model.StatusPedido;
import br.com.alura.springmvc.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("aguardando")
	public List<Pedido> getPedidosAguardandoOfertas()
	{
		Sort sort = Sort.by("id").descending();
		PageRequest paginacao = PageRequest.of(0, 20, sort);
		
		List<Pedido> lista = pedidoRepository.findByStatus(StatusPedido.aguardando, paginacao);
		
		lista.stream().forEach(pedido -> System.out.println(" retorno "+pedido.getDescricaoProduto()));
		
		return lista;
	}

}
