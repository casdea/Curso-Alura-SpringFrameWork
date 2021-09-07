package br.com.alura.springboot.apispringboot.forum.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.alura.springboot.apispringboot.forum.modelo.Curso;
import br.com.alura.springboot.apispringboot.forum.modelo.Topico;
import br.com.alura.springboot.apispringboot.forum.repository.CursoRepository;

public class TopicoInput {

	@NotNull
	@NotEmpty
	private String titulo;
	@NotNull
	@NotEmpty
	private String mensagem;
	@NotNull
	@NotEmpty
	private String nomeCurso;

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}
	
	public Topico to(CursoRepository cursoRepository)
	{
		Curso curso = cursoRepository.findByNome(this.nomeCurso);
		
		Topico topico = new Topico(titulo, mensagem, curso);
		return topico;
	}

}
