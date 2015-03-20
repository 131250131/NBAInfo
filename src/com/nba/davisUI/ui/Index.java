package com.nba.davisUI.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import com.nba.data.Player;
import com.nba.davisUI.myUI.ImageBin;
import com.nba.davisUI.myUI.MyPanel;
import com.nba.registerList.RegisterList;

public class Index extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	ArrayList<String> stringArray, nameArray;
	JLabel playerIcon1;
	Timer timer;
	JProgressBar progressbar;
	JButton enterButton, enterButton2;
	JLabel backgroundImage, playerInfo1, playerInfo2, playerInfo3;
	Player tempPlayer;
	
	public Index(){
		this.setBounds(0, 0, 1280, 720);
			
		stringArray = new ArrayList<String>();
		nameArray = new ArrayList<String>();
		
		timer = new Timer(1, this);
		
		progressbar = new JProgressBar();
		progressbar.setMinimum(0);
	    progressbar.setMaximum(400);
	    progressbar.setValue(0);
	    this.add(progressbar);
		
		getPic();
		
		tempPlayer = RegisterList.getPlayerWithName("Aaron Brooks");
		
		Color color = new Color(248, 248, 248);
		
		playerInfo1 = new JLabel();
		playerInfo1.setText("POSITION : " + tempPlayer.getPosition().toUpperCase());
		playerInfo1.setForeground(color);
		playerInfo1.setVisible(true);
		playerInfo1.setBounds(1000 - 20, 400, 200, 25);
		playerInfo1.setFont(new Font("OCR A Std", Font.BOLD, 15));
		this.add(playerInfo1);
		
		playerInfo2 = new JLabel();
		playerInfo2.setText("NAME : " + tempPlayer.getPlayerName().toUpperCase());
		playerInfo2.setForeground(color);
		playerInfo2.setVisible(true);
		playerInfo2.setBounds(800 - 50 + 248 - 30, 500 - 10 - 60 + 16 + 4, 400, 40);
		playerInfo2.setFont(new Font("OCR A Std", Font.BOLD, 15));
		this.add(playerInfo2);
		
		playerInfo3 = new JLabel();
		playerInfo3.setText("FROM : " + tempPlayer.getSchool().toUpperCase());
		playerInfo3.setForeground(color);
		playerInfo3.setVisible(true);
		playerInfo3.setBounds(1020 - 205 + 145, 320 - 115 - 120 + 515 - 105 + 20, 650, 30);
		playerInfo3.setFont(new Font("OCR A Std", Font.BOLD, 15));
		this.add(playerInfo3);
		
		playerIcon1 = new JLabel(new ImageIcon(stringArray.get(0)));
		playerIcon1.setBounds(720, -20, 300, 700);
		playerIcon1.setVisible(true);
		this.add(playerIcon1);
		
		JLabel backgroundImage2 = new JLabel(ImageBin.getImage("test"));
		backgroundImage2.setVisible(true);
		backgroundImage2.setBounds(0, 0, 1280, 720);
		this.add(backgroundImage2);
		
		timer.start();	
		
		enterButton = new JButton();
		enterButton.setBounds(105, 128, 380, 210);
		enterButton.setOpaque(false);
		enterButton.setBackground(null);
		enterButton.setBorder(BorderFactory.createEmptyBorder());
		enterButton.setContentAreaFilled(false);
		enterButton.addActionListener(this);
		this.add(enterButton);
		enterButton.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				backgroundImage.setIcon(ImageBin.getImage("indexBackground2"));	
				index++;
				
			}
			public void mouseExited(MouseEvent arg0) {
				backgroundImage.setIcon(ImageBin.getImage("indexBackground"));
			}
			}); 
		
		enterButton2 = new JButton();
		enterButton2.setBounds(105, 338, 380, 210);
		enterButton2.setOpaque(false);
		enterButton2.setBackground(null);
		enterButton2.setBorder(BorderFactory.createEmptyBorder());
		enterButton2.setContentAreaFilled(false);
		enterButton2.addActionListener(this);
		this.add(enterButton2);
		enterButton2.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				backgroundImage.setIcon(ImageBin.getImage("indexBackground3"));
				index++;
			}
			public void mouseExited(MouseEvent arg0) {
				backgroundImage.setIcon(ImageBin.getImage("indexBackground"));
			}
			}); 
		
		backgroundImage = new JLabel(ImageBin.getImage("indexBackground"));
		backgroundImage.setVisible(true);
		backgroundImage.setBounds(0, 0, 1280, 720);
		this.add(backgroundImage);
	}
	
	private void getPic(){
		 File dir = new File("data/ui/image/action");
		    File[] files = dir.listFiles();
		    for(int i = 0;i < files.length;i++){
		        //过滤非图片
		    	
		    	String[] name  = files[i].getName().split("[.]");
		    	nameArray.add(name[0]);
		    	
		         String fileType = files[i].getName().substring(files[i].getName().lastIndexOf('.')+1,files[i].getName().length());
		             if(fileType.toLowerCase().equals("png")){
		            	 stringArray.add(files[i].getPath());                    
		         }
		    }
	}
	
	int index = 0;
	
	public void actionPerformed(ActionEvent events) {
		
	      if (events.getSource() == timer) {
	    	  int value = progressbar.getValue();
	    	  if(value > 400)
	    		  value -= 400;
	    	  if(value == index){
	    		  progressbar.setValue(++value);
	    		  tempPlayer = RegisterList.getPlayerWithName(nameArray.get(value));
	    		  playerIcon1.setIcon(new ImageIcon(stringArray.get(value)));
	    		  playerInfo1.setText("POSITION : " + tempPlayer.getPosition().toUpperCase()); 
	    		  playerInfo2.setText("NAME : " + tempPlayer.getPlayerName().toUpperCase());
	    		  playerInfo3.setText("FROM : " + tempPlayer.getSchool().toUpperCase());
	    	  }
	    	  MainFrame.refresh.doClick();
	    	}
	      
	      if(events.getSource() == enterButton){
	    	  MainFrame.openPlayerTablePanel.doClick();
	      }

	 }
}
