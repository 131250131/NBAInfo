package com.nba.data;

public class Team implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public String getTeamShortName(){
		return shortName;
	}
	
	public Team(){}
	
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
//oppo都是对手的总数居；解释一下，对手的数据指的是，和我比赛的所有对手的数据；
	//总进攻回合数（*****需要更新*****）
		private double attackRounds;
	//对手进攻回合数（*****需要更新*****）
		private double oppoattackRounds;
	//球队助攻数（*****需要更新*****）
		int teamAssists;
	//对手助攻数（*****需要更新*****）
		int oppoAssists;
	//球队投篮命中数（*****需要更新*****）
		int teamFG ;
	//投篮命中数（*****需要更新*****）
		int oppoFG ;
	//球队投篮出手次数（*****需要更新*****）
		int teamFGTry ;
	//对手投篮出手次数（*****需要更新*****）
		int oppoFGTry ;	
	//球队三分命中数（*****需要更新*****）
		int team3FG ;
	//对手三分命中数（*****需要更新*****）
		int oppo3FG ;
	//球队三分出手次数（*****需要更新*****）
		int team3FGTry ;
	//对手三分出手次数（*****需要更新*****）
		int oppo3FGTry ;
	//球队球队罚球命中数（*****需要更新*****）
		int teamFTG;
	//对手球队罚球命中数（*****需要更新*****）
		int oppoFTG;
	//球队罚球出手数（*****需要更新*****）
		int teamFTGTry;
	//对手罚球出手数（*****需要更新*****）
		int oppoFTGTry;
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
	//对手抢断数（*****需要更新*****）
		int oppoSteals;	
	//球队盖帽数（*****需要更新*****）
		int teamBlocks;
	//对手盖帽数（*****需要更新*****）
		int oppoBlocks;
	//球队失误数（*****需要更新*****）
		int teamTurnovers;
	//对手失误数（*****需要更新*****）
		int oppoTurnovers;
	//球队犯规数（*****需要更新*****）
		int teamFouls;
	//球队犯规数（*****需要更新*****）
		int oppoFouls;	
	//球队总得分数（*****需要更新*****）
		int teamScores;
	//对手得分（*****需要更新*****）
		int oppoScores;
		
//这是球队的平均信息；
	//球队场均助攻数
		double aver_teamAssists;
	//对手场均助攻数
		double aver_oppoAssists;
	//球队场均投篮命中数
		double aver_teamFG ;
	//对手场均投篮命中数
		double aver_oppoFG ;
	//球队场均投篮出手次数
		double aver_teamFGTry ;
	//对手场均投篮出手次数
		double aver_oppoFGTry ;
	//球队投篮命中率
		double teamFGP;
	//对手投篮命中率
		double oppoFGP;
	//球队场均三分命中数
		double aver_team3FG;
	//对手场均三分命中数
		double aver_oppo3FG;
	//球队场均三分出手次数
		double aver_team3FGTry;
	//对手场均三分出手次数
		double aver_oppo3FGTry;
	//球队三分命中率
		double team3FGP; 
	//对手三分命中率
		double oppo3FGP; 
	//球队场均罚球命中数
		double aver_teamFTG;
	//对手场均罚球命中数
		double aver_oppoFTG;
	//球队场均罚球出手数
		double aver_teamFTGTry;
	//对手场均罚球出手数
		double aver_oppoFTGTry;
	//罚球命中率	
		double teamFTP; 
	//对手罚球命中率	
		double oppoFTP; 
	//球队场均进攻篮板数
		double aver_teamOffenceRebounds;
	//对手场均进攻篮板数
		double aver_oppoOffenceRebounds;
	//球队场均防守篮板数
		double aver_teamDeffenceRebounds;
	//对手场均防守篮板数
		double aver_oppoDeffenceRebounds;	
	//球队场均总篮板
		double aver_teamTotalRebounds;
	//对手场均总篮板
		double aver_oppoTotalRebounds;
	//球队场均抢断数
		double aver_teamSteals;
	//对手场均抢断数
		double aver_oppoSteals;
	//球队场均盖帽数
		double aver_teamBlocks;
	//对手场均盖帽数
		double aver_oppoBlocks;
	//球队场均失误数
		double aver_teamTurnovers;
	//对手场均失误数
		double aver_oppoTurnovers;
	//球队场均犯规数
		double aver_teamFouls;
	//对手场均犯规数
		double aver_oppoFouls;
	//球队场均总得分数
		double aver_teamScores;
	//对手对手场均得分数
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
	
		/*这个方法是来更新球队的总数据的，例如总助攻数，已经计算的常数，胜场数等等；
		 *参数列表里面，前半部分是本队的数据，后半部分是兑换艘的数据
		 *需要注意的是：那些需要计算的数据，例如 效率值什么都没写；
		 * */
		public void updateTeam(double tempattackRounds,int tempteamAssists,int tempteamFG,int tempteamFGTry,
				int tempteam3FG,int tempteam3FGTry,int tempteamFTG,int tempteamFTGTry,int tempteamOffenceRebounds,
				double tempteamDeffenceRebounds,int tempteamTotalRebounds,int tempteamSteals,int tempteamBlocks,
				int tempteamTurnovers,int tempteamFouls,int tempteamScores,int tempoppoScores,int tempoppoOffenceRebounds,
				int tempoppoDeffenceRebounds,int tempoppoTotalRebounds, double tempoppoattackRounds, int tempoppoAssists, int tempoppoFG, 
				int tempoppoFGTry, int tempoppo3FG, int tempoppo3FGTry, int tempoppoFTG, int tempoppoFTGTry, int tempoppoSteals,
				int tempoppoBlocks, int tempoppoTurnovers, int tempoppoFouls){
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

			
			this.oppoattackRounds+=tempoppoattackRounds;
			this.oppoAssists+=tempoppoAssists;
			this.oppoFG+=tempoppoFG;
			this.oppoFGTry+=tempoppoFGTry;
			this.oppo3FG+=tempoppo3FG;
			this.oppo3FGTry+=tempoppo3FGTry;
			this.oppoFTG+=tempoppoFTG;
			this.oppoFTGTry+=tempoppoFTGTry;
			this.oppoOffenceRebounds+=tempoppoOffenceRebounds;
			this.oppoDeffenceRebounds+=tempoppoDeffenceRebounds;
			this.oppoTotalRebounds+=tempoppoTotalRebounds;
			this.oppoSteals+=tempoppoSteals;
			this.oppoBlocks+=tempoppoBlocks;
			this.oppoTurnovers+=tempoppoTurnovers;
			this.oppoFouls+=tempoppoFouls;
			this.oppoScores+=tempoppoScores;
		}
		
//		//根据datatype，返回属性
//		public double getdata(DataType type){
//			switch(type){
//			case attackRounds:return this.attackRounds;
//			case teamAssists:return this.teamAssists;
//			case teamFG:return teamFG;
//			case teamFGTry:return teamFGTry;
//			case team3FG:return team3FG;
//			case team3FGTry:return team3FGTry;
//			case teamFTG:return teamFTG;
//			case teamFTGTry:return teamFTGTry;
//			case teamOffenceRebounds:return teamOffenceRebounds;
//			case teamDeffenceRebounds:return teamDeffenceRebounds;
//			case teamTotalRebounds:return teamTotalRebounds;
//			case teamSteals:return teamSteals;
//			case teamBlocks:return teamBlocks;
//			case teamTurnovers:return teamTurnovers;
//			case teamFouls:return teamFouls;
//			case teamScores:return teamScores;
//			case aver_teamAssists:return aver_teamAssists;
//			case aver_teamFG:return aver_teamFG;
//			case aver_teamFGTry:return aver_teamFGTry;
//			case teamFGP:return teamFGP;
//			case aver_team3FG:return aver_team3FG;
//			case aver_team3FGTry:return aver_team3FGTry;
//			case team3FGP:return team3FGP;
//			case aver_teamFTG:return aver_teamFTG;
//			case aver_teamFTGTry:return aver_teamFTGTry;
//			case teamFTP:return teamFTP;
//			case aver_teamOffenceRebounds:return aver_teamOffenceRebounds;
//			case aver_teamDeffenceRebounds:return aver_teamDeffenceRebounds;
//			case aver_teamTotalRebounds:return aver_teamTotalRebounds;
//			case aver_teamSteals:return aver_teamSteals;
//			case aver_teamBlocks:return aver_teamBlocks;
//			case aver_teamTurnovers:return aver_teamTurnovers;
//			case aver_teamFouls:return aver_teamFouls;
//			case aver_teamScores:return aver_teamScores;
//			case aver_oppoScores:return aver_oppoScores;
//			case teamOffE:return teamOffE;
//			case teamDefE:return teamDefE;
//			case teamOffERebE:return teamOffERebE;
//			case teamDefERebE:return teamDefERebE;
//			case teamSteE:return teamSteE;
//			case teamAssE:return teamAssE;
//			
//			case oppoattackRounds:return oppoattackRounds;
//			case oppoAssists:return oppoAssists;
//			case oppoFG:return oppoFG;
//			case oppoFGTry:return oppoFGTry;
//			case oppo3FG:return oppo3FG;
//			case oppo3FGTry:return oppo3FGTry;
//			case oppoFTG:return oppoFTG;
//			case oppoFTGTry:return oppoFTGTry;
//			case oppoOffenceRebounds:return oppoOffenceRebounds;
//			case oppoDeffenceRebounds:return oppoDeffenceRebounds;
//			case oppoTotalRebounds:return oppoTotalRebounds;
//			case oppoSteals:return oppoSteals;
//			case oppoBlocks:return oppoBlocks;
//			case oppoTurnovers:return oppoTurnovers;
//			case oppoFouls:return oppoFouls;
//			case oppoScores:return oppoScores;
//			
//			}
//			return 0.0;
//		}
}
