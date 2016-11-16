package br.com.sisclinic.model.enums;

public enum TipoAtendimento {
	
	ATENDIMENTO("Atendimento"),
	TRIAGEM("Triagem"),
	CONSULTA("Consulta");
	private String nome;
 
	private TipoAtendimento(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
