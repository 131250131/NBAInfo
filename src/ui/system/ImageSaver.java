package ui.system;

import java.awt.Color;

import javax.swing.ImageIcon;

public class ImageSaver {
	
	public static ImageIcon getIcon(String iconName){
		
		String iconPath = "image/effect/";
		
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
			case "scan" : return new ImageIcon(iconPath + "littleScan.png");
			case "live" : return new ImageIcon(iconPath + "live.png");
			case "live2" : return new ImageIcon(iconPath + "live2.png");
		}
		
		return null;
	}
	
	public static ImageIcon getTeamIcon(String teamName){
		return new ImageIcon("image/team/" + teamName + ".png");
	}
	
	public static ImageIcon getPlayerIcon(String playerName){
		return new ImageIcon("image/player/portrait/" + playerName + ".png");
	}
	
	public static ImageIcon getPlayerAcitonIcon(String playerName){
		return new ImageIcon("image/player/action/" + playerName + ".png");
	}

	public static Color getTeamBackColor(String teamName){
		Color name = null;
		switch(teamName){
		case "DAL":	
			name = new Color(0f / 255, 105f / 255, 180f / 255, 0.4f);
			break;
		case "DEN":	
			name = new Color(0f / 255, 149f / 255, 212f / 255, 0.4f);
			break;
		case "GSW":	
			name = new Color(239f / 255, 174f / 255, 23f / 255, 0.4f);
			break;	
		case "HOU":	
			name = new Color(226f / 255, 0f / 255, 76f / 255, 0.4f);
			break;	
		case "LAC":	
			name = new Color(0f / 255, 102f / 255, 174f / 255, 0.4f);
			break;	
		case "LAL":	
			name = new Color(82f / 255, 31f / 255, 110f / 255, 0.4f);
			break;	
		case "MEM":	
			name = new Color(90f / 255, 139f / 255, 188f / 255, 0.4f);
			break;	
		case "MIN":	
			name = new Color(0f / 255, 169f / 255, 79f / 255, 0.4f);
			break;
		case "NOP":	
			name = new Color(0f / 255, 56f / 255, 119f / 255, 0.4f);
			break;
		case "POR":	
			name = new Color(84f / 255, 84f / 255, 84f / 255, 0.4f);
			break;
		case "OKC":	
			name = new Color(0f / 255, 150f / 255, 207f / 255, 0.4f);
			break;
		case "PHX":	
			name = new Color(228f / 255, 95f / 255, 31f / 255, 0.4f);
			break;
		case "SAC":	
			name = new Color(48f / 255, 50f / 255, 156f / 255, 0.4f);
			break;
		case "SAS":	
			name = new Color(83f / 255, 83f / 255, 83f / 255, 0.4f);
			break;
		case "UTA":	
			name = new Color(0f / 255, 50f / 255, 110f / 255, 0.4f);
			break;
		case "ATL":
			name = new Color(232f / 255, 66f / 255, 74f / 255, 0.4f);
			break;
		case "BKN":	
			name = new Color(0f / 255, 0f / 255, 0f / 255, 0.4f);
			break;
		case "BOS":	
			name = new Color(2f / 255, 143f / 255, 78f / 255, 0.4f);
			break;
		case "CHA":	
			name = new Color(7f / 255, 161f / 255, 184f / 255, 0.4f);
			break;
		case "CHI":	
			name = new Color(205f / 255, 0f / 255, 58f / 255, 0.4f);
			break;
		case "CLE":	
			name = new Color(140f / 255, 0f / 255, 59f / 255, 0.4f);
			break;
		case "DET":	
			name = new Color(237f / 255, 0f / 255, 64f / 255, 0.4f);
			break;
		case "IND":	
			name = new Color(251f / 255, 185f / 255, 49f / 255, 0.4f);
			break;
		case "MIA":	
			name = new Color(154f / 255, 0f / 255, 47f / 255, 0.4f);
			break;
		case "MIL":	
			name = new Color(77f / 255, 127f / 255, 108f / 255, 0.4f);
			break;
		case "NYK":	
			name = new Color(244f / 255, 91f / 255, 32f / 255, 0.4f);
			break;
		case "ORL":	
			name = new Color(0f / 255, 107f / 255, 183f / 255, 0.4f);
			break;
		case "PHI":	
			name = new Color(6f / 255, 107f / 255, 178f / 255, 0.4f);
			break;
		case "TOR":	
			name = new Color(174f / 255, 23f / 255, 14f / 255, 0.4f);
			break;
		case "WAS":	
			name = new Color(46f / 255, 34f / 255, 46f / 255, 0.4f);
			break;
		}
		return name;
	}
}
