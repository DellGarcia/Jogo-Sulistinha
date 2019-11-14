package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import frontend.MyLabel;
import frontend.MyPanel;
import frontend.ProcessaImagem;
import frontend.RegistrarFont;
import statics.Cores;
import statics.Images;
import statics.PixelFont;

@SuppressWarnings("serial")
public class TelaApresentacao extends JFrame {
	
	// Animacao 
	private JPanel tela;
	
	// JLabel
	private JLabel imgAnonymous;
	private JLabel lblAnonymous;
	
	// Toolkit
	private Toolkit tk = Toolkit.getDefaultToolkit();
	private Dimension d = tk.getScreenSize();
	
	// Thread
	private Thread time;
	
	// Font
	private Font myFont;
	
	// TelaApresentacao 
 	private static TelaApresentacao INSTANCE;
	
	// Construtor
	private TelaApresentacao() {
		//Configurações do JFrame
		setTitle("Nome do Joginho");
		setSize(d.width, d.height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		
		try { init(); } catch (IOException e) {}
		
		// Thread
		time.start();
		
		// Adicionando a tela 
		tela.add(imgAnonymous);
		tela.add(lblAnonymous);
		
		setContentPane(tela);
		setVisible(true);
	}
	
	public void init() throws IOException {
		tela = new MyPanel(Cores.corCinzaDark);
		
		time = new Thread(new TelaDelay());
		myFont = RegistrarFont.minhaFont(PixelFont.PixelOperator, "40f");
		
		// imgAnonymous
		imgAnonymous = new MyLabel(
			200, 200, ProcessaImagem.processarArredondamento(Images.anonymous)
		);
		
		imgAnonymous.setLocation(
			(d.width - imgAnonymous.getWidth()) / 2
			, (d.height - imgAnonymous.getHeight()) / 2 - 75
		);
		
		// lblAnonymous
		lblAnonymous = new MyLabel(
			200, 70, "Anonymous", myFont, Color.WHITE
			, null, SwingConstants.CENTER, SwingConstants.CENTER
		);
		
		lblAnonymous.setLocation(
			(d.width - lblAnonymous.getWidth()) / 2
			, (d.height - lblAnonymous.getHeight()) / 2 + 75
		);
	}
	
	/* Classe TextoLoading */
	public class TelaDelay implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 1; i++) {
				try {
					Thread.sleep(1200);
					
				} catch (Exception e) {}
			}
			
			TelaInicial.getInstance();
			setInstance();
		}
	}
	
	public static synchronized void setInstance() {
		INSTANCE.dispose();
		INSTANCE = null;
	}
	
	public static synchronized TelaApresentacao getInstance() {
		// Se não haver uma instancia, cria uma
		if (INSTANCE == null) {
			INSTANCE = new TelaApresentacao();
		}
		
		return INSTANCE;
	}

}

