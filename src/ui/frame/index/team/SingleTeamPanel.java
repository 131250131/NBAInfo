package ui.frame.index.team;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.system.UIData;

@SuppressWarnings("serial")
public class SingleTeamPanel extends JPanel{
	//太平洋区 西南区 西北区
	//大西洋区 东南区 中部区
	
	TeamPicPanel[] picPanel = new TeamPicPanel[5];
	
	int width = (int) (600 * UIData.changeX);
	int height = (int) (260 * UIData.changeY);
	
	public SingleTeamPanel(int division){
		this.setVisible(true);
		//this.setOpaque(false);
		this.setLayout(null);
		this.setBackground(new Color(0.7f, 0.7f, 0.7f, 0.05f));
		
		int step = width / 5;
		
		for(int i = 0; i < 5; i++){
			picPanel[i] = new TeamPicPanel(step * i, 0, step, (int) (210 * UIData.changeY), getTeamName(division, i));
			this.add(picPanel[i]);
		}
		
		JLabel divisionName = new JLabel(getDivisionName(division) + "  ", JLabel.RIGHT);
		divisionName.setVisible(true);
		divisionName.setForeground(Color.ORANGE);
		divisionName.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		divisionName.setBounds(0, (int) ((260 - 38) * UIData.changeY), width, (int) (30 * UIData.changeY));
		this.add(divisionName);
	}
	
		
	//太平洋区 西南区 西北区
	//大西洋区 东南区 中部区
	
	private String getTeamName(int division, int i){
		
		int key = division * 5 + 1 + i;
		
		switch(key){
		case 1:
			return "LAL";
		case 2:
			return "PHX";
		case 3:
			return "GSW";
		case 4:
			return "LAC";
		case 5:
			return "SAC";
		
		case 6:
			return "SAS";
		case 7:
			return "DAL";
		case 8:
			return "CHA";
		case 9:
			return "MEM";
		case 10:
			return "HOU";
			
		case 11:
			return "OKC";
		case 12:
			return "DEN";
		case 13:
			return "POR";
		case 14:
			return "UTA";
		case 15:
			return "MIN";
		
		case 16:
			return "BOS";
		case 17:
			return "PHI";
		case 18:
			return "NYK";
		case 19:
			return "BKN";
		case 20:
			return "TOR";
			
		case 21:
			return "MIA";
		case 22:
			return "ORL";
		case 23:
			return "ATL";
		case 24:
			return "NOP";
		case 25:
			return "WAS";
		
		case 26:
			return "CHI";
		case 27:
			return "IND";
		case 28:
			return "DET";
		case 29:
			return "MIL";
		case 30:
			return "CLE";
		}
		
		return null;
	}
	
	private String getDivisionName(int division){
		switch(division){
		case 0:
			return "太平洋区";
		case 1:
			return "西南区";
		case 2:
			return "西北区";
		case 3:
			return "大西洋区";
		case 4:
			return "东南区";
		case 5:
			return "中部区";
		}
		
		return null;
	}
	
}
