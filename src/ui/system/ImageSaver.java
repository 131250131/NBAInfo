package ui.system;

import javax.swing.ImageIcon;

public class ImageSaver {
	
	public static ImageIcon getIcon(String iconName){
		
		String iconPath = "image/";
		
		switch(iconName){
			case "最底层背景图": return new ImageIcon(iconPath + "最底层背景图.png");
			case "首页图片" : return new ImageIcon(iconPath + "首页图片.png"); 
			case "首页图片2" : return new ImageIcon(iconPath + "首页图片2.png"); 
			case "选择栏背景" : return new ImageIcon(iconPath + "选择栏背景.png");
			case "选择栏背景-关闭" : return new ImageIcon(iconPath + "选择栏背景-关闭.png");
			case "主页背景" : return new ImageIcon(iconPath + "主页背景.gif");
			case "今日最佳球员背景" : return new ImageIcon(iconPath + "今日最佳球员背景.png");
			case "今日最佳球员背景2" : return new ImageIcon(iconPath + "今日最佳球员背景2.png");
			case "今日最佳球员背景3" : return new ImageIcon(iconPath + "今日最佳球员背景3.png");
			case "赛季最佳球员背景" : return new ImageIcon(iconPath + "赛季最佳球员背景.png");
			case "赛季最佳球员背景2" : return new ImageIcon(iconPath + "赛季最佳球员背景2.png");
		}
		
		return null;
	}

}
