package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class AnimacaoEntrada extends JPanel {

	
	private int x = 10;
	private int y = 10;
	private int myTimerDelay;
	private final Timer myTimer;
	private Dimension dimension = TelaPrincipal.dimension;
	
	public AnimacaoEntrada() {
		super();
		this.setSize(new Dimension(dimension.width, dimension.height-600));
		this.setVisible(true);
		this.setBackground(Color.WHITE);
		myTimerDelay = 100;
		myTimer = new Timer(myTimerDelay, gameTimer);
		myTimer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval(x, y, 50, 50);
	}
	
	public void redraw() {
		if(x + 60 > dimension.width) {
			x = 0;
			if(y + 60 > dimension.height) {
				y = 0;
			}else {
				y += 50;
			}
		}else {
			x += 20;
		}
		this.repaint();
	}
	
	ActionListener gameTimer = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			redraw();
		}
	};
	
}
