package br.com.zupacademy.guilhermejcs.casadocodigo.cadastrolivro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.guilhermejcs.casadocodigo.cadastrocategoria.Categoria;
import br.com.zupacademy.guilhermejcs.casadocodigo.novoautor.Autor;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String titulo;
	private @NotBlank @Size(max = 500) String resumo;
	private @NotBlank String sumario;
	private @NotNull @Min(20) BigDecimal preco;
	private @Min(100) int numeroPaginas;
	private @NotBlank String isbn;
	@NotNull
	private @Future LocalDate dataPublicacao;
	@ManyToOne
	private @NotNull @Valid Autor autor;
	@ManyToOne
	private @NotNull @Valid Categoria categoria;
	
	@Deprecated
	public Livro() {
	}

	public Livro(@NotBlank String titulo,
			@NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @Min(100) int numeroPaginas,
			@NotBlank String isbn, @Future @NotNull LocalDate dataPublicacao,
			@NotNull @Valid Autor autor, @NotNull @Valid Categoria categoria) {
				this.titulo = titulo;
				this.resumo = resumo;
				this.sumario = sumario;
				this.preco = preco;
				this.numeroPaginas = numeroPaginas;
				this.isbn = isbn;
				this.dataPublicacao = dataPublicacao;
				this.autor = autor;
				this.categoria = categoria;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public Autor getAutor() {
		return autor;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public String getResumo() {
		return resumo;
	}
	
	public String getSumario() {
		return sumario;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	
	public LocalDate getDataPublicacao() {
		return this.dataPublicacao;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo
				+ ", sumario=" + sumario + ", preco=" + preco
				+ ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn
				+ ", dataPublicacao=" + dataPublicacao + ", autor=" + autor
				+ ", categoria=" + categoria + "]";
	}

}