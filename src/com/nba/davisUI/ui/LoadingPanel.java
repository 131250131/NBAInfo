package com.nba.davisUI.ui;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import com.nba.davisUI.myUI.ImageBin;
import com.nba.davisUI.myUI.MyPanel;

public class LoadingPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	Timer timer;
	JProgressBar progressbar;
	JLabel words, enterOne, enterTwo;
	JButton enterButton;
	
	
	public LoadingPanel(){
		this.setBounds(0, 0, 1280, 720);
		
		timer = new Timer(14, this);;
		
	
		
		progressbar = new JProgressBar();
		progressbar.setOrientation(JProgressBar.HORIZONTAL);
		progressbar.setBounds(190 + 248, 480 - 115, 487, 4);
	    progressbar.setMinimum(0);
	    progressbar.setMaximum(100);
	    progressbar.setValue(0);
	    //progressbar.setStringPainted(true);
	   //progressbar.addChangeListener(this);
	   //progressbar.setBorderPainted(true);
	    progressbar.setBackground(Color.WHITE);
	    progressbar.setForeground(Color.BLACK);
	    progressbar.setVisible(true);
	    this.add(progressbar);
	    
	    words = new JLabel();
	    words.setText("赛场整理中...");
	    words.setBounds(625 - 173, 500 - 126, 200, 15);
	    words.setVisible(true);
	    this.add(words);
	   
	    enterOne = new JLabel(ImageBin.getImage("LoadingButtonOne"));
		enterOne.setVisible(false);
		enterOne.setBounds(0, 520, 1280, 200);
		this.add(enterOne);
		
		enterButton = new JButton();
		enterButton.setBounds(590, 600, 116, 33);
		enterButton.setOpaque(false);
		enterButton.setBackground(null);
		enterButton.setBorder(BorderFactory.createEmptyBorder());
		enterButton.setContentAreaFilled(false);

		this.add(enterButton);
		enterButton.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				enterOne.setIcon(ImageBin.getImage("LoadingButtonTwo"));
			}
			public void mouseExited(MouseEvent arg0) {
				enterOne.setIcon(ImageBin.getImage("LoadingButtonOne"));
			}
			}); 
		
		JLabel backgroundImage = new JLabel(ImageBin.getImage("LoadingBackground"));
		backgroundImage.setVisible(true);
		backgroundImage.setBounds(0, 0, 1280, 720);
		this.add(backgroundImage);
		timer.start();	
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == enterButton){
				MainFrame.openIndex.doClick();
		}
				
		int waitTime = 50;// 350
	       if (e.getSource() == timer) {
	           int value = progressbar.getValue();
	           
	           if (value == 0){
	        	   try {
						Thread.sleep(200);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
	        	   progressbar.setValue(++value);
	           }else if (value > 0 && value <= 20){
	        	   progressbar.setValue(++value);
	           }else if(value == 21){
	        	   words.setText("球员入场...");     	  
	        	   this.repaint();
	        	   try {
					Thread.sleep(waitTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
	        	   progressbar.setValue(++value);
        		  
	           }else if(value > 21 && value < 52){  
	        	   progressbar.setValue(++value);
	           }else if(value == 52){
	        	   words.setText("拉拉队暖场...");
	        	   this.repaint();
	        	   try {
						Thread.sleep(waitTime);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
	        	   progressbar.setValue(++value);
   
	           }else if(value > 52 && value < 80){
	        	   progressbar.setValue(++value);
	           }else if(value == 80){
	        	   words.setText("准备开哨...");
	        	   this.repaint();
	        	   
	        	   try {
						Thread.sleep(waitTime);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
	        	   progressbar.setValue(++value);
        		  
	           }else if(value > 80 && value < 100){
	        	   progressbar.setValue(++value);
	           }else{
	        	 
	        	  words.setText("");
	        	  this.repaint();   
	        	  
	              timer.stop();
	              enterOne.setVisible(true);
	              enterButton.addActionListener(this);
	           }
	       }
	    }	
}


	
