package com.nba.davisUI.ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.nba.davisUI.myUI.MyFrame;


public class MainFrame extends MyFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	
	LoadingPanel loadingPanel;
	PlayerTablePanel playerTablePanel;
	Index index;
	
	public static JButton openPlayerTablePanel;
	public MainFrame(){
		
		this.setLayout(null);
		
		loadingPanel = new LoadingPanel();	
		this.add(loadingPanel);
		
		openPlayerTablePanel= new JButton();
		openPlayerTablePanel.addActionListener(this);
		this.add(openPlayerTablePanel);
		
		//
		//openPlayerTablePanel.doClick();
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == openPlayerTablePanel){
			index = new Index();
			this.add(index);
			loadingPanel.setVisible(false);
		}
	}
	

}
