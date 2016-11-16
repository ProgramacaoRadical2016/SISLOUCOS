package br.com.sisclinic.model.values;

public enum TipoPessoa {
	
	PESSOA_FISICA("Pessoa F�sica"), 
	PESSOA_JURIDICA("Pessoa Jur�dica");
	
	private String label;

	private TipoPessoa(String label) {
		setLabel(label);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return getLabel();
	}
	
}