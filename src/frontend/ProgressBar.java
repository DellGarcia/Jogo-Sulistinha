package frontend;

import java.awt.Color;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class ProgressBar extends JProgressBar {
	public Color cor = new Color (65,105,225);
	
	public ProgressBar(int min, int max, int largura, int altura) {
		setMinimum(min);
		setMaximum(max);
		setSize(largura, altura);
		setForeground(cor);
		setBorderPainted(false);
	}

}
