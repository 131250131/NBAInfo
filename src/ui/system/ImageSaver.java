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
			case "热点球员背景" : return new ImageIcon(iconPath + "热点球员背景.png");
			case "进度条绿" : return new ImageIcon(iconPath + "进度条绿.png");
			case "进度条蓝" : return new ImageIcon(iconPath + "进度条蓝.png");
			case "进度条橘" : return new ImageIcon(iconPath + "进度条橘.png");
			case "进度条黄" : return new ImageIcon(iconPath + "进度条黄.png");
			case "进度条粉" : return new ImageIcon(iconPath + "进度条粉.png");
			case "标签绿" : return new ImageIcon(iconPath + "标签绿.png");
			case "标签蓝" : return new ImageIcon(iconPath + "标签蓝.png");
			case "标签橘" : return new ImageIcon(iconPath + "标签橘.png");
			case "标签黄" : return new ImageIcon(iconPath + "标签黄.png");
			case "标签粉" : return new ImageIcon(iconPath + "标签粉.png");
			case "单个比赛背景A" : return new ImageIcon(iconPath + "单个比赛背景A.png");
			case "单个比赛背景B" : return new ImageIcon(iconPath + "单个比赛背景B.png");
			case "比赛背景图片" : return new ImageIcon(iconPath + "比赛背景图片.png");
			case "rankW" : return new ImageIcon(iconPath + "rankW.png"); 
			case "rankW2" : return new ImageIcon(iconPath + "rankW2.png");
			case "rankE" : return new ImageIcon(iconPath + "rankE.png");
			case "rankE2" : return new ImageIcon(iconPath + "rankE2.png");
			case "新增页面背景" : return new ImageIcon(iconPath + "新增页面背景.png");
			case "新增页面背景2" : return new ImageIcon(iconPath + "新增页面背景2.png");
			case "滑轮背景" : return new ImageIcon(iconPath + "滑轮背景.png");
		}
		
		return null;
	}
	
	public static ImageIcon getTeamIcon(String teamName){
		return new ImageIcon("image/team/" + teamName + ".png");
	}
	
	public static ImageIcon getPlayerIcon(String playerName){
		return new ImageIcon("data/newImage/portrait/" + playerName + ".png");
	}

}
