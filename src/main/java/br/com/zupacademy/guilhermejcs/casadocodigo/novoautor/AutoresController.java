package br.com.zupacademy.guilhermejcs.casadocodigo.novoautor;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoresController {
	
	@PostMapping(value = "/autores")
	private String postMethodName(@RequestBody @Valid  NovoAutorRequest request) {
		Autor autor = request.toModel();
		return autor.toString();

	}
	
}
