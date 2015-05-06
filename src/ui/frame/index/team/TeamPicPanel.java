package ui.frame.index.team;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.ImageLabel;
import ui.system.ChineseTranslator;
import ui.system.Controller;
import ui.system.ImageSaver;
import ui.system.UIData;

@SuppressWarnings("serial")
public class TeamPicPanel extends JPanel implements ActionListener{

	JButton button;
	String _teamName;
	
	public TeamPicPanel(int x, int y , int width, int height, String teamName){
		
		_teamName = teamName;
		
		this.setVisible(true);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setBackground(new Color(0.7f, 0.7f, 0.7f, 0.1f));
		
		int picX = (int) (-40 * UIData.changeX);
		int picY = (int) (15 * UIData.changeY);
		int picWidth = (int) (200 * UIData.changeX);
		int picHeight = (int) (200 * UIData.changeY);
		
		int textHeight = (int) (30 * UIData.changeY);
		int blank = (int) (0 * UIData.changeY);
		
		JLabel teamNameLable = new JLabel(ChineseTranslator.TeamNameTrans(teamName), JLabel.CENTER);
		teamNameLable.setBounds(0, height - textHeight - blank, width, textHeight);
		teamNameLable.setVisible(true);
		teamNameLable.setForeground(Color.WHITE);
		this.add(teamNameLable);
		
		JPanel colorLabel = new JPanel();
		colorLabel.setBounds(0, height - textHeight - blank, width, textHeight);
		colorLabel.setVisible(true);
		colorLabel.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.8f));
		this.add(colorLabel);
		
		ImageLabel teamImage = new ImageLabel(ImageSaver.getTeamIcon(teamName), picX, picY, picWidth, picHeight);
		teamImage.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				button.doClick();
			}
		});
		this.add(teamImage);
		
		button = new JButton();
		button.addActionListener(this);
		this.add(button);
	}
	
	@Override
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button){
			Controller.addTeamPanel(_teamName);
		}
	}

}
