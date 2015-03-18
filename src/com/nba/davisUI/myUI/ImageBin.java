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
		}
		return null;
	}
	
}
