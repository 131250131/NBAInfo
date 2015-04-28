package ui.myUI;

import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BackColorPanel extends JPanel{
	
	public BackColorPanel(int x, int y, int width, int height, int style){
		this.setBounds(x, y, width, height);

		Color color1 = null, color2 = null, color3 = null;
		

		color1 = getBackColor(30, 28, 72, 0.3f);
		color2 = getBackColor(11, 10, 28, 0.4f);
		color3 = getBackColor(10, 10, 10, 0.8f);
	
		if(style == 0){
			this.setBackground(color3);
		}else{
			if(style % 2 == 0){
				this.setBackground(color2);
			}else{
				this.setBackground(color1);
			}
		}		
		this.setVisible(true);
	}
	
	private Color getBackColor(int r, int g, int b, float o){
		return new Color((float)r / 255, (float)g / 255, (float)b / 255, o);
	}

}
