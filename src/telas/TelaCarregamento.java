package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import frontend.InfiniteAnimation;
import frontend.MyLabel;
import frontend.MyPanel;
import frontend.RegistrarFont;
import statics.Cores;
import statics.PixelFont;

@SuppressWarnings("serial")
public class TelaCarregamento extends JFrame {
	
	// JPanel
	private JPanel tela;
	private JPanel animacao;
	
	// JLabel
	private JLabel lblLoading;
	
	// Toolkit
	public Toolkit tk = Toolkit.getDefaultToolkit();
	public Dimension d = tk.getScreenSize();
    
    // Thread
    private Thread loading;
    private Thread nowLoading;
    
    // Font
    private Font myFont;
    
    // String
    private String txtLoading[] = {"Now Loading", "Now Loading.", "Now Loading..", "Now Loading..."};
    
    
    // Construtor
	public TelaCarregamento() {
		//Configurações do JFrame
		setTitle("Nome do Joginho");
		setSize(d.width, d.height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		
		init();
		
		// Thread
		loading.start();
		nowLoading.start();
		
		// Adicionar a tela 
		tela.add(lblLoading);
		tela.add(animacao);
		
		setContentPane(tela);
		setVisible(true);
	}
	
	public void init() {
		tela = new MyPanel(Cores.corCinzaDark);
		myFont = RegistrarFont.minhaFont(PixelFont.PixelOperator, "40f");
		
		// Thread
		nowLoading = new Thread(new TextoLoading());
		loading = new Thread(new CarregarBarra());
		
		// Label - Now Loading
		lblLoading = new MyLabel(
			250, 50, txtLoading[0], myFont
			, Color.WHITE , null, SwingConstants.LEFT, SwingConstants.CENTER
		);
		
		lblLoading.setLocation(
			(d.width - lblLoading.getWidth() - 50)
			, (d.height - lblLoading.getHeight() - 50)
		);
		
		// Animacao
		animacao = new InfiniteAnimation("telaCarregamento", 50, 67, 96);
		animacao.setLocation(
			(d.width - animacao.getWidth() - 50) - lblLoading.getWidth()
			, (d.height - animacao.getHeight() - 50)
		);
	}
	
	/* Classe CarregarBarra */
	public class CarregarBarra implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(40);
					
				} catch (Exception e) {}
			}
			
			TelaPrincipal.getInstance();
			dispose();
		}
	}
	
	/* Classe TextoLoading */
	public class TextoLoading implements Runnable {
		@Override
		public void run() {
			int j = 0;
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(300);
					if (j == txtLoading.length) j = 0;
					lblLoading.setText(txtLoading[j]);
					j++;
					
				} catch (Exception e) {}
			}
		}
	}
	
}
