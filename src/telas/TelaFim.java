package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import frontend.LabelHTML;
import frontend.MyButton;
import frontend.MyLabel;
import frontend.MyPanel;
import frontend.MyTextField;
import frontend.RegistrarFont;
import statics.Cores;
import statics.PixelFont;

@SuppressWarnings("serial")
public class TelaFim extends JDialog implements ActionListener {

	// JPanel 
	private JPanel panel;
	
	// Toolkit
	public Toolkit tk = Toolkit.getDefaultToolkit();
	public Dimension d = tk.getScreenSize();
	
	// JLabel
	private JLabel lblRegras;
	
	// JTextField
	private JTextField lblTitle;
	
	// Font
	private Font myFont;
	private Font titleFont;
	
	// String
	private String txtResultado;
	private String titleResultado;
	
	// Color
	private Color corFundo;
	private Color corResultado;
	
	// Button
	protected JButton reiniciar;
	protected JButton voltarMenu;
	
	
	// Construtor 
	public TelaFim(String quemGanhou) {
		setTitle("Sobre o Jogo");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(750, 400);
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setModal(true);
		
		if (quemGanhou.equals("Mob")) {
			txtResultado = LabelHTML.html("Infelizmente você levou 5 golpes e acabou por morrer, tente novamente...", "50");
			corResultado = Cores.corVermelha;
			titleResultado = "Você perdeu";
			
		} else if (quemGanhou.equals("Jogador")) {
			txtResultado = LabelHTML.html("Parabéns, você conseguiu concluir o desafio, deseja tentar novamente?", "50");
			corResultado = Cores.corVerde;
			titleResultado = "Você ganhou";
			
		} else {
			txtResultado = LabelHTML.html("Você conseguiu dar um empate, parabéns (IMPOSSÍVEL)", "50");
			corResultado = Cores.corAmarela;
			titleResultado = "Você empatou";
		}
		
		init();
		
		voltarMenu.addActionListener(this);
		reiniciar.addActionListener(this);
		
		// Adicionar ao panel
		panel.add(reiniciar);
		panel.add(voltarMenu);
		panel.add(lblRegras);
		panel.add(lblTitle);
		
		setContentPane(panel);
		setVisible(true);
	}
	
	public void init() {
		myFont = RegistrarFont.minhaFont(PixelFont.PixelOperator, "25f");
		titleFont = RegistrarFont.minhaFont(PixelFont.PixelOperator, "30f");
		corFundo = Cores.corCinza;
		
		// Panel
		panel = new MyPanel(corFundo);
		
		// Titulo
		lblTitle = new MyTextField(getWidth(), 50, titleResultado, titleFont, corResultado, Color.WHITE);
		lblTitle.setLocation(0, 0);
		
		// Texto
		lblRegras = new MyLabel(750, 200, txtResultado, myFont, Color.WHITE);
		lblRegras.setLocation(
				(getWidth() - lblRegras.getWidth()) / 2
				, (getHeight() - lblRegras.getHeight()) / 2
		);
		
		// Voltar Menu
		voltarMenu = new MyButton (
			150, lblRegras.getHeight() + 100,
			150, 50,
			null, Color.WHITE,
			titleFont, "Menu",
			null, 3, corResultado,
			corFundo
		);
		
		// Reiniciar
		reiniciar = new MyButton (
			getWidth() - 300, lblRegras.getHeight() + 100,
			150, 50,
			null, Color.WHITE,
			titleFont, "Reiniciar",
			null, 3, corResultado,
			corFundo
		);
	}

	// Action Listener
	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == voltarMenu) {
			dispose();
			
			TelaPrincipal.objSom.stopSound(TelaPrincipal.musicaFundo);
			TelaInicial.getInstance();
			TelaPrincipal.setInstance();
		}
		
		if (evt.getSource() == reiniciar) {
			dispose();
			
			TelaPrincipal.objSom.stopSound(TelaPrincipal.musicaFundo);
			TelaPrincipal.restart();
		}
		
	}
	
}
