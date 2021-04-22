package br.com.zupacademy.guilhermejcs.casadocodigo.cadastrolivro;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long>{
	
   @Query("SELECT new br.com.zupacademy.guilhermejcs.casadocodigo.cadastrolivro.LivroDTO(l.id, l.titulo) FROM Livro l")
    List<LivroDTO> retornaLivros();
}
