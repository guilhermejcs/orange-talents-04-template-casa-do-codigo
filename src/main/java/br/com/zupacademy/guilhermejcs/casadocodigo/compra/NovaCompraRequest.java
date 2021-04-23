package br.com.zupacademy.guilhermejcs.casadocodigo.compra;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.guilhermejcs.casadocodigo.compartilhado.ExistsId;
import br.com.zupacademy.guilhermejcs.casadocodigo.paisestado.Estado;
import br.com.zupacademy.guilhermejcs.casadocodigo.paisestado.Pais;

public class NovaCompraRequest {

	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;
	@ExistsId(domainClass = Estado.class, fieldName = "id")
	private Long idEstado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;

	public NovaCompraRequest(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, @NotBlank String telefone, @NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.telefone = telefone;
		this.cep = cep;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Compra toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, idPais);
		Compra compra = new Compra(email, nome, sobrenome, documento, endereco, complemento, cidade,
				pais, telefone,
				cep);
		if (idEstado != null) {
			compra.setEstado(manager.find(Estado.class, idEstado));
		}

		return compra;
	}
}
