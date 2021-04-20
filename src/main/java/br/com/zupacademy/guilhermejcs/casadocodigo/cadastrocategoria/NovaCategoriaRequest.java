package br.com.zupacademy.guilhermejcs.casadocodigo.cadastrocategoria;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.guilhermejcs.casadocodigo.compartilhado.UniqueValue;

public class NovaCategoriaRequest {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

}
