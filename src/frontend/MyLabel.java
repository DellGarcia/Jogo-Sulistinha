package frontend;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MyLabel extends JLabel {
	
	public MyLabel(int largura, int altura, ImageIcon img) {
		setSize(largura, altura);
		setBackground(null);
		setLayout(null);
		setOpaque(false);
		setIcon(img);
	}
	
	public MyLabel(int largura, int altura, String txt, Font font, Color foreground) {
		setSize(largura, altura);
		setFont(font);
		setText(txt);
		setForeground(foreground);
		setBackground(null);
		setLayout(null);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
	}
	
	public MyLabel(int largura, int altura, String txt, Font font, Color foreground, Color background) {
		setSize(largura, altura);
		setFont(font);
		setText(txt);
		setForeground(foreground);
		setBackground(background);
		setLayout(null);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
	}
	
	public MyLabel(int largura, int altura, String txt, Font font, Color foreground, 
			Color background, int swingHorizontal, int swingVertical) {
		setSize(largura, altura);
		setFont(font);
		setText(txt);
		setForeground(foreground);
		setBackground(background);
		setLayout(null);
		setHorizontalAlignment(swingHorizontal);
		setVerticalAlignment(swingVertical);
	}

}
