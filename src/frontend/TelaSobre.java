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
			"Esse � um jogo que testar� seus conhecimentos sobre a regi�o Sul do Brail,\n"
			+ "ele consiste em diversas quest�es com 4 alternativas cada, sendo apenas 1 correta,\n"
			+ "a cada acerto voc� infligir� 1 cora��o de dano ao oponente, caso contr�rio\n"
			+ "o inimigo lhe causar� 1 cora��o de dano, os personagens possuem 5 cora��es cada,\n"
			+ "vence quem levar o oponente a 0 cora��es primeiro!\n"
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
