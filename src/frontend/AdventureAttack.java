package frontend;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import backend.ArmazenaFrame;

@SuppressWarnings("serial")
public class AdventureAttack extends JPanel implements ActionListener {
	
	// Toolkit 
	private Toolkit tk = Toolkit.getDefaultToolkit();

	// Timer
	private Timer animationTimer;
	private Integer animationTimerDelay;
	
	// Animacao 
	private ArmazenaFrame af;
	private int sizeAnimation;
	private ImageIcon images[];
	private int imagemAtual;
	
	public AdventureAttack() {
		super();
		
		this.animationTimerDelay = 120;
		this.af = new ArmazenaFrame("adventure-attack");
		this.sizeAnimation = af.getFrames().size();
		this.images = new ImageIcon[sizeAnimation];
		this.setOpaque(false);
		this.setSize(new Dimension(157, 137));
		this.setLayout(null);
		this.setVisible(false);
		
	}
	
	public void iniciarAnimacao() {

		this.setVisible(true);
		
		for (int i = 0; i < sizeAnimation; i++) {
			images[i] = new ImageIcon(
					tk.createImage(af.getFrames().get(i).getCaminho()).getScaledInstance(200, 148, Image.SCALE_DEFAULT)
			);
			
			if (animationTimer == null) {
				imagemAtual = 0;
				animationTimer = new Timer(animationTimerDelay, this);
				animationTimer.start();
		      
		    } else if (!animationTimer.isRunning()) animationTimer.restart();
		}
	}
	
	public void pararAnimacao() {
		this.setVisible(false);
		animationTimer.stop();
	}
	
	// ========================================================================================== //
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (images[imagemAtual].getImageLoadStatus() == MediaTracker.COMPLETE) {
			images[imagemAtual].paintIcon(this, g, 0, 0);
			imagemAtual = (imagemAtual + 1) % sizeAnimation;
	    }
		
		if (imagemAtual == sizeAnimation - 1) {
			pararAnimacao();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
}
