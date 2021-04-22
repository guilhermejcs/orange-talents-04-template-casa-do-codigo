package br.com.zupacademy.guilhermejcs.casadocodigo.cadastrolivro;

public class LivroDTO {
	private Long id;
	private String titulo;

	public LivroDTO(Long id, String titulo) {
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
