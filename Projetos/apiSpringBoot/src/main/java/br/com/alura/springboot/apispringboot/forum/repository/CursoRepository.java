package br.com.alura.springboot.apispringboot.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.springboot.apispringboot.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nomeCurso); 


}
