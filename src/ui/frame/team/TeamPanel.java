package ui.frame.team;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.system.ChineseTranslator;
import ui.system.ImageSaver;
import ui.system.UIData;
import vo.TeamVO;

@SuppressWarnings("serial")
public class TeamPanel extends JPanel{
	
	int width = (int) (1720 * UIData.changeX);
	int height = (int) (5000 * UIData.changeY);
	
	public TeamPanel(TeamVO team){
		this.setLayout(null);
		this.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setVisible(true);
		
		JLabel title = new JLabel("球队信息");
		title.setBounds((int) (285 * UIData.changeX), (int) (30 * UIData.changeY), (int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		title.setForeground(Color.LIGHT_GRAY);
		title.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		title.setVisible(true);
		this.add(title);
		
		int labelX = (int) (200 * UIData.changeX);
		int labelWidth = (int) (1410 * UIData.changeX);
		int playerLabelY = (int) (100 * UIData.changeY);
		int playerLabelHeight = (int) (300 * UIData.changeY);
		TeamInfoLabel teamInfoLabel = new TeamInfoLabel(labelX, playerLabelY, labelWidth, playerLabelHeight, team);
		this.add(teamInfoLabel);
		
		TeamDataTable teamDataTabel = new TeamDataTable(labelX, playerLabelY + playerLabelHeight * 4 - (int) (180 * UIData.changeY), labelWidth, playerLabelHeight * 10 + (int) (480 * UIData.changeY), team);
		this.add(teamDataTabel);
		
		TeamDataLabel dataLabel = new TeamDataLabel(labelX, playerLabelY + playerLabelHeight * 4 + (int) (300 * UIData.changeY), labelWidth, playerLabelHeight * 10, team);
		this.add(dataLabel);
		
		TeamList teamList = new TeamList(team);
		teamList.setBounds(labelX, playerLabelY + playerLabelHeight, labelWidth, playerLabelHeight * 3);
		this.add(teamList);
		
		JPanel panel = new JPanel();
		panel.setBounds(labelX, teamDataTabel.getY(), labelWidth, teamDataTabel.getY() + teamDataTabel.getHeight() - (playerLabelY + playerLabelHeight));
		panel.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.6f));
		panel.setVisible(true);
		this.add(panel);
		
		JPanel backPanel = new JPanel();
		backPanel.setBounds(labelX, 0, labelWidth, height);
		backPanel.setBackground(ImageSaver.getTeamBackColor(ChineseTranslator.TeamNameTrans(team.getTeamName())));
		backPanel.setVisible(true);
		this.add(backPanel);
	}

}
