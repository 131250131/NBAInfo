package userInterface.myUI;

import javax.swing.ImageIcon;

public class ImageSaver {
	
	public static ImageIcon getIcon(String iconName){
		
		String iconPath = "data/newImage/";
		
		switch(iconName){
		case "background1": return new ImageIcon(iconPath + "background0.png");
		//case "background2": return new ImageIcon(iconPath + "background2.png");
		case "background3": return new ImageIcon(iconPath + "background3.png");
		case "background4": return new ImageIcon(iconPath + "background4.png");
		case "todayBack0" : return new ImageIcon(iconPath + "todayBack0.png");
		case "todayBack1" : return new ImageIcon(iconPath + "todayBack1.png");
		case "todayBack2" : return new ImageIcon(iconPath + "todayBack2.png");
		case "todayPlayerBack" : return new ImageIcon(iconPath + "TodayPlayerBack.png");
		case "todayPlayerBack2" : return new ImageIcon(iconPath + "TodayPlayerBack2.png");
		case "todayPlayerBack3" : return new ImageIcon(iconPath + "TodayPlayerBack3.png");
		case "backLogo" : return new ImageIcon(iconPath + "backLogo.png");
		case "allPlayerBack" : return new ImageIcon(iconPath + "allPlayerBack.png");
		case "allPlayerBack2" : return new ImageIcon(iconPath + "allPlayerBack2.png");
		case "allPlayerBack3" : return new ImageIcon(iconPath + "allPlayerBack3.png");
		case "keyGameBack" : return new ImageIcon(iconPath + "keyGameBack.png");
		case "keyGameBack2" : return new ImageIcon(iconPath + "keyGameBack2.png");
		case "adv1" : return new ImageIcon(iconPath + "adv1.png");
		
		case "singleMatchBack" : return new ImageIcon(iconPath + "singleMatchBack.png");
		case "singleMatchBack2" : return new ImageIcon(iconPath + "singleMatchBack2.png");
		case "singleMatchBack3" : return new ImageIcon(iconPath + "singleMatchBack3.png");
		
		case "standingBack" : return new ImageIcon(iconPath + "standingBack.png");
		
		case "ATL0" : return new ImageIcon(iconPath + "TodayTeam/ATL0.png");
		case "ATL1" : return new ImageIcon(iconPath + "TodayTeam/ATL1.png");
		case "BKN0" : return new ImageIcon(iconPath + "TodayTeam/BKN0.png");
		case "BKN1" : return new ImageIcon(iconPath + "TodayTeam/BKN1.png");
		case "BOS0" : return new ImageIcon(iconPath + "TodayTeam/BOS0.png");
		case "BOS1" : return new ImageIcon(iconPath + "TodayTeam/BOS1.png");
		case "CHA0" : return new ImageIcon(iconPath + "TodayTeam/CHA0.png");
		case "CHA1" : return new ImageIcon(iconPath + "TodayTeam/CHA1.png");
		case "CHI0" : return new ImageIcon(iconPath + "TodayTeam/CHI0.png");
		case "CHI1" : return new ImageIcon(iconPath + "TodayTeam/CHI1.png");
		
		case "CLE0" : return new ImageIcon(iconPath + "TodayTeam/CLE0.png");
		case "CLE1" : return new ImageIcon(iconPath + "TodayTeam/CLE1.png");
		case "DAL0" : return new ImageIcon(iconPath + "TodayTeam/DAL0.png");
		case "DAL1" : return new ImageIcon(iconPath + "TodayTeam/DAL1.png");
		case "DEN0" : return new ImageIcon(iconPath + "TodayTeam/DEN0.png");
		case "DEN1" : return new ImageIcon(iconPath + "TodayTeam/DEN1.png");
		case "DET0" : return new ImageIcon(iconPath + "TodayTeam/DET0.png");
		case "DET1" : return new ImageIcon(iconPath + "TodayTeam/DET1.png");
		case "GSW0" : return new ImageIcon(iconPath + "TodayTeam/GSW0.png");
		case "GSW1" : return new ImageIcon(iconPath + "TodayTeam/GSW1.png");
		
		case "HOU0" : return new ImageIcon(iconPath + "TodayTeam/HOU0.png");
		case "HOU1" : return new ImageIcon(iconPath + "TodayTeam/HOU1.png");
		case "IND0" : return new ImageIcon(iconPath + "TodayTeam/IND0.png");
		case "IND1" : return new ImageIcon(iconPath + "TodayTeam/IND1.png");
		case "LAC0" : return new ImageIcon(iconPath + "TodayTeam/LAC0.png");
		case "LAC1" : return new ImageIcon(iconPath + "TodayTeam/LAC1.png");
		case "LAL0" : return new ImageIcon(iconPath + "TodayTeam/LAL0.png");
		case "LAL1" : return new ImageIcon(iconPath + "TodayTeam/LAL1.png");
		case "MEM0" : return new ImageIcon(iconPath + "TodayTeam/MEM0.png");
		case "MEM1" : return new ImageIcon(iconPath + "TodayTeam/MEM1.png");
		
		case "MIA0" : return new ImageIcon(iconPath + "TodayTeam/MIA0.png");
		case "MIA1" : return new ImageIcon(iconPath + "TodayTeam/MIA1.png");
		case "MIL0" : return new ImageIcon(iconPath + "TodayTeam/MIL0.png");
		case "MIL1" : return new ImageIcon(iconPath + "TodayTeam/MIL1.png");
		case "MIN0" : return new ImageIcon(iconPath + "TodayTeam/MIN0.png");
		case "MIN1" : return new ImageIcon(iconPath + "TodayTeam/MIN1.png");
		case "NOP0" : return new ImageIcon(iconPath + "TodayTeam/NOP0.png");
		case "NOP1" : return new ImageIcon(iconPath + "TodayTeam/NOP1.png");
		case "NYK0" : return new ImageIcon(iconPath + "TodayTeam/NYK0.png");
		case "NYK1" : return new ImageIcon(iconPath + "TodayTeam/NYK1.png");
		
		case "OKC0" : return new ImageIcon(iconPath + "TodayTeam/OKC0.png");
		case "OKC1" : return new ImageIcon(iconPath + "TodayTeam/OKC1.png");
		case "ORL0" : return new ImageIcon(iconPath + "TodayTeam/ORL0.png");
		case "ORL1" : return new ImageIcon(iconPath + "TodayTeam/ORL1.png");
		case "PHI0" : return new ImageIcon(iconPath + "TodayTeam/PHI0.png");
		case "PHI1" : return new ImageIcon(iconPath + "TodayTeam/PHI1.png");
		case "PHX0" : return new ImageIcon(iconPath + "TodayTeam/PHX0.png");
		case "PHX1" : return new ImageIcon(iconPath + "TodayTeam/PHX1.png");
		case "POR0" : return new ImageIcon(iconPath + "TodayTeam/POR0.png");
		case "POR1" : return new ImageIcon(iconPath + "TodayTeam/POR1.png");
		
		case "SAC0" : return new ImageIcon(iconPath + "TodayTeam/SAC0.png");
		case "SAC1" : return new ImageIcon(iconPath + "TodayTeam/SAC1.png");
		case "SAS0" : return new ImageIcon(iconPath + "TodayTeam/SAS0.png");
		case "SAS1" : return new ImageIcon(iconPath + "TodayTeam/SAS1.png");
		case "TOR0" : return new ImageIcon(iconPath + "TodayTeam/TOR0.png");
		case "TOR1" : return new ImageIcon(iconPath + "TodayTeam/TOR1.png");
		case "UTA0" : return new ImageIcon(iconPath + "TodayTeam/UTA0.png");
		case "UTA1" : return new ImageIcon(iconPath + "TodayTeam/UTA1.png");
		case "WAS0" : return new ImageIcon(iconPath + "TodayTeam/WAS0.png");
		case "WAS1" : return new ImageIcon(iconPath + "TodayTeam/WAS1.png");
		
		case "mouseEffect" : return new ImageIcon(iconPath + "TodayTeam/mouseEffect.png");
		//用于其他通用路径，文件夹/图片名
		default: 
			System.out.println(iconPath + iconName+".png");
			return new ImageIcon(iconPath + iconName+".png");
		
		}
		
	}
}
