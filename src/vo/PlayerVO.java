package vo;

import java.util.ArrayList;

import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;
import logic.Player;
import logic.PlayerController;
import logic.TeamController;

public class PlayerVO implements Comparable<PlayerVO>{
		private boolean isfirst=false;
		private double advancedP=0;
		public String comparetype="";
		private int double_double=0;
		private double aveg_double=0;
		private int matchnumbers=0;
		private String teamname=" ";
		public PlayerVO(){
		
		}
		public double getaveg_double(){
			return aveg_double;
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
			private String weight;
		
		//6.球员生日
			//格式类似： JAN 14， 1985
			private String playerBirth;
		
		//7.球员年龄
			private int playerAge;//没有
		
		//8.球员进入联盟时间
			private int exp;//没有
			
		//9.球员学校或国家
			private String school;
		
        //10.球员ID (*****要传*****) //没用的
			String playerID;
			
		    String HighSchool;
		    
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
			@SuppressWarnings("unused")
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
			
			private String season;
			
			private String salary;
		
            private double wingames=0;
            private double losegames=0;
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
				return aver_playerAssists;
			}

			public double getAver_playerPlayTime() {
				return aver_playerPlayTime;
			}

			public double getAver_playerFG() {
				return aver_playerFG;
			}

			public double getAver_playerFGTry() {
				return aver_playerFGTry;
			}

			public double getAver_player3FG() {
				return aver_player3FG;
			}

			public double getAver_player3FGTry() {
				return aver_player3FGTry;
			}

			public double getAver_playerFTG() {
				return aver_playerFTG;
			}

			public double getAver_playerFTGTry() {
				return aver_playerFTGTry;
			}

			public double getAver_playerOffenceRebounds() {
				return aver_playerOffenceRebounds;
			}

			public double getAver_playerDeffenceRebounds() {
				return aver_playerDeffenceRebounds;
			}

			public double getAver_playerTotalRebounds() {
				return aver_playerTotalRebounds;
			}

			public double getAver_playerSteals() {
				return aver_playerSteals;
			}

			public double getAver_playerBlocks() {
				return aver_playerBlocks;
			}

			public double getAver_playerTurnovers() {
				return aver_playerTurnovers;
			}

			public double getAver_playerFouls() {
				return aver_playerFouls;
			}

			public double getAver_playerScores() {
				return aver_playerScores;
			}

			public double getPlayerFGP() {
				return playerFGP;
			}

			public double getPlayer3FGP() {
				return player3FGP;
			}

			public double getPlayerFTGP() {
				return playerFTGP;
			}

			public double getPlayerPER() {
			       return playerPER;
			}

			public double getPlayerGmScER() {
				return  (playerAttends==0)?0:
					Double.parseDouble(String.format("%.8f",(playerScores + 0.4 * playerFG - 0.7 * playerFGTry - 0.4 * (playerFTGTry - playerFTG)
						+ 0.7 * playerOffenceRebounds + 0.3 * playerDeffenceRebounds + playerSteals + 0.7 * playerAssists 
						+ 0.7 * playerBlocks - 0.4 * playerFouls - playerTurnovers) / playerAttends));
			}

			public double getPlayerTSP() {
				return playerTSP;
			}

			public double getPlayerSER() {
				return playerSER;
			}

			public double getRR() {
				return RR;
			}

			public double getO_RR() {
				return o_RR;
			}

			public double getD_RR() {
				return d_RR;
			}

			public double getAR() {
				return AR;		
			}

			public double getSR() {
				return SR;
			}

			public double getBR() {
				return BR;
			}

			public double getTR() {
				return TR;
			}

			public double getUR() {
				return UR;
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

			public String getWeight() {
				return weight;
			}

			public void setWeight(String weight) {
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
				//this.weight=player.getWeight();
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
				this.allTeamRebounds = player.getAllTeamRebounds();
				this.allEnemyRebounds = player.getAllEnemyRebounds();
				this.o_allTeamRebounds =player.getO_allTeamRebounds();
				this.o_allEnemyRebounds = player.getO_allEnemyRebounds();
				this.d_allTeamRebounds = player.getD_allTeamRebounds();
				this.d_allEnemyRebounds = player.getD_allEnemyRebounds();
				this.allTeamFT = player.getAllTeamFT();
				this.allTeamShoots = player.getAllTeamShoots();
				this.allEnemy2Shoots = player.getAllEnemy2Shoots();
				this.allTeamFTShoots = player.getAllTeamFTShoots();
				this.allTeamTurnover =player.getAllTeamTurnover();
				this.allEnemyOffenceTimes = player.getAllEnemyOffenceTimes();
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
			    this.double_double=player.getDouble_double();
			    //System.out.println(player.getDouble_double());
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
			public String getPlayerPositionEnglish(){
				String result = null;
				//System.out.println(this.getPosition());
				if(this.getPosition()==null){
					PlayerController p=PlayerController.getInstance();
					ArrayList<PlayerVO> pp=p.getAllPlayerVO();
					for(PlayerVO l:pp){
						if(l.getPlayerName().equals(this.getPlayerName())){
						    this.setPosition(l.getPosition());
						    break;
						}
					}
				}
				if(this.getPosition().equals("F")
						||(this.getPosition().equals("F-C"))
						||(this.getPosition().equals("C-F"))
						||(this.getPosition().equals("F-G"))
						||(this.getPosition().equals("G-F"))){
					result = "F";
				}
				if(this.getPosition().equals("C")
						||this.getPosition().equals("C-F")
						||this.getPosition().equals("F-C")){
					result = "C";
				}
				if(this.getPosition().equals("G")
						||(this.getPosition().equals("F-G"))
						||(this.getPosition().equals("G-F"))){
					result = "G";
				}
				return result;
			}
			public String getPlayerDistribution() {
				String result = null;
				String teamName = this.getTeamShortName();
				result = TeamController.getTeamDistribution(teamName);
				return result;
			}
		   
	       public PlayerHighInfo getPlayerHighInfo(String option){
	    	   PlayerHighInfo playerhighInfo =new PlayerHighInfo();
	    	   if(option.equals("aveg")){
	    	   playerhighInfo.setAssistEfficient(getAR());
	    	   playerhighInfo.setBlockShotEfficient(getBR());
	    	   playerhighInfo.setDefendReboundEfficient(getD_RR());
	    	   playerhighInfo.setFaultEfficient(getTR());
	    	   playerhighInfo.setGmSc(getPlayerGmScER());
	    	   playerhighInfo.setLeague("east");
	    	   playerhighInfo.setName(getPlayerName());
	    	   playerhighInfo.setOffendReboundEfficient(getO_RR());
	    	   playerhighInfo.setPosition(getPlayerPositionEnglish());
	    	   playerhighInfo.setRealShot(getPlayerTSP());
	    	   playerhighInfo.setReboundEfficient(getRR());
	    	   playerhighInfo.setShotEfficient(getPlayerSER());
	    	   playerhighInfo.setStealEfficient(getSR());
	    	   playerhighInfo.setTeamName(teamShortName);
	    	   }
	    	   else{
	    		   playerhighInfo.setAssistEfficient(getAR());
		    	   playerhighInfo.setBlockShotEfficient(getBR());
		    	   playerhighInfo.setDefendReboundEfficient(getD_RR());
		    	   playerhighInfo.setFaultEfficient(getTR());
		    	   playerhighInfo.setGmSc(getPlayerGmScER());
		    	   playerhighInfo.setLeague("east");
		    	   playerhighInfo.setName(getPlayerName());
		    	   playerhighInfo.setOffendReboundEfficient(getO_RR());
		    	   playerhighInfo.setPosition(getPlayerPositionEnglish());
		    	   playerhighInfo.setRealShot(getPlayerTSP());
		    	   playerhighInfo.setReboundEfficient(getRR());
		    	   playerhighInfo.setShotEfficient(getPlayerSER());
		    	   playerhighInfo.setStealEfficient(getSR());
		    	   playerhighInfo.setTeamName(teamShortName);
	    	   }
	    	   return playerhighInfo;
	       }
		  public PlayerNormalInfo getPlayerNormalInfo(String option){
			  PlayerNormalInfo pl=new PlayerNormalInfo();
			  if(option.equals("aveg")){
			  pl.setAge(playerAge);
			  pl.setAssist(getAver_playerAssists());
			  pl.setBlockShot(getAver_playerBlocks());
			  pl.setDefend(getAver_playerDeffenceRebounds());
			  pl.setEfficiency(getPlayerPER());
			  pl.setFault(getAver_playerTurnovers());
			  pl.setFoul(getAver_playerFouls());
			  pl.setMinute(getAver_playerPlayTime());
			  pl.setName(playerName);
			  pl.setNumOfGame(Integer.parseInt(playerNumber));
			  pl.setOffend(getAver_playerOffenceRebounds());
			  pl.setPenalty(getPlayerFTGP());
			  pl.setPoint(getAver_playerScores());
			  pl.setRebound(getAver_playerTotalRebounds());
			  pl.setShot(getPlayerFGP());
			  pl.setStart(getStartTimes());
			  pl.setSteal(getAver_playerSteals());
			  pl.setTeamName(teamShortName);
			  pl.setThree(getPlayer3FGP());
			  }
			  else{
				  pl.setAge(playerAge);
				  pl.setAssist(getPlayerAssists());
				  pl.setBlockShot(getPlayerBlocks());
				  pl.setDefend(getPlayerDeffenceRebounds());
				  pl.setEfficiency(getPlayerPER());
				  pl.setFault(getPlayerTurnovers());
				  pl.setFoul(getPlayerFouls());
				  pl.setMinute(getPlayerPlayTime());
				  pl.setName(playerName);
				  pl.setNumOfGame(Integer.parseInt(playerNumber));
				  pl.setOffend(getPlayerOffenceRebounds());
				  pl.setPenalty(getPlayerFTGP());
				  pl.setPoint(getPlayerScores());
				  pl.setRebound(getPlayerTotalRebounds());
				  pl.setShot(getPlayerFGP());
				  pl.setStart(getStartTimes());
				  pl.setSteal(getPlayerSteals());
				  pl.setTeamName(teamShortName);
				  pl.setThree(getPlayer3FGP());
			  }
			  return pl;
		  }
		  public PlayerHotInfo getPLayerHOTInfo(String f){
			  PlayerHotInfo pl=new PlayerHotInfo();
			  pl.setField(f);
			  pl.setName(playerName);
			  pl.setPosition(getPlayerPositionEnglish());
			  pl.setTeamName(teamShortName);
			  PlayerController p=PlayerController.getInstance();
			  p.getAdvancedPlayers("f");
			  pl.setUpgradeRate(advancedP);
			  pl.setValue(this.getdatebystring(f, "aveg"));
			  return pl;
		  }
          public PlayerKingInfo getPlayerKingInfo(String f){
        	  PlayerKingInfo pl=new PlayerKingInfo();
        	  pl.setField(f);
        	  pl.setName(playerName);
        	  pl.setPosition(getPlayerPositionEnglish());
        	  pl.setTeamName(teamShortName);
        	  pl.setValue(this.getdatebystring(f,"aveg"));
        	  return pl;

          }
          
          public double getdatebystring(String f,String option){
        	  if(option.equals("aveg")){
        		  if(f.equals("score")||f.equals("point")){
        			  return this.getAver_playerScores();
        		  }
        		  if(f.equals("rebound")){
        			  return this.getAver_playerTotalRebounds();
        		  }
        		  if(f.equals("assit")){
        			  return this.getAver_playerAssists();
        		  }
        		  if(f.equals("3FGP")){
        			  return this.getPlayer3FGP();
        		  }
        		  if(f.equals("FGP")){
        			  return this.getPlayerFGP();
        		  }
        		  if(f.equals("FTGP")){
        			  return this.getPlayerFTGP();
        		  }
        		  if(f.equals("blockShot")){
        			  return this.getAver_playerBlocks();
        		  }
        		  if(f.equals("steal")){
        			  return this.getAver_playerSteals();
        		  }
        	  }
        	  else{
        		  if(f.equals("score")||f.equals("point")){
        			  return this.getPlayerScores();
        		  }
        		  if(f.equals("rebound")){
        			  return this.getPlayerTotalRebounds();
        		  }
        		  if(f.equals("assit")){
        			  return this.getPlayerAssists();
        		  }
        		  if(f.equals("3FGP")){
        			  return this.getPlayer3FGP();
        		  }
        		  if(f.equals("FGP")){
        			  return this.getPlayerFGP();
        		  }
        		  if(f.equals("FTGP")){
        			  return this.getPlayerFTGP();
        		  }
        		  if(f.equals("blockShot")){
        			  return this.getPlayerBlocks();
        		  }
        		  if(f.equals("steal")){
        			  return this.getPlayerSteals();
        		  }
        	  }
        	  return 0;
          }
          public Double getplayerdata(String field,String option){
        	 if(option.equals("aveg")){
        		 if(field.equals("score")||field.equals("point")){
        			 return this.getAver_playerScores();
        		 }
        	 
        	 if(field.equals("rebound")){
        		 return this.getAver_playerTotalRebounds();
        	 }
        	 if(field.equals("assit")){
        		 return this.getAver_playerAssists();
        	 }
        	 if(field.equals("blockShot")){
        		 return this.getAver_playerBlocks();
        	 }
        	 if(field.equals("steal")){
        		 return this.getAver_playerSteals();
        	 }
        	 if(field.equals("foul")){
        		 return this.getAver_playerFouls();
        	 }
        	 if(field.equals("fault")){
        		 return this.getAver_playerTurnovers();
        	 }
        	 if(field.equals("minute")){
        		 return this.getAver_playerPlayTime();
        	 }
        	 if(field.equals("efficient")){
        		 return this.getPlayerPER();
        	 }
        	 if(field.equals("shot")){
        		 return this.getPlayerFGP();
        	 }
        	 if(field.equals("three")){
        		 return this.getPlayer3FGP();
        	 }
        	 if(field.equals("penalty")){
        		 return this.getPlayerFTGP();
        	 }
        	 if(field.equals("doubleTwo")){
        		 return this.getaveg_double();
        	 }
        	 if(field.equals("realShot")){
        		return this.getPlayerTSP();
        	 }
        	 if(field.equals("GmSc")){
        		 return this.getPlayerGmScER();
        	 }
        	 if(field.equals("shotEfficient")){
        		 return this.getPlayerSER();
        	 }
        	 if(field.equals("reboundEfficient")){
        		 return this.getRR();
        	 }
        	 if(field.equals("offendReboundEfficient")){
        		 return getO_RR();
        	 }
        	 if(field.equals("defendReboundEfficient")){
        		 return getD_RR();
        	 }
        	 if(field.equals("assistEfficient")){
        		 return getAR();
        	 }
        	 if(field.equals("blockShotEfficient")){
        		 return getBR();
        	 }
        	 if(field.equals("faultEfficient")){
        		 return getTR();
        	 }
        	 if(field.equals("frequency")){
        		 return getUR();
        	 }
          }
        	 else{
        		 if(field.equals("score")||field.equals("point")){
        			 return (double)this.getPlayerScores();
        		 }
        	 
        	 if(field.equals("rebound")){
        		 return (double)this.getPlayerTotalRebounds();
        	 }
        	 if(field.equals("assit")){
        		 return (double)this.getPlayerAssists();
        	 }
        	 if(field.equals("blockShot")){
        		 return (double)this.getPlayerBlocks();
        	 }
        	 if(field.equals("steal")){
        		 return (double)this.getPlayerSteals();
        	 }
        	 if(field.equals("foul")){
        		 return (double)this.getPlayerFouls();
        	 }
        	 if(field.equals("fault")){
        		 return (double)this.getPlayerTurnovers();
        	 }
        	 if(field.equals("minute")){
        		 return (double)this.getPlayerPlayTime();
        	 }
        	 if(field.equals("efficient")){
        		 return (double)this.getPlayerPER();
        	 }
        	 if(field.equals("shot")){
        		 return (double)this.getPlayerFGP();
        	 }
        	 if(field.equals("three")){
        		 return this.getPlayer3FGP();
        	 }
        	 if(field.equals("penalty")){
        		 return this.getPlayerFTGP();
        	 }
        	 if(field.equals("doubleTwo")){
        		 return (double)this.getdouble_double();
        	 }
        	 if(field.equals("realShot")){
        		return this.getPlayerTSP();
        	 }
        	 if(field.equals("GmSc")){
        		 return this.getPlayerGmScER();
        	 }
        	 if(field.equals("shotEfficient")){
        		 return this.getPlayerSER();
        	 }
        	 if(field.equals("reboundEfficient")){
        		 return this.getRR();
        	 }
        	 if(field.equals("offendReboundEfficient")){
        		 return getO_RR();
        	 }
        	 if(field.equals("defendReboundEfficient")){
        		 return getD_RR();
        	 }
        	 if(field.equals("assistEfficient")){
        		 return getAR();
        	 }
        	 if(field.equals("blockShotEfficient")){
        		 return getBR();
        	 }
        	 if(field.equals("faultEfficient")){
        		 return getTR();
        	 }
        	 if(field.equals("frequency")){
        		 return getUR();
        	 }
             }
          
          return 0.0;
	}
		public String getPlayerID() {
			return playerID;
		}
		public void setPlayerID(String playerID) {
			this.playerID = playerID;
		}
		public String getHighSchool() {
			return HighSchool;
		}
		public void setHighSchool(String highSchool) {
			HighSchool = highSchool;
		}
		public String getSeason() {
			return season;
		}
		public void setSeason(String season) {
			this.season = season;
		}
		public String getSalary() {
			return salary;
		}
		public void setSalary(String salary) {
			this.salary = salary;
		}
		public double getWingames() {
			return wingames;
		}
		public void setWingames(double wingames) {
			this.wingames = wingames;
		}
		public double getLosegames() {
			return losegames;
		}
		public void setLosegames(double losegames) {
			this.losegames = losegames;
		}
		public int getMatchnumbers() {
			return matchnumbers;
		}
		public void setMatchnumbers(int matchnumbers) {
			this.matchnumbers = matchnumbers;
		}
		public boolean isIsfirst() {
			return isfirst;
		}
		public void setIsfirst(boolean isfirst) {
			this.isfirst = isfirst;
		}
		public String getTeamname() {
			return teamname;
		}
		public void setTeamname(String teamname) {
			this.teamname = teamname;
		}
}

