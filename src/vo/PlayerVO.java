package vo;

import java.util.ArrayList;

import logic.Player;
import logic.TeamController;

public class PlayerVO implements Comparable<PlayerVO>{
		
		private double advancedP=0;
		public String comparetype="";
		private int double_double=0;
		public PlayerVO(){
		
		}
		
		ArrayList<Integer> attendedMatches =new ArrayList<Integer>();
		
		public ArrayList<Integer> getAttendedMatches() {
			return attendedMatches;
		}
		
		public void addAttendedMatches(int num) {
			attendedMatches.add(num);
		}
		
		String teamShortName;
		
		public void updateTeamShortName(String _teamShortName){	
			teamShortName = _teamShortName;
		}
		
		
//		public String get
		
		//球员类， 用序列号进行保存
		
		//1.球员名称 （球员名称作为查找唯一标识）
			//格式类似：Anthony Tolliver
			private String playerName;
		
		//2.球员号码
			private String playerNumber;
			
		//3.球员位置
			//先发中锋C 先发前锋F 先发后卫G 
			private String position;
			
		//4.球员高度
			//格式类似：6-0 (6尺0寸)
			private String height;
			
		//5.球员体重
			//格式类似：161
			private double weight;
		
		//6.球员生日
			//格式类似： JAN 14， 1985
			private String playerBirth;
		
		//7.球员年龄
			private int playerAge;
		
		//8.球员进入联盟时间
			private int exp;
			
		//9.球员学校或国家
			private String school;
		
//		//10.球员ID (*****要传*****) //没用的
//			int playerID;
			
		//11.球员参赛场数 
			private int playerAttends;
			
		//12.球员先发场数 (*****要传*****)
			private int startTimes;
			
		//13.队员助攻数 (*****要传*****)
			private int playerAssists;

		//14.队员上场时间(单位：秒) (*****要传*****)
			private int playerPlayTime;	
			
		//15.队员投篮命中数 (*****要传*****)
			private int playerFG; 
			
		//16.队员投篮出手数 (*****要传*****)
			private int playerFGTry; 
				
		//17.队员三分命中数 (*****要传*****)
			private int player3FG;
			
		//18.队员三分出手数 (*****要传*****)
			private int player3FGTry;
			
		//19.队员罚球命中数 (*****要传*****)
			private int playerFTG;
			
		//20.队员罚球出手数 (*****要传*****)
			private int playerFTGTry; 
			
		//21.队员进攻篮板数 (*****要传*****)
			private int playerOffenceRebounds;
				
		//22.队员防守篮板数 (*****要传*****)
			private int playerDeffenceRebounds;
				
		//23.队员总篮板数 (*****要传*****)
			private int playerTotalRebounds; 
			
		//24.队员抢断数 (*****要传*****)
			private int playerSteals;
			
		//25.队员盖帽数 (*****要传*****)
			private int playerBlocks;		
			
		//26.队员失误数 (*****要传*****)
			private int playerTurnovers;
			
		//27.队员犯规数 (*****要传*****)
			private int playerFouls;
			
		//28.队员总得分数 (*****要传*****)
			private int playerScores; 
			
			
		//29.队员平均助攻数
			private double aver_playerAssists ;
			
		//30.队员平均在场时间
			private double aver_playerPlayTime  ;
			
		//31.队员平均投篮命中数
			private double aver_playerFG  ;
			
		//32.队员平均投篮出手数
			private double aver_playerFGTry ;
			
		//33.队员平均三分命中数
			private double aver_player3FG ;
					
		//34.队员平均三分出手数
			private double aver_player3FGTry ;
			
		//35.队员平均罚球命中数
			private double aver_playerFTG ;
			
		//36.队员平均罚球出手数
			private double aver_playerFTGTry ;
			
		//37.队员平均进攻篮板数
			private double aver_playerOffenceRebounds ;
			
		//38.队员平均防守篮板数
			private double aver_playerDeffenceRebounds ;
			
		//39.队员平均总篮板数
			private double aver_playerTotalRebounds ;
			
		//40.队员平均抢断数
			private double aver_playerSteals ;
			
		//41.队员平均盖帽数
			private double aver_playerBlocks ;
			
		//42.队员平均失误数
			private double aver_playerTurnovers ;
			
		//43.队员平均犯规数
			private double aver_playerFouls ;
			
		//44.队员平均得分
			private double aver_playerScores ;
			
		//45.队员投篮命中率
			private double playerFGP ;
			
		//46.队员三分命中率
			private double player3FGP ;
			
		//47.队员罚球命中率	
			private double playerFTGP ;
			
		//48.队员效率(PER)
			private double playerPER ;
			
		//49.队员GmSc效率值
			private double playerGmScER ;
			
		//50.队员真实命中率
			private double playerTSP ;
			
		//51.队员投篮效率
			private double playerSER ;
			
		//52.队员篮板率
			private double RR;
			
		//53.进攻篮板率
			private double o_RR;
			
		//54.防守篮板率
			private double d_RR;
			
		//55.助攻率
			private double AR;
			
		//56.抢断率
			private double SR;
			
		//57.盖帽率
			private double BR;
			
		//58.失误率
			private double TR;
			
		//59.使用率
			private double UR;
			
			
		//60.球员队友出场时间 (*****要传*****)
			private int teammatePlayTime;
			
		//61.球员球队总篮板 (*****要传*****) 
			private int allTeamRebounds;
			
		//62.球员对手总篮板 (*****要传*****)
			private int allEnemyRebounds;
			
		//63.球员球队进攻篮板 (*****要传*****)
			private int o_allTeamRebounds;
			
		//64.球员对手进攻篮板 (*****要传*****)
			private int o_allEnemyRebounds;
			
		//65.球员球队防守篮板 (*****要传*****)
			private int d_allTeamRebounds;
			
		//66.球员对手防守篮板 (*****要传*****)
			private int d_allEnemyRebounds;
			
		//67.球员球队总进球数 (*****要传*****)
			private int allTeamFT;
			
		//68.球员球队出手数 (*****要传*****)
			private int allTeamShoots;
			
		//69.球队对手两分球出手数 (*****要传*****)
			private int allEnemy2Shoots;
			
		//70.球队球员罚球次数 (*****要传*****)
			private int allTeamFTShoots;
			
		//71.球队所有球员失误次数 (*****要传*****)
			private int allTeamTurnover;
			
		//72.球队对手进攻次数 (*****要传*****)
			private double allEnemyOffenceTimes;
			
			
		

			public void setAttendedMatches(ArrayList<Integer> attendedMatches) {
				this.attendedMatches = attendedMatches;
			}

			public void setAver_playerAssists(double aver_playerAssists) {
				this.aver_playerAssists = aver_playerAssists;
			}

			public void setAver_playerPlayTime(double aver_playerPlayTime) {
				this.aver_playerPlayTime = aver_playerPlayTime;
			}

			public void setAver_playerFG(double aver_playerFG) {
				this.aver_playerFG = aver_playerFG;
			}

			public void setAver_playerFGTry(double aver_playerFGTry) {
				this.aver_playerFGTry = aver_playerFGTry;
			}

			public void setAver_player3FG(double aver_player3FG) {
				this.aver_player3FG = aver_player3FG;
			}

			public void setAver_player3FGTry(double aver_player3FGTry) {
				this.aver_player3FGTry = aver_player3FGTry;
			}

			public void setAver_playerFTG(double aver_playerFTG) {
				this.aver_playerFTG = aver_playerFTG;
			}

			public void setAver_playerFTGTry(double aver_playerFTGTry) {
				this.aver_playerFTGTry = aver_playerFTGTry;
			}

			public void setAver_playerOffenceRebounds(double aver_playerOffenceRebounds) {
				this.aver_playerOffenceRebounds = aver_playerOffenceRebounds;
			}

			public void setAver_playerDeffenceRebounds(double aver_playerDeffenceRebounds) {
				this.aver_playerDeffenceRebounds = aver_playerDeffenceRebounds;
			}

			public void setAver_playerTotalRebounds(double aver_playerTotalRebounds) {
				this.aver_playerTotalRebounds = aver_playerTotalRebounds;
			}

			public void setAver_playerSteals(double aver_playerSteals) {
				this.aver_playerSteals = aver_playerSteals;
			}

			public void setAver_playerBlocks(double aver_playerBlocks) {
				this.aver_playerBlocks = aver_playerBlocks;
			}

			public void setAver_playerTurnovers(double aver_playerTurnovers) {
				this.aver_playerTurnovers = aver_playerTurnovers;
			}

			public void setAver_playerFouls(double aver_playerFouls) {
				this.aver_playerFouls = aver_playerFouls;
			}

			public void setAver_playerScores(double aver_playerScores) {
				this.aver_playerScores = aver_playerScores;
			}

			public void setPlayerFGP(double playerFGP) {
				this.playerFGP = playerFGP;
			}

			public void setPlayer3FGP(double player3fgp) {
				player3FGP = player3fgp;
			}

			public void setPlayerFTGP(double playerFTGP) {
				this.playerFTGP = playerFTGP;
			}

			public void setPlayerPER(double playerPER) {
				this.playerPER = playerPER;
			}

			public void setPlayerGmScER(double playerGmScER) {
				this.playerGmScER = playerGmScER;
			}

			public void setPlayerTSP(double playerTSP) {
				this.playerTSP = playerTSP;
			}

			public void setPlayerSER(double playerSER) {
				this.playerSER = playerSER;
			}

			public void setRR(double rR) {
				RR = rR;
			}

			public void setO_RR(double o_RR) {
				this.o_RR = o_RR;
			}

			public void setD_RR(double d_RR) {
				this.d_RR = d_RR;
			}

			public void setAR(double aR) {
				AR = aR;
			}

			public void setSR(double sR) {
				SR = sR;
			}

			public void setBR(double bR) {
				BR = bR;
			}

			public void setTR(double tR) {
				TR = tR;
			}

			public void setUR(double uR) {
				UR = uR;
			}

			public double getAver_playerAssists() {
				return  Double.parseDouble(String.format("%.3f",((playerAttends==0)?0:playerAssists / (playerAttends+0.0))));
			}

			public double getAver_playerPlayTime() {
				return  Double.parseDouble(String.format("%.3f",((playerAttends==0)?0:playerPlayTime / (playerAttends+0.0))));
			}

			public double getAver_playerFG() {
				return  Double.parseDouble(String.format("%.3f",((playerAttends==0)?0:playerFG / (playerAttends+0.0))));
			}

			public double getAver_playerFGTry() {
				return  Double.parseDouble(String.format("%.3f",((playerAttends==0)?0:playerFGTry / (playerAttends+0.0))));
			}

			public double getAver_player3FG() {
				return   Double.parseDouble(String.format("%.3f",((playerAttends==0)?0:player3FG / (playerAttends+0.0))));
			}

			public double getAver_player3FGTry() {
				return  Double.parseDouble(String.format("%.3f",((playerAttends==0)?0:player3FGTry / (playerAttends+0.0))));
			}

			public double getAver_playerFTG() {
				return   Double.parseDouble(String.format("%.3f",((playerAttends==0)?0:playerFTG / (playerAttends+0.0))));
			}

			public double getAver_playerFTGTry() {
				return  Double.parseDouble(String.format("%.3f",((playerAttends==0)?0:playerFTGTry / (playerAttends+0.0))));
			}

			public double getAver_playerOffenceRebounds() {
				return  Double.parseDouble(String.format("%.3f",((playerAttends==0)?0:playerOffenceRebounds / (playerAttends+0.0))));
			}

			public double getAver_playerDeffenceRebounds() {
				return   Double.parseDouble(String.format("%.3f",((playerAttends==0)?0:playerDeffenceRebounds / (playerAttends+0.0))));
			}

			public double getAver_playerTotalRebounds() {
				return   Double.parseDouble(String.format("%.3f",((playerAttends==0)?0:playerTotalRebounds / (playerAttends+0.0))));
			}

			public double getAver_playerSteals() {
				return  Double.parseDouble(String.format("%.3f",((playerAttends==0)?0:playerSteals / (playerAttends+0.0))));
			}

			public double getAver_playerBlocks() {
				return  Double.parseDouble(String.format("%.3f",((playerAttends==0)?0:playerBlocks / (playerAttends+0.0))));
			}

			public double getAver_playerTurnovers() {
				return  Double.parseDouble(String.format("%.3f",((playerAttends==0)?0:playerTurnovers / (playerAttends+0.0))));
			}

			public double getAver_playerFouls() {
				return  Double.parseDouble(String.format("%.3f",((playerAttends==0)?0:playerFouls / (playerAttends+0.0))));
			}

			public double getAver_playerScores() {
				return  Double.parseDouble(String.format("%.3f",((playerAttends==0)?0:playerScores / (playerAttends+0.0))));
			}

			public double getPlayerFGP() {
				if(playerFGTry == 0){
					return 0;
				}else{
					return Double.parseDouble(String.format("%.3f",(playerFG+0.0)/(playerFGTry+0.0)));
				}
			}

			public double getPlayer3FGP() {
				if (player3FGTry!= 0)
					return Double.parseDouble(String.format("%.3f",(player3FG+0.0)/(player3FGTry+0.0)));
				else
					return 0;
			}

			public double getPlayerFTGP() {
				return (playerFTGTry==0)?0:Double.parseDouble(String.format("%.3f",(playerFTG+0.0)/(playerFTGTry+0.0)));
			}

			public double getPlayerPER() {
				return (playerAttends==0)?0:((playerScores + playerTotalRebounds + playerAssists + playerSteals + playerBlocks) 
						- (playerFGTry - playerFG) - (playerFTGTry - playerFTG) - playerTurnovers) / playerAttends;
			}

			public double getPlayerGmScER() {
				return  (playerAttends==0)?0:
					Double.parseDouble(String.format("%.3f",(playerScores + 0.4 * playerFG - 0.7 * playerFGTry - 0.4 * (playerFTGTry - playerFTG)
						+ 0.7 * playerOffenceRebounds + 0.3 * playerDeffenceRebounds + playerSteals + 0.7 * playerAssists 
						+ 0.7 * playerBlocks - 0.4 * playerFouls - playerTurnovers) / playerAttends));
			}

			public double getPlayerTSP() {
				return (playerFGTry==0)?0:Double.parseDouble(String.format("%.3f", (playerScores + 0.0)/ (2 * ((playerFGTry+0.0) + 0.44 * (playerFTGTry+0.0)))));
			}

			public double getPlayerSER() {
				return (playerFGTry==0)?0: Double.parseDouble(String.format("%.3f",(((playerFG + 0.0) + 0.5 * (player3FG + 0.0)) / (playerFGTry + 0.0))));
			}

			public double getRR() {
				return (playerPlayTime==0)?0:
					Double.parseDouble(String.format("%.3f",(playerTotalRebounds + 0.0)*(((teammatePlayTime + 0.0)+(playerPlayTime + 0.0))/5)
					/(playerPlayTime + 0.0)/((allTeamRebounds + 0.0)+(allEnemyRebounds + 0.0))));
			}

			public double getO_RR() {
				return (playerPlayTime==0)?0:
					Double.parseDouble(String.format("%.3f",(playerOffenceRebounds + 0.0)*(((teammatePlayTime + 0.0)+(playerPlayTime + 0.0))/5)
					/(playerPlayTime + 0.0)/((o_allTeamRebounds + 0.0)+(o_allEnemyRebounds + 0.0))));
			}

			public double getD_RR() {
				return (playerPlayTime==0)?0:
					Double.parseDouble(String.format("%.3f",(playerDeffenceRebounds + 0.0)*(((teammatePlayTime + 0.0)+(playerPlayTime + 0.0))/5)
					/(playerPlayTime + 0.0)/((d_allTeamRebounds + 0.0)+(d_allEnemyRebounds + 0.0))));
			}

			public double getAR() {
				if((teammatePlayTime+playerPlayTime)/5 == 0  || playerPlayTime == 0){
					return 0;
				}else{
					double a = playerAssists;
					double b = (teammatePlayTime + playerPlayTime);
					double c = playerPlayTime;
					
					return Double.parseDouble(String.format("%.3f",
							playerAssists / (c / (b / 5) * allTeamFT - playerFG)                ));
					//return playerAssists / (playerPlayTime / (teammatePlayTime + playerPlayTime) / 5) * ( allTeamFT - playerFG );
				}
					
			}

			public double getSR() {
				return (playerPlayTime==0)?0:
					Double.parseDouble(String.format("%.3f",playerSteals*((teammatePlayTime+playerPlayTime)/5)/playerPlayTime/allEnemyOffenceTimes));
			}

			public double getBR() {
				return (playerPlayTime==0)?0:
					Double.parseDouble(String.format("%.3f",(playerBlocks + 0.0)*(((teammatePlayTime + 0.0)+(playerPlayTime + 0.0))
							/5)/(playerPlayTime + 0.0)/(allEnemy2Shoots + 0.0)));
			}

			public double getTR() {
				return (playerPlayTime==0)?0:
					Double.parseDouble(String.format("%.3f",playerTurnovers/(playerFGTry - player3FGTry + 0.44 * playerFTGTry+playerTurnovers)));
			}

			public double getUR() {
				return (playerPlayTime==0)?0:
					Double.parseDouble(String.format("%.3f",(playerFGTry+0.44*playerFTGTry+playerTurnovers)*
						(teammatePlayTime+playerPlayTime)/5/playerPlayTime/
						(allTeamShoots+0.44*allTeamFTShoots+allTeamTurnover)));
			}
//			
//	       

			public String getTeamShortName() {
				return teamShortName;
			}

			public void setTeamShortName(String teamShortName) {
				this.teamShortName = teamShortName;
			}

			public String getPlayerName() {
				return playerName;
			}

			public void setPlayerName(String playerName) {
				this.playerName = playerName;
			}

			public String getPlayerNumber() {
				return playerNumber;
			}

			public void setPlayerNumber(String playerNumber) {
				this.playerNumber = playerNumber;
			}

			public String getPosition() {
				return position;
			}

			public void setPosition(String position) {
				this.position = position;
			}

			public String getHeight() {
				return height;
			}

			public void setHeight(String height) {
				this.height = height;
			}

			public double getWeight() {
				return weight;
			}

			public void setWeight(double weight) {
				this.weight = weight;
			}

			public String getPlayerBirth() {
				return playerBirth;
			}

			public void setPlayerBirth(String playerBirth) {
				this.playerBirth = playerBirth;
			}

			public int getPlayerAge() {
				return playerAge;
			}

			public void setPlayerAge(int playerAge) {
				this.playerAge = playerAge;
			}

			public int getExp() {
				return exp;
			}

			public void setExp(int exp) {
				this.exp = exp;
			}

			public String getSchool() {
				return school;
			}

			public void setSchool(String school) {
				this.school = school;
			}

			public int getPlayerAttends() {
				return playerAttends;
			}

			public void setPlayerAttends(int playerAttends) {
				this.playerAttends = playerAttends;
			}

			public int getStartTimes() {
				return startTimes;
			}

			public void setStartTimes(int startTimes) {
				this.startTimes = startTimes;
			}

			public int getPlayerAssists() {
				return playerAssists;
			}

			public void setPlayerAssists(int playerAssists) {
				this.playerAssists = playerAssists;
			}

			public int getPlayerPlayTime() {
				return playerPlayTime;
			}

			public void setPlayerPlayTime(int playerPlayTime) {
				this.playerPlayTime = playerPlayTime;
			}

			public int getPlayerFG() {
				return playerFG;
			}

			public void setPlayerFG(int playerFG) {
				this.playerFG = playerFG;
			}

			public int getPlayerFGTry() {
				return playerFGTry;
			}

			public void setPlayerFGTry(int playerFGTry) {
				this.playerFGTry = playerFGTry;
			}

			public int getPlayer3FG() {
				return player3FG;
			}

			public void setPlayer3FG(int player3fg) {
				player3FG = player3fg;
			}

			public int getPlayer3FGTry() {
				return player3FGTry;
			}

			public void setPlayer3FGTry(int player3fgTry) {
				player3FGTry = player3fgTry;
			}

			public int getPlayerFTG() {
				return playerFTG;
			}

			public void setPlayerFTG(int playerFTG) {
				this.playerFTG = playerFTG;
			}

			public int getPlayerFTGTry() {
				return playerFTGTry;
			}

			public void setPlayerFTGTry(int playerFTGTry) {
				this.playerFTGTry = playerFTGTry;
			}

			public int getPlayerOffenceRebounds() {
				return playerOffenceRebounds;
			}

			public void setPlayerOffenceRebounds(int playerOffenceRebounds) {
				this.playerOffenceRebounds = playerOffenceRebounds;
			}

			public int getPlayerDeffenceRebounds() {
				return playerDeffenceRebounds;
			}

			public void setPlayerDeffenceRebounds(int playerDeffenceRebounds) {
				this.playerDeffenceRebounds = playerDeffenceRebounds;
			}

			public int getPlayerTotalRebounds() {
				return playerTotalRebounds;
			}

			public void setPlayerTotalRebounds(int playerTotalRebounds) {
				this.playerTotalRebounds = playerTotalRebounds;
			}

			public int getPlayerSteals() {
				return playerSteals;
			}

			public void setPlayerSteals(int playerSteals) {
				this.playerSteals = playerSteals;
			}

			public int getPlayerBlocks() {
				return playerBlocks;
			}

			public void setPlayerBlocks(int playerBlocks) {
				this.playerBlocks = playerBlocks;
			}

			public int getPlayerTurnovers() {
				return playerTurnovers;
			}

			public void setPlayerTurnovers(int playerTurnovers) {
				this.playerTurnovers = playerTurnovers;
			}

			public int getPlayerFouls() {
				return playerFouls;
			}

			public void setPlayerFouls(int playerFouls) {
				this.playerFouls = playerFouls;
			}

			public int getPlayerScores() {
				return playerScores;
			}

			public void setPlayerScores(int playerScores) {
				this.playerScores = playerScores;
			}

			public int getTeammatePlayTime() {
				return teammatePlayTime;
			}

			public void setTeammatePlayTime(int teammatePlayTime) {
				this.teammatePlayTime = teammatePlayTime;
			}

			public int getAllTeamRebounds() {
				return allTeamRebounds;
			}

			public void setAllTeamRebounds(int allTeamRebounds) {
				this.allTeamRebounds = allTeamRebounds;
			}

			public int getAllEnemyRebounds() {
				return allEnemyRebounds;
			}

			public void setAllEnemyRebounds(int allEnemyRebounds) {
				this.allEnemyRebounds = allEnemyRebounds;
			}

			public int getO_allTeamRebounds() {
				return o_allTeamRebounds;
			}

			public void setO_allTeamRebounds(int o_allTeamRebounds) {
				this.o_allTeamRebounds = o_allTeamRebounds;
			}

			public int getO_allEnemyRebounds() {
				return o_allEnemyRebounds;
			}

			public void setO_allEnemyRebounds(int o_allEnemyRebounds) {
				this.o_allEnemyRebounds = o_allEnemyRebounds;
			}

			public int getD_allTeamRebounds() {
				return d_allTeamRebounds;
			}

			public void setD_allTeamRebounds(int d_allTeamRebounds) {
				this.d_allTeamRebounds = d_allTeamRebounds;
			}

			public int getD_allEnemyRebounds() {
				return d_allEnemyRebounds;
			}

			public void setD_allEnemyRebounds(int d_allEnemyRebounds) {
				this.d_allEnemyRebounds = d_allEnemyRebounds;
			}

			public int getAllTeamFT() {
				return allTeamFT;
			}

			public void setAllTeamFT(int allTeamFT) {
				this.allTeamFT = allTeamFT;
			}

			public int getAllTeamShoots() {
				return allTeamShoots;
			}

			public void setAllTeamShoots(int allTeamShoots) {
				this.allTeamShoots = allTeamShoots;
			}

			public int getAllEnemy2Shoots() {
				return allEnemy2Shoots;
			}

			public void setAllEnemy2Shoots(int allEnemy2Shoots) {
				this.allEnemy2Shoots = allEnemy2Shoots;
			}

			public int getAllTeamFTShoots() {
				return allTeamFTShoots;
			}

			public void setAllTeamFTShoots(int allTeamFTShoots) {
				this.allTeamFTShoots = allTeamFTShoots;
			}

			public int getAllTeamTurnover() {
				return allTeamTurnover;
			}

			public void setAllTeamTurnover(int allTeamTurnover) {
				this.allTeamTurnover = allTeamTurnover;
			}

			public double getAllEnemyOffenceTimes() {
				return allEnemyOffenceTimes;
			}

			public void setAllEnemyOffenceTimes(double allEnemyOffenceTimes) {
				this.allEnemyOffenceTimes = allEnemyOffenceTimes;
			}
			
			//根据Player对象new完善PlayerVO对象;
			//VO只是用来传达信息，用来展示;本软件中数据流是单项的;所以VO就特别容易写;
			public void creatplayervo(Player player){
				//球员基本信息;
				this.playerName=player.getPlayerName();
				this.playerNumber=player.getPlayerNumber();
				this.position=player.getPosition();
				this.height=player.getHeight();
				this.weight=player.getWeight();
				this.playerBirth=player.getPlayerBirth();
				this.playerAge=player.getPlayerAge();
				this.exp=player.getExp();
				this.school=player.getSchool();
				playerPlayTime=player.getPlayerPlayTime();
				
				//球员单项总数据;
				this.playerAttends=player.getPlayerAttends();
				this.playerScores=player.getPlayerScores();
				this.playerAssists=player.getPlayerAssists();
				//this.playerPlayTime=player.getPlayerPlayTime();
				this.playerFG=player.getPlayerFG();
				this.playerFGTry=player.getPlayerFGTry();
				this.player3FG=player.getPlayer3FG();
				this.player3FGTry=player.getPlayer3FGTry();
				this.playerFTG=player.getPlayerFTG();
				this.playerFTGTry=player.getPlayerFTGTry();
				this.playerOffenceRebounds=player.getPlayerOffenceRebounds();
				this.playerDeffenceRebounds=player.getPlayerDeffenceRebounds();
				this.playerTotalRebounds=player.getPlayerTotalRebounds();
				this.playerSteals=player.getPlayerSteals();
				this.playerBlocks=player.getPlayerBlocks();
				this.playerTurnovers=player.getPlayerTurnovers();
				this.playerFouls=player.getPlayerFouls();
				this.teamShortName=player.getTeamShortName();
				this.attendedMatches=player.getAttendedMatches();
			
				//球员场均数据;
				this.aver_playerScores=this.getAver_playerScores();
				this.aver_playerAssists=this.getAver_playerAssists();
				this.aver_playerPlayTime=player.getAver_playerPlayTime();
				this.aver_playerFG=player.getAver_playerFG();
				this.aver_playerFGTry=player.getAver_playerFGTry();
				this.aver_player3FG=player.getAver_player3FG();
				this.aver_player3FGTry=player.getAver_player3FGTry();
				this.aver_playerFTG=player.getAver_playerFTG();
				this.aver_playerFTGTry=player.getAver_playerFTGTry();
				this.aver_playerOffenceRebounds=player.getAver_playerOffenceRebounds();
				this.aver_playerDeffenceRebounds=player.getAver_playerDeffenceRebounds();
				this.aver_playerTotalRebounds=player.getAver_playerTotalRebounds();
				this.aver_playerSteals=player.getAver_playerSteals();
				this.aver_playerBlocks=player.getAver_playerBlocks();
				this.aver_playerTurnovers=player.getAver_playerTurnovers();
				this.aver_playerFouls=player.getAver_playerFouls();
				
				//球员各种统计数据,某某率;
				this.playerFGP = player.getPlayerFGP();
				this.player3FGP = player.getPlayer3FGP();
				this.playerFTGP = player.getPlayerFTGP();
				this.playerPER = player.getPlayerPER();
				this.playerGmScER =player.getPlayerPER();
				this.playerTSP = player.getPlayerTSP();
				this.playerSER = player.getPlayerSER();
				this.RR = player.getRR();
				this.o_RR = player.getO_RR();
				this.d_RR = player.getD_RR();
				this.AR = player.getAR();
				this.SR = player.getSR();
				this.BR = player.getBR();
				this.TR = player.getTR();
				this.UR = player.getUR();
			    this.advancedP=player.getAdvancedP();
			}

			public double getAdvancedP() {
				return advancedP;
			}

			public void setAdvancedP(double advancedP) {
				this.advancedP = advancedP;
			}

			@Override
			public int compareTo(PlayerVO o) {
				// TODO Auto-generated method stub
				if(comparetype.equals("两双")){
					   if(double_double-o.getdouble_double()<0)
		     		       return 1;
					   if(double_double-o.getdouble_double()==0)
						   return 0;
					   return -1;
		     	   }
		     	
		     	   if(comparetype.equals("得分/篮板/助攻")){
		     		   if( (this.getPlayerScores()+this.getPlayerTotalRebounds()+this.getPlayerAssists() )-( o.getPlayerScores()+o.getPlayerTotalRebounds()+o.getPlayerAssists())<0)
		     		       return 1;
		     		  if( (this.getPlayerScores()+this.getPlayerTotalRebounds()+this.getPlayerAssists() )-( o.getPlayerScores()+o.getPlayerTotalRebounds()+o.getPlayerAssists())==0)
		     		   return 0;
		     	   }
		     	  
		     	   if(comparetype.equals("助攻")){
		     		   if( (this.getPlayerAssists()-o.getPlayerAssists() )<0)
		     		       return 1;
		     		  if( (this.getPlayerAssists()-o.getPlayerAssists() )==0)
		     			  return 0;
		     		   return -1;
		     	   }
		     	   if(comparetype.equals("分钟")){
		     		   if((this.getPlayerPlayTime()-o.getPlayerPlayTime())<0)
		     		       return 1;
		     		  if((this.getPlayerPlayTime()-o.getPlayerPlayTime())==0)
		     			  return 0;
		               return -1;
		     	   }
		     	  
		     	   if(comparetype.equals("篮板")){
		     		  if((this.getPlayerTotalRebounds()-o.getPlayerTotalRebounds())<0)
		    		       return 1;
		     		 if((this.getPlayerTotalRebounds()-o.getPlayerTotalRebounds())==0)
		     			 return 0;
		              return -1;
		     	   }
		     	   if(comparetype.equals("抢断")){
		     		  // System.out.println("ppp");
		     		  if((this.getPlayerSteals()-o.getPlayerSteals())<0)
		   		           return 1;
		     		  if((this.getPlayerSteals()-o.getPlayerSteals())==0)
		     			  return 0;
		    		  return -1;
		     	   }
		     	   if(comparetype.equals("盖帽")){
		     		  if((this.getPlayerBlocks()-o.getPlayerBlocks())<0)
		  		           return 1;
		     		 if((this.getPlayerBlocks()-o.getPlayerBlocks())==0)
		     			 return 0;
		   		      return -1;
		     	   }
		     	   if(comparetype.equals("失误")){
		     		  if((this.getPlayerTurnovers()-o.getPlayerTurnovers()<0))
		 		           return 1;
		     		 if((this.getPlayerTurnovers()-o.getPlayerTurnovers()==0))
		     			 return 0;
		  		      return -1;
		     	   }
		     	   if(comparetype.equals("犯规")){
		     		  if((this.getPlayerFouls()-o.getPlayerFouls()<0))
		    		           return 1;
		     		 if((this.getPlayerFouls()-o.getPlayerFouls()==0))
		     			 return 0;
		     		      return -1;
		     	   }
		     	   if(comparetype.equals("得分")){
		     		  if((this.getPlayerScores()-o.getPlayerScores()<0))
		   		           return 1;
		     		 if((this.getPlayerScores()-o.getPlayerScores()==0))
		     			 return 0;
		    		      return -1;
		     	   }
		     	   if(comparetype.equals("投篮")){
		     		  if((this.getPlayerFGP()-o.getPlayerFGP()<0))
		  		           return 1;
		     		 if((this.getPlayerFGP()-o.getPlayerFGP()==0))
		     			 return 0;
		   		      return -1;
		     	   }
		     	   if(comparetype.equals("三分")){
		     		  if((this.getPlayer3FGP()-o.getPlayer3FGP()<0))
		 		           return 1;
		     		 if((this.getPlayer3FGP()-o.getPlayer3FGP()==0))
		     			 return 0;
		  		      return -1;
		     	   }


		     	   if(comparetype.equals("罚球")){
		     		  if((this.getPlayerFTGP()-o.getPlayerFTGP()<0))
				           return 1;
		     		  if((this.getPlayerFTGP()-o.getPlayerFTGP()==0))
		     			  return 0;
		 		      return -1;
		     	   }
		     	   if(comparetype.equals("效率")){
		     		  if((this.getPlayerPER()-o.getPlayerPER()<0))
				           return 1;
		     		 if((this.getPlayerPER()-o.getPlayerPER()==0))
		     			 return 0;
		 		      return -1;
		     	   }
		     	  if(comparetype.equals("进步率")){
		     		   if(this.getAdvancedP()-o.getAdvancedP()<0){
		     			   return 1;
		     		   }
		     		  if(this.getAdvancedP()-o.getAdvancedP()==0)
		     			  return 0;
		     		   return -1;	   
		     	   }
		     	 if(comparetype.equals("效率")){
		     		   if(this.getPlayerGmScER()-o.getPlayerGmScER()<0){
		     			   return 1;
		     		   }
		     		  if(this.getPlayerGmScER()-o.getPlayerGmScER()==0)
		     			  return 0;
		     		   return -1;	   
		     	   }
		     	if(comparetype.equals("平均篮板")){
		     		   if(this.getAver_playerTotalRebounds()-o.getAver_playerTotalRebounds()<0){
		     			   return 1;
		     		   }
		     		  if(this.getAver_playerTotalRebounds()-o.getAver_playerTotalRebounds()==0)
		     			  return 0;
		     		   return -1;	   
		     	   }
		     	if(comparetype.equals("平均助攻")){
		     		   if(this.getAver_playerAssists()-o.getAver_playerAssists()<0){
		     			   return 1;
		     		   }
		     		  if(this.getAver_playerAssists()-o.getAver_playerAssists()==0)
		     			  return 0;
		     		   return -1;	   
		     	   }
		     	if(comparetype.equals("平均抢断")){
		     		   if(this.getAver_playerSteals()-o.getAver_playerSteals()<0){
		     			   return 1;
		     		   }
		     		  if(this.getAver_playerSteals()-o.getAver_playerSteals()==0)
		     			  return 0;
		     		   return -1;	   
		     	   }
		     	if(comparetype.equals("平均得分")){
		     		   if(this.getAver_playerScores()-o.getAver_playerScores()<0){
		     			   return 1;
		     		   }
		     		  if(this.getAver_playerScores()-o.getAver_playerScores()==0)
		     			  return 0;
		     		   return -1;	   
		     	   }
		     	if(comparetype.equals("平均盖帽")){
		     		   if(this.getAver_playerBlocks()-o.getAver_playerBlocks()<0){
		     			   return 1;
		     		   }
		     		  if(this.getAver_playerBlocks()-o.getAver_playerBlocks()==0)
		     			  return 0;
		     		   return -1;	   
		     	   }
		     	if(comparetype.equals("FGP")){
		     		if(this.getPlayerFGP()-o.getPlayerFGP()<0){
		     			return 1;
		     		}
		     		if(this.getPlayerFGP()-o.getPlayerFGP()==0)
		     			return 0;
		     		return -1;
		     		
		     	}
		     	if(comparetype.equals("3FGP")){
		     		if(this.getPlayer3FGP()-o.getPlayer3FGP()<0){
		     			return 1;
		     		}
		     		if(this.getPlayer3FGP()-o.getPlayer3FGP()==0)
		     			return 0;
		     		return -1;
		     	}
		     	if(comparetype.equals("FTGP")){
		     		if(this.getPlayerFTGP()-o.getPlayerFTGP()<0){
		     			return 1;
		     		}
		     		if(this.getPlayerFTGP()-o.getPlayerFTGP()==0)
		     			return 0;
		     		return -1;
		     	}
					return 0;

					
			}

			public String getComparetype() {
				return comparetype;
			}

			public void setComparetype(String comparetype) {
				this.comparetype = comparetype;
			}

			public int getdouble_double() {
				return double_double;
			}

			public void setdouble_double(int double_double) {
				this.double_double = double_double;
			}

			public String getPlayerPosition(){
				String result = null;
				if(this.getPosition().equals("F")
						||(this.getPosition().equals("F-C"))
						||(this.getPosition().equals("C-F"))
						||(this.getPosition().equals("F-G"))
						||(this.getPosition().equals("G-F"))){
					result = "前锋";
				}
				if(this.getPosition().equals("C")
						||this.getPosition().equals("C-F")
						||this.getPosition().equals("F-C")){
					result = "中锋";
				}
				if(this.getPosition().equals("G")
						||(this.getPosition().equals("F-G"))
						||(this.getPosition().equals("G-F"))){
					result = "后卫";
				}
				return result;
			}

			public String getPlayerDistribution() {
				String result = null;
				String teamName = this.getTeamShortName();
				result = TeamController.getTeamDistribution(teamName);
				System.out.println(this.getPlayerName()+"distribution"+" "+result+" "+teamName);
				return result;
			}
			
	
			

	}

