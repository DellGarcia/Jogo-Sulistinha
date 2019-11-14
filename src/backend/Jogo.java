package backend;

import java.util.ArrayList;
import java.util.Collections;

import model.Questao;

public class Jogo {

	// Atributos
	private ArrayList<Questao> questions;
	private boolean ativo;
	private int total;
	private int acertos;
	private int erros;
	
	// Construtor
	public Jogo() {
		// TODO Auto-generated constructor stub
		this.ativo = true;
		this.questions = new ArmazenaQuestao().getQuestoes();
		Collections.shuffle(questions);
	}
	
	
	// Getters e Setters
	public ArrayList<Questao> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Questao> questions) {
		this.questions = questions;
	}

	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public void setAcertos(int acertos) {
		this.acertos = acertos;
	}


	public void setErros(int erros) {
		this.erros = erros;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getAcertos() {
		return acertos;
	}


	public void setAcertos() {
		this.acertos++;
	}


	public int getErros() {
		return erros;
	}


	public void setErros() {
		this.erros++;
	}
	
	
}
