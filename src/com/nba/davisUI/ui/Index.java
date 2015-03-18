package com.nba.davisUI.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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
		
		JLabel backgroundImage = new JLabel(ImageBin.getImage("indexBackground"));
		backgroundImage.setVisible(true);
		backgroundImage.setBounds(0, 0, 1280, 720);
		this.add(backgroundImage);
		
		timer.start();	
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
	    		  try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
	    		  progressbar.setValue(++value);
	    		  index++;
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
