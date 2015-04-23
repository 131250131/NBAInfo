package ui.myUI;

import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BackColorPanel extends JPanel{
	
	public BackColorPanel(int x, int y, int width, int height, int style){
		this.setBounds(x, y, width, height);
		switch(style){
		case 0: 
			this.setBackground(new Color(0.6f, 0.6f, 0.6f, 0.3f));
			break;
		case 1:
			this.setBackground(new Color(97f / 255, 45f / 255, 141f / 255, 0.1f));
			break; 
		case 2:
			this.setBackground(new Color(241f / 255, 92f / 255, 54f / 255, 0.1f));
			break;
		}
		this.setVisible(true);
	}

}
