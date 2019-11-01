package backend;

public class Alternativa {

	private String texto;
	private boolean correta;
	
	public Alternativa(String texto, boolean correta) {
		// TODO Auto-generated constructor stub
		this.texto = texto;
		this.correta = correta;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isCorreta() {
		return correta;
	}

	public void setCorreta(boolean correta) {
		this.correta = correta;
	}
	
	
}
