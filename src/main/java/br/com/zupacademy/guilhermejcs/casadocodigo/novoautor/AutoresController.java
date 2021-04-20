package br.com.zupacademy.guilhermejcs.casadocodigo.novoautor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoresController {
	
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}

	@PostMapping(value = "/autores")
	@Transactional
	public String cria(@RequestBody @Valid NovoAutorRequest request) {
		Autor autor = request.toModel();
		manager.persist(autor);
		return autor.toString();
	}
}
