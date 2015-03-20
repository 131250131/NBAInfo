package com.nba.davisUI.ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nba.davisUI.myUI.ImageBin;
import com.nba.davisUI.myUI.MyFrame;


public class MainFrame extends MyFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	
	LoadingPanel loadingPanel;
	PlayerTablePanel playerTablePanel;
	Index index;
	JLabel exitButton, mimiButton;
	JButton exitBt, miniBt;
	
	public static JButton openPlayerTablePanel, refresh, openIndex;
	public MainFrame(){
		
		this.setLayout(null);
		
		exitButton = new JLabel(ImageBin.getImage("exit1"));
		exitButton.setBounds(0, 0, 1280, 720);
		exitButton.setVisible(true);
		this.add(exitButton);
		
		mimiButton = new JLabel(ImageBin.getImage("mini1"));
		mimiButton.setBounds(0, 0, 1280, 720);
		mimiButton.setVisible(true);
		this.add(mimiButton);
		
		exitBt = new JButton();
		exitBt.setBounds(1280 - 28, 0, 28, 33);
		exitBt.setOpaque(false);
		exitBt.setBackground(null);
		exitBt.setBorder(BorderFactory.createEmptyBorder());
		exitBt.setContentAreaFilled(false);
		
		this.add(exitBt);
		exitBt.addActionListener(this);
		exitBt.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				exitButton.setIcon(ImageBin.getImage("exit2"));
			}
			public void mouseExited(MouseEvent arg0) {
				exitButton.setIcon(ImageBin.getImage("exit1"));
			}
			}); 
		
		miniBt = new JButton();
		miniBt.setBounds(1280 - 25 - 28, 0, 25, 33);
		miniBt.setOpaque(false);
		miniBt.setBackground(null);
		miniBt.setBorder(BorderFactory.createEmptyBorder());
		miniBt.setContentAreaFilled(false);
		
		this.add(miniBt);
		miniBt.addActionListener(this);
		miniBt.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				mimiButton.setIcon(ImageBin.getImage("mini2"));
			}
			public void mouseExited(MouseEvent arg0) {
				mimiButton.setIcon(ImageBin.getImage("mini1"));
			}
			}); 
		
		openIndex = new JButton();
		openIndex.addActionListener(this);
		this.add(openIndex);
		
		openPlayerTablePanel= new JButton();
		openPlayerTablePanel.addActionListener(this);
		this.add(openPlayerTablePanel);
		
		refresh = new JButton();
		refresh.addActionListener(this);
		this.add(refresh);
		
		
		index = new Index();
		index.setVisible(false);
		this.add(index);
		
		loadingPanel = new LoadingPanel();	
		this.add(loadingPanel);
		
		playerTablePanel=new PlayerTablePanel();
		playerTablePanel.setVisible(false);
		this.add(playerTablePanel);
		
		
		//
		//openPlayerTablePanel.doClick();
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == openIndex){
			loadingPanel.setVisible(false);
			index.setVisible(true);
		}
		
		if(events.getSource() == openPlayerTablePanel){
			index.setVisible(false);
			playerTablePanel.setVisible(true);
		}
		
		if(events.getSource() == exitBt){
			System.exit(0);
		}
		
		if(events.getSource() == miniBt){
			this.setExtendedState(JFrame.ICONIFIED);
		}
		
		if(events.getSource() == refresh){
			mimiButton.setIcon(ImageBin.getImage("mini1"));
			exitButton.setIcon(ImageBin.getImage("exit1"));
		}
		
		
	}
	

}
