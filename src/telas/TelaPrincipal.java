package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import backend.Jogo;
import frontend.AdventureAttack;
import frontend.InfiniteAnimation;
import frontend.LabelHTML;
import frontend.MobAttack;
import frontend.MyButton;
import frontend.MyLabel;
import frontend.MyPanel;
import frontend.ProgressBar;
import frontend.RegistrarFont;
import frontend.Som;
import model.Personagem;
import statics.Cores;
import statics.Images;
import statics.PixelFont;
import statics.Sound;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {
	
	// JPanel
	private JPanel tela;
	private JPanel areaQuestao;
	private JPanel batalha;
	private JPanel adventure;
	private JPanel mob;
	private JPanel chao;
	private JPanel background;
	
	private MobAttack mobAttack;
	private AdventureAttack adventureAttack;
	
	// Vidas
	private JPanel vidasAdventure[][];
	private JPanel vidasMob[][];
	String[] vidas = {Images.heart, Images.noHeart};
	
	// JLabel
	private JLabel lblEnunciado;
	
	// JTextArea
	private JTextArea txaAlternativas;
	
	// JRadioButton
	private JButton[] btnAlternativa;
	
	private JProgressBar pbTempoResposta;
	
	// Toolkit
	public Toolkit tk = Toolkit.getDefaultToolkit();
	public Dimension d = tk.getScreenSize();
	
    // Jogo
    private Jogo game;
    private int indexQuestao;
    
    //Personagens
    private Personagem principal;
    private Personagem inimigo;
    
    // Thread
    private Thread loading;
    
    // Font
    private Font myFont;
    
    // Musica 
 	protected static Som objSom;
 	protected static String musicaFundo;
 	
 	// TelaPrincipal 
 	private static TelaPrincipal INSTANCE;
 	
 	// Construtor
	private TelaPrincipal() {
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
		
		// Musica de Fundo
		objSom.playSound(musicaFundo, Clip.LOOP_CONTINUOUSLY);
		
		// Adicionar
		batalha.add(mob);
		batalha.add(adventure);
		batalha.add(chao);
		batalha.add(background);
		
		tela.add(batalha);
		tela.add(areaQuestao);
		
		areaQuestao.add(lblEnunciado);
		areaQuestao.add(pbTempoResposta);
		areaQuestao.add(txaAlternativas);

		setContentPane(tela);
		setVisible(true);
	}
	
	public void init() {
		// JPanels
		tela = new MyPanel();
		areaQuestao = new MyPanel(d.width, 500, Cores.corCinza);
		areaQuestao.setLocation(0, d.height - areaQuestao.getHeight());
		
		// Thread
		loading = new Thread(new CarregarBarra());
		
		// Vidas
		vidasAdventure = new MyPanel[5][2];
		vidasMob = new MyPanel[5][2];
		
		// Area batalha
		batalha = new MyPanel(new Color(33, 33, 37));
		batalha.setSize(new Dimension(d.width, d.height - 500));
		batalha.setLocation(0, 0);
		
		btnAlternativa = new JButton[4];
		
		objSom = new Som();
		musicaFundo = Sound.goblinSlayerOP;
		
		myFont = RegistrarFont.minhaFont(PixelFont.PixelOperator, "25f");
		
		principal = new Personagem();
		inimigo = new Personagem();
		principal.setInimigo(false);
		inimigo.setInimigo(true);
		
		game = new Jogo();
		indexQuestao = 0;
		
		// Chao
		chao = new MyPanel(new ImageIcon(Images.floor).getImage().getScaledInstance(1389, 150, 1));
		chao.setSize(d.width, 50);
		chao.setOpaque(false);
		chao.setLocation(0, batalha.getHeight() - chao.getHeight());
		
		// Background
		background = new MyPanel(new ImageIcon(Images.background).getImage());
		background.setSize(d.width, batalha.getHeight() - 10);
		background.setLocation(0, 0);
	
		// Principal
		adventure = new InfiniteAnimation("adventure-idle", 150, 88, 102);
		adventure.setLocation(150, batalha.getHeight() - adventure.getHeight() - 50);
	
		// Inimigo
		mob = new InfiniteAnimation("skeleton-idle", 75, 84, 119);
		mob.setLocation(batalha.getWidth() - mob.getWidth() - 150, batalha.getHeight() - mob.getHeight() - 50);
		
		// Ataque inimigo
		mobAttack = new MobAttack();
		mobAttack.setSize(180, 156);
		mobAttack.setLocation(adventure.getX() + adventure.getWidth() - 40, mobAttack.getHeight() - 90);
		
		// Ataque Adventure
		adventureAttack = new AdventureAttack();
		adventureAttack.setSize(200, 146);
		adventureAttack.setLocation(mob.getX() - adventureAttack.getWidth() + 30, adventureAttack.getHeight() - 70);
		
		// Vida Adventure
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				vidasAdventure[j][i] = new MyPanel(new ImageIcon(vidas[i]).getImage().getScaledInstance(50, 47, 1));
				vidasAdventure[j][i].setSize(50, 47);
				vidasAdventure[j][i].setLocation(((adventure.getX() - vidasAdventure[j][i].getWidth()) / 2 + j*60), 25);
				vidasAdventure[j][i].setOpaque(false);
				batalha.add(vidasAdventure[j][i]);
			}
		}
			
		// Vida Mob
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				vidasMob[j][i] = new MyPanel(new ImageIcon(vidas[i]).getImage().getScaledInstance(50, 47, 1));
				vidasMob[j][i].setSize(50, 47);
				vidasMob[j][i].setLocation(((mob.getX() - vidasMob[j][i].getWidth() - 75) + j*60), 25);
				vidasMob[j][i].setOpaque(false);
				batalha.add(vidasMob[j][i]);
			}
		}
		
		// Area do Enunciado da Questão
		lblEnunciado = new MyLabel(
			areaQuestao.getWidth() / 100 * 50, areaQuestao.getHeight() / 100 * 20
			, LabelHTML.html(game.getQuestions().get(indexQuestao).getEnunciado(), "50"), myFont
			, Color.BLACK, Color.WHITE
		);
		
		lblEnunciado.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		lblEnunciado.setLocation(areaQuestao.getWidth() / 2 - lblEnunciado.getWidth() / 2, areaQuestao.getHeight()/100*20);
		lblEnunciado.setFocusable(false);
		lblEnunciado.setOpaque(true);
		
		//Progress Bar
		pbTempoResposta = new ProgressBar(0, 100, areaQuestao.getWidth()/100*50, 20, Cores.corVerde, Color.BLACK, 3);
		pbTempoResposta.setLocation(
			areaQuestao.getWidth()/2 - pbTempoResposta.getWidth()/2
			, areaQuestao.getHeight()/100*40 + 50
		);
		
		// TextArea Alternativas
		txaAlternativas = new JTextArea();
		txaAlternativas.setSize(areaQuestao.getWidth()/100*70, areaQuestao.getHeight()/100*30);
		txaAlternativas.setLocation(areaQuestao.getWidth()/2 - txaAlternativas.getWidth()/2, areaQuestao.getHeight()/100*30 + 175);
		txaAlternativas.setLayout(new GridLayout(2, 2));
		txaAlternativas.setEditable(false);
		txaAlternativas.setFocusable(false);
		txaAlternativas.setBackground(Color.BLACK);
		txaAlternativas.setForeground(Color.WHITE);
		txaAlternativas.setFont(myFont);
		
		// Button Alternativas
		for (int i = 0; i < 4; i++) {
			btnAlternativa[i] = new MyButton (
				0, 0, 0, 0, 
				Color.WHITE, Color.BLACK,
				myFont, LabelHTML.html(game.getQuestions().get(indexQuestao).getAlternativas().get(i).getTexto(), "50"), 
				Color.BLACK, 3,
				new Color(200, 221, 230), Color.BLACK
			);
			
			int k = i;
			
			btnAlternativa(i, k);
			txaAlternativas.add(btnAlternativa[i]);
		}
	}
	
	
	/* Métodos */
	public void atualizarQuestao() {
		if(indexQuestao + 1 < game.getQuestions().size()) {
			game.setAtivo(true);
			indexQuestao++;
			lblEnunciado.setText(LabelHTML.html(game.getQuestions().get(indexQuestao).getEnunciado(), "50"));
			
			for(int i = 0; i < 4; i++) {
				btnAlternativa[i].setBackground(Color.WHITE);
				btnAlternativa[i].setText(LabelHTML.html(game.getQuestions().get(indexQuestao).getAlternativas().get(i).getTexto(), "50"));
			}
			
			loading = new Thread(new CarregarBarra());
			loading.start();
			pbTempoResposta.setForeground(Cores.corVerde);
			
		} else {
//			new TelaFim(null);
		}
		
	}
	
	/* Classe CarregarBarra */
	public class CarregarBarra implements Runnable {
		@Override
		public void run() {
			for (int i = 100; i >= 0; i--) {
				try {
					Thread.sleep(250);
					pbTempoResposta.setValue(i);
					
					if (pbTempoResposta.getValue() <= 25) {
						pbTempoResposta.setForeground(Cores.corVermelha);
						
					} else if (pbTempoResposta.getValue() <= 50) {
						pbTempoResposta.setForeground(Cores.corLaranja);
						
					} else if (pbTempoResposta.getValue() <= 75) {
						pbTempoResposta.setForeground(Cores.corAmarela);
						
					}
					
				} catch (Exception e) {}
			}
			
			game.setErros();
			principal.setVidas();
			ataque(false);
			
			
			for(int j = 0; j < 4; j++) {
				if(game.getQuestions().get(indexQuestao).getAlternativas().get(j).isCorreta()) {
					btnAlternativa[j].setBackground(Cores.corVerde);
				}
			}
			
			new Timer().schedule(new TimerTask() {
				
				@Override
				public void run() {
					game.setErros();
					atualizarQuestao();
					idle();
				}
				
			}, 700);
		}
	}
	
	/* Ação Botão Alternativa */
	public void btnAlternativa(int i, int k) {
		btnAlternativa[i].addActionListener(new ActionListener() {
			Timer timer = new Timer();
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				loading.stop();
				
				// Se o jogo está ativo
				if(game.isAtivo()) {
					// Se a alternativa escolhida está correta
					if(game.getQuestions().get(indexQuestao).getAlternativas().get(k).isCorreta()) {
						btnAlternativa[k].setBackground(Cores.corVerde);
						game.setAcertos();
						inimigo.setVidas();
						ataque(true);
						
						if(inimigo.getVidas() == 0) {
							new TelaFim("Jogador");
							game.setAtivo(false);
						}
						
					} else {
						btnAlternativa[k].setBackground(Cores.corVermelha);
						
						for(int j = 0; j < 4; j++) {
							// Marcar a opção correta de verde
							if(game.getQuestions().get(indexQuestao).getAlternativas().get(j).isCorreta()) {
								btnAlternativa[j].setBackground(Cores.corVerde);
								
							}
						}
						
						game.setErros();
						principal.setVidas();
						ataque(false);
						
						if(principal.getVidas() == 0) {
							new TelaFim("Mob");
							game.setAtivo(false);
							
						}
					}
					
					if(game.isAtivo()) {
						game.setAtivo(false);
						timer.schedule(new TimerTask() {
							
							@Override
							public void run() {
								atualizarQuestao();
								
								idle();
							}
							
						}, 1000);
					}
					
				}
			}
		});
	}
	
	public void ataque(Boolean jogador) {
		if (jogador) {
			vidasMob[inimigo.getVidas()][0].setVisible(false);
			/*adventure.setVisible(false);
			adventureAttack.iniciarAnimacao();*/
			
		} else {
			vidasAdventure[principal.getVidas()][0].setVisible(false);
			/*mob.setVisible(false);
			mobAttack.iniciarAnimacao();*/
			
		}
	}
	
	public void idle() {
		mob.setVisible(true);
		adventure.setVisible(true);
	}
	
	// INSTANCE
	public static synchronized void setInstance() {
		INSTANCE.dispose();
		INSTANCE = null;
	}
	
	public static synchronized void restart() {
		// Pega a antiga instancia, cria uma nova e fecha a antiga
		TelaPrincipal OLDINSTANCE = INSTANCE;
		INSTANCE = new TelaPrincipal();
		OLDINSTANCE.dispose();
	}
	
	
	public static synchronized TelaPrincipal getInstance() {
		// Se não haver uma instancia, cria uma
		if (INSTANCE == null) {
			INSTANCE = new TelaPrincipal();
		}
		
		return INSTANCE;
	}
	
}
