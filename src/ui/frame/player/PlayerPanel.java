package ui.frame.player;

import java.awt.Dimension;

import javax.swing.JPanel;

import ui.system.UIData;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel{
	
	int width = (int) (1720 * UIData.changeX);
	int height = (int) (3000 * UIData.changeY);
	
	public PlayerPanel(){
		this.setLayout(null);
		this.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setVisible(true);
		
		
	}

}
