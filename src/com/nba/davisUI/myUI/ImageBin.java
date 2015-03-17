package com.nba.davisUI.myUI;

import javax.swing.ImageIcon;

public class ImageBin {
	
	
	public static ImageIcon getImage(String key){
		 
		String ImageFilePath = "data/ui/image/";
		
		switch(key){
		
		case "LoadingBackground" : return new ImageIcon(ImageFilePath + "loading/loadingBackground.png");
		
		}
		return null;
	}
}
