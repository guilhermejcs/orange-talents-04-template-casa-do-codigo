package br.com.zupacademy.guilhermejcs.casadocodigo.detalhelivro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zupacademy.guilhermejcs.casadocodigo.cadastrolivro.Livro;

public class DetalheSiteLivroResponse {

	private String titulo;
	private DetalheSiteAutorResponse autor;
	private String isbn;
	private int numeroPaginas;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private String dataPublicacao;

	public DetalheSiteLivroResponse(Livro livro) {
		titulo = livro.getTitulo();
		autor = new DetalheSiteAutorResponse(livro.getAutor());
		isbn = livro.getIsbn();
		numeroPaginas = livro.getNumeroPaginas();
		preco = livro.getPreco();
		resumo = livro.getResumo();
		sumario = livro.getSumario();
		dataPublicacao = livro.getDataPublicacao()
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
	}

	public String getTitulo() {
		return titulo;
	}

	public DetalheSiteAutorResponse getAutor() {
		return autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
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

	public String getDataPublicacao() {
		return dataPublicacao;
	}
	
	
}
