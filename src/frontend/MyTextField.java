package frontend;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MyTextField extends JTextField {
	
	public MyTextField(int largura, int altura, String txt, Font font, Color background, Color foreground) {
		setSize(largura, altura);
		setText(txt);
		setFont(font);
		setBackground(background);
		setForeground(foreground);
		setLayout(null);
		setBorder(null);
		setEditable(false);
		setFocusable(false);
		setHorizontalAlignment(SwingConstants.CENTER);
	}
}