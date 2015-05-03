package ui.system;

public class ChineseTranslator {
	
	public static String teamEastOrWest(boolean isEast){
		if(isEast){
			return "东部";
		}else{
			return "西部";
		}		
	}
	
	public static String teamDivisionTrans(String _division){
		String division = null;
		switch(_division){
		case "Southeast":
			return "东南区";
		case "Atlantic":
			return "大西洋区";
		case "Central":
			return "中部区";
		case "Southwest":
			return "西南区";
		case "Pacific":
			return "太平洋区";
		case "Northwest":
			return "西北区";
		}
		return division;
	}
	
	public static String TeamNameTrans(String teamName){
		String name = null;
		switch(teamName){
		case "DAL":	
			name = "小牛";
			break;
		case "DEN":	
			name = "掘金";
			break;
		case "GSW":	
			name = "勇士";
			break;	
		case "HOU":	
			name = "火箭";
			break;	
		case "LAC":	
			name = "快船";
			break;	
		case "LAL":	
			name = "湖人";
			break;	
		case "MEM":	
			name = "灰熊";
			break;	
		case "MIN":	
			name = "灰狼";
			break;
		case "NOP":	
			name = "鹈鹕";
			break;
		case "POR":	
			name = "拓荒者";
			break;
		case "OKC":	
			name = "雷霆";
			break;
		case "PHX":	
			name = "太阳";
			break;
		case "SAC":	
			name = "国王";
			break;
		case "SAS":	
			name = "马刺";
			break;
		case "UTA":	
			name = "爵士";
			break;
		case "ATL":
			name = "老鹰";
			break;
		case "BKN":	
			name = "篮网";
			break;
		case "BOS":	
			name = "凯尔特人";
			break;
		case "CHA":	
			name = "黄蜂";
			break;
		case "CHI":	
			name = "公牛";
			break;
		case "CLE":	
			name = "骑士";
			break;
		case "DET":	
			name = "活塞";
			break;
		case "IND":	
			name = "步行者";
			break;
		case "MIA":	
			name = "热火";
			break;
		case "MIL":	
			name = "雄鹿";
			break;
		case "NYK":	
			name = "尼克斯";
			break;
		case "ORL":	
			name = "魔术";
			break;
		case "PHI":	
			name = "76人";
			break;
		case "TOR":	
			name = "猛龙";
			break;
		case "WAS":	
			name = "奇才";
			break;
		}	
		return name;
	}

}
