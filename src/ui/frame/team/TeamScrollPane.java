package ui.frame.team;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import ui.myUI.ImageLabel;
import ui.system.Controller;
import ui.system.ImageSaver;
import ui.system.UIData;
import vo.TeamVO;

@SuppressWarnings("serial")
public class TeamScrollPane extends JScrollPane  implements ActionListener{
	
	String teamName;
	TeamVO team;
	
	int x = UIData.getNextX();
	int y = 0;
	int width = UIData.slideSize;
	int height = UIData.fheight;
	
	JButton button;
	
	public TeamScrollPane(String _teamName){
		init(_teamName);
		this.setBounds(x, y, width, height);
		this.setBackground(null);
		this.setOpaque(false);
		this.getViewport().setOpaque(false);
		this.setBorder(null);
		this.getVerticalScrollBar().setOpaque(false);
		this.getVerticalScrollBar().setBorder(BorderFactory.createEmptyBorder());
		this.getVerticalScrollBar().setUnitIncrement(35);

		TeamPanel teamPanel = new TeamPanel(team);
		this.setViewportView(teamPanel);
		
		button = new JButton();
		button.setBounds((int) (1720 * UIData.changeX), y, (int) (200 * UIData.changeX), teamPanel.height);
		button.setVisible(true);
		button.setOpaque(false);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		button.addActionListener(this);
		this.add(button);
		
		ImageLabel addback1 = new ImageLabel(ImageSaver.getIcon("新增页面背景2"), 0, 0, UIData.frameWidth, UIData.frameHeight);
		this.add(addback1);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == button){
			UIData.returnToFormerStep();
			this.setVisible(false);
		}
		
	}
	
	private TeamVO getTeam(){
		
		ArrayList<TeamVO> array = Controller.teamController.getTeamHistorySeason(teamName, 0);
		TeamVO team = array.get(array.size() - 1);
		return team;
	}
	
	private void init(String _teamName){
		teamName = _teamName;
		team = getTeam();
	}
}
