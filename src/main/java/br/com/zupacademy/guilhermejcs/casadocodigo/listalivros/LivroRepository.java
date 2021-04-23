package br.com.zupacademy.guilhermejcs.casadocodigo.listalivros;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.guilhermejcs.casadocodigo.cadastrolivro.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long>{
	
   @Query("SELECT new br.com.zupacademy.guilhermejcs.casadocodigo.listalivros"
   		+ ".ListaLivrosDTO(l.id, l.titulo) FROM Livro l")
    List<ListaLivrosDTO> retornaLivros();
}
