package frontend;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import backend.Jogo;
import backend.Personagem;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {
	
	// JPanel
	private JPanel tela;
	private JPanel areaQuestao;
	private JPanel areaAnimacao;
	
	// JLabel
	private JLabel lblEnunciado;
	
	// JTextArea
	private JTextArea txaAlternativas;
	
	// JRadioButton
	private JButton[] btnAlternativa;
	
	private JProgressBar pbTempoResposta;
	
	// Toolkit
	protected static Toolkit tk = Toolkit.getDefaultToolkit();
	protected static Dimension dimension = tk.getScreenSize();
	
    // Jogo
    private Jogo game;
    private int indexQuestao;
    
    //Personagens
    private Personagem principal;
    private Personagem inimigo;
    
    // Thread
    private Thread loading;
    
    // Font
    private Font century;
    
	
	public TelaPrincipal() {
		// TODO Auto-generated constructor stub
		tela = new JPanel();
		areaQuestao = new JPanel();
		areaAnimacao = new JPanel();
		lblEnunciado = new JLabel();
		txaAlternativas = new JTextArea();
		btnAlternativa = new JButton[4];
		principal = new Personagem();
		principal.setInimigo(false);
		inimigo = new Personagem();
		inimigo.setInimigo(true);
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
		
		// Animacao
		areaAnimacao = new AnimacaoBatalha();
		areaAnimacao.setLocation(0, 0);
		tela.add(areaAnimacao);
		
		// Area da Questao
		areaQuestao.setSize(dimension.width, 600);
		areaQuestao.setLayout(null);
		areaQuestao.setBackground(Color.DARK_GRAY);
		areaQuestao.setLocation(0, dimension.height - areaQuestao.getHeight());
		tela.add(areaQuestao);
		
		// Area do Enunciado da Questão
		lblEnunciado.setSize(areaQuestao.getWidth()/100*40, areaQuestao.getHeight()/100*20);
		lblEnunciado.setLocation(areaQuestao.getWidth()/2 - lblEnunciado.getWidth()/2, 20);
		lblEnunciado.setText(game.getQuestions().get(indexQuestao).getEnunciado());
		lblEnunciado.setFocusable(false);
		lblEnunciado.setOpaque(true);
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnunciado.setBackground(Color.WHITE);
		lblEnunciado.setForeground(Color.BLACK);
		lblEnunciado.setFont(century);
		areaQuestao.add(lblEnunciado);
		
		//Progress Bar
		pbTempoResposta = new ProgressBar(0, 100, areaQuestao.getWidth()/100*50, 20);
		pbTempoResposta.setLocation(areaQuestao.getWidth()/2 - pbTempoResposta.getWidth()/2, areaQuestao.getHeight()/100*30 + 50);
		pbTempoResposta.setValue(20);
		loading = new Thread(new CarregarBarra());
		loading.start();		
		areaQuestao.add(pbTempoResposta);
		
		// Area das alternativas
		txaAlternativas.setSize(areaQuestao.getWidth()/100*60, areaQuestao.getHeight()/100*40);
		txaAlternativas.setLocation(areaQuestao.getWidth()/2 - txaAlternativas.getWidth()/2, areaQuestao.getHeight()/100*30 + 100);
		txaAlternativas.setLayout(new GridLayout(2, 2));
		for(int i = 0; i < 4; i++) {
			btnAlternativa[i] = new BotaoPersonalizado();
			btnAlternativa[i].setText(game.getQuestions().get(indexQuestao).getAlternativas().get(i).getTexto());
			btnAlternativa[i].setBackground(Color.WHITE);
			btnAlternativa[i].setForeground(Color.BLACK);
			btnAlternativa[i].setHorizontalAlignment(SwingConstants.CENTER);
			btnAlternativa[i].setFont(century);
			int k = i;
			btnAlternativa[i].addActionListener(new ActionListener() {
				Timer timer = new Timer();
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					loading.stop();
					if(game.isAtivo()) {
						if(game.getQuestions().get(indexQuestao).getAlternativas().get(k).isCorreta()) {
							btnAlternativa[k].setBackground(Color.GREEN);
							game.setAcertos();
							inimigo.setVidas();
							if(inimigo.getVidas() == 0) {
								JOptionPane.showMessageDialog(null, "Voce Ganhou");
								game.setAtivo(false);
							}
						}else {
							btnAlternativa[k].setBackground(Color.RED);
							for(int j = 0; j < 4; j++) {
								if(game.getQuestions().get(indexQuestao).getAlternativas().get(j).isCorreta()) {
									btnAlternativa[j].setBackground(Color.GREEN);
								}
							}
							game.setErros();
							principal.setVidas();
							if(principal.getVidas() == 0) {
								JOptionPane.showMessageDialog(null, "Voce Perdeu");
								game.setAtivo(false);
							}
						}
						if(game.isAtivo()) {
							game.setAtivo(false);
							timer.schedule(new TimerTask() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									atualizarQuestao();
								}
							}, 700);
						}
					}
				}
			});
			txaAlternativas.add(btnAlternativa[i]);
		}
		txaAlternativas.setEditable(false);
		txaAlternativas.setFocusable(false);
		txaAlternativas.setBackground(Color.BLACK);
		txaAlternativas.setForeground(Color.WHITE);
		txaAlternativas.setFont(century);
		areaQuestao.add(txaAlternativas);
		
		
		setVisible(true);
		
	}
	
	public void atualizarQuestao() {
		if(indexQuestao + 1 < game.getQuestions().size()) {
			game.setAtivo(true);
			indexQuestao++;
			lblEnunciado.setText(game.getQuestions().get(indexQuestao).getEnunciado());
			for(int i = 0; i < 4; i++) {
				btnAlternativa[i].setBackground(Color.WHITE);
				btnAlternativa[i].setText(game.getQuestions().get(indexQuestao).getAlternativas().get(i).getTexto());
			}
			loading = new Thread(new CarregarBarra());
			loading.start();
		}else {
			JOptionPane.showMessageDialog(null, "O Jogo Acabou\nAcertos: " + game.getAcertos()  + "\nErros: " + game.getErros());
		} 
		
	}
	
	/* Classe CarregarBarra */
	public class CarregarBarra implements Runnable {
		@Override
		public void run() {
			for (int i = 100; i > 0; i--) {
				try {
					Thread.sleep(50);
					pbTempoResposta.setValue(i);
				} catch (Exception e) {}
			}
			game.setErros();
			atualizarQuestao();
		}
	}
	
}
