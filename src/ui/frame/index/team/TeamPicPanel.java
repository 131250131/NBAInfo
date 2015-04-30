package ui.frame.index.team;

import java.awt.Color;

import javax.swing.JPanel;

import ui.myUI.ImageLabel;
import ui.system.ImageSaver;
import ui.system.UIData;

@SuppressWarnings("serial")
public class TeamPicPanel extends JPanel{

	public TeamPicPanel(int x, int y , int width, int height, String teamName){
		this.setVisible(true);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setBackground(new Color(0.7f, 0.7f, 0.7f, 0.1f));
		
		int picX = (int) (-40 * UIData.changeX);
		int picY = (int) (30 * UIData.changeY);
		int picWidth = (int) (200 * UIData.changeX);
		int picHeight = (int) (200 * UIData.changeY);
		
		ImageLabel teamImage = new ImageLabel(ImageSaver.getTeamIcon(teamName), picX, picY, picWidth, picHeight);
		this.add(teamImage);
	}
	
}
