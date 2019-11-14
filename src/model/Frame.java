package model;

public class Frame {
	
	private String caminho;
	
	public Frame(String linha[]) {
		this.caminho = linha[0];
	}
	
	// GET
	public String getCaminho() {
		return caminho;
	}
	
	// SET
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

}
