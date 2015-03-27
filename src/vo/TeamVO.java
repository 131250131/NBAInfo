package vo;

public class TeamVO {
//TeamVO用于bl层和ui层的交互，
	
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
		
		
		
}
