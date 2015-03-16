package com.nba.ui;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	
	
	public MainFrame(){
		
		Toolkit toolkit = this.getToolkit();
		int screenX = toolkit.getScreenSize().width;
		int screenY = toolkit.getScreenSize().height;
		int frameSizeX = screenX/3*2;
		int frameSizeY = screenY/3*2;
		System.out.println(frameSizeX+""+frameSizeY);
		
		setSize(frameSizeX, frameSizeY);
		setLocation((screenX - frameSizeX) / 2 , (screenY - frameSizeY) / 2);
		setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		PlayerPanel playerPanel = new PlayerPanel();
		this.add(playerPanel);
		playerPanel.setVisible(true);
		
	}

}
