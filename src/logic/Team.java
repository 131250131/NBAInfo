package logic;

import java.util.ArrayList;

import po.TeamPO;
import vo.TeamVO;
import vo.win_lose;

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
			
			
		//Bonus功能;
			private double winLose;//胜负场;
			private win_lose win_lose=new win_lose();
			private win_lose home=new win_lose();//主场输赢的次数;
			private win_lose guest=new win_lose();//客场输赢的次数;
			
			private win_lose recent10=new win_lose();
			private win_lose recent10_Home=new win_lose();
			private win_lose recent10_Guest=new win_lose();
			
			private boolean lianxu_win;
			private boolean lianxu_win_Home;
			private boolean lianxu_win_Guest;
			private int lianxu;
			private int lianxu_Home;
			private int lianxu_Guest;
			private int longestWin;
			private int longestLose;
			
			private win_lose lessThan3Points=new win_lose();//3分之内胜负场
			private win_lose moreThan10Points=new win_lose();//10分以上胜负关系
			
			private win_lose myTeamMoreThan100=new win_lose();//本队得分上100时的胜负关系
			private win_lose oppoTeamMoreThan100=new win_lose();//对手得分上100时的胜负关系
			
			private win_lose oppoIsStrong=new win_lose();//对手胜率50%时的胜负关系
			
			private win_lose MoreFGP=new win_lose();//命中率领先
			private win_lose MoreRebounds=new win_lose();//篮板领先
			private win_lose LessTurnovers=new win_lose();//更少失误时的胜负关系
			
			private win_lose banchanglingxian=new win_lose();//半场领先
			private win_lose banchangluohou=new win_lose();//半场落后
			private win_lose sanjielinxian=new win_lose();//第三节领先
			private win_lose sanjieluohou=new win_lose();//第三节落后
			
			private ArrayList<Integer> attendmatches =new ArrayList<Integer>();
			
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
			return Double.parseDouble(String.format("%.3f", (winGames + 0.0)/(winGames+losGames)));

		}



		public void setWinRate(double winrate) {
			winRate=winrate;
		}



		public double getAttackRounds() {
			return Double.parseDouble(String.format("%.3f", (this.attackRounds + 0.0)/(winGames+losGames)));
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
			return teamOffenceRebounds + teamDeffenceRebounds;
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
			//Double.parseDouble(String.format("%.3f", (aver_teamAssists + 0.0)/(winGames+losGames)))
			return Double.parseDouble(String.format("%.3f", (this.teamAssists + 0.0)/(this.compGames)));
		}



		public void setAver_teamAssists(double aver_teamAssists) {
			this.aver_teamAssists = aver_teamAssists;
		}



		public double getAver_oppoAssists() {
			
			return Double.parseDouble(String.format("%.3f", (this.oppoAssists + 0.0)/(this.compGames)));
		}



		public void setAver_oppoAssists(double aver_oppoAssists) {
			this.aver_oppoAssists = aver_oppoAssists;
		}



		public double getAver_teamFG() {
			
			return Double.parseDouble(String.format("%.3f", (this.teamFG + 0.0)/(this.compGames)));
		}



		public void setAver_teamFG(double aver_teamFG) {
			this.aver_teamFG = aver_teamFG;
		}



		public double getAver_oppoFG() {
			return Double.parseDouble(String.format("%.3f", (this.oppoFG + 0.0)/(this.compGames)));
		}



		public void setAver_oppoFG(double aver_oppoFG) {
			this.aver_oppoFG = aver_oppoFG;
		}



		public double getAver_teamFGTry() {
			return Double.parseDouble(String.format("%.3f", (this.teamFGTry + 0.0)/(this.compGames)));
		}



		public void setAver_teamFGTry(double aver_teamFGTry) {
			this.aver_teamFGTry = aver_teamFGTry;
		}



		public double getAver_oppoFGTry() {
			return Double.parseDouble(String.format("%.3f", (this.oppoFGTry + 0.0)/(this.compGames)));
		}



		public void setAver_oppoFGTry(double aver_oppoFGTry) {
			this.aver_oppoFGTry = aver_oppoFGTry;
		}



		public double getTeamFGP() {
			return Double.parseDouble(String.format("%.3f",(teamFG + 0.0) / (teamFGTry + 0.0)));

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
			return Double.parseDouble(String.format("%.3f",(this.team3FG + 0.0) / (this.compGames + 0.0)));
		}



		public void setAver_team3FG(double aver_team3FG) {
			this.aver_team3FG = aver_team3FG;
		}



		public double getAver_oppo3FG() {
			return Double.parseDouble(String.format("%.3f",(this.oppo3FG + 0.0) / (this.compGames + 0.0)));
		}



		public void setAver_oppo3FG(double aver_oppo3FG) {
			this.aver_oppo3FG = aver_oppo3FG;
		}



		public double getAver_team3FGTry() {
			return Double.parseDouble(String.format("%.3f",(team3FGTry + 0.0) / (this.compGames +0.0)));
		}



		public void setAver_team3FGTry(double aver_team3FGTry) {
			this.aver_team3FGTry = aver_team3FGTry;
		}



		public double getAver_oppo3FGTry() {
			return Double.parseDouble(String.format("%.3f",(oppo3FGTry + 0.0) / (this.compGames + 0.0)));
		}



		public void setAver_oppo3FGTry(double aver_oppo3FGTry) {
			this.aver_oppo3FGTry = aver_oppo3FGTry;
		}



		public double getTeam3FGP() {
			return Double.parseDouble(String.format("%.3f",(team3FG + 0.0) / (team3FGTry + 0.0)));
		}



		public void setTeam3FGP(double team3fgp) {
			team3FGP = team3fgp;
		}



		public double getOppo3FGP() {
			return Double.parseDouble(String.format("%.3f",(oppo3FG + 0.0) / (oppo3FGTry + 0.0)));
		}



		public void setOppo3FGP(double oppo3fgp) {
			oppo3FGP = oppo3fgp;
		}



		public double getAver_teamFTG() {
			return Double.parseDouble(String.format("%.3f",(teamFTG + 0.0) / (this.compGames + 0.0)));
		}



		public void setAver_teamFTG(double aver_teamFTG) {
			this.aver_teamFTG = aver_teamFTG;
		}



		public double getAver_oppoFTG() {
			return Double.parseDouble(String.format("%.3f",(this.oppoFTG + 0.0) / (this.compGames + 0.0)));
		}



		public void setAver_oppoFTG(double aver_oppoFTG) {
			this.aver_oppoFTG = aver_oppoFTG;
		}



		public double getAver_teamFTGTry() {
			return Double.parseDouble(String.format("%.3f",(this.teamFTGTry + 0.0) / (this.compGames + 0.0)));
		}



		public void setAver_teamFTGTry(double aver_teamFTGTry) {
			this.aver_teamFTGTry = aver_teamFTGTry;
		}



		public double getAver_oppoFTGTry() {
			return Double.parseDouble(String.format("%.3f",(this.oppoFTGTry + 0.0) / (this.compGames + 0.0)));
		}



		public void setAver_oppoFTGTry(double aver_oppoFTGTry) {
			this.aver_oppoFTGTry = aver_oppoFTGTry;
		}



		public double getTeamFTGP() {
			return Double.parseDouble(String.format("%.3f",(this.teamFTG + 0.0) / (this.compGames + 0.0)));

		}



		public void setTeamFTGP(double teamFTGP) {
			this.teamFTGP = teamFTGP;
		}



		public double getOppoFTGP() {
			return Double.parseDouble(String.format("%.3f",(this.oppoFTG + 0.0) / (this.compGames + 0.0)));
		}



		public void setOppoFTGP(double oppoFTGP) {
			this.oppoFTGP = oppoFTGP;
		}



		public double getAver_teamOffenceRebounds() {
			return Double.parseDouble(String.format("%.3f",(this.teamOffenceRebounds + 0.0) / (this.compGames + 0.0)));
		}



		public void setAver_teamOffenceRebounds(double aver_teamOffenceRebounds) {
			this.aver_teamOffenceRebounds = aver_teamOffenceRebounds;
		}



		public double getAver_oppoOffenceRebounds() {
			return Double.parseDouble(String.format("%.3f",(this.oppoOffenceRebounds + 0.0) / (this.compGames + 0.0)));

		}



		public void setAver_oppoOffenceRebounds(double aver_oppoOffenceRebounds) {
			this.aver_oppoOffenceRebounds = aver_oppoOffenceRebounds;
		}



		public double getAver_teamDeffenceRebounds() {
			return Double.parseDouble(String.format("%.3f",(this.teamDeffenceRebounds + 0.0) / (this.compGames + 0.0)));

		}



		public void setAver_teamDeffenceRebounds(double aver_teamDeffenceRebounds) {
			this.aver_teamDeffenceRebounds = aver_teamDeffenceRebounds;
		}



		public double getAver_oppoDeffenceRebounds() {
			return Double.parseDouble(String.format("%.3f",(this.oppoDeffenceRebounds + 0.0) / (this.compGames + 0.0)));

		}



		public void setAver_oppoDeffenceRebounds(double aver_oppoDeffenceRebounds) {
			this.aver_oppoDeffenceRebounds = aver_oppoDeffenceRebounds;
		}



		public double getAver_teamTotalRebounds() {
			return Double.parseDouble(String.format("%.3f",(this.teamTotalRebounds + 0.0) / (this.compGames + 0.0)));

		}



		public void setAver_teamTotalRebounds(double aver_teamTotalRebounds) {
			this.aver_teamTotalRebounds = aver_teamTotalRebounds;
		}



		public double getAver_oppoTotalRebounds() {
			return Double.parseDouble(String.format("%.3f",(this.oppoTotalRebounds + 0.0) / (this.compGames + 0.0)));

		}



		public void setAver_oppoTotalRebounds(double aver_oppoTotalRebounds) {
			this.aver_oppoTotalRebounds = aver_oppoTotalRebounds;
		}



		public double getAver_teamSteals() {
			return Double.parseDouble(String.format("%.3f",(this.teamSteals + 0.0) / (this.compGames + 0.0)));

		}



		public void setAver_teamSteals(double aver_teamSteals) {
			this.aver_teamSteals = aver_teamSteals;
		}



		public double getAver_oppoSteals() {
			return Double.parseDouble(String.format("%.3f",(this.oppoSteals + 0.0) / (this.compGames + 0.0)));

		}



		public void setAver_oppoSteals(double aver_oppoSteals) {
			this.aver_oppoSteals = aver_oppoSteals;
		}



		public double getAver_teamBlocks() {
			return Double.parseDouble(String.format("%.3f",(this.teamBlocks + 0.0) / (this.compGames + 0.0)));

		}



		public void setAver_teamBlocks(double aver_teamBlocks) {
			this.aver_teamBlocks = aver_teamBlocks;
		}



		public double getAver_oppoBlocks() {
			return Double.parseDouble(String.format("%.3f",(this.oppoBlocks + 0.0) / (this.compGames + 0.0)));
		}



		public void setAver_oppoBlocks(double aver_oppoBlocks) {
			this.aver_oppoBlocks = aver_oppoBlocks;
		}



		public double getAver_teamTurnovers() {
			return Double.parseDouble(String.format("%.3f",(this.teamTurnovers + 0.0) / (this.compGames + 0.0)));

		}



		public void setAver_teamTurnovers(double aver_teamTurnovers) {
			this.aver_teamTurnovers = aver_teamTurnovers;
		}



		public double getAver_oppoTurnovers() {
			return Double.parseDouble(String.format("%.3f",(this.oppoTurnovers + 0.0) / (this.compGames + 0.0)));

		}



		public void setAver_oppoTurnovers(double aver_oppoTurnovers) {
			this.aver_oppoTurnovers = aver_oppoTurnovers;
		}



		public double getAver_teamFouls() {
			return Double.parseDouble(String.format("%.3f",(this.teamFouls + 0.0) / (this.compGames + 0.0)));

		}



		public void setAver_teamFouls(double aver_teamFouls) {
			this.aver_teamFouls = aver_teamFouls;
		}



		public double getAver_oppoFouls() {
			return Double.parseDouble(String.format("%.3f",(this.oppoFouls + 0.0) / (this.compGames + 0.0)));

		}



		public void setAver_oppoFouls(double aver_oppoFouls) {
			this.aver_oppoFouls = aver_oppoFouls;
		}



		public double getAver_teamScores() {
			return Double.parseDouble(String.format("%.3f",(this.teamScores + 0.0) / (this.compGames + 0.0)));

		}



		public void setAver_teamScores(double aver_teamScores) {
			this.aver_teamScores = aver_teamScores;
		}



		public double getAver_oppoScores() {
			return Double.parseDouble(String.format("%.3f",(this.oppoScores + 0.0) / (this.compGames + 0.0)));

		}



		public void setAver_oppoScores(double aver_oppoScores) {
			this.aver_oppoScores = aver_oppoScores;
		}



		public double getTeamOffE() {
			return Double.parseDouble(String.format("%.3f",teamScores/attackRounds*100));
		}



		public void setTeamOffE(double teamOffE) {
			this.teamOffE = teamOffE;
		}



		public double getTeamDefE() {
			return Double.parseDouble(String.format("%.3f",oppoScores/oppoattackRounds*100));

		}



		public void setTeamDefE(double teamDefE) {
			this.teamDefE = teamDefE;
		}



		public double getTeamOffERebE() {
			return teamOffenceRebounds/(teamOffenceRebounds+oppoDeffenceRebounds);
		}



		public void setTeamOffERebE(double teamOffERebE) {
			this.teamOffERebE = teamOffERebE;
		}



		public double getTeamDefERebE() {
			try{
			return teamDeffenceRebounds/(teamDeffenceRebounds+oppoOffenceRebounds);
			}catch(Exception e){
				return 0;
			}

		}



		public void setTeamDefERebE(double teamDefERebE) {
			this.teamDefERebE = teamDefERebE;
		}



		public double getTeamSteE() {
			return Double.parseDouble(String.format("%.3f",teamSteals/oppoattackRounds*100));

		}



		public void setTeamSteE(double teamSteE) {
			this.teamSteE = teamSteE;
		}



		public double getTeamAssE() {
			return Double.parseDouble(String.format("%.3f",teamAssists/attackRounds*100));

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
			attendmatches=teampo.getAttendmatches();
		
			//bonus项值得传递
			winLose=teampo.getWinLose();
			win_lose=teampo.getWin_lose();
			home=teampo.getHome();
			guest=teampo.getGuest();
			recent10=teampo.getRecent10();
			recent10_Home=teampo.getRecent10_Home();
			recent10_Guest=teampo.getRecent10_Guest();
			//lianxu_win=teampo.getl();
		    //lianxu_win_Home;
			//lianxu_win_Guest;
			lianxu=teampo.getLianxu();
		    lianxu_Home=teampo.getLianxu_Home();
			lianxu_Guest=teampo.getLianxu_Guest();
			longestWin=teampo.getLongestWin();
		    longestLose=teampo.getLongestLose();
			lessThan3Points=teampo.getLessThan3Points();//3分之内胜负场
		    moreThan10Points=teampo.getMoreThan10Points();//10分以上胜负关系
			
            myTeamMoreThan100=teampo.getMyTeamMoreThan100();//本队得分上100时的胜负关系
		    oppoTeamMoreThan100=teampo.getOppoTeamMoreThan100();//对手得分上100时的胜负关系
			oppoIsStrong=teampo.getOppoIsStrong();//对手胜率50%时的胜负关系
			MoreFGP=teampo.getMoreFGP();//命中率领先
			MoreRebounds=teampo.getMoreRebounds();//篮板领先
			LessTurnovers=teampo.getLessTurnovers();//更少失误时的胜负关系
		    banchanglingxian=teampo.getBanchanglingxian();//半场领先
			banchangluohou=teampo.getBanchangluohou();//半场落后
		}
		
		public TeamVO createTeamVO(){
			TeamVO vo = new TeamVO();
			vo.creatteamvo(this);
			//System.out.println("tt"+vo.getCompGames());
			return vo;
		}


		public boolean getisEast() {
			return isEast;
		}

		public ArrayList<Integer> getAttendmatches() {
			return attendmatches;
		}
        public void addAttendmatches(int matchnum){
        	attendmatches.add(matchnum);
        }
		
		public double getWinLose() {
			return winLose;
		}
		public void setWinLose(double winLose) {
			this.winLose = winLose;
		}
		public win_lose getRecent10() {
			return recent10;
		}
		public void setRecent10(win_lose recent10) {
			this.recent10 = recent10;
		}
		public win_lose getRecent10_Home() {
			return recent10_Home;
		}
		public void setRecent10_Home(win_lose recent10_Home) {
			this.recent10_Home = recent10_Home;
		}
		public win_lose getRecent10_Guest() {
			return recent10_Guest;
		}
		public void setRecent10_Guest(win_lose recent10_Guest) {
			this.recent10_Guest = recent10_Guest;
		}
		public boolean isLianxu_win() {
			return lianxu_win;
		}
		public void setLianxu_win(boolean lianxu_win) {
			this.lianxu_win = lianxu_win;
		}
		public boolean isLianxu_win_Home() {
			return lianxu_win_Home;
		}
		public void setLianxu_win_Home(boolean lianxu_win_Home) {
			this.lianxu_win_Home = lianxu_win_Home;
		}
		public boolean isLianxu_win_Guest() {
			return lianxu_win_Guest;
		}
		public void setLianxu_win_Guest(boolean lianxu_win_Guest) {
			this.lianxu_win_Guest = lianxu_win_Guest;
		}
		public int getLianxu() {
			return lianxu;
		}
		public void setLianxu(int lianxu) {
			this.lianxu = lianxu;
		}
		public int getLianxu_Home() {
			return lianxu_Home;
		}
		public void setLianxu_Home(int lianxu_Home) {
			this.lianxu_Home = lianxu_Home;
		}
		public int getLianxu_Guest() {
			return lianxu_Guest;
		}
		public void setLianxu_Guest(int lianxu_Guest) {
			this.lianxu_Guest = lianxu_Guest;
		}
		public int getLongestWin() {
			return longestWin;
		}
		public void setLongestWin(int longestWin) {
			this.longestWin = longestWin;
		}
		public int getLongestLose() {
			return longestLose;
		}
		public void setLongestLose(int longestLose) {
			this.longestLose = longestLose;
		}
		public win_lose getMoreThan10Points() {
			return moreThan10Points;
		}
		public void setMoreThan10Points(win_lose moreThan10Points) {
			this.moreThan10Points = moreThan10Points;
		}
		public win_lose getMyTeamMoreThan100() {
			return myTeamMoreThan100;
		}
		public void setMyTeamMoreThan100(win_lose myTeamMoreThan100) {
			this.myTeamMoreThan100 = myTeamMoreThan100;
		}
		public win_lose getOppoTeamMoreThan100() {
			return oppoTeamMoreThan100;
		}
		public void addwinOppoTeamMoreThan100() {
			this.oppoTeamMoreThan100.addWin();
		}
		public void addloseOppoTeamMoreThan100() {
			this.oppoTeamMoreThan100.addLose();
		}
		public win_lose getOppoIsStrong() {
			return oppoIsStrong;
		}
		public void setOppoIsStrong(win_lose oppoIsStrong) {
			this.oppoIsStrong = oppoIsStrong;
		}
		public win_lose getMoreFGP() {
			return MoreFGP;
		}
		public void setMoreFGP(win_lose moreFGP) {
			MoreFGP = moreFGP;
		}
		public win_lose getMoreRebounds() {
			return MoreRebounds;
		}
		public void setMoreRebounds(win_lose moreRebounds) {
			MoreRebounds = moreRebounds;
		}
		public win_lose getLessTurnovers() {
			return LessTurnovers;
		}
		public void setLessTurnovers(win_lose moreTurnovers) {
			LessTurnovers = moreTurnovers;
		}
		public win_lose getSanjielinxian() {
			return sanjielinxian;
		}
		public void setSanjielinxian(win_lose sanjielinxian) {
			this.sanjielinxian = sanjielinxian;
		}
		public win_lose getSanjieluohou() {
			return sanjieluohou;
		}
		public void setSanjieluohou(win_lose sanjieluohou) {
			this.sanjieluohou = sanjieluohou;
		}
		public win_lose getLessThan3Points() {
			return lessThan3Points;
		}
		public void setLessThan3Points(win_lose lessThan3Points) {
			this.lessThan3Points = lessThan3Points;
		}
		public win_lose getBanchanglingxian() {
			return banchanglingxian;
		}
		public void setBanchanglingxian(win_lose banchanglingxian) {
			this.banchanglingxian = banchanglingxian;
		}
		public win_lose getBanchangluohou() {
			return banchangluohou;
		}
		public void setBanchangluohou(win_lose banchangluohou) {
			this.banchangluohou = banchangluohou;
		}
		public win_lose getHome() {
			return home;
		}
		public void setHome(win_lose home) {
			this.home = home;
		}
		public win_lose getGuest() {
			return guest;
		}
		public void setGuest(win_lose guest) {
			this.guest = guest;
		}

		public win_lose getWin_lose() {
			return win_lose;
		}

		public void setWin_lose(win_lose win_lose) {
			this.win_lose = win_lose;
		}

		public void setOppoTeamMoreThan100(win_lose oppoTeamMoreThan100) {
			this.oppoTeamMoreThan100 = oppoTeamMoreThan100;
		}

		public void setAttendmatches(ArrayList<Integer> attendmatches) {
			this.attendmatches = attendmatches;
		}
			
}
