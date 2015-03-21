package com.nba.davisUI.ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.nba.davisUI.myUI.ImageBin;
import com.nba.davisUI.myUI.MyFrame;


public class MainFrame extends MyFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	
	LoadingPanel loadingPanel;
	PlayerTablePanel playerTablePanel;
	TeamTablePanel teamTablePanel;
	Index index;
	JLabel exitBt, miniBt;
	
	public static JButton openPlayerTablePanel, refresh, openIndex, openTeamTabelPanel;
	public MainFrame(){
		
		this.setLayout(null);
		
	
		exitBt = new JLabel(ImageBin.getImage("exit1"));
		exitBt.setBounds(1280 - 24, 0, 24, 24);
//		exitBt.setOpaque(false);
//		exitBt.setBackground(null);
//		exitBt.setBorder(BorderFactory.createEmptyBorder());
//		exitBt.setContentAreaFilled(false);
		
		
		exitBt.addMouseListener(new MouseListenerOfThisFrame("exitBt"));
		
		miniBt = new JLabel(ImageBin.getImage("mini1"));
		miniBt.setBounds(1280 -24*2, 0, 24, 24);
//		miniBt.setOpaque(false);
//		miniBt.setBackground(null);
//		miniBt.setBorder(BorderFactory.createEmptyBorder());
//		miniBt.setContentAreaFilled(false);
		
		
		miniBt.addMouseListener(new MouseListenerOfThisFrame("miniBt"));
		
		openIndex = new MyButtonOfOpenIndex();
		
		
		openPlayerTablePanel = new MyButtonOfopenPlayerTablePanel();
		openPlayerTablePanel.addMouseListener(new MouseListenerOfThisFrame("openPlayerTablePanel"));
		
		
		openTeamTabelPanel = new JButton();
		openTeamTabelPanel.addActionListener(this);
		this.add(openTeamTabelPanel);
		
		refresh = new JButton();
		refresh.addMouseListener(new MouseListenerOfThisFrame("refresh"));
		
		
		
		index = new Index();
		index.setVisible(false);
		
		
		loadingPanel = new LoadingPanel();	
		
		
		playerTablePanel=new PlayerTablePanel();
		playerTablePanel.setVisible(false);
		
		teamTablePanel = new TeamTablePanel();
		teamTablePanel.setVisible(false);
		this.add(teamTablePanel);
		
		this.add(exitBt,0);
		this.add(miniBt,1);
		this.add(index,2);
		this.add(openPlayerTablePanel,3);
		this.add(loadingPanel,4);
		this.add(playerTablePanel,5);
		this.add(openIndex,6);
		this.add(refresh,7);
		
		//
		//openPlayerTablePanel.doClick();
	}
	
	@SuppressWarnings("serial")
	class MyButtonOfOpenIndex extends JButton{
		public void doClick(){
			loadingPanel.setVisible(false);
			index.setVisible(true);
		}
	}
	@SuppressWarnings("serial")
	class MyButtonOfopenPlayerTablePanel extends JButton{
		public void doClick(){
			index.setVisible(false);
			playerTablePanel.setVisible(true);
		}
	}
	class MouseListenerOfThisFrame implements MouseListener{

		String s;
		public MouseListenerOfThisFrame(String s){
			this.s=s;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if(s.equals("exitBt")){
				System.exit(0);
			}
			else if(s.equals("miniBt")){
			
				MainFrame.this.setExtendedState(JFrame.ICONIFIED);
			}
			else if(s.equals("refresh")){
				miniBt.setIcon(ImageBin.getImage("mini1"));
				exitBt.setIcon(ImageBin.getImage("exit1"));
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if(s.equals("exitBt")){
				exitBt.setIcon(ImageBin.getImage("exit2"));
			}
			else if(s.equals("miniBt")){
			
				miniBt.setIcon(ImageBin.getImage("mini2"));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(s.equals("exitBt")){
				exitBt.setIcon(ImageBin.getImage("exit1"));
			}
			else if(s.equals("miniBt")){
			
				miniBt.setIcon(ImageBin.getImage("mini1"));
			}
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent events) {
		// TODO Auto-generated method stub
		
		if(events.getSource() == openTeamTabelPanel){
			index.setVisible(false);
			teamTablePanel.setVisible(true);
		}
		
	}
	

}
