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
	WarningPanel warn;
	public static JButton openPlayerTablePanel, refresh, openIndex, openTeamTabelPanel,returnFromPlayerTablePanel,returnFromTeamTabelPanel;
	
	public static MyButtonOfWarn warnbt;
	public MainFrame(){
		
		this.setLayout(null);
		
	
		exitBt = new JLabel(ImageBin.getImage("exit1"));
		exitBt.setBounds(1280 - 24, 0, 24, 24);
		exitBt.addMouseListener(new MouseListenerOfThisFrame("exitBt"));
		
		miniBt = new JLabel(ImageBin.getImage("mini1"));
		miniBt.setBounds(1280 -24*2, 0, 24, 24);
		miniBt.addMouseListener(new MouseListenerOfThisFrame("miniBt"));
		
		openIndex = new MyButtonOfOpenIndex();
		
		
		openPlayerTablePanel = new MyButtonOfopenPlayerTablePanel();
		openPlayerTablePanel.addMouseListener(new MouseListenerOfThisFrame("openPlayerTablePanel"));
		
		
		openTeamTabelPanel = new JButton();
		openTeamTabelPanel.addActionListener(this);
		this.add(openTeamTabelPanel);
		
		returnFromPlayerTablePanel = new JButton();
		returnFromPlayerTablePanel.addActionListener(new ActionListenerOfRe("player"));
		this.add(returnFromPlayerTablePanel);
		
		returnFromTeamTabelPanel = new JButton();
		returnFromTeamTabelPanel.addActionListener(new ActionListenerOfRe("team"));
		this.add(returnFromTeamTabelPanel);
		
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
		
		warn=new WarningPanel();
		warnbt=new MyButtonOfWarn();
		
		this.add(warn,0);
		this.add(exitBt,1);
		this.add(miniBt,2);
		this.add(index,3);
		this.add(openPlayerTablePanel,4);
		this.add(loadingPanel,5);
		this.add(playerTablePanel,6);
		this.add(openIndex,7);
		this.add(refresh,8);
		
		
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
	class MyButtonOfWarn extends JButton{
		public void showWarning(String text){
			warn.showWarning(text);
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
	
	class ActionListenerOfRe implements ActionListener{

		String T="";
		public ActionListenerOfRe(String t){
			T=t;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(T.equals("player")){
				index.setVisible(true);
				playerTablePanel.setVisible(false);
			}
			else if(T.equals("team")){
				index.setVisible(true);
				teamTablePanel.setVisible(false);
			}
		}
		
	}

}
