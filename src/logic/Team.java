package logic;

import po.TeamPO;
import vo.TeamVO;

public class Team {
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
			
			
			
		public Team(TeamPO teampo) {
			//Basic info
			teamName=teampo.getTeamName();
			shortName=teampo.getShortName();
			location=teampo.getLocation();
			isEast=teampo.getisEast();
			division=teampo.getDivision();
			gymName=teampo.getGymName();
			birthYear=teampo.getBirthYear();
			
			teamAssists=0;
			teamFG=0;
			teamFGTry=0;
			team3FG=0;
			team3FGTry=0;
			teamFTG=0;
			teamFTGTry=0;
			teamOffenceRebounds=0;
			teamDeffenceRebounds=0;
			teamTotalRebounds=0;
			teamSteals=0;
			teamBlocks=0;
			teamTurnovers=0;
			teamFouls=0;
			teamScores=0;
			}

		public Team() {
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



		public double getAttackRounds() {
			return attackRounds;
		}



		public void setAttackRounds(double attackRounds) {
			this.attackRounds = attackRounds;
		}



		public int getTeamAssists() {
			return teamAssists;
		}



		public void setTeamAssists(int teamAssists) {
			this.teamAssists = teamAssists;
		}



		public int getTeamFG() {
			return teamFG;
		}



		public void setTeamFG(int teamFG) {
			this.teamFG = teamFG;
		}



		public int getTeamFGTry() {
			return teamFGTry;
		}



		public void setTeamFGTry(int teamFGTry) {
			this.teamFGTry = teamFGTry;
		}



		public int getTeam3FG() {
			return team3FG;
		}



		public void setTeam3FG(int team3fg) {
			team3FG = team3fg;
		}



		public int getTeam3FGTry() {
			return team3FGTry;
		}



		public void setTeam3FGTry(int team3fgTry) {
			team3FGTry = team3fgTry;
		}



		public int getTeamFTG() {
			return teamFTG;
		}



		public void setTeamFTG(int teamFTG) {
			this.teamFTG = teamFTG;
		}



		public int getTeamFTGTry() {
			return teamFTGTry;
		}



		public void setTeamFTGTry(int teamFTGTry) {
			this.teamFTGTry = teamFTGTry;
		}



		public int getTeamOffenceRebounds() {
			return teamOffenceRebounds;
		}



		public void setTeamOffenceRebounds(int teamOffenceRebounds) {
			this.teamOffenceRebounds = teamOffenceRebounds;
		}



		public int getTeamDeffenceRebounds() {
			return teamDeffenceRebounds;
		}



		public void setTeamDeffenceRebounds(int teamDeffenceRebounds) {
			this.teamDeffenceRebounds = teamDeffenceRebounds;
		}



		public int getTeamTotalRebounds() {
			return teamTotalRebounds;
		}



		public void setTeamTotalRebounds(int teamTotalRebounds) {
			this.teamTotalRebounds = teamTotalRebounds;
		}



		public int getTeamSteals() {
			return teamSteals;
		}



		public void setTeamSteals(int teamSteals) {
			this.teamSteals = teamSteals;
		}



		public int getTeamBlocks() {
			return teamBlocks;
		}



		public void setTeamBlocks(int teamBlocks) {
			this.teamBlocks = teamBlocks;
		}



		public int getTeamTurnovers() {
			return teamTurnovers;
		}



		public void setTeamTurnovers(int teamTurnovers) {
			this.teamTurnovers = teamTurnovers;
		}



		public int getTeamFouls() {
			return teamFouls;
		}



		public void setTeamFouls(int teamFouls) {
			this.teamFouls = teamFouls;
		}



		public int getTeamScores() {
			return teamScores;
		}



		public void setTeamScores(int teamScores) {
			this.teamScores = teamScores;
		}



		public double getOppoattackRounds() {
			return oppoattackRounds;
		}



		public void setOppoattackRounds(double oppoattackRounds) {
			this.oppoattackRounds = oppoattackRounds;
		}



		public int getOppoAssists() {
			return oppoAssists;
		}



		public void setOppoAssists(int oppoAssists) {
			this.oppoAssists = oppoAssists;
		}



		public int getOppoFG() {
			return oppoFG;
		}



		public void setOppoFG(int oppoFG) {
			this.oppoFG = oppoFG;
		}



		public int getOppoFGTry() {
			return oppoFGTry;
		}



		public void setOppoFGTry(int oppoFGTry) {
			this.oppoFGTry = oppoFGTry;
		}



		public int getOppo3FG() {
			return oppo3FG;
		}



		public void setOppo3FG(int oppo3fg) {
			oppo3FG = oppo3fg;
		}



		public int getOppo3FGTry() {
			return oppo3FGTry;
		}



		public void setOppo3FGTry(int oppo3fgTry) {
			oppo3FGTry = oppo3fgTry;
		}



		public int getOppoFTG() {
			return oppoFTG;
		}



		public void setOppoFTG(int oppoFTG) {
			this.oppoFTG = oppoFTG;
		}



		public int getOppoFTGTry() {
			return oppoFTGTry;
		}



		public void setOppoFTGTry(int oppoFTGTry) {
			this.oppoFTGTry = oppoFTGTry;
		}



		public int getOppoOffenceRebounds() {
			return oppoOffenceRebounds;
		}



		public void setOppoOffenceRebounds(int oppoOffenceRebounds) {
			this.oppoOffenceRebounds = oppoOffenceRebounds;
		}



		public int getOppoDeffenceRebounds() {
			return oppoDeffenceRebounds;
		}



		public void setOppoDeffenceRebounds(int oppoDeffenceRebounds) {
			this.oppoDeffenceRebounds = oppoDeffenceRebounds;
		}



		public int getOppoTotalRebounds() {
			return oppoTotalRebounds;
		}



		public void setOppoTotalRebounds(int oppoTotalRebounds) {
			this.oppoTotalRebounds = oppoTotalRebounds;
		}



		public int getOppoSteals() {
			return oppoSteals;
		}



		public void setOppoSteals(int oppoSteals) {
			this.oppoSteals = oppoSteals;
		}



		public int getOppoBlocks() {
			return oppoBlocks;
		}



		public void setOppoBlocks(int oppoBlocks) {
			this.oppoBlocks = oppoBlocks;
		}



		public int getOppoTurnovers() {
			return oppoTurnovers;
		}



		public void setOppoTurnovers(int oppoTurnovers) {
			this.oppoTurnovers = oppoTurnovers;
		}



		public int getOppoFouls() {
			return oppoFouls;
		}



		public void setOppoFouls(int oppoFouls) {
			this.oppoFouls = oppoFouls;
		}



		public int getOppoScores() {
			return oppoScores;
		}



		public void setOppoScores(int oppoScores) {
			this.oppoScores = oppoScores;
		}



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



		//更新的方法，
		public void updateTeamInfo(Team myTeam,Team oppoTeam){
			this.compGames++;
			if(myTeam.getTeamScores()>oppoTeam.getTeamScores()){
				this.winGames++;
			}else{
				this.losGames++;
			}
			
			this.attackRounds+=myTeam.getTeamFGTry() + 0.4 * myTeam.getTeamFTGTry() - 1.07 * (myTeam.getTeamOffenceRebounds() /
					(myTeam.getTeamOffenceRebounds() + oppoTeam.getTeamDeffenceRebounds()) * (myTeam.getTeamFGTry() - myTeam.getTeamFG())) + 1.07 * myTeam.getTeamTurnovers();
			this.teamAssists+=myTeam.getTeamAssists();
			this.teamFG+=myTeam.getTeamFG();
			this.teamFGTry+=myTeam.getTeamFGTry();
			this.team3FG+=myTeam.getTeam3FG();
			this.team3FGTry+=myTeam.getTeam3FGTry();
			this.teamFTG+=myTeam.getTeamFTG();
			this.teamFTGTry+=myTeam.getTeamFTGTry();
			this.teamOffenceRebounds+=myTeam.getTeamOffenceRebounds();
			this.teamDeffenceRebounds+=myTeam.getTeamDeffenceRebounds();
			this.teamTotalRebounds+=myTeam.getTeamTotalRebounds();
			this.teamSteals+=myTeam.getTeamSteals();
			this.teamBlocks+=myTeam.getTeamBlocks();
			this.teamTurnovers+=myTeam.getTeamTurnovers();
			this.teamFouls+=myTeam.getTeamFouls();
			this.teamScores+=myTeam.getTeamScores();
				
			this.oppoattackRounds+=oppoTeam.getTeamFGTry() + 0.4 * oppoTeam.getTeamFTGTry() - 1.07 * (oppoTeam.getTeamOffenceRebounds() /
					(oppoTeam.getTeamOffenceRebounds() + myTeam.getTeamDeffenceRebounds()) * (oppoTeam.getTeamFGTry() - oppoTeam.getTeamFG())) + 1.07 * oppoTeam.getTeamTurnovers();
			this.oppoAssists+=oppoTeam.getTeamAssists();
			this.oppoFG+=oppoTeam.getTeamFG();
			this.oppoFGTry+=oppoTeam.getTeamFGTry();
			this.oppo3FG+=oppoTeam.getTeam3FG();
			this.oppo3FGTry+=oppoTeam.getTeam3FGTry();
			this.oppoFTG+=oppoTeam.getTeamFTG();
			this.oppoFTGTry+=oppoTeam.getTeamFTGTry();
			this.oppoOffenceRebounds+=oppoTeam.getTeamOffenceRebounds();
			this.oppoDeffenceRebounds+=oppoTeam.getTeamDeffenceRebounds();
			this.oppoTotalRebounds+=oppoTeam.getTeamTotalRebounds();
			this.oppoSteals+=oppoTeam.getTeamSteals();
			this.oppoBlocks+=oppoTeam.getTeamBlocks();
			this.oppoTurnovers+=oppoTeam.getTeamTurnovers();
			this.oppoFouls+=oppoTeam.getTeamFouls();
			this.oppoScores+=oppoTeam.getTeamScores();
				
		}
		
		public void creatteam(TeamPO teampo){
			teamName=teampo.getTeamName();
			shortName=teampo.getShortName();
			location=teampo.getLocation();
			isEast=teampo.getisEast();
			division=teampo.getDivision();
			gymName=teampo.getGymName();
			birthYear=teampo.getBirthYear();
			teamAssists=teampo.getTeamAssists();
			teamFG=teampo.getTeamFG();
			teamFGTry=teampo.getTeamFGTry();
			team3FG=teampo.getTeam3FG();
			team3FGTry=teampo.getTeam3FGTry();
			teamFTG=teampo.getTeamFTG();
			teamFTGTry=teampo.getTeamFGTry();
			teamOffenceRebounds=teampo.getTeamOffenceRebounds();
			teamDeffenceRebounds=teampo.getTeamDeffenceRebounds();
			teamTotalRebounds=teampo.getTeamTotalRebounds();
			teamSteals=teampo.getTeamSteals();
			teamBlocks=teampo.getTeamBlocks();
			teamTurnovers=teampo.getTeamTurnovers();
			teamFouls=teampo.getTeamFouls();
			teamScores=teampo.getTeamScores();
		}
		
		public TeamVO createTeamVO(){
			TeamVO vo = new TeamVO();
			vo.creatteamvo(this);
			return vo;
		}


		public boolean getisEast() {
			return isEast;
		}

			
}
