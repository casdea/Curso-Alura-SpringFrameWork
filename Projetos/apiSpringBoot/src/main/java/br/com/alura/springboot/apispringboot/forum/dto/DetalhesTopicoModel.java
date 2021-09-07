package br.com.alura.springboot.apispringboot.forum.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.springboot.apispringboot.forum.modelo.StatusTopico;
import br.com.alura.springboot.apispringboot.forum.modelo.Topico;

public class DetalhesTopicoModel {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	private StatusTopico statusTopico;
	private List<RespostaModel> respostas;

	public DetalhesTopicoModel(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		this.nomeAutor = topico.getAutor().getNome();
		this.statusTopico = topico.getStatus();
		this.respostas = new ArrayList<RespostaModel>();
		this.respostas.addAll(topico.getRespostas().stream().map(RespostaModel::new).collect(Collectors.toList()));

	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static List<DetalhesTopicoModel> toList(List<Topico> topicos) {
		return topicos.stream().map(DetalhesTopicoModel::new).collect(Collectors.toList());
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public StatusTopico getStatusTopico() {
		return statusTopico;
	}

	public List<RespostaModel> getRespostas() {
		return respostas;
	}

}
