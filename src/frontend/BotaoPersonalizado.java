package frontend;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class BotaoPersonalizado extends JButton{
	
	public BotaoPersonalizado(int x, int y, int width, int height, Color backgroung, Color foreground, Font font) {
		// TODO Auto-generated constructor stub
		setSize(width, height);
		setLocation(x, y);
		setFont(font);
		setBackground(backgroung);
		setForeground(foreground);
		setOpaque(true);
		setSelected(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setFocusPainted(false);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public BotaoPersonalizado(int x, int y, int width, int height, Color backgroung, Color foreground) {
		// TODO Auto-generated constructor stub
		setSize(width, height);
		setLocation(x, y);
		setFont(new Font("Lucida Console", Font.PLAIN, 25));
		setBackground(backgroung);
		setForeground(foreground);
		setOpaque(true);
		setSelected(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setFocusPainted(false);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public BotaoPersonalizado(int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
		setSize(width, height);
		setLocation(x, y);
		setFont(new Font("Lucida Console", Font.PLAIN, 25));
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setOpaque(true);
		setSelected(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setFocusPainted(false);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
