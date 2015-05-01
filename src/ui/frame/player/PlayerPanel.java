package ui.frame.player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.system.UIData;
import vo.PlayerVO;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel{
	
	int width = (int) (1720 * UIData.changeX);
	int height = (int) (3000 * UIData.changeY);
	
	public PlayerPanel(PlayerVO player){
		this.setLayout(null);
		this.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setVisible(true);
		
		JLabel title = new JLabel("球员信息");
		title.setBounds((int) (85 * UIData.changeX), (int) (30 * UIData.changeY), (int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		title.setForeground(Color.ORANGE);
		title.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		title.setVisible(true);
		this.add(title);
		
		int labelX = (int) (200 * UIData.changeX);
		int labelWidth = (int) (1410 * UIData.changeX);
		int playerLabelY = (int) (100 * UIData.changeY);
		int playerLabelHeight = (int) (300 * UIData.changeY);
		PlayerInfoLabel playerInfoLabel = new PlayerInfoLabel(labelX, playerLabelY, labelWidth, playerLabelHeight, player);
		this.add(playerInfoLabel);
	}

}
