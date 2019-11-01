package frontend;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import backend.Jogo;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {
	
	// JPanel
	private JPanel tela;
	private JPanel areaQuestao;
	
	// JTextArea
	private JTextArea txaEnunciado;
	private JTextArea txaAlternativas;
	
	// JRadioButton
	private JRadioButton[] rbtnAlternativa;
	
	// Toolkit
	protected static Toolkit tk = Toolkit.getDefaultToolkit();
	protected static Dimension dimension = tk.getScreenSize();
	
    // Jogo
    private Jogo game;
    private int indexQuestao;
    
    // Font
    private Font century;
    
	
	public TelaPrincipal() {
		// TODO Auto-generated constructor stub
		tela = new JPanel();
		areaQuestao = new JPanel();
		txaEnunciado = new JTextArea();
		txaAlternativas = new JTextArea();
		rbtnAlternativa = new JRadioButton[4];
		century = new Font("Century Gothic", Font.PLAIN, 18);
		game = new Jogo();
		indexQuestao = 0;
		init();
	}
	
	public void init() {
		
		//Configurações do JFrame
		setTitle("Sulistas");
		setSize(dimension.width, dimension.height);
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Tela de Fundo
		tela.setBackground(Color.WHITE);
		tela.setLayout(null);
		setContentPane(tela);
		
		// Area da Questao
		areaQuestao.setSize(1080, 720);
		areaQuestao.setLayout(null);
		areaQuestao.setBackground(Color.LIGHT_GRAY);
		areaQuestao.setLocation(getWidth()/2 - areaQuestao.getWidth()/2, getHeight()/2 - areaQuestao.getHeight()/2);
		tela.add(areaQuestao);
		
		// Area do Emuciado da Questão
		txaEnunciado.setSize(areaQuestao.getWidth()/100*90, areaQuestao.getHeight()/100*30);
		txaEnunciado.setLocation(areaQuestao.getWidth()/2 - txaEnunciado.getWidth()/2, 20);
		txaEnunciado.setText(game.getQuestions().get(indexQuestao).getEnunciado());
		txaEnunciado.setEditable(false);
		txaEnunciado.setFocusable(false);
		txaEnunciado.setBackground(Color.BLACK);
		txaEnunciado.setForeground(Color.WHITE);
		txaEnunciado.setFont(century);
		areaQuestao.add(txaEnunciado);
		
		txaAlternativas.setSize(areaQuestao.getWidth()/100*90, areaQuestao.getHeight()/100*50);
		txaAlternativas.setLocation(areaQuestao.getWidth()/2 - txaAlternativas.getWidth()/2, areaQuestao.getHeight()/100*30 + 50);
		int x = txaAlternativas.getWidth()/2 - areaQuestao.getWidth()/100*80/2, y = 20;
		for(int i = 0; i < 4; i++) {
			rbtnAlternativa[i] = new JRadioButton();
			rbtnAlternativa[i].setText(txaAlternativas.getText() + game.getQuestions().get(indexQuestao).getAlternativas().get(i).getTexto());
			rbtnAlternativa[i].setSize(areaQuestao.getWidth()/100*80, 50);
			rbtnAlternativa[i].setLocation(x, y);
			rbtnAlternativa[i].setBackground(Color.WHITE);
			rbtnAlternativa[i].setFont(century);
			txaAlternativas.add(rbtnAlternativa[i]);
			y += 60;
		}
		txaAlternativas.setEditable(false);
		txaAlternativas.setFocusable(false);
		txaAlternativas.setBackground(Color.BLACK);
		txaAlternativas.setForeground(Color.WHITE);
		txaAlternativas.setFont(century);
		areaQuestao.add(txaAlternativas);
		
		
		setVisible(true);
		
	}
	
}
