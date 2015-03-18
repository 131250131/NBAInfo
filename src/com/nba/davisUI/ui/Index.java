package com.nba.davisUI.ui;

import javax.swing.JLabel;

import com.nba.davisUI.myUI.ImageBin;
import com.nba.davisUI.myUI.MyPanel;

public class Index extends MyPanel{

	private static final long serialVersionUID = 1L;

	public Index(){
		this.setBounds(0, 0, 1280, 720);
		
		JLabel backgroundImage = new JLabel(ImageBin.getImage("indexBackground"));
		backgroundImage.setVisible(true);
		backgroundImage.setBounds(0, 0, 1280, 720);
		this.add(backgroundImage);
		
	}
}
