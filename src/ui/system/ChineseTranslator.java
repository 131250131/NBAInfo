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
		case "三城黑鹰队" :
			  name = "TRI";
			  break; 
			case "TRI" :
			  name = "三城黑鹰队";
			  break; 
			case "丹佛掘金队" :
			  name = "DEN";
			  break; 
			case "DEN" :
			  name = "丹佛掘金队";
			  break; 
			case "丹佛火箭队" :
			  name = "DNR";
			  break; 
			case "DNR" :
			  name = "丹佛火箭队";
			  break; 
			case "丹佛老掘金队" :
			  name = "DNN";
			  break; 
			case "DNN" :
			  name = "丹佛老掘金队";
			  break; 
			case "丹佛老老掘金队" :
			  name = "DNA";
			  break; 
			case "DNA" :
			  name = "丹佛老老掘金队";
			  break; 
			case "亚特兰大老鹰队" :
			  name = "ATL";
			  break; 
			case "ATL" :
			  name = "亚特兰大老鹰队";
			  break; 
			case "休斯顿小牛队" :
			  name = "HSM";
			  break; 
			case "HSM" :
			  name = "休斯顿小牛队";
			  break; 
			case "休斯顿火箭队" :
			  name = "HOU";
			  break; 
			case "HOU" :
			  name = "休斯顿火箭队";
			  break; 
			case "佛罗里达人队" :
			  name = "FLO";
			  break; 
			case "FLO" :
			  name = "佛罗里达人队";
			  break; 
			case "俄克拉荷马雷霆队" :
			  name = "OKC";
			  break; 
			case "OKC" :
			  name = "俄克拉荷马雷霆队";
			  break; 
			case "克里夫兰反叛者队" :
			  name = "CLR";
			  break; 
			case "CLR" :
			  name = "克里夫兰反叛者队";
			  break; 
			case "克里夫兰骑士队" :
			  name = "CLE";
			  break; 
			case "CLE" :
			  name = "克里夫兰骑士队";
			  break; 
			case "匹兹堡秃鹰队" :
			  name = "PTC";
			  break; 
			case "PTC" :
			  name = "匹兹堡秃鹰队";
			  break; 
			case "匹兹堡铁人队" :
			  name = "PIT";
			  break; 
			case "PIT" :
			  name = "匹兹堡铁人队";
			  break; 
			case "匹兹堡风笛手队" :
			  name = "PTP";
			  break; 
			case "PTP" :
			  name = "匹兹堡风笛手队";
			  break; 
			case "华盛顿奇才队" :
			  name = "WAS";
			  break; 
			case "WAS" :
			  name = "华盛顿奇才队";
			  break; 
			case "华盛顿子弹队" :
			  name = "WSB";
			  break; 
			case "WSB" :
			  name = "华盛顿子弹队";
			  break; 
			case "华盛顿老首都队" :
			  name = "WSC";
			  break; 
			case "WSC" :
			  name = "华盛顿老首都队";
			  break; 
			case "华盛顿首都队" :
			  name = "WSA";
			  break; 
			case "WSA" :
			  name = "华盛顿首都队";
			  break; 
			case "卡罗来纳美洲狮队" :
			  name = "CAR";
			  break; 
			case "CAR" :
			  name = "卡罗来纳美洲狮队";
			  break; 
			case "印第安纳喷气机队" :
			  name = "INJ";
			  break; 
			case "INJ" :
			  name = "印第安纳喷气机队";
			  break; 
			case "印第安纳步行者队" :
			  name = "IND";
			  break; 
			case "IND" :
			  name = "印第安纳步行者队";
			  break; 
			case "印第安纳波利斯队" :
			  name = "INO";
			  break; 
			case "INO" :
			  name = "印第安纳波利斯队";
			  break; 
			case "印第安纳老者队" :
			  name = "INA";
			  break; 
			case "INA" :
			  name = "印第安纳老者队";
			  break; 
			case "圣地亚哥快船队" :
			  name = "SDC";
			  break; 
			case "SDC" :
			  name = "圣地亚哥快船队";
			  break; 
			case "圣地亚哥火箭队" :
			  name = "SDR";
			  break; 
			case "SDR" :
			  name = "圣地亚哥火箭队";
			  break; 
			case "圣地亚哥远航队" :
			  name = "SDS";
			  break; 
			case "SDS" :
			  name = "圣地亚哥远航队";
			  break; 
			case "圣安东尼奥老刺队" :
			  name = "SAA";
			  break; 
			case "SAA" :
			  name = "圣安东尼奥老刺队";
			  break; 
			case "圣安东尼奥马刺队" :
			  name = "SAS";
			  break; 
			case "SAS" :
			  name = "圣安东尼奥马刺队";
			  break; 
			case "圣路易斯精神队" :
			  name = "SSL";
			  break; 
			case "SSL" :
			  name = "圣路易斯精神队";
			  break; 
			case "圣路易斯老鹰队" :
			  name = "STL";
			  break; 
			case "STL" :
			  name = "圣路易斯老鹰队";
			  break; 
			case "圣路易轰炸机队" :
			  name = "STB";
			  break; 
			case "STB" :
			  name = "圣路易轰炸机队";
			  break; 
			case "圣迭戈征服者队" :
			  name = "SDA";
			  break; 
			case "SDA" :
			  name = "圣迭戈征服者队";
			  break; 
			case "堪萨奥马哈国王队" :
			  name = "KCO";
			  break; 
			case "KCO" :
			  name = "堪萨奥马哈国王队";
			  break; 
			case "堪萨斯城国王队" :
			  name = "KCK";
			  break; 
			case "KCK" :
			  name = "堪萨斯城国王队";
			  break; 
			case "夏洛特黄蜂队" :
			  name = "CHA";
			  break; 
			case "CHA" :
			  name = "夏洛特黄蜂队";
			  break; 
			case "多伦多猛龙队" :
			  name = "TOR";
			  break; 
			case "TOR" :
			  name = "多伦多猛龙队";
			  break; 
			case "多伦多麝香队" :
			  name = "TRH";
			  break; 
			case "TRH" :
			  name = "多伦多麝香队";
			  break; 
			case "奥克兰橡树队" :
			  name = "OAK";
			  break; 
			case "OAK" :
			  name = "奥克兰橡树队";
			  break; 
			case "奥兰多魔术队" :
			  name = "ORL";
			  break; 
			case "ORL" :
			  name = "奥兰多魔术队";
			  break; 
			case "孟菲斯檀木队" :
			  name = "MMT";
			  break; 
			case "MMT" :
			  name = "孟菲斯檀木队";
			  break; 
			case "孟菲斯灰熊队" :
			  name = "MEM";
			  break; 
			case "MEM" :
			  name = "孟菲斯灰熊队";
			  break; 
			case "孟菲斯职业者队" :
			  name = "MMP";
			  break; 
			case "MMP" :
			  name = "孟菲斯职业者队";
			  break; 
			case "孟菲斯超音速队" :
			  name = "MMS";
			  break; 
			case "MMS" :
			  name = "孟菲斯超音速队";
			  break; 
			case "安德逊包装工队" :
			  name = "AND";
			  break; 
			case "AND" :
			  name = "安德逊包装工队";
			  break; 
			case "密尔沃基老鹰队" :
			  name = "MLH";
			  break; 
			case "MLH" :
			  name = "密尔沃基老鹰队";
			  break; 
			case "密尔沃基雄鹿队" :
			  name = "MIL";
			  break; 
			case "MIL" :
			  name = "密尔沃基雄鹿队";
			  break; 
			case "巴尔的摩子弹队" :
			  name = "BLB";
			  break; 
			case "BLB" :
			  name = "巴尔的摩子弹队";
			  break; 
			case "巴提摩尔子弹队" :
			  name = "BAL";
			  break; 
			case "BAL" :
			  name = "巴提摩尔子弹队";
			  break; 
			case "布法罗勇敢者队" :
			  name = "BUF";
			  break; 
			case "BUF" :
			  name = "布法罗勇敢者队";
			  break; 
			case "布鲁克林篮网队" :
			  name = "BKN";
			  break; 
			case "BKN" :
			  name = "布鲁克林篮网队";
			  break; 
			case "底特律活塞队" :
			  name = "DET";
			  break; 
			case "DET" :
			  name = "底特律活塞队";
			  break; 
			case "底特律猎鹰队" :
			  name = "DTF";
			  break; 
			case "DTF" :
			  name = "底特律猎鹰队";
			  break; 
			case "德州丛林队" :
			  name = "TEX";
			  break; 
			case "TEX" :
			  name = "德州丛林队";
			  break; 
			case "新奥尔良海盗队" :
			  name = "NOB";
			  break; 
			case "NOB" :
			  name = "新奥尔良海盗队";
			  break; 
			case "新奥尔良爵士队" :
			  name = "NOJ";
			  break; 
			case "NOJ" :
			  name = "新奥尔良爵士队";
			  break; 
			case "新奥尔良鹈鹕队" :
			  name = "NOH";
			  break; 
			case "NOH" :
			  name = "新奥尔良鹈鹕队";
			  break; 
			case "新泽西篮网队" :
			  name = "NJN";
			  break; 
			case "NJN" :
			  name = "新泽西篮网队";
			  break; 
			case "新泽西美洲人队" :
			  name = "NJA";
			  break; 
			case "NJA" :
			  name = "新泽西美洲人队";
			  break; 
			case "旧金山勇士队" :
			  name = "SFW";
			  break; 
			case "SFW" :
			  name = "旧金山勇士队";
			  break; 
			case "明尼苏达森林狼队" :
			  name = "MIN";
			  break; 
			case "MIN" :
			  name = "明尼苏达森林狼队";
			  break; 
			case "明尼苏达风笛手队" :
			  name = "MNP";
			  break; 
			case "MNP" :
			  name = "明尼苏达风笛手队";
			  break; 
			case "明尼苏达麝香队" :
			  name = "MNM";
			  break; 
			case "MNM" :
			  name = "明尼苏达麝香队";
			  break; 
			case "明尼阿波利斯湖人队" :
			  name = "MNL";
			  break; 
			case "MNL" :
			  name = "明尼阿波利斯湖人队";
			  break; 
			case "普罗登斯蒸汽队" :
			  name = "PRO";
			  break; 
			case "PRO" :
			  name = "普罗登斯蒸汽队";
			  break; 
			case "波士顿凯尔特人队" :
			  name = "BOS";
			  break; 
			case "BOS" :
			  name = "波士顿凯尔特人队";
			  break; 
			case "波特兰开拓者队" :
			  name = "POR";
			  break; 
			case "POR" :
			  name = "波特兰开拓者队";
			  break; 
			case "洛杉矶快船队" :
			  name = "LAC";
			  break; 
			case "LAC" :
			  name = "洛杉矶快船队";
			  break; 
			case "洛杉矶星光队" :
			  name = "LAS";
			  break; 
			case "LAS" :
			  name = "洛杉矶星光队";
			  break; 
			case "洛杉矶湖人队" :
			  name = "LAL";
			  break; 
			case "LAL" :
			  name = "洛杉矶湖人队";
			  break; 
			case "温哥华灰熊队" :
			  name = "VAN";
			  break; 
			case "VAN" :
			  name = "温哥华灰熊队";
			  break; 
			case "滑铁卢老鹰队" :
			  name = "WAT";
			  break; 
			case "WAT" :
			  name = "滑铁卢老鹰队";
			  break; 
			case "犹他星光队" :
			  name = "UTS";
			  break; 
			case "UTS" :
			  name = "犹他星光队";
			  break; 
			case "犹他爵士队" :
			  name = "UTA";
			  break; 
			case "UTA" :
			  name = "犹他爵士队";
			  break; 
			case "福特韦恩活塞队" :
			  name = "FTW";
			  break; 
			case "FTW" :
			  name = "福特韦恩活塞队";
			  break; 
			case "纽约尼克斯队" :
			  name = "NYK";
			  break; 
			case "NYK" :
			  name = "纽约尼克斯队";
			  break; 
			case "纽约篮网队" :
			  name = "NYN";
			  break; 
			case "NYN" :
			  name = "纽约篮网队";
			  break; 
			case "纽约老篮网队" :
			  name = "NYA";
			  break; 
			case "NYA" :
			  name = "纽约老篮网队";
			  break; 
			case "维吉尼亚大地主队" :
			  name = "VIR";
			  break; 
			case "VIR" :
			  name = "维吉尼亚大地主队";
			  break; 
			case "罗切斯特皇家队" :
			  name = "ROC";
			  break; 
			case "ROC" :
			  name = "罗切斯特皇家队";
			  break; 
			case "肯塔基上校队" :
			  name = "KEN";
			  break; 
			case "KEN" :
			  name = "肯塔基上校队";
			  break; 
			case "芝加哥公牛队" :
			  name = "CHI";
			  break; 
			case "CHI" :
			  name = "芝加哥公牛队";
			  break; 
			case "芝加哥包装工队" :
			  name = "CHP";
			  break; 
			case "CHP" :
			  name = "芝加哥包装工队";
			  break; 
			case "芝加哥西风队" :
			  name = "CHZ";
			  break; 
			case "CHZ" :
			  name = "芝加哥西风队";
			  break; 
			case "芝加哥雄鹿队" :
			  name = "CHS";
			  break; 
			case "CHS" :
			  name = "芝加哥雄鹿队";
			  break; 
			case "菲尼克斯太阳队" :
			  name = "PHO";
			  break; 
			case "PHO" :
			  name = "菲尼克斯太阳队";
			  break; 
			case "萨克拉门托国王队" :
			  name = "SAC";
			  break; 
			case "SAC" :
			  name = "萨克拉门托国王队";
			  break; 
			case "西伯根红人队" :
			  name = "SHE";
			  break; 
			case "SHE" :
			  name = "西伯根红人队";
			  break; 
			case "西拉丘斯国民队" :
			  name = "SYR";
			  break; 
			case "SYR" :
			  name = "西拉丘斯国民队";
			  break; 
			case "西雅图超音速队" :
			  name = "SEA";
			  break; 
			case "SEA" :
			  name = "西雅图超音速队";
			  break; 
			case "费城76人队" :
			  name = "PHI";
			  break; 
			case "PHI" :
			  name = "费城76人队";
			  break; 
			case "费城勇士队" :
			  name = "PHW";
			  break; 
			case "PHW" :
			  name = "费城勇士队";
			  break; 
			case "辛辛纳提皇家队" :
			  name = "CIN";
			  break; 
			case "CIN" :
			  name = "辛辛纳提皇家队";
			  break; 
			case "达拉斯丛林队" :
			  name = "DLC";
			  break; 
			case "DLC" :
			  name = "达拉斯丛林队";
			  break; 
			case "达拉斯小牛队" :
			  name = "DAL";
			  break; 
			case "DAL" :
			  name = "达拉斯小牛队";
			  break; 
			case "迈阿密佛罗里达队" :
			  name = "MMF";
			  break; 
			case "MMF" :
			  name = "迈阿密佛罗里达队";
			  break; 
			case "迈阿密热火队" :
			  name = "MIA";
			  break; 
			case "MIA" :
			  name = "迈阿密热火队";
			  break; 
			case "金州勇士队" :
			  name = "GSW";
			  break; 
			case "GSW" :
			  name = "金州勇士队";
			  break; 
			case "阿纳海姆搞基队" :
			  name = "ANA";
			  break; 
			case "ANA" :
			  name = "阿纳海姆搞基队";
			  break; 
			case "首都子弹队" :
			  name = "CAP";
			  break; 
			case "CAP" :
			  name = "首都子弹队";
			  break; 
		}	
		return name;
	}

}
