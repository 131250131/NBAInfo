package com.nba.davisUI.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import com.nba.davisUI.myUI.ImageBin;


public class WarningPanel extends JPanel{
	private JLabel picture = new JLabel(ImageBin.getImage("warn"));
	private JLabel warningWord = new JLabel();
	
	
	public WarningPanel() {
		initial ();
	}
	
	public WarningPanel(String text) {
		warningWord.setText(text);
		initial ();
	}
	
	public void setWarningWord(String text) {
		warningWord.setText(text);
		initial ();
	}

	public void showWarning(String text){
		setWarningWord(text);
		Thread t=new Thread(new ThreadOfWarning());
		t.start();
	}
	private void initial () {
		this.setOpaque(false);
		this.setLayout(null);
		this.add(picture,0);
		this.add(warningWord,1);
		picture.setBounds(0,0,24,24);
		warningWord.setBounds(30,-3,720,30);
		warningWord.setFont(new Font("宋体",Font.BOLD,16));
		warningWord.setForeground(Color.white);
		this.setBounds(600,720,780,50);
	}
	public class ThreadOfWarning  implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			int x=600;
			int y=720;
			
			while(y!=670){
				if((y-670)>10){
					y-=10;
				}
				else{
					y=670;
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				WarningPanel.this.setLocation(x, y);
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while(y!=720){
				if((720-y)>10){
					y+=10;
				}
				else{
					y=720;
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				WarningPanel.this.setLocation(x, y);
			}
		}
		
	}
}
