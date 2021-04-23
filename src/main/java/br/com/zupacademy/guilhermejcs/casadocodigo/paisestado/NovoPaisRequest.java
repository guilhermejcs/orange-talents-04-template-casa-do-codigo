package br.com.zupacademy.guilhermejcs.casadocodigo.paisestado;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.guilhermejcs.casadocodigo.compartilhado.UniqueValue;

public class NovoPaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
