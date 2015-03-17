package com.nba.davisUI.ui;


import com.nba.davisUI.myUI.MyFrame;


public class MainFrame extends MyFrame{
	
	private static final long serialVersionUID = 1L;
	
	public MainFrame(){
		
		LoadingPanel loadingPanel = new LoadingPanel();
		this.add(loadingPanel);
	
	}

}
