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
		case "小牛":	
			name = "DAL";
			break;
		case "DEN":	
			name = "掘金";
			break;
		case "掘金":	
			name = "DEN";
			break;
		case "GSW":	
			name = "勇士";
			break;
		case "勇士":	
			name = "GSW";
			break;	
		case "HOU":	
			name = "火箭";
			break;
		case "火箭":	
			name = "HOU";
			break;
		case "LAC":	
			name = "快船";
			break;
		case "快船":	
			name = "LAC";
			break;	
		case "LAL":	
			name = "湖人";
			break;
		case "湖人":	
			name = "LAL";
			break;	
		case "MEM":	
			name = "灰熊";
			break;
		case "灰熊":	
			name = "MEM";
			break;
		case "MIN":	
			name = "灰狼";
			break;
		case "灰狼":	
			name = "MIN";
			break;
		case "NOP":	
			name = "鹈鹕";
			break;
		case "鹈鹕":	
			name = "NOP";
			break;
		case "POR":	
			name = "拓荒者";
			break;
		case "拓荒者":	
			name = "POR";
			break;
		case "OKC":	
			name = "雷霆";
			break;
		case "雷霆":	
			name = "OKC";
			break;
		case "PHX":	
			name = "太阳";
			break;
		case "太阳":	
			name = "PHX";
			break;
		case "SAC":	
			name = "国王";
			break;
		case "国王":	
			name = "SAC";
			break;
		case "SAS":	
			name = "马刺";
			break;
		case "马刺":	
			name = "SAS";
			break;
		case "UTA":	
			name = "爵士";
			break;
		case "爵士":	
			name = "UTA";
			break;
		case "ATL":
			name = "老鹰";
			break;
		case "老鹰":
			name = "ATL";
			break;
		case "BKN":	
			name = "篮网";
			break;
		case "篮网":	
			name = "BKN";
			break;
		case "BOS":	
			name = "凯尔特人";
			break;
		case "凯尔特人":	
			name = "BOS";
			break;
		case "CHA":	
			name = "黄蜂";
			break;
		case "黄蜂":	
			name = "CHA";
			break;
		case "CHI":	
			name = "公牛";
			break;
		case "公牛":	
			name = "CHI";
			break;
		case "CLE":	
			name = "骑士";
			break;
		case "骑士":	
			name = "CLE";
			break;
		case "DET":	
			name = "活塞";
			break;
		case "活塞":	
			name = "DET";
			break;
		case "IND":	
			name = "步行者";
			break;
		case "步行者":	
			name = "IND";
			break;
		case "MIA":	
			name = "热火";
			break;
		case "热火":	
			name = "MIA";
			break;
		case "MIL":	
			name = "雄鹿";
			break;
		case "雄鹿":	
			name = "MIL";
			break;
		case "NYK":	
			name = "尼克斯";
			break;
		case "尼克斯":	
			name = "NYK";
			break;
		case "ORL":	
			name = "魔术";
			break;
		case "魔术":	
			name = "ORL";
			break;
		case "PHI":	
			name = "76人";
			break;
		case "76人":	
			name = "PHI";
			break;
		case "TOR":	
			name = "猛龙";
			break;
		case "猛龙":	
			name = "TOR";
			break;
		case "WAS":	
			name = "奇才";
			break;
		case "奇才":	
			name = "WAS";
			break;
		}	
		return name;
	}

}
