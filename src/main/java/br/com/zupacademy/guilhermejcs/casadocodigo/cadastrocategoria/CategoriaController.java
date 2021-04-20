package br.com.zupacademy.guilhermejcs.casadocodigo.cadastrocategoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager manager;
	@Autowired ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
	}
	
	@PostMapping(value = "/categorias")
	@Transactional
	public String cria(@RequestBody @Valid NovaCategoriaRequest request) {
		Categoria novaCategoria = new Categoria(request.getNome());
		manager.persist(novaCategoria);
		return novaCategoria.toString();
	}

	

}
