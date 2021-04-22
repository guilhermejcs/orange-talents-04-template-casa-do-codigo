package br.com.zupacademy.guilhermejcs.casadocodigo.cadastrolivro;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivrosController {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	LivroRepository livroRepository;

	@PostMapping(value = "/livros")
	@Transactional
	public String cria(@RequestBody @Valid NovoLivroRequest request) {
		Livro novoLivro = request.toModel(manager);
		manager.persist(novoLivro);
		return novoLivro.toString();
	}

	@GetMapping(value = "/livros")
	public List<LivroDTO> listaLivros() {
		return livroRepository.retornaLivros();
	}
	
	
}
