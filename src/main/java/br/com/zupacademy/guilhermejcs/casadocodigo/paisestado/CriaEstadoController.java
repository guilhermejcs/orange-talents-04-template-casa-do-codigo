package br.com.zupacademy.guilhermejcs.casadocodigo.paisestado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriaEstadoController {
		
		@PersistenceContext
		private EntityManager manager;

		@PostMapping(value = "/estados")
		@Transactional
		public String cria(@RequestBody @Valid NovoEstadoRequest request) {		
			Estado novoEstado = request.toModel(manager);		
			manager.persist(novoEstado);
			return novoEstado.toString();
		}
}
