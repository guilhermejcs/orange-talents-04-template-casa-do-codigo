package br.com.zupacademy.guilhermejcs.casadocodigo.cadastrolivro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.guilhermejcs.casadocodigo.cadastrocategoria.Categoria;
import br.com.zupacademy.guilhermejcs.casadocodigo.compartilhado.ExistsId;
import br.com.zupacademy.guilhermejcs.casadocodigo.compartilhado.UniqueValue;
import br.com.zupacademy.guilhermejcs.casadocodigo.novoautor.Autor;

public class NovoLivroRequest {

	@NotBlank
	@UniqueValue(domainClass = Livro.class,fieldName = "titulo")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull
	@Min(20)
	private BigDecimal preco;
	@Min(100)
	private int numeroPaginas;
	@NotBlank
	@UniqueValue(domainClass = Livro.class,fieldName = "isbn")
	private String isbn;
	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	@NotNull
	@ExistsId(domainClass = Categoria.class, fieldName= "id")
	private Long idCategoria;
	@NotNull
	@ExistsId(domainClass = Autor.class, fieldName= "id")
	private Long idAutor;

	public NovoLivroRequest(@NotBlank String titulo,
			@NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @Min(100) int numeroPaginas,
			@NotBlank String isbn, @NotNull Long idCategoria,
			@NotNull Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	/*
	 * O Jackson precisa desse setter para desserializar o json com a data no
	 * parãmetro pelo construtor.
	 */
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro toModel(EntityManager manager) {
		@NotNull Autor autor = manager.find(Autor.class, idAutor);
		@NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
		
		Assert.state(autor!=null,"Você está querendo cadastrar um livro para um autor que não existe no banco "+ idAutor);
		Assert.state(categoria!=null,"Você está querendo cadastrar um livro para uma categoria que não existe no banco "+ idCategoria);
		
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn,
				dataPublicacao, autor, categoria);

	}
	
}
