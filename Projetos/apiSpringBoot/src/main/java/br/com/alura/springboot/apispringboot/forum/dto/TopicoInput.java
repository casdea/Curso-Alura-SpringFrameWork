package br.com.alura.springboot.apispringboot.forum.dto;

import br.com.alura.springboot.apispringboot.forum.modelo.Curso;
import br.com.alura.springboot.apispringboot.forum.modelo.Topico;
import br.com.alura.springboot.apispringboot.forum.repository.CursoRepository;

public class TopicoInput {

	private String titulo;
	private String mensagem;
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
