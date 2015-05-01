package ui.frame.player;

import java.awt.Color;

import javax.swing.JPanel;

import ui.myUI.ImageLabel;
import ui.system.ImageSaver;
import ui.system.UIData;
import vo.PlayerVO;

@SuppressWarnings("serial")
public class PlayerInfoLabel extends JPanel{
		
	public PlayerInfoLabel(int x, int y, int width, int height, PlayerVO player){
		this.setVisible(true);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		//this.setOpaque(false);
		this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.6f));
		
		
		//player.getPlayerName()
		ImageLabel image = new ImageLabel(ImageSaver.getPlayerIcon("Alan Anderson")
				, (int) (30 * UIData.changeX), (int) (30 * UIData.changeY), (int) (240 * UIData.changeX), (int) (200 * UIData.changeY));
		this.add(image);
	}

}
