package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TelaInicial extends JFrame {

	// Panel de Fundo
	private JPanel tela;
	
	// Botoes
	private JButton btnStartGame;
	private JButton btnAboutGame;
	private JButton btnQuitGame;
	
	// Toolkit
	private Toolkit tk = Toolkit.getDefaultToolkit();
	private Dimension d = tk.getScreenSize();
	
	// Construtor
	public TelaInicial() {
		// Controles
		int btnWidth = 200, btnHeight = 50;
		int reguladorHorizontal = 0, reguladorVertical = 100;
		Color corFundo = Color.DARK_GRAY, corLetra = Color.WHITE;
		
		btnStartGame = new BotaoPersonalizado(
												d.width/2 - btnWidth/2 + reguladorHorizontal, d.height/2 - btnHeight/2  + reguladorVertical,
												btnWidth, btnHeight,
												corFundo, corLetra);
		btnAboutGame = new BotaoPersonalizado(
												d.width/2 - btnWidth/2 + reguladorHorizontal, d.height/2 - btnHeight/2 + (btnHeight + 20)  + reguladorVertical,
												btnWidth, btnHeight,
												corFundo, corLetra);
		
		btnQuitGame = new BotaoPersonalizado(
												d.width/2 - btnWidth/2 + reguladorHorizontal, d.height/2 - btnHeight/2 + 2 * (btnHeight + 20)  + reguladorVertical,
												btnWidth, btnHeight,
												corFundo, corLetra);
		
		init();	
	}
	
	public void init() {
		
		setTitle("Nome do Joginho");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
		
		tela = new JPanel();
		tela.setBackground(Color.WHITE);
		tela.setLayout(null);
		setContentPane(tela);
		
		btnStartGame.setText("Start Game");
		tela.add(btnStartGame);
		
		btnAboutGame.setText("Sobre o Jogo");
		tela.add(btnAboutGame);
		
		btnQuitGame.setText("Sair do Jogo");
		tela.add(btnQuitGame);
		
		acaoBotoes();
		
		setVisible(true);
	}
	
	public void acaoBotoes() {
		
		btnStartGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaPrincipal();
				setVisible(false);
			}
		});
		
		btnQuitGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnAboutGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaSobre();
//				setVisible(false);
			}
		});
	}
	
}
