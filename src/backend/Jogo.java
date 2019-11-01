package backend;

import java.util.ArrayList;
import java.util.Collections;

public class Jogo {

	// Atributos
	private ArrayList<Questao> questions;
	
	
	// Construtor
	public Jogo() {
		// TODO Auto-generated constructor stub
		questions = new ArmazenaQuestao().getQuestoes();
		Collections.shuffle(questions);
	}
	
	
	// Getters e Setters
	public ArrayList<Questao> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Questao> questions) {
		this.questions = questions;
	}
	
}
