package com.old;

public class WeiDaiMa {
	
//////第一步 从球员文件中获得以下内容
		//1.球员名称 （球员名称作为查找唯一标识）
			//格式类似：Anthony Tolliver
			String playerName;
	
		//2.球员号码
			int playerNumber;
			
		//3.球员位置
			//中锋C 前锋F 后卫G 
			String position;
			
		//4.球员高度
			//格式类似：6-0 (6尺0寸)
			String height;
			
		//5.球员体重
			//格式类似：161
			double weight;
		
		//6.球员生日
			//格式类似： JAN 14， 1985
			String playerBirth;
		
		//7.球员年龄
			int playerAge;
		
		//8.球员进入联盟时间
			int exp;
			
		//9.球员学校或国家
			String School;
			
	//第一次创建时读取这些文件 为每一球员创建单独的文件以便后期保存数据
	//存储格式可以定义为如下形式：
		 /*
		  	"playerName;playerNumber;position;height;weight;playerBirth;playerAge;exp;School;"
			""
		  */
	//即
		/*
		 	"球员名称;球员号码;球员位置;球员高度;球员体重;球员生日;球员年龄;球员进入联盟时间;球员学校或国家;"
		 	""
		 */
	
//////第二步 读取球队文件 为每一球队创建单独文件以便后期保存数据
		//1.球队全名
			String teamName;
		
		//2.球队简称
			String shortName;
		
		//3.球队城市
			String city;
		
		//4.球队分部
			String area;
		
		//5.球队分区
			String division;
			
		//6.体育馆名称
			String gymName;
			
		//7.创建时间
			int timeBuiltTime;
		
	//存储格式可以定义为如下形式：
		/*
			"teamName;shortName;city;area;division;gymName;timeBuiltTime;"
			""
		*/
	//即
		/*
			 "球队全名;球队简称;球队城市;球队分部;球队分区;体育馆名称;创建时间;"
			 ""
		 */	
			
//////第三步 开始读取比赛信息 并且实时更新到各个部分中
			
		//T1.队伍比赛场数
		int teamAttends;//teamAttends++;
		
		//判断球员为左队还是右队 即“PHI-DEN”中的前者还是后者
		boolean isLeft;
		
		//注意!!!以下读出的数据我们做成一个数组进行存储,定义为String[] MatchReader;	
			//1.球员名称 这是分辨球员唯一方式（ String playerName;）
				//MatchReader[0]
			//2.位置
				//注意这里只有先发会有位置显示（先发中锋C 先发前锋F 先发后卫G ）其余为空
				//MatchReader[1]
			//3.在场时间
				//MatchReader[2] 其格式类似 30:24 通过时间转换函数 int playTimeTransform(String time) 返回;
				//playTimeTransform(MatchReader[2]);
					/*int playTimeTransform(String time){
					  	String[] array = time.split(":");
					  	return Integer.parseInt(array[0]) * 60 + Integer.parseInt(array[1]);//单位秒
						}*/
				int playTime;//playTime = playTimeTransform(MatchReader[2]);
			//4.投篮命中数
				int FG;//FG = Integer.parseInt(MatchReader[3]); 
			//5.投篮出手数
				int FGTry;//FGTry = Integer.parseInt(MatchReader[4]); 
			//6.三分命中数
				int threeFG;//threeFG = Integer.parseInt(MatchReader[5]); 
			//7.三分出手数
				int threeFGTry;//threeFGTry = Integer.parseInt(MatchReader[6]); 
			//8.罚球命中数
				int FTG;//FTG = Integer.parseInt(MatchReader[7]); 
			//9.罚球出手数
				int FTGTry;//FTGTry = Integer.parseInt(MatchReader[8]); 
			//10.进攻篮板数
				int offenceRebounds;//offenceRebounds = Integer.parseInt(MatchReader[9]); 
			//11.防守篮板数
				int deffenceRebounds;//deffenceRebounds = Integer.parseInt(MatchReader[10]); 
			//12.总篮板数
				int totalRebounds;//totalRebounds = Integer.parseInt(MatchReader[11]); 
			//13.助攻数
				int assists;//assists = Integer.parseInt(MatchReader[12]); 
			//14.抢断数
				int steals;//steals = Integer.parseInt(MatchReader[13]); 
			//15.盖帽数
				int blocks;//blocks = Integer.parseInt(MatchReader[14]); 
			//16.失误数
				int turnovers;//turnovers = Integer.parseInt(MatchReader[15]); 
			//17.犯规数
				int fouls;//fouls = Integer.parseInt(MatchReader[16]); 
			//18.个人得分
				int scores;//scores = Integer.parseInt(MatchReader[17]); 
			
	//接下来通过这些数据来增加至队伍以及球员的属性中
			//1.球员参赛场数
			int playerAttends;//playerAttends++;
			
			//2.球员先发场数
			int startTimes;
				/*if(MatchReader[1].equals("F") || MatchReader[1].equals("G") || MatchReader[1].equals("C") ){
				 	startTimes++;
				 	}
				 */
			
			//3.队员助攻数
			int playerAssists;//playerAssists = playerAssists + assists;
			
			//T3.球队助攻数
			int teamAssists ;//teamAssists = teamAssists + assists;

			//4.队员上场时间(单位：秒)
			int playerPlayTime;//playerPlayTime = playerPlayTime + playTime;
			
			//This4.本场比赛总出场时间
			int teamPlayTime;//teamPlayTime = teamPlayTime + playTime;
			
			//5.队员投篮命中数
			int playerFG;//playerFG = playerFG + FG; 
			
			//T5.球队投篮命中数
			int teamFG ;//teamFG = teamFG + FG;
			
			//This5.本场球队投篮命中数
			int leftTeamFG;
			int rightTeamFG;
				//if(isLeft) leftTeamFG = leftTeamFG + FG;
				//else rightTeamFG = rightTeamFG + FG;
			
			//6.队员投篮出手数
			int playerFGTry;//playerFGTry = playerFGTry + FGTry; 
			
			//T6.球队投篮出手次数
			int teamFGTry ;//teamFGTry = teamFGTry + FGTry;
			
			//This6.本场球队投篮出手次数
			int leftTeamFGTry;
			int rightTeamFGTry;
				//if(isLeft) leftTeamFGTry = leftTeamFGTry + FGTry;
				//else rightTeamFGTry = rightTeamFGTry + FGTry;
			
			//7.队员三分命中数
			int player3FG;//player3FG = player3FG + threeFG; 
			
			//T7.球队三分命中数
			int team3FG ;//team3FG = team3FG + threeFG;
			
			//8.队员三分出手数
			int player3FGTry;//player3FGTry = player3FGTry + threeFGTry;
			
			//T8.球队三分出手数
			int team3FGTry;//team3FGTry = team3FGTry + threeFGTry;
			
			//9.队员罚球命中数
			int playerFTG;//playerFTG = playerFTG + FTG; 
			
			//T9.球队罚球命中数
			int teamFTG;//teamFTG = teamFTG + FTG;
			
			//10.队员罚球出手数
			int playerFTGTry;//playerFTGTry = playerFTGTry + FTGTry; 
			
			//T10.球队罚球出手数
			int teamFTGTry;//teamFTGTry = teamFTGTry + FTGTry; 
			
			//This10.本场球队罚球出手次数
			int leftTeamFTGTry;
			int rightTeamFTGTry;
				//if(isLeft) leftTeamFTGTry = leftTeamFTGTry + FTGTry;
				//else rightTeamFTGTry = rightTeamFTGTry + FTGTry;
			
			//11.队员进攻篮板数
			int playerOffenceRebounds;//playerOffenceRebounds = playerOffenceRebounds + offenceRebounds; 
			
			//T11.球队进攻篮板数
			int teamOffenceRebounds;//teamOffenceRebounds = teamOffenceRebounds + offenceRebounds;
			
			//This11.本场比赛球队进攻篮板数
			int leftOffenceRebounds;
			int rightOffenceRebounds;
				//if(isLeft) leftOffenceRebounds = leftOffenceRebounds + offenceRebounds;
				//else rightOffenceRebounds = rightOffenceRebounds + offenceRebounds;
			
			//12.队员防守篮板数
			int playerDeffenceRebounds;//playerDeffenceRebounds = playerDeffenceRebounds + deffenceRebounds; 
			
			//T12.球队防守篮板数
			int teamDeffenceRebounds;//teamDeffenceRebounds = teamDeffenceRebounds + deffenceRebounds; 
			
			//This12.本场比赛球队防守篮板数
			int leftDeffenceRebounds;
			int rightDeffenceRebounds;;
				//if(isLeft) leftDeffenceRebounds = leftDeffenceRebounds + offenceRebounds;
				//else rightDeffenceRebounds = rightDeffenceRebounds + offenceRebounds;
			
			//13.队员总篮板数
			int playerTotalRebounds;//playerTotalRebounds = playerTotalRebounds + totalRebounds; 
			
			//T13.球队总篮板数
			int teamTotalRebounds;//teamTotalRebounds = teamTotalRebounds + totalRebounds; 
			
			//This13.本场比赛球队总篮板数
			int leftTotalRebounds;
			int rightTotalRebounds;;
				//if(isLeft) leftTotalRebounds = leftTotalRebounds + totalRebounds;
				//else rightTotalRebounds = rightTotalRebounds + totalRebounds;
			
			//14.队员抢断数
			int playerSteals;//playerSteals = playerSteals + steals; 
			
			//T14.球队抢断数
			int teamSteals;//teamSteals = teamSteals + steals; 
			
			//15.队员盖帽数
			int playerBlocks;//playerBlocks = playerBlocks + blocks;
			
			//T15.球队盖帽数
			int teamBlocks;//teamBlocks = teamBlocks + blocks;
			
			//16.队员失误数
			int playerTurnovers;//playerTurnovers = playerTurnovers + turnovers; 
			
			//T16.球队失误数
			int teamTurnovers;//teamTurnovers = teamTurnovers + turnovers;
			
			//This16.本场比赛球队失误数
			int leftTeamTurnovers;
			int rightTeamTurnovers;
				//if(isLeft) leftTeamTurnovers = leftTeamTurnovers + turnovers;
				//else rightTeamTurnovers = rightTeamTurnovers + turnovers;
			
			//17.队员犯规数
			int playerFouls;//playerFouls = playerFouls + fouls;
			
			//T17.球队犯规数
			int teamFouls;//teamFouls = teamFouls + fouls;
			
			//19.队员总得分数
			int playerScores;//playerScores = playerScores + scores; 
			
			//T19.球队总得分数
			int teamScores;//teamScores = teamScores + scores; 
			
			//20.队员平均助攻数
			double aver_playerAssists = playerAssists / playerAttends;
			
			//21.队员平均在场时间
			double aver_playerPlayTime = playerPlayTime / playerAttends;
			
			//22.队员平均投篮命中数
			double aver_playerFG = playerFG / playerAttends;
			
			//23.队员平均投篮出手数
			double aver_playerFGTry = playerFGTry / playerAttends;
			
			//24.队员平均三分命中数
			double aver_player3FG = player3FG / playerAttends;
					
			//25.队员平均三分出手数
			double aver_player3FGTry = player3FGTry / playerAttends;
			
			//26.队员平均罚球命中数
			double aver_playerFTG = playerFTG / playerAttends;
			
			//27.队员平均罚球出手数
			double aver_playerFTGTry = playerFTGTry / playerAttends;
			
			//28.队员平均进攻篮板数
			double aver_playerOffenceRebounds = playerOffenceRebounds / playerAttends;
			
			//29.队员平均防守篮板数
			double aver_playerDeffenceRebounds = playerDeffenceRebounds / playerAttends;
			
			//30.队员平均总篮板数
			double aver_playerTotalRebounds = playerTotalRebounds / playerAttends;
			
			//31.队员平均抢断数
			double aver_playerSteals = playerSteals / playerAttends;
			
			//32.队员平均盖帽数
			double aver_playerBlocks = playerBlocks / playerAttends;
			
			//33.队员平均失误数
			double aver_playerTurnovers = playerTurnovers / playerAttends;
			
			//34.队员平均犯规数
			double aver_playerFouls = playerFouls / playerAttends;
			
			//35.队员平均得分
			double aver_playerScores = playerScores / playerAttends;
			
			//36.队员投篮命中率
			double playerFGP = playerFG / playerFGTry;
			
			//37.队员三分命中率
			double player3FGP = player3FG / player3FGTry;
			
			//38.队员罚球命中率	
			double playerFTGP = playerFTG / playerFTGTry;
			
			//39.队员效率(PER)
			double playerPER = ((playerScores + playerTotalRebounds + playerAssists + playerSteals + playerBlocks) 
					- (playerFGTry - playerFG) - (playerFTGTry - playerFTG) - playerTurnovers) / playerAttends;
			
			//40.队员GmSc效率值
			double playerGmScER = (playerScores + 0.4 * playerFG - 0.7 * playerFGTry - 0.4 * (playerFTGTry - playerFTG)
					+ 0.7 * playerOffenceRebounds + 0.3 * playerDeffenceRebounds + playerSteals + 0.7 * playerAssists 
					+ 0.7 * playerBlocks - 0.4 * playerFouls - playerTurnovers) / playerAttends;
			
			//41.队员真实命中率
			double playerTSP = playerScores / (2 * (playerFGTry + 0.44 * playerFTGTry));
			
			//42.队员投篮效率
			double playerSER = (playerFG + 0.5 * player3FG) / playerFGTry;
			
			//43.队员篮板率
			//double 
			
}
