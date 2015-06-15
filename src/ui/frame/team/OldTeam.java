package ui.frame.team;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.frame.index.hotspot.HotspotBounds;
import ui.myUI.BackColorPanel;
import ui.system.UIData;

@SuppressWarnings("serial")
public class OldTeam extends JPanel implements ActionListener{
	
	OldSingleTeamPanel[] singleTeamPanel = new OldSingleTeamPanel[14];
	JButton button;
	
	public OldTeam(){
		
		int width = (int) (1920 * UIData.changeX);
		int height = (int) (1080 * UIData.changeY);
		
		this.setLayout(null);
		this.setBounds(UIData.getNextX(), 0, width, height);
		this.setOpaque(false);
		this.setVisible(true);
		
		JLabel title = new JLabel("过往球队");
		title.setBounds((int) (35 * UIData.changeX), (int) (115 * UIData.changeY), (int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		title.setForeground(Color.ORANGE);
		title.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		title.setVisible(true);
		this.add(title);
		
		initTeamPanel();
		
		BackColorPanel backPanel1 = new BackColorPanel(0,
				(int) (((1280 - 900) / 2 - 20) * UIData.changeY), HotspotBounds.BackPanel1Width, (int) (940 * UIData.changeY), 0);
		this.add(backPanel1);
		
		BackColorPanel backPanel = new BackColorPanel(0, 0, width, height, 5);
		this.add(backPanel);
		
		button = new JButton();
		button.setBounds((int) (1720 * UIData.changeX), 0, (int) (200 * UIData.changeX), (int) (1080 * UIData.changeY));
		button.setVisible(true);
		button.setOpaque(false);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		button.addActionListener(this);
		this.add(button);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == button){
			UIData.returnToFormerStep();
			this.setVisible(false);
		}
		
	}
	
	private void initTeamPanel(){
		//太平洋区 西南区 西北区
		//大西洋区 东南区 中部区
		int panelX = (int) (200 * UIData.changeX);
		int panelXE = (int) (1130 * UIData.changeX);
		int panelY = (int) (80 * UIData.changeY);
		int panelWidth = (int) (600 * UIData.changeX);
		int panelHeight = (int) (120 * UIData.changeY);
		int blank = (int) (8 * UIData.changeY);
		
		for(int i = 0; i < 7; i++){
			singleTeamPanel[i] = new OldSingleTeamPanel(i);
			singleTeamPanel[i].setBounds(panelX, panelY + (panelHeight + blank) * i, panelWidth, panelHeight);
			singleTeamPanel[i].setVisible(true);
			this.add(singleTeamPanel[i]);
		}
		
		for(int i = 7; i < 14; i++){
			singleTeamPanel[i] = new OldSingleTeamPanel(i);
			singleTeamPanel[i].setBounds(panelXE, panelY + (panelHeight + blank) * (i - 7), panelWidth, panelHeight);
			singleTeamPanel[i].setVisible(true);
			this.add(singleTeamPanel[i]);
		}
	}

}
