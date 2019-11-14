package frontend;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MyButton extends JButton {
	
	public MyButton(int x, int y, int width, int height, Color backgroung, Color foreground, 
			Font font, String txt, Color border, int line, Color hoverBackground, Color hoverForeground) {
		setSize(width, height);
		setLocation(x, y);
		setFont(font);
		setBackground(backgroung);
		setForeground(foreground);
		setText(txt);
		setSelected(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(true);
		setBorder(BorderFactory.createLineBorder(border, line));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		// Mouse Listener
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(backgroung);
				setForeground(foreground);
				setBorder(BorderFactory.createLineBorder(border, line));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(hoverBackground);
				setForeground(hoverForeground);
				setBorder(BorderFactory.createLineBorder(hoverForeground, line));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
				
		// Mouse Motion Listener
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {}
			
			@Override
			public void mouseDragged(MouseEvent e) {}
			
		});
		
	}
	
	public MyButton(int x, int y, int width, int height, Color backgroung, 
			Color foreground, Font font, String txt, Color border, int line) {
		setSize(width, height);
		setLocation(x, y);
		setFont(font);
		setBackground(backgroung);
		setForeground(foreground);
		setText(txt);
		setSelected(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setFocusPainted(false);
		setBorder(BorderFactory.createLineBorder(border, line));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public MyButton(int x, int y, int width, int height, Color backgroung, Color foreground) {
		setSize(width, height);
		setLocation(x, y);
		setFont(new Font("Lucida Console", Font.PLAIN, 25));
		setBackground(backgroung);
		setForeground(foreground);
		setSelected(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setFocusPainted(false);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public MyButton(int x, int y, int width, int height) {
		setSize(width, height);
		setLocation(x, y);
		setFont(new Font("Lucida Console", Font.PLAIN, 25));
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setSelected(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setFocusPainted(false);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public MyButton(int x, int y, int largura, int altura, Image img) {
		setLocation(x, y);
		setSize(largura, altura);
		setOpaque(false);
		setSelected(false);
		setBorder(null);
		setFocusable(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setIcon(new ImageIcon(img));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent evt) {}
			
			@Override
			public void mousePressed(MouseEvent evt) {}
			
			@Override
			public void mouseExited(MouseEvent evt) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent evt) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent evt) {}
		});
	}
	
	public MyButton() {
		setFont(new Font("Lucida Console", Font.PLAIN, 25));
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setSelected(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setFocusPainted(false);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
