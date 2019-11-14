package frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel extends JPanel {
	
	private Image img;
	
	public MyPanel() {
		setLayout(null);
	}

	public MyPanel(Color background) {
		setBackground(background);
		setLayout(null);
	}
	
	public MyPanel(int largura, int altura, Color background) {
		setSize(largura, altura);
		setBackground(background);
		setLayout(null);
	}
	
	public MyPanel(Image img) {
		this.img = img;
		setLayout(null);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this);
	}

}
