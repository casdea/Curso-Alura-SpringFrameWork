package br.com.alura.springboot.apispringboot.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.springboot.apispringboot.forum.dto.AtualizarTopicoInput;
import br.com.alura.springboot.apispringboot.forum.dto.DetalhesTopicoModel;
import br.com.alura.springboot.apispringboot.forum.dto.TopicoInput;
import br.com.alura.springboot.apispringboot.forum.dto.TopicoModel;
import br.com.alura.springboot.apispringboot.forum.modelo.Topico;
import br.com.alura.springboot.apispringboot.forum.repository.CursoRepository;
import br.com.alura.springboot.apispringboot.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	public List<TopicoModel> lista(String nomeCurso) {
		if (nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoModel.toList(topicos);

		} else {
			// tipo 1
			// List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			// tipo 2
			List<Topico> topicos = topicoRepository.findByCursoNomeQuery(nomeCurso);
			return TopicoModel.toList(topicos);
		}
	}

	@PostMapping
	public ResponseEntity<TopicoModel> criar(@RequestBody @Valid TopicoInput topicoInput,
			UriComponentsBuilder uriComponentsBuilder) {
		Topico topico = topicoInput.to(cursoRepository);
		topicoRepository.save(topico);

		URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

		return ResponseEntity.created(uri).body(new TopicoModel(topico));
	}

	@GetMapping("/{id}")
	public DetalhesTopicoModel find(@PathVariable Long id) {

		Optional<Topico> opcional = topicoRepository.findById(id);

		if (opcional.isPresent() == false) {
			return null;
		}

		return new DetalhesTopicoModel(opcional.get());
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoModel> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizarTopicoInput atualizarTopicoInput, UriComponentsBuilder uriComponentsBuilder) {

		Topico topico = atualizarTopicoInput.atualizar(id, topicoRepository);

		if (topico == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(new TopicoModel(topico));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id,
			@RequestBody @Valid AtualizarTopicoInput atualizarTopicoInput, UriComponentsBuilder uriComponentsBuilder) {

		Optional<Topico> opcional = topicoRepository.findById(id);

		if (opcional.isPresent() == false) {
			return null;
		}

		Topico topico = opcional.get();
		
		if (topico == null)
			return ResponseEntity.notFound().build();
		else {
			topicoRepository.delete(topico);
			return ResponseEntity.ok().build();
		}
	}

}
