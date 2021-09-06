package br.com.alura.springboot.apispringboot.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.springboot.apispringboot.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
