package br.com.zupacademy.guilhermejcs.casadocodigo.novoautor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoresController {
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/autores")
	@Transactional
	public String cria(@RequestBody @Valid NovoAutorRequest request) {
		Autor autor = request.toModel();
		manager.persist(autor);
		return autor.toString();
	}
}
