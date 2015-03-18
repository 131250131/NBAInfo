package com.nba.davisUI.ui;

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

import com.nba.davisUI.myUI.ImageBin;
import com.nba.davisUI.myUI.MyPanel;

public class Index extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	ArrayList<String> stringArray;
	JLabel player;
	Timer timer;
	JProgressBar progressbar;
	JButton enterButton, enterButton2;
	JLabel backgroundImage;
	
	public Index(){
		this.setBounds(0, 0, 1280, 720);
			
		stringArray = new ArrayList<String>();
		
//		JLabel backgroundImage2 = new JLabel(ImageBin.getImage("test"));
//		backgroundImage2.setVisible(true);
//		backgroundImage2.setBounds(0, 0, 1280, 720);
//		this.add(backgroundImage2);
		
		timer = new Timer(7, this);
		
		progressbar = new JProgressBar();
		progressbar.setMinimum(0);
	    progressbar.setMaximum(400);
	    progressbar.setValue(0);
	    this.add(progressbar);
		
		getPic();
		
		player = new JLabel(new ImageIcon(stringArray.get(0)));
		player.setBounds(720 - 10, -20, 300, 700);
		player.setVisible(true);
		this.add(player);
		
		
		
		timer.start();	
		
		enterButton = new JButton();
		enterButton.setBounds(105, 128, 380, 210);
		enterButton.setOpaque(false);
		enterButton.setBackground(null);
		enterButton.setBorder(BorderFactory.createEmptyBorder());
		enterButton.setContentAreaFilled(false);

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
		         String fileType = files[i].getName().substring(files[i].getName().lastIndexOf('.')+1,files[i].getName().length());
		             if(fileType.toLowerCase().equals("png")){
		            	 stringArray.add(files[i].getPath());                    
		         }
		    }
	}
	
	int index = 0;
	
	public void actionPerformed(ActionEvent e) {
		
	      if (e.getSource() == timer) {
	    	  int value = progressbar.getValue();
	    	  
	    	  if(value == index){
	    		  progressbar.setValue(++value);
	    		 
	    		  player.setIcon(new ImageIcon(stringArray.get(value)));
	    		  
	    		 
	    	  }
//	    	  else if(value == 1){
//	    		  try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e1) {
//						e1.printStackTrace();
//					}
//		    		  progressbar.setValue(++value);
//		    		  player.setIcon(new ImageIcon(stringArray.get(value)));
//	    		  
//	    	  }else if(value == 2){
//	    		  try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e1) {
//						e1.printStackTrace();
//					}
//		    		  progressbar.setValue(++value);
//		    		  player.setIcon(new ImageIcon(stringArray.get(value)));
//	    	  }
	    		
	    	}

	 }
}
