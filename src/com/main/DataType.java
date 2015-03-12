package com.main;

public enum DataType {
	/*球员数据*/
	//11.球员参赛场数 
			 playerAttends,
			
		//12.球员先发场数 (*****要传*****)
			 startTimes,
			
		//13.队员助攻数 (*****要传*****)
			 playerAssists,

		//14.队员上场时间(单位：秒) (*****要传*****)
			 playerPlayTime,	
			
		//15.队员投篮命中数 (*****要传*****)
			 playerFG, 
			
		//16.队员投篮出手数 (*****要传*****)
			 playerFGTry, 
				
		//17.队员三分命中数 (*****要传*****)
			 player3FG,
			
		//18.队员三分出手数 (*****要传*****)
			 player3FGTry,
			
		//19.队员罚球命中数 (*****要传*****)
			 playerFTG,
			
		//20.队员罚球出手数 (*****要传*****)
			 playerFTGTry, 
			
		//21.队员进攻篮板数 (*****要传*****)
			 playerOffenceRebounds,
				
		//22.队员防守篮板数 (*****要传*****)
			 playerDeffenceRebounds,
				
		//23.队员总篮板数 (*****要传*****)
			 playerTotalRebounds, 
			
		//24.队员抢断数 (*****要传*****)
			 playerSteals,
			
		//25.队员盖帽数 (*****要传*****)
			 playerBlocks,		
			
		//26.队员失误数 (*****要传*****)
			 playerTurnovers,
			
		//27.队员犯规数 (*****要传*****)
			 playerFouls,
			
		//28.队员总得分数 (*****要传*****)
			 playerScores, 
			
		//29.队员平均助攻数
			  aver_playerAssists ,
			
		//30.队员平均在场时间
			  aver_playerPlayTime  ,
			
		//31.队员平均投篮命中数
			  aver_playerFG  ,
			
		//32.队员平均投篮出手数
			  aver_playerFGTry ,
			
		//33.队员平均三分命中数
			  aver_player3FG ,
					
		//34.队员平均三分出手数
			  aver_player3FGTry ,
			
		//35.队员平均罚球命中数
			  aver_playerFTG ,
			
		//36.队员平均罚球出手数
			  aver_playerFTGTry ,
			
		//37.队员平均进攻篮板数
			  aver_playerOffenceRebounds ,
			
		//38.队员平均防守篮板数
			  aver_playerDeffenceRebounds ,
			
		//39.队员平均总篮板数
			  aver_playerTotalRebounds ,
			
		//40.队员平均抢断数
			  aver_playerSteals ,
			
		//41.队员平均盖帽数
			  aver_playerBlocks ,
			
		//42.队员平均失误数
			  aver_playerTurnovers ,
			
		//43.队员平均犯规数
			  aver_playerFouls ,
			
		//44.队员平均得分
			  aver_playerScores ,
			
		//45.队员投篮命中率
			  playerFGP ,
			
		//46.队员三分命中率
			  player3FGP ,
			
		//47.队员罚球命中率	
			  playerFTGP ,
			
		//48.队员效率(PER)
			  playerPER ,
			
		//49.队员GmSc效率值
			  playerGmScER ,
			
		//50.队员真实命中率
			  playerTSP ,
			
		//51.队员投篮效率
			  playerSER ,
			
		//52.队员篮板率
			  RR,
			
		//53.进攻篮板率
			  o_RR,
			
		//54.防守篮板率
			  d_RR,
			
		//55.助攻率
			  AR,
			
		//56.抢断率
			  SR,
			
		//57.盖帽率
			  BR,
			
		//58.失误率
			  TR,
			
		//59.使用率
			  UR,
			
			
		//60.球员队友出场时间 (*****要传*****)
			 teammatePlayTime,
			
		//61.球员球队总篮板 (*****要传*****) 
			 allTeamRebounds,
			
		//62.球员对手总篮板 (*****要传*****)
			 allEnemyRebounds,
			
		//63.球员球队进攻篮板 (*****要传*****)
			 o_allTeamRebounds,
			
		//64.球员对手进攻篮板 (*****要传*****)
			 o_allEnemyRebounds,
			
		//65.球员球队防守篮板 (*****要传*****)
			 d_allTeamRebounds,
			
		//66.球员对手防守篮板 (*****要传*****)
			 d_allEnemyRebounds,
			
		//67.球员球队总进球数 (*****要传*****)
			 allTeamFT,
			
		//68.球员球队出手数 (*****要传*****)
			 allTeamShoots,
			
		//69.球队对手两分球出手数 (*****要传*****)
			 allEnemy2Shoots,
			
		//70.球队球员罚球次数 (*****要传*****)
			 allTeamFTShoots,
			
		//71.球队所有球员失误次数 (*****要传*****)
			 allTeamTurnover,
			
		//72.球队对手进攻次数 (*****要传*****)
			 allEnemyOffenceTimes,
		
			 
	/*球队数据*/
				//球队比赛场数，胜率；（*****需要更新*****）
				 compGames,//总场
				 winGames,//胜场
				 losGames,//败场
				winRate,//胜率
				
		//接下来是球队赛季总数据；	
			//总进攻回合数（*****需要更新*****）
				attackRounds,
			//球队助攻数（*****需要更新*****）
				 teamAssists,
			//球队投篮命中数（*****需要更新*****）
				 teamFG ,
			//球队投篮出手次数（*****需要更新*****）
				 teamFGTry ,
			//球队三分命中数（*****需要更新*****）
				 team3FG ,
			//球队三分出手次数（*****需要更新*****）
				 team3FGTry ,
			//球队球队罚球命中数（*****需要更新*****）
				 teamFTG,
			//球队罚球出手数（*****需要更新*****）
				 teamFTGTry,
			//球队进攻篮板数（*****需要更新*****）
				 teamOffenceRebounds,

			//球队防守篮板数（*****需要更新*****）
				 teamDeffenceRebounds,

			//球队总篮板数（*****需要更新*****）
				 teamTotalRebounds,

			//球队抢断数（*****需要更新*****）
				 teamSteals,
			//球队盖帽数（*****需要更新*****）
				 teamBlocks,
			//球队失误数（*****需要更新*****）
				 teamTurnovers,
			//球队犯规数（*****需要更新*****）
				 teamFouls,
			//球队总得分数（*****需要更新*****）
				 teamScores,

				
		//这是球队的平均信息；
			//球队场均助攻数
				 aver_teamAssists ,
			//球队场均投篮命中数
				 aver_teamFG ,
			//球队场均投篮出手次数
				 aver_teamFGTry ,
			//球队投篮命中率
				 teamFGP,
			//球队场均三分命中数
				 aver_team3FG,
			//球队场均三分出手次数
				 aver_team3FGTry,
			//球队三分命中率
				 team3FGP, 
			//球队场均罚球命中数
				 aver_teamFTG,
			//球队场均罚球出手数
				 aver_teamFTGTry,
			//罚球命中率	
				 teamFTP, 
			//球队场均进攻篮板数
				 aver_teamOffenceRebounds,
			//球队场均防守篮板数
				 aver_teamDeffenceRebounds,
			//球队场均总篮板数
				 aver_teamTotalRebounds,
			//球队场均抢断数
				 aver_teamSteals,
			//球队场均盖帽数
				 aver_teamBlocks,
			//球队场均失误数
				 aver_teamTurnovers,
			//球队场均犯规数
				 aver_teamFouls,
			//球队场均总得分数
				 aver_teamScores,
			//球队对手场均得分数
				 aver_oppoScores,
			//球队进攻效率：
				teamOffE,
			//球队防守效率
				teamDefE,
			//球队进攻篮板效率
				teamOffERebE,
			//球队防守篮板效率
				teamDefERebE,
			//球队抢断效率
				teamSteE,
			//球队助攻效率
				teamAssE, 
				
			//对手进攻篮板数（*****需要更新*****）
				oppoOffenceRebounds,
			//对手防守篮板（*****需要更新*****）
				oppoDeffenceRebounds,
			//对手得分（*****需要更新*****）
				oppoScores,
			//对手总篮板数（*****需要更新*****）
				oppoTotalRebounds,
			//对手总进攻回合
				oppoattackRounds, 
			//对手总助攻
				oppoAssists, 
			//对手总命中
				oppoFG, 
			//对手总出手
				oppoFGTry, 
			//对手总
				oppoFouls, 
			//对手总助攻
				oppoTurnovers, 
			//对手总盖帽
				oppoBlocks, 
			//对艘总抢断
				oppoSteals, 
			//对手总罚篮
				oppoFTGTry, 
			//对手总命中罚篮
				oppoFTG, 
			//对手三分总出手
				oppo3FGTry, 
			//对手三分总命中
				oppo3FG;
}

