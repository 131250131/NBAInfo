package userInterface.ui.indexUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import userInterface.myUI.ImageSaver;

@SuppressWarnings("serial")
public class TodayMatchLabel extends JLabel{
	
	public TodayMatchLabel(int style, int index){
			
		if(style == 0){
			if(index % 2 == 0){
				this.setIcon(ImageSaver.getIcon(("todayBack0")));
			}else{
				this.setIcon(ImageSaver.getIcon(("todayBack1")));
			}
			this.setVisible(true);
		}else if(style == 1){
			this.setForeground(new Color(239, 130, 131));
			this.setBackground(null);
			this.setHorizontalAlignment(JLabel.CENTER);
			this.setFont(new Font("Candara",Font.BOLD ,15));
			
			switch(index){
			case 0 : this.setText("BKN 91 - 88 CHA");break;
			case 1 : this.setText("LAC 111 - 80 NYK");break;
			case 2 : this.setText("HOU 101 - 103 SAC");break;
			case 3 : this.setText("POR 78 - 93 TOR");break;
			case 4 : this.setText("BOS 97 - 120 MIN");break;
			case 5 : this.setText("more");break;
			case 6 : this.setText("Players");break;
			case 7 : this.setText("Teams");break;
			case 8 : this.setText("Hotspots");break;
			case 9 : this.setText("Standings");break;
			}
		}else if(style == 3){
			switch(index){
			case 0 : setIcon(ImageSaver.getIcon(("BKN0")));break;
			case 1 : setIcon(ImageSaver.getIcon(("LAC0")));break;
			case 2 : setIcon(ImageSaver.getIcon(("HOU0")));break;
			case 3 : setIcon(ImageSaver.getIcon(("POR0")));break;
			case 4 : setIcon(ImageSaver.getIcon(("BOS0")));break;
			case 5 : setIcon(ImageSaver.getIcon(("TOR0")));break;
			case 6 : setIcon(ImageSaver.getIcon(("UTA0")));break;
			case 7 : setIcon(ImageSaver.getIcon(("WAS0")));break;
			case 8 : setIcon(ImageSaver.getIcon(("ATL0")));break;
			case 9 : setIcon(ImageSaver.getIcon(("ATL0")));break;
			}
		}else{
			switch(index){
			case 0 : setIcon(ImageSaver.getIcon(("CHA1")));break;
			case 1 : setIcon(ImageSaver.getIcon(("NYK1")));break;
			case 2 : setIcon(ImageSaver.getIcon(("SAC1")));break;
			case 3 : setIcon(ImageSaver.getIcon(("TOR1")));break;
			case 4 : setIcon(ImageSaver.getIcon(("MIN1")));break;
			case 5 : setIcon(ImageSaver.getIcon(("CHI1")));break;
			case 6 : setIcon(ImageSaver.getIcon(("BKN1")));break;
			case 7 : setIcon(ImageSaver.getIcon(("BKN1")));break;
			case 8 : setIcon(ImageSaver.getIcon(("BKN1")));break;
			case 9 : setIcon(ImageSaver.getIcon(("BKN1")));break;
			}
		}
	

	}
}
