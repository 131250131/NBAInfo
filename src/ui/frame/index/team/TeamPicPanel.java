package ui.frame.index.team;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.ImageLabel;
import ui.system.ImageSaver;
import ui.system.UIData;

@SuppressWarnings("serial")
public class TeamPicPanel extends JPanel implements ActionListener{

	JButton button;
	
	public TeamPicPanel(int x, int y , int width, int height, String teamName){
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
		
		JLabel teamNameLable = new JLabel(getTeamChineseName(teamName), JLabel.CENTER);
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
		this.add(teamImage);
		
		button = new JButton();
		button.setBounds(0, 0, width, height);
		button.setVisible(true);
		button.addActionListener(this);
		button.setOpaque(false);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		this.add(button);
	}
	
	private String getTeamChineseName(String teamName){
		String name = null;
		switch(teamName){
		case "DAL":	
			name = "小牛";
			break;
		case "DEN":	
			name = "掘金";
			break;
		case "GSW":	
			name = "勇士";
			break;	
		case "HOU":	
			name = "火箭";
			break;	
		case "LAC":	
			name = "快船";
			break;	
		case "LAL":	
			name = "湖人";
			break;	
		case "MEM":	
			name = "灰熊";
			break;	
		case "MIN":	
			name = "灰狼";
			break;
		case "NOP":	
			name = "鹈鹕";
			break;
		case "POR":	
			name = "拓荒者";
			break;
		case "OKC":	
			name = "雷霆";
			break;
		case "PHX":	
			name = "太阳";
			break;
		case "SAC":	
			name = "国王";
			break;
		case "SAS":	
			name = "马刺";
			break;
		case "UTA":	
			name = "爵士";
			break;
		case "ATL":
			name = "老鹰";
			break;
		case "BKN":	
			name = "篮网";
			break;
		case "BOS":	
			name = "凯尔特人";
			break;
		case "CHA":	
			name = "黄蜂";
			break;
		case "CHI":	
			name = "公牛";
			break;
		case "CLE":	
			name = "骑士";
			break;
		case "DET":	
			name = "活塞";
			break;
		case "IND":	
			name = "步行者";
			break;
		case "MIA":	
			name = "热火";
			break;
		case "MIL":	
			name = "雄鹿";
			break;
		case "NYK":	
			name = "尼克斯";
			break;
		case "ORL":	
			name = "魔术";
			break;
		case "PHI":	
			name = "76人";
			break;
		case "TOR":	
			name = "猛龙";
			break;
		case "WAS":	
			name = "奇才";
			break;
		}	
	return name;

	}
	
	@Override
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button){
			
		}
	}

}
