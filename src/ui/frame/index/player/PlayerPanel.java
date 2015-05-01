package ui.frame.index.player;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.BackColorPanel;
import ui.system.UIData;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel{

	int x = UIData.playerBoundsX;
	int y = UIData.playerBoundsY;
	int width = UIData.playerBoundsWidth;
	int height = UIData.playerBoundsHeight;
	
	public PlayerPanel(){
		this.setVisible(true);
		this.setOpaque(false);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		
		JLabel title = new JLabel("球员列表");
		title.setBounds((int) (185 * UIData.changeX), (int) (115 * UIData.changeY), (int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		title.setForeground(Color.ORANGE);
		title.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		title.setVisible(true);
		this.add(title);
		
		BackColorPanel backPanel = new BackColorPanel(0, 0, width, height, 6);
		this.add(backPanel);
	}
	
}
