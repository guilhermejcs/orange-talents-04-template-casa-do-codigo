package br.com.zupacademy.guilhermejcs.casadocodigo.listalivros;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListaLivrosController {

	@Autowired
	LivroRepository livroRepository;

	@GetMapping(value = "/livros")
	public List<ListaLivrosDTO> listaLivros() {
		return livroRepository.retornaLivros();
	}
}
