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
		int compGames;//总场
		int winGames;//胜场
		int losGames;//败场
		private double winRate;//胜率
		
//接下来是球队赛季总数据；	
	//总进攻回合数（*****需要更新*****）
		private double attackRounds;
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
	//对手进攻篮板数（*****需要更新*****）
		int oppoOffenceRebounds;
	//球队防守篮板数（*****需要更新*****）
		int teamDeffenceRebounds;
	//对手防守篮板（*****需要更新*****）
		int oppoDeffenceRebounds;
	//球队总篮板数（*****需要更新*****）
		int teamTotalRebounds;
	//对手总篮板数（*****需要更新*****）
		int oppoTotalRebounds;
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
	//对手得分（*****需要更新*****）
		int oppoScores;
		
//这是球队的平均信息；
	//球队场均助攻数
		double aver_teamAssists ;
	//球队场均投篮命中数
		double aver_teamFG ;
	//球队场均投篮出手次数
		double aver_teamFGTry ;
	//球队投篮命中率
		double teamFGP;
	//球队场均三分命中数
		double aver_team3FG;
	//球队场均三分出手次数
		double aver_team3FGTry;
	//球队三分命中率
		double team3FGP; 
	//球队场均罚球命中数
		double aver_teamFTG;
	//球队场均罚球出手数
		double aver_teamFTGTry;
	//罚球命中率	
		double teamFTP; 
	//球队场均进攻篮板数
		double aver_teamOffenceRebounds;
	//球队场均防守篮板数
		double aver_teamDeffenceRebounds;
	//球队场均总篮板数
		double aver_teamTotalRebounds;
	//球队场均抢断数
		double aver_teamSteals;
	//球队场均盖帽数
		double aver_teamBlocks;
	//球队场均失误数
		double aver_teamTurnovers;
	//球队场均犯规数
		double aver_teamFouls;
	//球队场均总得分数
		double aver_teamScores;
	//球队对手场均得分数
		double aver_oppoScores;
	//球队进攻效率：
		private double teamOffE;
	//球队防守效率
		private double teamDefE;
	//球队进攻篮板效率
		private double teamOffERebE;
	//球队防守篮板效率
		private double teamDefERebE;
	//球队抢断效率
		private double teamSteE;
	//球队助攻效率
		private double teamAssE;

		/*计算需要的对手数据*/
		//对手防守篮板数
		int enemyDeffenceRebounds;
		//对手前场篮板数
		int enemyOffenceRebounds;
	
		
		public double getWinRate() {
			return winGames/(winGames+losGames);
		}
		public double getAttackRounds() {
			return teamFGTry+0.4*teamFTGTry-1.07*(teamOffenceRebounds/(teamOffenceRebounds+enemyDeffenceRebounds)*(teamFGTry-teamFG))+1.07*teamTurnovers;
		}
		public double getTeamOffE() {
			return teamOffE;
		}
		public double getTeamDefE() {
			return teamDefE;
		}
		public double getTeamOffERebE() {
			return teamOffenceRebounds/(teamOffenceRebounds+enemyDeffenceRebounds);
		}
		public double getTeamDefERebE() {
			return teamDeffenceRebounds/(teamDeffenceRebounds+enemyOffenceRebounds);
		}
		public double getTeamSteE() {
			return teamSteE;
		}
		public double getTeamAssE() {
			return teamAssE;
		}
	
		//
		public void updateTeam(double tempattackRounds,int tempteamAssists,int tempteamFG,int tempteamFGTry,
				int tempteam3FG,int tempteam3FGTry,int tempteamFTG,int tempteamFTGTry,int tempteamOffenceRebounds,
				double tempteamDeffenceRebounds,int tempteamTotalRebounds,int tempteamSteals,int tempteamBlocks,
				int tempteamTurnovers,int tempteamFouls,int tempteamScores,int tempoppoScores,int tempoppoOffenceRebounds,
				int tempoppoDeffenceRebounds,int tempoppoTotalRebounds){
			this.compGames++;
			if(tempteamScores>tempoppoScores){
				this.winGames++;
			}else{
				this.losGames++;
			}
			this.attackRounds+=tempattackRounds;
			this.teamAssists+=tempteamAssists;
			this.teamFG+=tempteamFG;
			this.teamFGTry+=tempteamFGTry;
			this.team3FG+=tempteam3FG;
			this.team3FGTry+=tempteam3FGTry;
			this.teamFTG+=tempteamFTG;
			this.teamFTGTry+=tempteamFTGTry;
			this.teamOffenceRebounds+=tempteamOffenceRebounds;
			this.teamDeffenceRebounds+=tempteamDeffenceRebounds;
			this.teamTotalRebounds+=tempteamTotalRebounds;
			this.teamSteals+=tempteamSteals;
			this.teamBlocks+=tempteamBlocks;
			this.teamTurnovers+=tempteamTurnovers;
			this.teamFouls+=tempteamFouls;
			this.teamScores+=tempteamScores;
			this.oppoScores+=tempoppoScores;
			this.oppoOffenceRebounds+=tempoppoOffenceRebounds;
			this.oppoDeffenceRebounds+=tempoppoDeffenceRebounds;
			this.oppoTotalRebounds+=tempoppoTotalRebounds;
		}
}
