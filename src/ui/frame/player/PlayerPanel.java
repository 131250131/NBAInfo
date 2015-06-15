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
	int height = (int) (4000 * UIData.changeY);
	
	public PlayerPanel(PlayerVO player){
		this.setLayout(null);
		this.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setVisible(true);
		
		JLabel title = new JLabel("球员信息");
		title.setBounds((int) (285 * UIData.changeX), (int) (30 * UIData.changeY), (int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		title.setForeground(Color.LIGHT_GRAY);
		title.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		title.setVisible(true);
		this.add(title);
		
		int labelX = (int) (200 * UIData.changeX);
		int labelWidth = (int) (1410 * UIData.changeX);
		int playerLabelY = (int) (100 * UIData.changeY);
		int playerLabelHeight = (int) (300 * UIData.changeY);
		int dataLabelHeight = (int) (3000 * UIData.changeY);
		
		JPanel black = new JPanel();
		black.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.6f));
		black.setBounds((int) (201 * UIData.changeX), (int) (674 * UIData.changeY), (int) (1411 * UIData.changeX), (int) (20 * UIData.changeY));
		black.setVisible(true);
		this.add(black);
		
		JPanel black2 = new JPanel();
		black2.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.6f));
		black2.setBounds((int) (201 * UIData.changeX), (int) ((674 + 270) * UIData.changeY), (int) (1411 * UIData.changeX), (int) (20 * UIData.changeY));
		black2.setVisible(true);
		this.add(black2);
		
		PlayerInfoLabel playerInfoLabel = new PlayerInfoLabel(labelX, playerLabelY, labelWidth, playerLabelHeight, player);
		this.add(playerInfoLabel);
		
		int tableHeight = (int) (650 * UIData.changeY);
		
		PlayerDataTable playerDataTabel = new PlayerDataTable(labelX, playerLabelY + playerLabelHeight, labelWidth, tableHeight, player);
		this.add(playerDataTabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(labelX, playerLabelY + playerLabelHeight, labelWidth, tableHeight);
		panel.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.6f));
		panel.setVisible(true);
		this.add(panel);
		
		PlayerDataLabel playerDataLabel = new PlayerDataLabel(labelX, playerLabelY + playerLabelHeight + tableHeight, labelWidth, dataLabelHeight, player);
		this.add(playerDataLabel);
		
		JPanel backPanel = new JPanel();
		backPanel.setBounds(labelX, 0, labelWidth, height);
		backPanel.setBackground(new Color(0, 0, 0, 0.8f));
		backPanel.setVisible(true);
		this.add(backPanel);
	}

}
