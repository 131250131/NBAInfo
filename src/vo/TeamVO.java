package vo;

import logic.Team;
import po.TeamPO;

public class TeamVO {
	//TeamVO用于bl层和ui层的交互，
		
		/*
	 	* 球队基本信息
	 	* */
	
		//球队名称： 
		private String teamName;
		//球队缩写：
		private String shortName;
		//球队所在地
		private String location;
		//赛区
		private boolean isEast;
		//分区
		private String division;
		//球馆名称
		private String gymName;
		//建立时间
		private int birthYear;
		
		//球队的编号；
		private int teamID;
		//球队比赛场数，胜率；（*****需要更新*****）
		private int compGames;//总场
		private int winGames;//胜场
		private int losGames;//败场
		private double winRate;//胜率
		
		
		public int getTeamID() {
			return teamID;
		}
		public void setTeamID(int teamID) {
			this.teamID = teamID;
		}
		public int getCompGames() {
			return compGames;
		}
		public void setCompGames(int compGames) {
			this.compGames = compGames;
		}
		public int getWinGames() {
			return winGames;
		}
		public void setWinGames(int winGames) {
			this.winGames = winGames;
		}
		public int getLosGames() {
			return losGames;
		}
		public void setLosGames(int losGames) {
			this.losGames = losGames;
		}
		public double getWinRate() {
			return winRate;
		}
		public void setWinRate(double winRate) {
			this.winRate = winRate;
		}

			//接下来是球队赛季总数据；	
/*接下俩的一些数据，均来自于比赛文件，不做任何的处理，只是简单得通过+=更新
 * */
		//总进攻回合数（*****需要更新*****）
			private double attackRounds;//需要手动计算;
		//球队助攻数（*****需要更新*****）
			private int teamAssists;
		//球队投篮命中数（*****需要更新*****）
			private int teamFG ;
		//球队投篮出手次数（*****需要更新*****）
			private int teamFGTry ;
		//球队三分命中数（*****需要更新*****）
			private int team3FG ;
		//球队三分出手次数（*****需要更新*****）
			private int team3FGTry ;
		//球队球队罚球命中数（*****需要更新*****）
			private int teamFTG;
		//球队罚球出手数（*****需要更新*****）
			private int teamFTGTry;
		//球队进攻篮板数（*****需要更新*****）
			private int teamOffenceRebounds;
		//球队防守篮板数（*****需要更新*****）
			private int teamDeffenceRebounds;
		//球队总篮板数（*****需要更新*****）
			private int teamTotalRebounds;
		//球队抢断数（*****需要更新*****）
			private int teamSteals;
		//球队盖帽数（*****需要更新*****）
			private int teamBlocks;
		//球队失误数（*****需要更新*****）
			private int teamTurnovers;
		//球队犯规数（*****需要更新*****）
			private int teamFouls;
		//球队总得分数（*****需要更新*****）
			private int teamScores;
			
		//对手进攻回合数（*****需要更新*****）
			private double oppoattackRounds;
		//对手助攻数（*****需要更新*****）
			private int oppoAssists;
		//投篮命中数（*****需要更新*****）
			private int oppoFG ;
		//对手投篮出手次数（*****需要更新*****）
			private int oppoFGTry ;	
		//对手三分命中数（*****需要更新*****）
			private int oppo3FG ;
		//对手三分出手次数（*****需要更新*****）
			private int oppo3FGTry ;
		//对手球队罚球命中数（*****需要更新*****）
			private int oppoFTG;
		//对手罚球出手数（*****需要更新*****）
			private int oppoFTGTry;
		//对手进攻篮板数（*****需要更新*****）
			private int oppoOffenceRebounds;
		//对手防守篮板（*****需要更新*****）
			private int oppoDeffenceRebounds;
		//对手总篮板数（*****需要更新*****）
			private int oppoTotalRebounds;
		//对手抢断数（*****需要更新*****）
			private int oppoSteals;	
		//对手盖帽数（*****需要更新*****）
			private int oppoBlocks;		
		//对手失误数（*****需要更新*****）
			private int oppoTurnovers;
		//球队犯规数（*****需要更新*****）
			private int oppoFouls;	
		//对手得分（*****需要更新*****）
			private int oppoScores;
			
//这是球队的平均信息；
		//球队场均助攻数
			private double aver_teamAssists;
		//对手场均助攻数
			private double aver_oppoAssists;
		//球队场均投篮命中数
			private double aver_teamFG ;
		//对手场均投篮命中数
			private double aver_oppoFG ;
		//球队场均投篮出手次数
			private double aver_teamFGTry ;
		//对手场均投篮出手次数
			private double aver_oppoFGTry ;
		//球队投篮命中率
			private double teamFGP;
		//对手投篮命中率
			private double oppoFGP;
		//球队场均三分命中数
			private double aver_team3FG;
		//对手场均三分命中数
			private double aver_oppo3FG;
		//球队场均三分出手次数
			private double aver_team3FGTry;
		//对手场均三分出手次数
			private double aver_oppo3FGTry;
		//球队三分命中率
			private double team3FGP; 
		//对手三分命中率
			private double oppo3FGP; 
		//球队场均罚球命中数
			private double aver_teamFTG;
		//对手场均罚球命中数
			private double aver_oppoFTG;
		//球队场均罚球出手数
			private double aver_teamFTGTry;
		//对手场均罚球出手数
			private double aver_oppoFTGTry;
		//罚球命中率	
			private double teamFTGP; 
		//对手罚球命中率	
			private double oppoFTGP; 
		//球队场均进攻篮板数
			private double aver_teamOffenceRebounds;
		//对手场均进攻篮板数
			private double aver_oppoOffenceRebounds;
		//球队场均防守篮板数
			private double aver_teamDeffenceRebounds;
		//对手场均防守篮板数
			private double aver_oppoDeffenceRebounds;	
		//球队场均总篮板
			private double aver_teamTotalRebounds;
		//对手场均总篮板
			private double aver_oppoTotalRebounds;
		//球队场均抢断数
			private double aver_teamSteals;
		//对手场均抢断数
			private double aver_oppoSteals;
		//球队场均盖帽数
			private double aver_teamBlocks;
		//对手场均盖帽数
			private double aver_oppoBlocks;
		//球队场均失误数
			private double aver_teamTurnovers;
		//对手场均失误数
			private double aver_oppoTurnovers;
		//球队场均犯规数
			private double aver_teamFouls;
		//对手场均犯规数
			private double aver_oppoFouls;
		//球队场均总得分数
			private double aver_teamScores;
		//对手对手场均得分数
			private double aver_oppoScores;
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

			
			public double getAver_teamAssists() {
				return aver_teamAssists;
			}
			public void setAver_teamAssists(double aver_teamAssists) {
				this.aver_teamAssists = aver_teamAssists;
			}
			public double getAver_oppoAssists() {
				return aver_oppoAssists;
			}
			public void setAver_oppoAssists(double aver_oppoAssists) {
				this.aver_oppoAssists = aver_oppoAssists;
			}
			public double getAver_teamFG() {
				return aver_teamFG;
			}
			public void setAver_teamFG(double aver_teamFG) {
				this.aver_teamFG = aver_teamFG;
			}
			public double getAver_oppoFG() {
				return aver_oppoFG;
			}
			public void setAver_oppoFG(double aver_oppoFG) {
				this.aver_oppoFG = aver_oppoFG;
			}
			public double getAver_teamFGTry() {
				return aver_teamFGTry;
			}
			public void setAver_teamFGTry(double aver_teamFGTry) {
				this.aver_teamFGTry = aver_teamFGTry;
			}
			public double getAver_oppoFGTry() {
				return aver_oppoFGTry;
			}
			public void setAver_oppoFGTry(double aver_oppoFGTry) {
				this.aver_oppoFGTry = aver_oppoFGTry;
			}
			public double getTeamFGP() {
				return teamFGP;
			}
			public void setTeamFGP(double teamFGP) {
				this.teamFGP = teamFGP;
			}
			public double getOppoFGP() {
				return oppoFGP;
			}
			public void setOppoFGP(double oppoFGP) {
				this.oppoFGP = oppoFGP;
			}
			public double getAver_team3FG() {
				return aver_team3FG;
			}
			public void setAver_team3FG(double aver_team3FG) {
				this.aver_team3FG = aver_team3FG;
			}
			public double getAver_oppo3FG() {
				return aver_oppo3FG;
			}
			public void setAver_oppo3FG(double aver_oppo3FG) {
				this.aver_oppo3FG = aver_oppo3FG;
			}
			public double getAver_team3FGTry() {
				return aver_team3FGTry;
			}
			public void setAver_team3FGTry(double aver_team3FGTry) {
				this.aver_team3FGTry = aver_team3FGTry;
			}
			public double getAver_oppo3FGTry() {
				return aver_oppo3FGTry;
			}
			public void setAver_oppo3FGTry(double aver_oppo3FGTry) {
				this.aver_oppo3FGTry = aver_oppo3FGTry;
			}
			public double getTeam3FGP() {
				return team3FGP;
			}
			public void setTeam3FGP(double team3fgp) {
				team3FGP = team3fgp;
			}
			public double getOppo3FGP() {
				return oppo3FGP;
			}
			public void setOppo3FGP(double oppo3fgp) {
				oppo3FGP = oppo3fgp;
			}
			public double getAver_teamFTG() {
				return aver_teamFTG;
			}
			public void setAver_teamFTG(double aver_teamFTG) {
				this.aver_teamFTG = aver_teamFTG;
			}
			public double getAver_oppoFTG() {
				return aver_oppoFTG;
			}
			public void setAver_oppoFTG(double aver_oppoFTG) {
				this.aver_oppoFTG = aver_oppoFTG;
			}
			public double getAver_teamFTGTry() {
				return aver_teamFTGTry;
			}
			public void setAver_teamFTGTry(double aver_teamFTGTry) {
				this.aver_teamFTGTry = aver_teamFTGTry;
			}
			public double getAver_oppoFTGTry() {
				return aver_oppoFTGTry;
			}
			public void setAver_oppoFTGTry(double aver_oppoFTGTry) {
				this.aver_oppoFTGTry = aver_oppoFTGTry;
			}
			public double getTeamFTGP() {
				return teamFTGP;
			}
			public void setTeamFTGP(double teamFTGP) {
				this.teamFTGP = teamFTGP;
			}
			public double getOppoFTGP() {
				return oppoFTGP;
			}
			public void setOppoFTGP(double oppoFTGP) {
				this.oppoFTGP = oppoFTGP;
			}
			public double getAver_teamOffenceRebounds() {
				return aver_teamOffenceRebounds;
			}
			public void setAver_teamOffenceRebounds(double aver_teamOffenceRebounds) {
				this.aver_teamOffenceRebounds = aver_teamOffenceRebounds;
			}
			public double getAver_oppoOffenceRebounds() {
				return aver_oppoOffenceRebounds;
			}
			public void setAver_oppoOffenceRebounds(double aver_oppoOffenceRebounds) {
				this.aver_oppoOffenceRebounds = aver_oppoOffenceRebounds;
			}
			public double getAver_teamDeffenceRebounds() {
				return aver_teamDeffenceRebounds;
			}
			public void setAver_teamDeffenceRebounds(double aver_teamDeffenceRebounds) {
				this.aver_teamDeffenceRebounds = aver_teamDeffenceRebounds;
			}
			public double getAver_oppoDeffenceRebounds() {
				return aver_oppoDeffenceRebounds;
			}
			public void setAver_oppoDeffenceRebounds(double aver_oppoDeffenceRebounds) {
				this.aver_oppoDeffenceRebounds = aver_oppoDeffenceRebounds;
			}
			public double getAver_teamTotalRebounds() {
				return aver_teamTotalRebounds;
			}
			public void setAver_teamTotalRebounds(double aver_teamTotalRebounds) {
				this.aver_teamTotalRebounds = aver_teamTotalRebounds;
			}
			public double getAver_oppoTotalRebounds() {
				return aver_oppoTotalRebounds;
			}
			public void setAver_oppoTotalRebounds(double aver_oppoTotalRebounds) {
				this.aver_oppoTotalRebounds = aver_oppoTotalRebounds;
			}
			public double getAver_teamSteals() {
				return aver_teamSteals;
			}
			public void setAver_teamSteals(double aver_teamSteals) {
				this.aver_teamSteals = aver_teamSteals;
			}
			public double getAver_oppoSteals() {
				return aver_oppoSteals;
			}
			public void setAver_oppoSteals(double aver_oppoSteals) {
				this.aver_oppoSteals = aver_oppoSteals;
			}
			public double getAver_teamBlocks() {
				return aver_teamBlocks;
			}
			public void setAver_teamBlocks(double aver_teamBlocks) {
				this.aver_teamBlocks = aver_teamBlocks;
			}
			public double getAver_oppoBlocks() {
				return aver_oppoBlocks;
			}
			public void setAver_oppoBlocks(double aver_oppoBlocks) {
				this.aver_oppoBlocks = aver_oppoBlocks;
			}
			public double getAver_teamTurnovers() {
				return aver_teamTurnovers;
			}
			public void setAver_teamTurnovers(double aver_teamTurnovers) {
				this.aver_teamTurnovers = aver_teamTurnovers;
			}
			public double getAver_oppoTurnovers() {
				return aver_oppoTurnovers;
			}
			public void setAver_oppoTurnovers(double aver_oppoTurnovers) {
				this.aver_oppoTurnovers = aver_oppoTurnovers;
			}
			public double getAver_teamFouls() {
				return aver_teamFouls;
			}
			public void setAver_teamFouls(double aver_teamFouls) {
				this.aver_teamFouls = aver_teamFouls;
			}
			public double getAver_oppoFouls() {
				return aver_oppoFouls;
			}
			public void setAver_oppoFouls(double aver_oppoFouls) {
				this.aver_oppoFouls = aver_oppoFouls;
			}
			public double getAver_teamScores() {
				return aver_teamScores;
			}
			public void setAver_teamScores(double aver_teamScores) {
				this.aver_teamScores = aver_teamScores;
			}
			public double getAver_oppoScores() {
				return aver_oppoScores;
			}
			public void setAver_oppoScores(double aver_oppoScores) {
				this.aver_oppoScores = aver_oppoScores;
			}
			public double getTeamOffE() {
				return teamOffE;
			}
			public void setTeamOffE(double teamOffE) {
				this.teamOffE = teamOffE;
			}
			public double getTeamDefE() {
				return teamDefE;
			}
			public void setTeamDefE(double teamDefE) {
				this.teamDefE = teamDefE;
			}
			public double getTeamOffERebE() {
				return teamOffERebE;
			}
			public void setTeamOffERebE(double teamOffERebE) {
				this.teamOffERebE = teamOffERebE;
			}
			public double getTeamDefERebE() {
				return teamDefERebE;
			}
			public void setTeamDefERebE(double teamDefERebE) {
				this.teamDefERebE = teamDefERebE;
			}
			public double getTeamSteE() {
				return teamSteE;
			}
			public void setTeamSteE(double teamSteE) {
				this.teamSteE = teamSteE;
			}
			public double getTeamAssE() {
				return teamAssE;
			}
			public void setTeamAssE(double teamAssE) {
				this.teamAssE = teamAssE;
			}

			
		public double getAttackRounds() {
				return attackRounds;
		}
		public void setAttackRounds(double attackRounds) {
				this.attackRounds = attackRounds;
		}
		public double getOppoattackRounds() {
				return oppoattackRounds;
		}
		public void setOppoattackRounds(double oppoattackRounds) {
			this.oppoattackRounds = oppoattackRounds;
		}
		public int getTeamAssists() {
				return teamAssists;
		}
		public void setTeamAssists(int teamAssists) {
				this.teamAssists = teamAssists;
		}
		public int getOppoAssists() {
				return oppoAssists;
		}
		public void setOppoAssists(int oppoAssists) {
				this.oppoAssists = oppoAssists;
		}
		public int getTeamFG() {
				return teamFG;
		}
		public void setTeamFG(int teamFG) {
				this.teamFG = teamFG;
		}
		public int getOppoFG() {
				return oppoFG;
		}
		public void setOppoFG(int oppoFG) {
				this.oppoFG = oppoFG;
		}
		public int getTeamFGTry() {
				return teamFGTry;
		}
		public void setTeamFGTry(int teamFGTry) {
				this.teamFGTry = teamFGTry;
		}
		public int getOppoFGTry() {
				return oppoFGTry;
		}
		public void setOppoFGTry(int oppoFGTry) {
				this.oppoFGTry = oppoFGTry;
		}
		public int getTeam3FG() {
			return team3FG;
		}
		public void setTeam3FG(int team3fg) {
			team3FG = team3fg;
		}
		public int getOppo3FG() {
			return oppo3FG;
		}
		public void setOppo3FG(int oppo3fg) {
			oppo3FG = oppo3fg;
		}
		public int getTeam3FGTry() {
			return team3FGTry;
		}
		public void setTeam3FGTry(int team3fgTry) {
			team3FGTry = team3fgTry;
		}
		public int getOppo3FGTry() {
			return oppo3FGTry;
		}
		public void setOppo3FGTry(int oppo3fgTry) {
			oppo3FGTry = oppo3fgTry;
		}
		public int getTeamFTG() {
			return teamFTG;
		}
		public void setTeamFTG(int teamFTG) {
			this.teamFTG = teamFTG;
		}
		public int getOppoFTG() {
			return oppoFTG;
		}
		public void setOppoFTG(int oppoFTG) {
			this.oppoFTG = oppoFTG;
		}
		public int getTeamFTGTry() {
			return teamFTGTry;
		}
		public void setTeamFTGTry(int teamFTGTry) {
			this.teamFTGTry = teamFTGTry;
		}
		public int getOppoFTGTry() {
			return oppoFTGTry;
		}
		public void setOppoFTGTry(int oppoFTGTry) {
			this.oppoFTGTry = oppoFTGTry;
		}
		public int getTeamOffenceRebounds() {
			return teamOffenceRebounds;
		}
		public void setTeamOffenceRebounds(int teamOffenceRebounds) {
			this.teamOffenceRebounds = teamOffenceRebounds;
		}
		public int getOppoOffenceRebounds() {
			return oppoOffenceRebounds;
		}
		public void setOppoOffenceRebounds(int oppoOffenceRebounds) {
			this.oppoOffenceRebounds = oppoOffenceRebounds;
		}
		public int getTeamDeffenceRebounds() {
			return teamDeffenceRebounds;
		}
		public void setTeamDeffenceRebounds(int teamDeffenceRebounds) {
			this.teamDeffenceRebounds = teamDeffenceRebounds;
		}
		public int getOppoDeffenceRebounds() {
			return oppoDeffenceRebounds;
		}
		public void setOppoDeffenceRebounds(int oppoDeffenceRebounds) {
			this.oppoDeffenceRebounds = oppoDeffenceRebounds;
		}
		public int getTeamTotalRebounds() {
			return teamTotalRebounds;
		}
		public void setTeamTotalRebounds(int teamTotalRebounds) {
			this.teamTotalRebounds = teamTotalRebounds;
		}
		public int getOppoTotalRebounds() {
			return oppoTotalRebounds;
		}
		public void setOppoTotalRebounds(int oppoTotalRebounds) {
			this.oppoTotalRebounds = oppoTotalRebounds;
		}
		public int getTeamSteals() {
			return teamSteals;
		}
		public void setTeamSteals(int teamSteals) {
			this.teamSteals = teamSteals;
		}
		public int getOppoSteals() {
			return oppoSteals;
		}
		public void setOppoSteals(int oppoSteals) {
			this.oppoSteals = oppoSteals;
		}
		public int getTeamBlocks() {
			return teamBlocks;
		}
		public void setTeamBlocks(int teamBlocks) {
			this.teamBlocks = teamBlocks;
		}
		public int getOppoBlocks() {
			return oppoBlocks;
		}
		public void setOppoBlocks(int oppoBlocks) {
			this.oppoBlocks = oppoBlocks;
		}
		public int getTeamTurnovers() {
			return teamTurnovers;
		}
		public void setTeamTurnovers(int teamTurnovers) {
			this.teamTurnovers = teamTurnovers;
		}
		public int getOppoTurnovers() {
			return oppoTurnovers;
		}
		public void setOppoTurnovers(int oppoTurnovers) {
			this.oppoTurnovers = oppoTurnovers;
		}
		public int getTeamFouls() {
			return teamFouls;
		}
		public void setTeamFouls(int teamFouls) {
			this.teamFouls = teamFouls;
		}
		public int getOppoFouls() {
			return oppoFouls;
		}
		public void setOppoFouls(int oppoFouls) {
			this.oppoFouls = oppoFouls;
		}
		public int getTeamScores() {
			return teamScores;
		}
		public void setTeamScores(int teamScores) {
			this.teamScores = teamScores;
		}
		public int getOppoScores() {
			return oppoScores;
		}
		public void setOppoScores(int oppoScores) {
			this.oppoScores = oppoScores;
		}

		
		public String getTeamName() {
			return teamName;
		}
		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}
		
		public String getShortName() {
			return shortName;
		}
		public void setShortName(String shortName) {
			this.shortName = shortName;
		}
		
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		
		public boolean isEast() {
			return isEast;
		}
		public void setEast(boolean isEast) {
			this.isEast = isEast;
		}
		
		public String getDivision() {
			return division;
		}
		public void setDivision(String division) {
			this.division = division;
		}
		
		public String getGymName() {
			return gymName;
		}
		public void setGymName(String gymName) {
			this.gymName = gymName;
		}
		
		public int getBirthYear() {
			return birthYear;
		}
		public void setBirthYear(int birthYear) {
			this.birthYear = birthYear;
		}
		
		//创建teamVO需要对平均值进行处理..
		public void creatteamvo(Team team){
			/*
			 * 		//球队的编号；
		private int teamID;
		//球队比赛场数，胜率；（*****需要更新*****）
		private int compGames;//总场
		private int winGames;//胜场
		private int losGames;//败场
		private double winRate;//胜率
			 * */
			
			//球队基本信息
			this.teamName=team.getTeamName();
			this.shortName=team.getShortName();
			this.location=team.getLocation();
			this.isEast=team.getisEast();
			this.division=team.getDivision();
			this.gymName=team.getGymName();
			this.birthYear=team.getBirthYear();
			
			//整体数据
			this.teamID=team.getTeamID();
			this.compGames=team.getCompGames();
			this.winGames=team.getWinGames();
			this.losGames=team.getLosGames();
			this.winRate=team.getWinRate();
			
			//球队单项数据总计;
			this.teamAssists=team.getTeamAssists();
			this.teamFG=team.getTeamFG();
			this.teamFGTry=team.getTeamFGTry();
			this.team3FG=team.getTeam3FG();
			this.team3FGTry=team.getTeam3FGTry();
			this.teamFTG=team.getTeamFTG();
			this.teamFTGTry=team.getTeamFGTry();
			this.teamOffenceRebounds=team.getTeamOffenceRebounds();
			this.teamDeffenceRebounds=team.getTeamDeffenceRebounds();
			this.teamTotalRebounds=team.getTeamTotalRebounds();
			this.teamSteals=team.getTeamSteals();
			this.teamBlocks=team.getTeamBlocks();
			this.teamTurnovers=team.getTeamTurnovers();
			this.teamFouls=team.getTeamFouls();
			this.teamScores=team.getTeamScores();
			
			//球队单项平均数据统计;
			this.aver_teamAssists=team.getAver_teamAssists();
			this.aver_teamFG=team.getAver_teamFG();
			this.aver_teamFGTry=team.getAver_teamFGTry();
			this.aver_team3FG=team.getAver_team3FG();
			this.aver_team3FGTry=team.getAver_team3FGTry();
			this.aver_teamFTG=team.getAver_teamFTG();
			this.aver_teamFTGTry=team.getAver_teamFGTry();
			this.aver_teamOffenceRebounds=team.getAver_teamOffenceRebounds();
			this.aver_teamDeffenceRebounds=team.getAver_teamDeffenceRebounds();
			this.aver_teamTotalRebounds=team.getAver_teamTotalRebounds();
			this.aver_teamSteals=team.getAver_teamSteals();
			this.aver_teamBlocks=team.getAver_teamBlocks();
			this.aver_teamTurnovers=team.getAver_teamTurnovers();
			this.aver_teamFouls=team.getAver_teamFouls();
			this.aver_teamScores=team.getAver_teamScores();
			
			//球队各种效率;
			this.teamFGP = team.getTeamFGP();
			this.team3FGP = team.getTeam3FGP();
			this.teamFTGP = team.getTeamFTGP();
			this.teamOffE = team.getTeamOffE();
			this.teamDefE = team.getTeamDefE();
			this.teamOffERebE = team.getTeamOffE();
			this.teamDefERebE = team.getTeamDefERebE();
			this.teamSteals = team.getTeamSteals();
			this.teamAssE = team.getTeamAssE();
			
			//对手单项总数据统计;
			this.oppoAssists=team.getOppoAssists();
			this.oppoFG=team.getOppoFG();
			this.oppoFGTry=team.getOppoFGTry();
			this.oppo3FG=team.getOppo3FG();
			this.oppo3FGTry=team.getOppo3FGTry();
			this.oppoFTG=team.getOppoFTG();
			this.oppoFTGTry=team.getOppoFGTry();
			this.oppoOffenceRebounds=team.getOppoOffenceRebounds();
			this.oppoDeffenceRebounds=team.getOppoDeffenceRebounds();
			this.oppoTotalRebounds=team.getOppoTotalRebounds();
			this.oppoSteals=team.getOppoSteals();
			this.oppoBlocks=team.getOppoBlocks();
			this.oppoTurnovers=team.getOppoTurnovers();
			this.oppoFouls=team.getOppoFouls();
			this.oppoScores=team.getOppoScores();
			
			//对手单项平均数据统计;
			this.aver_oppoAssists=team.getAver_oppoAssists();
			this.aver_oppoFG=team.getAver_oppoFG();
			this.aver_oppoFGTry=team.getAver_oppoFGTry();
			this.aver_oppo3FG=team.getAver_oppo3FG();
			this.aver_oppo3FGTry=team.getAver_oppo3FGTry();
			this.aver_oppoFTG=team.getAver_oppoFTG();
			this.aver_oppoFTGTry=team.getAver_oppoFGTry();
			this.aver_oppoOffenceRebounds=team.getAver_oppoOffenceRebounds();
			this.aver_oppoDeffenceRebounds=team.getAver_oppoDeffenceRebounds();
			this.aver_oppoTotalRebounds=team.getAver_oppoTotalRebounds();
			this.aver_oppoSteals=team.getAver_oppoSteals();
			this.aver_oppoBlocks=team.getAver_oppoBlocks();
			this.aver_oppoTurnovers=team.getAver_oppoTurnovers();
			this.aver_oppoFouls=team.getAver_oppoFouls();
			this.aver_oppoScores=team.getAver_oppoScores();
			
			
		}


}
