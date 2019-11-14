package model;

public class Personagem {

	// Atributos
	int vidas;
	boolean inimigo;
	
	public Personagem() {
		// TODO Auto-generated constructor stub
		this.vidas = 5;
	}
	
	// Getters e Setters
	public int getVidas() {
		return vidas;
	}
	public void setVidas() {
		this.vidas--;
	}
	public boolean isInimigo() {
		return inimigo;
	}
	public void setInimigo(boolean inimigo) {
		this.inimigo = inimigo;
	}
	
	
}
