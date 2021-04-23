package br.com.zupacademy.guilhermejcs.casadocodigo.listalivros;

public class ListaLivrosDTO {
	private Long id;
	private String titulo;

	public ListaLivrosDTO(Long id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
		
}
