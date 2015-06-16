package ui.frame.index.match;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JComboBox;

import ui.system.Controller;
import ui.system.UIData;

@SuppressWarnings("serial")
public class MatchComboBox extends JComboBox<String>{
		
	public MatchComboBox(){
		this.setBounds((int) ((85  + 135) * UIData.changeX), (int) (190 * UIData.changeY),
				(int) (200 * UIData.changeX), (int) (35 * UIData.changeY));
		addItem();
		this.setVisible(true);
		this.setBackground(Color.DARK_GRAY);
		this.setForeground(Color.WHITE);
	}
	
	private void addItem(){
		ArrayList<String> dateList = Controller.matchController.getMatchdatesbySeaon("2014-2015");
		System.out.println(dateList.size());
		for(int i = dateList.size() - 1; i >= 0; i--){
			String date = dateList.get(i);	
			this.addItem(date);
		}
	}
}
