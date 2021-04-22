package br.com.zupacademy.guilhermejcs.casadocodigo.cadastrolivro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivrosController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/livros")
	@Transactional
	public String cria(@RequestBody @Valid NovoLivroRequest request) {
		Livro novoLivro = request.toModel(manager);
		manager.persist(novoLivro);
		return novoLivro.toString();
	}

	
}
