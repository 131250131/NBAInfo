package com.nba.davisUI.myUI;

import java.io.File;

import javax.swing.ImageIcon;

public class ImageBin {
	
	
	public static ImageIcon getImage(String key){
		 
		String ImageFilePath = "data/ui/image/";
		
		switch(key){
		
		case "LoadingBackground" : return new ImageIcon(ImageFilePath + "loading/loadingBackground.png");
		case "LoadingButtonOne" : return new ImageIcon(ImageFilePath + "loading/loadingButtonOne.png");
		case "LoadingButtonTwo" : return new ImageIcon(ImageFilePath + "loading/loadingButtonTwo.png");
		case "indexBackground" : return new ImageIcon(ImageFilePath + "index/indexBackground.png");
		case "test" : return new ImageIcon(ImageFilePath + "index/test.png");
		case "indexBackground2" : return new ImageIcon(ImageFilePath + "index/indexBackground2.png");
		case "indexBackground3" : return new ImageIcon(ImageFilePath + "index/indexBackground3.png");
		case "exit1" : return new ImageIcon(ImageFilePath + "all/exitButton1.png");
		case "exit2" : return new ImageIcon(ImageFilePath + "all/exitButton2.png");
		case "mini1" : return new ImageIcon(ImageFilePath + "all/miniButton1.png");
		case "mini2" : return new ImageIcon(ImageFilePath + "all/miniButton2.png");
		case "bgOfPlayer" : return new ImageIcon(ImageFilePath + "bg/playerbg.jpg");
		case "scan" : return new ImageIcon(ImageFilePath + "all/littleScan.png");
		case "warn" : return new ImageIcon(ImageFilePath + "all/warn.png");
		case "return" : return new ImageIcon(ImageFilePath + "all/return.png");
		default://专用于球员头像
			return new ImageIcon(ImageFilePath + "portrait/"+key+".png");
		}
	}
	
}
