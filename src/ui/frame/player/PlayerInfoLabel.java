package ui.frame.player;

import java.awt.Color;

import javax.swing.JPanel;

import vo.PlayerVO;

@SuppressWarnings("serial")
public class PlayerInfoLabel extends JPanel{
		
	public PlayerInfoLabel(int x, int y, int width, int height, PlayerVO player){
		this.setVisible(true);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		//this.setOpaque(false);
		this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.9f));
		
	}

}
