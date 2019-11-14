package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import frontend.InfiniteAnimation;
import frontend.MyButton;
import frontend.RegistrarFont;
import frontend.Som;
import statics.Cores;
import statics.PixelFont;
import statics.Sound;

@SuppressWarnings("serial")
public class TelaInicial extends JFrame implements ActionListener {

	// Panel de Fundo
	private JPanel tela;
	
	// Botoes
	private JButton btnStartGame;
	private JButton btnAboutGame;
	private JButton btnQuitGame;
	
	// Toolkit
	private Toolkit tk = Toolkit.getDefaultToolkit();
	private Dimension d = tk.getScreenSize();
	
	// Musica 
	private Som objSom;
	private String musicaFundo;
	
	// Color
	private Color corLetra;
	private Color corFundo;
	private Color corBorda;
	
	// Font
	private Font fontBtn;
	
	// TelaInicial 
 	private static TelaInicial INSTANCE;
	
	
	// Construtor
	private TelaInicial() {
		//Configurações do JFrame
		setTitle("Nome do Joginho");
		setSize(d.width, d.height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		
		init();
		
		// Ação dos botões
		btnStartGame.addActionListener(this);
		btnAboutGame.addActionListener(this);
		btnQuitGame.addActionListener(this);

		// Adicionando a tela
		tela.add(btnStartGame);
		tela.add(btnAboutGame);
		tela.add(btnQuitGame);
		
		// Tocando a música
		objSom.playSound(musicaFundo, Clip.LOOP_CONTINUOUSLY);
		
		setContentPane(tela);
		setVisible(true);
	}
	
	public void init() {
		tela = new InfiniteAnimation("telaInicial", 80, d.width, d.height);
		objSom = new Som();
		
		corLetra = Cores.corCinza;
		corFundo = Cores.corVerde;
		corBorda = Cores.corCinza;
		
		musicaFundo = Sound.feelGoodInc;
		fontBtn = RegistrarFont.minhaFont(PixelFont.PixelOperator, "28f");
		
		int btnWidth = 200, btnHeight = 50;
		int reguladorHorizontal = 0, reguladorVertical = 100;
		
		btnStartGame = new MyButton (
			d.width/2 - btnWidth/2 + reguladorHorizontal, d.height/2 - btnHeight/2  + reguladorVertical,
			btnWidth, btnHeight,
			corFundo, corLetra,
			fontBtn, "Start Game",
			corBorda, 3, corLetra,
			corFundo
		);
		
		btnAboutGame = new MyButton (
			d.width/2 - btnWidth/2 + reguladorHorizontal, d.height/2 - btnHeight/2 + (btnHeight + 20)  + reguladorVertical,
			btnWidth, btnHeight,
			corFundo, corLetra,
			fontBtn, "Sobre o Jogo",
			corBorda, 3, corLetra,
			corFundo
		);
		
		btnQuitGame = new MyButton (
			d.width/2 - btnWidth/2 + reguladorHorizontal, d.height/2 - btnHeight/2 + 2 * (btnHeight + 20)  + reguladorVertical,
			btnWidth, btnHeight,
			corFundo, corLetra,
			fontBtn, "Sair do Jogo",
			corBorda, 3, corLetra,
			corFundo
		);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		// Start game 
		if (evt.getSource() == btnStartGame) {
			objSom.stopSound(musicaFundo);
			new TelaCarregamento();
			setInstance();
		}
		
		// About game
		if (evt.getSource() == btnAboutGame) {
			new TelaSobre();
		}
		
		// Quit game
		if (evt.getSource() == btnQuitGame) {
			System.exit(0);
		}
	}
	
	// INSTANCE
	public static synchronized void setInstance() {
		INSTANCE.dispose();
		INSTANCE = null;
	}
	
	public static synchronized TelaInicial getInstance() {
		// Se não haver uma instancia, cria uma
		if (INSTANCE == null) {
			INSTANCE = new TelaInicial();
		}
		
		return INSTANCE;
	}
	
}