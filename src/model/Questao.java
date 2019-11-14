package model;

import java.util.ArrayList;
import java.util.Collections;

import backend.Alternativa;

public class Questao {

	// Atributos
	private int id;
	private String enunciado;
	private ArrayList<Alternativa> alternativas;
	
	// Construtor
	public Questao(String linha[]) {
		this.id = Integer.parseInt(linha[0]);
		this.enunciado = linha[1];
		this.alternativas = new ArrayList<Alternativa>();
		this.alternativas.add(new Alternativa(linha[2], true));
		this.alternativas.add(new Alternativa(linha[3], false));
		this.alternativas.add(new Alternativa(linha[4], false));
		this.alternativas.add(new Alternativa(linha[5], false));
		Collections.shuffle(alternativas);
	}

	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public ArrayList<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(ArrayList<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}
	
}
