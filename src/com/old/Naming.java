package com.old;

public class Naming {//test
	
//	//Team Information
//		//球队名称： 
//			String teamName;
//		//球队缩写：
//			String shortName;
//		//球队所在地
//			String location;
//		//赛区
//			boolean isEast;
//		//分区
//			String division;
//		//球馆名称
//			String gymName;
//		//建立时间
//			int birthYear;
//		
//		//比赛场数
			
	//Player Information
		//球员名称
			String playerName;
		//所属球队
			String playerTeamName;
		//参赛场数
			int attends;
		//先发场数
			int startTimes;
			
		//球员队友出场时间
			int teamatePlayTime;
		//球员球队总篮板
			int allTeamRebounds;
		//球员对手总篮板
			int allEnemyRebounds;
		//球员球队进攻篮板
			int o_allTeamRebounds;
		//球员对手进攻篮板
			int o_allEnemyRebounds;
		//球员球队防守篮板
			int d_allTeamRebounds;
		//球员对手防守篮板
			int d_allEnemyRebounds;
		//球员球队总进球数
			int allTeamFT;
		//球员球队出手数
			int allTeamShoots;
		//球队对手出手数
			int allEnemyShoots;
		//球队球员罚球次数
			int allTeamFTShoots;
		//球队所有球员失误次数
			int allTeamTurnover;
		//球队对手进攻次数
			int allEnemyOffenceTime;
			
		//助攻数
			int assists;
		//在场时间
			int playTime;
		//投篮命中数
			int FG;
		//投篮出手数
			int shoots;
		//三分命中数
			int threePointFG;
		//三分出手数
			int threePointShoots;
		//罚球命中数
			int FT;
		//罚球出手数
			int FTShoots;
		//进攻篮板数
			int o_Rebounds;
		//防守篮板数
			int d_Rebounds;
		//篮板数
			int totalRebounds;
		//抢断数
			int steals;
		//盖帽数
			int blocks;
		//失误数
			int turnover;
		//犯规数
			int fouls;
		//得分
			int scores;
			
		//平均助攻数
			double aver_assists = assists / attends;
		//平均在场时间
			double aver_playTime = playTime / attends;
		//平均投篮命中数
			double aver_FG = FG / attends;
		//平均投篮出手数
			double aver_shoots = shoots / attends;
		//平均三分命中数
			double aver_threePointFG = threePointFG / attends;
		//平均三分出手数
			double aver_threePointShoots = threePointShoots / attends;
		//平均罚球命中数
			double aver_FT = FT / attends;
		//平均罚球出手数
			double aver_FTShoots = FTShoots / attends;
		//平均进攻篮板数
			double aver_o_Rebounds = o_Rebounds / attends;
		//平均防守篮板数
			double aver_d_Rebounds = d_Rebounds / attends;
		//平均篮板数
			double aver_totalRebounds = totalRebounds / attends;
		//平均抢断数
			double aver_steals = steals / attends;
		//平均盖帽数
			double aver_blocks = blocks / attends;
		//平均失误数
			double aver_turnover = turnover / attends;
		//平均犯规数
			double aver_fouls = fouls / attends;
		//平均得分
			double aver_scores = scores / attends;
			
		//投篮命中率
			double FGP = shoots / FG;
		//三分命中率
			double threePointP = threePointShoots / threePointFG; 
		//罚球命中率	
			double FTP = FTShoots / FT;
		//效率
			double PER = ((scores + totalRebounds + assists + steals + blocks) 
							- (shoots - FG) - (FTShoots - FT) - turnover) / attends;
		//GmSc效率值
			double GmScER = (scores + 0.4 * FG - 0.7 * shoots - 0.4 * (FTShoots - FT)
					+ 0.7 * o_Rebounds + 0.3 * d_Rebounds + steals + 0.7 * assists 
					+ 0.7 * blocks - 0.4 * fouls - turnover) / attends;
		//真实命中率
			double TSP = scores / (2 * (shoots + 0.44 * FTShoots));
			
		//投篮效率
			double SER = (FG + 0.5 * threePointFG) / shoots;
			
		//篮板率
			double RR = totalRebounds * (teamatePlayTime / 5) 
					/ playTime / (allTeamRebounds + allEnemyRebounds);
		//进攻篮板率
			double o_RR = totalRebounds * (teamatePlayTime / 5) 
					/ playTime / (o_allTeamRebounds + o_allEnemyRebounds);
		//防守篮板率
			double d_RR = totalRebounds * (teamatePlayTime / 5) 
					/ playTime / (d_allTeamRebounds + d_allEnemyRebounds);
		//助攻率
			double AR = assists / (playTime / (teamatePlayTime / 5) * allTeamFT - FG);
		//抢断率
			double SR = steals * (teamatePlayTime / 5) / playTime / allEnemyOffenceTime;
		//盖帽率
			double BR = blocks * (teamatePlayTime / 5) / playTime / allEnemyShoots;
		//失误率
			double TR = turnover / (shoots + 0.44 * FTShoots + turnover);
		//使用率
			double UR = (shoots + 0.44 * FTShoots + turnover) * (teamatePlayTime / 5) 
					/ playTime / (allTeamShoots + 0.44 * allTeamFTShoots + allTeamTurnover);
		//球员位置
			String position;
		//球员联盟分区
		//球员联盟分部
		
}
