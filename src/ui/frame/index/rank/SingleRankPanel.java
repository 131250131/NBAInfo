package ui.frame.index.rank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.ImageLabel;
import ui.system.ImageSaver;
import ui.system.UIData;

@SuppressWarnings("serial")
public class SingleRankPanel extends JPanel{
	
	JButton backgroundEnterEffect;
	ImageLabel back, back2;
	
	public SingleRankPanel(String name, int rank, String EastOrWest, int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setOpaque(false);
		this.setVisible(true);
		
		int picWidth = (int) (240 * UIData.changeX);
		int picHeight = (int) (240 * UIData.changeY);
		
		if(EastOrWest.equals("W")){
			JLabel score = new JLabel (getScore(name), JLabel.RIGHT);
			score.setForeground(Color.WHITE);
			score.setBounds((int) (-80 * UIData.changeX), 0, width, height);
			score.setFont(new Font("Arail", Font.BOLD, (int) (30 * UIData.changeY)));
			score.setVisible(true);
			this.add(score);
			
			JLabel ranking = new JLabel ((rank + 1) + " ", JLabel.RIGHT);
			ranking.setForeground(Color.GRAY);
			ranking.setBounds(0, 0, width, height);
			ranking.setFont(new Font("Trajan Pro", Font.BOLD, (int) (30 * UIData.changeY)));
			ranking.setVisible(true);
			this.add(ranking);
			
			ImageLabel logo = new ImageLabel(ImageSaver.getTeamIcon(name), - picWidth / 2 + (int) (30 * UIData.changeX)
					, (int) (-60 * UIData.changeY), picWidth, picHeight);
			this.add(logo);
			back = new ImageLabel(ImageSaver.getIcon("rankW"), 0, 0 ,width, height);
			this.add(back);
			back2 = new ImageLabel(ImageSaver.getIcon("rankW2"), 0, 0 ,width, height);
			back2.setVisible(false);
			this.add(back2);
		}else{
			JLabel score = new JLabel (getScore(name), JLabel.LEFT);
			score.setForeground(Color.WHITE);
			score.setBounds((int) (80 * UIData.changeX), 0, width, height);
			score.setFont(new Font("Arail", Font.BOLD, (int) (30 * UIData.changeY)));
			score.setVisible(true);
			this.add(score);
			
			JLabel ranking = new JLabel (" " + (rank + 1), JLabel.LEFT);
			ranking.setForeground(Color.GRAY);
			ranking.setBounds(0, 0, width, height);
			ranking.setFont(new Font("Trajan Pro", Font.BOLD, (int) (30 * UIData.changeY)));
			ranking.setVisible(true);
			this.add(ranking);
			
			ImageLabel logo = new ImageLabel(ImageSaver.getTeamIcon(name), width - picWidth / 2 - (int) (30 * UIData.changeX)
					, (int) (-60 * UIData.changeY) , picWidth, picHeight);
			this.add(logo);
			if(name.equals("CHI")){
				logo.setLocation(logo.getLocation().x, (int) (-100 * UIData.changeY));
			}
			back = new ImageLabel(ImageSaver.getIcon("rankE"), 0, 0 ,width, height);
			this.add(back);
			back2 = new ImageLabel(ImageSaver.getIcon("rankE2"), 0, 0 ,width, height);
			back2.setVisible(false);
			this.add(back2);
		}
					
		backgroundEnterEffect = new JButton();
		backgroundEnterEffect.setBounds(0, 0, width, height);
		backgroundEnterEffect.setVisible(true);
		backgroundEnterEffect.setBorder(BorderFactory.createEmptyBorder());
		backgroundEnterEffect.setOpaque(false);
		backgroundEnterEffect.setBackground(null);
		backgroundEnterEffect.setContentAreaFilled(false);
		backgroundEnterEffect.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				back.setVisible(false);
				back2.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				back.setVisible(true);
				back2.setVisible(false);
			}
			}); 
		this.add(backgroundEnterEffect);
	}
	
	private String getScore(String name){
		String score = null;
			switch(name){
			case "DAL":	
				score = "61-21";
				break;
			case "DEN":	
				score = "58-19";
				break;
			case "GSW":	
				score = "56-20";
				break;	
			case "HOU":	
				score = "50-25";
				break;	
			case "LAC":	
				score = "47-29";
				break;	
			case "LAL":	
				score = "42-42";
				break;	
			case "MEM":	
				score = "39-47";
				break;	
			case "MIN":	
				score = "36-50";
				break;
			case "NOP":	
				score = "32-53";
				break;
			case "POR":	
				score = "29-57";
				break;
			case "OKC":	
				score = "26-60";
				break;
			case "PHX":	
				score = "22-62";
				break;
			case "SAC":	
				score = "20-64";
				break;
			case "SAS":	
				score = "18-69";
				break;
			case "UTA":	
				score = "16-60";
				break;
			case "ATL":
				score = "70-12";
				break;
			case "BKN":	
				score = "60-22";
				break;
			case "BOS":	
				score = "58-24";
				break;
			case "CHA":	
				score = "55-27";
				break;
			case "CHI":	
				score = "51-31";
				break;
			case "CLE":	
				score = "44-38";
				break;
			case "DET":	
				score = "42-40";
				break;
			case "IND":	
				score = "38-44";
				break;
			case "MIA":	
				score = "32-50";
				break;
			case "MIL":	
				score = "30-52";
				break;
			case "NYK":	
				score = "29-53";
				break;
			case "ORL":	
				score = "28-54";
				break;
			case "PHI":	
				score = "26-56";
				break;
			case "TOR":	
				score = "22-60";
				break;
			case "WAS":	
				score = "16-66";
				break;
			}	
		return score;
	}

}
