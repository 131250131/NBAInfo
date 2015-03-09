package com.main;
public class Team implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Team(String _teamFullName, String _teamShortName, String _teamLocation
			, String _teamEastOrWest, String _teamDivision, String _teamGym, String _teamBirth){
		
		teamName = _teamFullName;
		shortName = _teamShortName;
		location = _teamLocation;
		
		if(_teamEastOrWest.equals("E")){
			isEast = true;
		}else{
			isEast = false;
		}
		
		division = _teamDivision;
		gymName = _teamGym;
		birthYear = Integer.parseInt(_teamBirth);
	}
	
	/*这是一个球队的整体信息*/
	
	//首先是最基本的信息
	
	//球队全名 │ 缩写│ 所在地 │ 赛区│ 分区 │ 主场 │ 建立时间║
	
	//球队名称： 
		String teamName;
	//球队缩写：
		String shortName;
	//球队所在地
		String location;
	//赛区
		boolean isEast;
	//分区
		String division;
	//球馆名称
		String gymName;
	//建立时间
		int birthYear;
	
	/*
	 * 更新这个类需要哪些数据；
	 * */
	
	
	//球队的编号；
		int teamID;
	//球队比赛场数，胜率；（*****需要更新*****）
		int compGames;
		int winGames;
		int losGames;
		double winRate;
		
//接下来是球队赛季总数据；	
	//总进攻回合数（*****需要更新*****）
		int attackRounds;
	//球队助攻数（*****需要更新*****）
		int teamAssists;
	//球队投篮命中数（*****需要更新*****）
		int teamFG ;
	//球队投篮出手次数（*****需要更新*****）
		int teamFGTry ;
	//球队三分命中数（*****需要更新*****）
		int team3FG ;
	//球队三分出手次数（*****需要更新*****）
		int team3FGTry ;
	//球队球队罚球命中数（*****需要更新*****）
		int teamFTG;
	//球队罚球出手数（*****需要更新*****）
		int teamFTGTry;
	//球队进攻篮板数（*****需要更新*****）
		int teamOffenceRebounds;
	//球队防守篮板数（*****需要更新*****）
		int teamDeffenceRebounds;
	//球队总篮板数（*****需要更新*****）
		int teamTotalRebounds;
	//球队抢断数（*****需要更新*****）
		int teamSteals;
	//球队盖帽数（*****需要更新*****）
		int teamBlocks;
	//球队失误数（*****需要更新*****）
		int teamTurnovers;
	//球队犯规数（*****需要更新*****）
		int teamFouls;
	//球队总得分数（*****需要更新*****）
		int teamScores;
		
//这是球队的平均信息；
	//球队场均助攻数
		int aver_teamAssists ;
	//球队场均投篮命中数
		int aver_teamFG ;
	//球队场均投篮出手次数
		int aver_teamFGTry ;
	//球队投篮命中率
		double teamFGP;
	//球队场均三分命中数
		int aver_team3FG;
	//球队场均三分出手次数
		int aver_team3FGTry;
	//球队三分命中率
		double team3FGP; 
	//球队场均罚球命中数
		int aver_teamFTG;
	//球队场均罚球出手数
		int aver_teamFTGTry;
	//罚球命中率	
		double teamFTP; 
	//球队场均进攻篮板数
		int aver_teamOffenceRebounds;
	//球队场均防守篮板数
		int aver_teamDeffenceRebounds;
	//球队场均总篮板数
		int aver_teamTotalRebounds;
	//球队场均抢断数
		int aver_teamSteals;
	//球队场均盖帽数
		int aver_teamBlocks;
	//球队场均失误数
		int aver_teamTurnovers;
	//球队场均犯规数
		int aver_teamFouls;
	//球队场均总得分数
		int aver_teamScores;
	//球队进攻效率：
		double teamOffE;
	//球队防守效率
		double teamDefE;
	//球队篮板效率
		double teamRebE;
	//球队抢断效率
		double teamSteE;
	//球队助攻效率
		double teamAssE;
	
}
