package br.com.alura.springmvc.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.alura.springmvc.model.Oferta;

public class RequisicaoNovaOferta {
	private String valorOferta;
	private String dataEntrega;
	private String descricaoOferta;
	private Long pedidoId;

	public String getValorOferta() {
		return valorOferta;
	}

	public void setValorOferta(String valorOferta) {
		this.valorOferta = valorOferta;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getDescricaoOferta() {
		return descricaoOferta;
	}

	public void setDescricaoOferta(String descricaoOferta) {
		this.descricaoOferta = descricaoOferta;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setValorOferta(new BigDecimal(this.valorOferta));
		oferta.setDescricaoOferta(this.descricaoOferta);
		oferta.setDataEntrega(LocalDate.parse(this.dataEntrega, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		return oferta;
	}

}
