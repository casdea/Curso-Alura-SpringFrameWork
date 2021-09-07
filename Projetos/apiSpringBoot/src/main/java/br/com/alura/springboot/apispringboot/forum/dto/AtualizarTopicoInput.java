package br.com.alura.springboot.apispringboot.forum.dto;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.alura.springboot.apispringboot.forum.modelo.Topico;
import br.com.alura.springboot.apispringboot.forum.repository.TopicoRepository;

public class AtualizarTopicoInput {

	@NotNull
	@NotEmpty
	private String titulo;
	@NotNull
	@NotEmpty
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Optional<Topico> opcional = topicoRepository.findById(id);

		if (opcional.isPresent() == false) {
			return null;
		}

		Topico topico = opcional.get();
		topico.setTitulo(this.getTitulo());
		topico.setMensagem(this.getMensagem());
		return topico;
	}
}
