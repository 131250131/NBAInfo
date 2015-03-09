package com.main;

public class Player implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	public Player(String _playerName, String _playerNumber,String _playerPosition,
			String _playerHeight, String _playerWeight, String _playerBirth, 
			String _playerAge, String _playerExp, String _playerSchool, int _playerID){
		
		playerName = _playerName;
		playerNumber = _playerNumber;
		position = _playerPosition;
		height = _playerHeight;
		weight = Double.parseDouble(_playerWeight);
		playerBirth = _playerBirth;
		playerAge = Integer.parseInt(_playerAge);
		
		if(_playerExp.equals("R")){
			exp = 0;
		}else{
			exp = Integer.parseInt(_playerExp);
		}
		
		school = _playerSchool;
		playerID = _playerID;
		
	}
	
	//球员类， 用序列号进行保存
	
	//1.球员名称 （球员名称作为查找唯一标识）
		//格式类似：Anthony Tolliver
		String playerName;
	
	//2.球员号码
		String playerNumber;
		
	//3.球员位置
		//先发中锋C 先发前锋F 先发后卫G 
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
		String school;
	
	//10.球员ID (*****要传*****)
		int playerID;
		
	//11.球员参赛场数 
		int playerAttends;
		
	//12.球员先发场数 (*****要传*****)
		int startTimes;
		
	//13.队员助攻数 (*****要传*****)
		int playerAssists;

	//14.队员上场时间(单位：秒) (*****要传*****)
		int playerPlayTime;	
		
	//15.队员投篮命中数 (*****要传*****)
		int playerFG; 
		
	//16.队员投篮出手数 (*****要传*****)
		int playerFGTry; 
		
	//17.队员三分命中数 (*****要传*****)
		int player3FG;
		
	//18.队员三分出手数 (*****要传*****)
		int player3FGTry;
		
	//19.队员罚球命中数 (*****要传*****)
		int playerFTG;
		
	//20.队员罚球出手数 (*****要传*****)
		int playerFTGTry; 
		
	//21.队员进攻篮板数 (*****要传*****)
		int playerOffenceRebounds;
			
	//22.队员防守篮板数 (*****要传*****)
		int playerDeffenceRebounds;
			
	//23.队员总篮板数 (*****要传*****)
		int playerTotalRebounds; 
		
	//24.队员抢断数 (*****要传*****)
		int playerSteals;
		
	//25.队员盖帽数 (*****要传*****)
		int playerBlocks;		
		
	//26.队员失误数 (*****要传*****)
		int playerTurnovers;
		
	//27.队员犯规数 (*****要传*****)
		int playerFouls;
		
	//28.队员总得分数 (*****要传*****)
		int playerScores; 
		
//	//29.队员平均助攻数
//		double aver_playerAssists = playerAssists / playerAttends;
//		
//	//30.队员平均在场时间
//		double aver_playerPlayTime = playerPlayTime / playerAttends;
//		
//	//31.队员平均投篮命中数
//		double aver_playerFG = playerFG / playerAttends;
//		
//	//32.队员平均投篮出手数
//		double aver_playerFGTry = playerFGTry / playerAttends;
//		
//	//33.队员平均三分命中数
//		double aver_player3FG = player3FG / playerAttends;
//				
//	//34.队员平均三分出手数
//		double aver_player3FGTry = player3FGTry / playerAttends;
//		
//	//35.队员平均罚球命中数
//		double aver_playerFTG = playerFTG / playerAttends;
//		
//	//36.队员平均罚球出手数
//		double aver_playerFTGTry = playerFTGTry / playerAttends;
//		
//	//37.队员平均进攻篮板数
//		double aver_playerOffenceRebounds = playerOffenceRebounds / playerAttends;
//		
//	//38.队员平均防守篮板数
//		double aver_playerDeffenceRebounds = playerDeffenceRebounds / playerAttends;
//		
//	//39.队员平均总篮板数
//		double aver_playerTotalRebounds = playerTotalRebounds / playerAttends;
//		
//	//40.队员平均抢断数
//		double aver_playerSteals = playerSteals / playerAttends;
//		
//	//41.队员平均盖帽数
//		double aver_playerBlocks = playerBlocks / playerAttends;
//		
//	//42.队员平均失误数
//		double aver_playerTurnovers = playerTurnovers / playerAttends;
//		
//	//43.队员平均犯规数
//		double aver_playerFouls = playerFouls / playerAttends;
//		
//	//44.队员平均得分
//		double aver_playerScores = playerScores / playerAttends;
//		
//	//45.队员投篮命中率
//		double playerFGP = playerFG / playerFGTry;
//		
//	//46.队员三分命中率
//		double player3FGP = player3FG / player3FGTry;
//		
//	//47.队员罚球命中率	
//		double playerFTGP = playerFTG / playerFTGTry;
//		
//	//48.队员效率(PER)
//		double playerPER = ((playerScores + playerTotalRebounds + playerAssists + playerSteals + playerBlocks) 
//				- (playerFGTry - playerFG) - (playerFTGTry - playerFTG) - playerTurnovers) / playerAttends;
//		
//	//49.队员GmSc效率值
//		double playerGmScER = (playerScores + 0.4 * playerFG - 0.7 * playerFGTry - 0.4 * (playerFTGTry - playerFTG)
//				+ 0.7 * playerOffenceRebounds + 0.3 * playerDeffenceRebounds + playerSteals + 0.7 * playerAssists 
//				+ 0.7 * playerBlocks - 0.4 * playerFouls - playerTurnovers) / playerAttends;
//		
//	//50.队员真实命中率
//		double playerTSP = playerScores / (2 * (playerFGTry + 0.44 * playerFTGTry));
//		
//	//51.队员投篮效率
//		double playerSER = (playerFG + 0.5 * player3FG) / playerFGTry;
//		
//	//52.队员篮板率
//		double RR;
//		
//	//53.进攻篮板率
//		double o_RR;
//		
//	//54.防守篮板率
//		double d_RR;
//		
//	//55.助攻率
//		double AR;
//		
//	//56.抢断率
//		double SR;
//		
//	//57.盖帽率
//		double BR;
//		
//	//58.失误率
//		double TR;
//		
//	//59.使用率
//		double UR;
//		
//		
//	//60.球员队友出场时间 (*****要传*****)
//		int teammatePlayTime;
//		
//	//61.球员球队总篮板 (*****要传*****) 
//		int allTeamRebounds;
//		
//	//62.球员对手总篮板 (*****要传*****)
//		int allEnemyRebounds;
//		
//	//63.球员球队进攻篮板 (*****要传*****)
//		int o_allTeamRebounds;
//		
//	//64.球员对手进攻篮板 (*****要传*****)
//		int o_allEnemyRebounds;
//		
//	//65.球员球队防守篮板 (*****要传*****)
//		int d_allTeamRebounds;
//		
//	//66.球员对手防守篮板 (*****要传*****)
//		int d_allEnemyRebounds;
//		
//	//67.球员球队总进球数 (*****要传*****)
//		int allTeamFT;
//		
//	//68.球员球队出手数 (*****要传*****)
//		int allTeamShoots;
//		
//	//69.球队对手出手数 (*****要传*****)
//		int allEnemyShoots;
//		
//	//70.球队球员罚球次数 (*****要传*****)
//		int allTeamFTShoots;
//		
//	//71.球队所有球员失误次数 (*****要传*****)
//		int allTeamTurnover;
//		
//	//72.球队对手进攻次数 (*****要传*****)
//		int allEnemyOffenceTime;
//		
//	
}
