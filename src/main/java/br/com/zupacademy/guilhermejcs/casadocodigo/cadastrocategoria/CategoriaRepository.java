package br.com.zupacademy.guilhermejcs.casadocodigo.cadastrocategoria;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{

	Optional<Categoria> findByNome(String nome);
}
