package frontend;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class TelaSobre extends JFrame {

	
	private JPanel fundo;
	private JTextArea txaRegras;
	
	private String texto[] = {
			"Esse é um jogo que testará seus conhecimentos sobre a região Sul do Brail,\n"
			+ "ele consiste em diversas questões com 4 alternativas cada, sendo apenas 1 correta,\n"
			+ "a cada acerto você infligirá 1 coração de dano ao oponente, caso contrário\n"
			+ "o inimigo lhe causará 1 coração de dano, os personagens possuem 5 corações cada,\n"
			+ "vence quem levar o oponente a 0 corações primeiro!\n"
	};
	
	public TelaSobre() {
		// TODO Auto-generated constructor stub
	
		setTitle("Sobre o Jogo");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600, 300);
		setLayout(null);
		setLocationRelativeTo(null);
		
		fundo = new JPanel();
		fundo.setBackground(Color.WHITE);
		setContentPane(fundo);
		
		txaRegras = new JTextArea();
		txaRegras.setText(texto[0]);
		fundo.add(txaRegras);
		
		setVisible(true);
	}
	
}
