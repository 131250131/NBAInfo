package com.nba.ui;

import javax.swing.JPanel;

public class PlayerPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public PlayerPanel(){
		this.setLayout(null);
		
		MyTable playerTable = new MyTable();
		playerTable.setVisible(true);
		playerTable.mySetBounds(120, 80, 720, 400);
		this.add(playerTable);
	}

}
