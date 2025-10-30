package br.com.malu.enums;

public enum Acesso {
	
	gerente("gerente"),
	vendedor("vendedor");
	
	private String acesso;
	
	private Acesso(String acesso) {
		this.acesso = acesso;
	}

}
