package com.nba.davisUI.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import com.nba.davisUI.myUI.ImageBin;
import com.nba.davisUI.myUI.MyPanel;

public class LoadingPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	Timer timer;
	JProgressBar progressbar;
	
	public LoadingPanel(){
		this.setBounds(0, 0, 1280, 720);
		
		timer = new Timer(80, this);;
	
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
		
		JLabel backgroundImage = new JLabel(ImageBin.getImage("LoadingBackground"));
		backgroundImage.setVisible(true);
		backgroundImage.setBounds(0, 0, 1280, 720);
		this.add(backgroundImage);
		
		timer.start();
			
	}
	
	public void actionPerformed(ActionEvent e) {

	       if (e.getSource() == timer) {
	           int value = progressbar.getValue();
	           if (value < 100)
	              progressbar.setValue(++value);
	           else {
	              timer.stop(); 
	           }
	       }

	    }
}
