package thirdVersion;

import java.util.ArrayList;

public class TeamMatchDataVO {
	//比赛ID
	String matchID;
	//球队中文名
	String teamChinsesName;
	//各项单场数据
	int isplayoff = -1;
	double FGP=0.0;
	int FGZ=0;
	int FG=0;
	double ThreeFGP=0.0;
	int ThreeFGZ=0;
	int ThreeFG=0;
	double FTGP=0.0;
	int FTGZ=0;
	int FTG=0;
	double realShootRate=0.0;
	int Rebounds=0;
	int ORebounds=0;
	int DRebounds=0;
	int assists=0;
	int steals=0;
	int blocks=0;
	int turnovers=0;
	int fouls=0;
	int Scores=0;
	private ArrayList<PlayerMatchDataVO> players=new ArrayList<PlayerMatchDataVO>();
	public String getMatchID() {
		return matchID;
	}
	public void setMatchID(String matchID) {
		this.matchID = matchID;
	}
	public String getTeamChinsesName() {
		return teamChinsesName;
	}
	public void setTeamChinsesName(String teamChinsesName) {
		this.teamChinsesName = teamChinsesName;
	}
	public double getFGP() {
		return FGP;
	}
	public void setFGP(double fGP) {
		FGP = fGP;
	}
	public int getFGZ() {
		return FGZ;
	}
	public void setFGZ(int fGZ) {
		FGZ = fGZ;
	}
	public int getFG() {
		return FG;
	}
	public void setFG(int fG) {
		FG = fG;
	}
	public double getThreeFGP() {
		return ThreeFGP;
	}
	public void setThreeFGP(double threeFGP) {
		ThreeFGP = threeFGP;
	}
	public int getThreeFGZ() {
		return ThreeFGZ;
	}
	public void setThreeFGZ(int threeFGZ) {
		ThreeFGZ = threeFGZ;
	}
	public int getThreeFG() {
		return ThreeFG;
	}
	public void setThreeFG(int threeFG) {
		ThreeFG = threeFG;
	}
	public double getFTGP() {
		return FTGP;
	}
	public void setFTGP(double fTGP) {
		FTGP = fTGP;
	}
	public int getFTGZ() {
		return FTGZ;
	}
	public void setFTGZ(int fTGZ) {
		FTGZ = fTGZ;
	}
	public int getFTG() {
		return FTG;
	}
	public void setFTG(int fTG) {
		FTG = fTG;
	}
	public double getRealShootRate() {
		return realShootRate;
	}
	public void setRealShootRate(double realShootRate) {
		this.realShootRate = realShootRate;
	}
	public int getRebounds() {
		return Rebounds;
	}
	public void setRebounds(int rebounds) {
		Rebounds = rebounds;
	}
	public int getORebounds() {
		return ORebounds;
	}
	public void setORebounds(int oRebounds) {
		ORebounds = oRebounds;
	}
	public int getDRebounds() {
		return DRebounds;
	}
	public void setDRebounds(int dRebounds) {
		DRebounds = dRebounds;
	}
	public int getAssists() {
		return assists;
	}
	public void setAssists(int assists) {
		this.assists = assists;
	}
	public int getSteals() {
		return steals;
	}
	public void setSteals(int steals) {
		this.steals = steals;
	}
	public int getBlocks() {
		return blocks;
	}
	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}
	public int getTurnovers() {
		return turnovers;
	}
	public void setTurnovers(int turnovers) {
		this.turnovers = turnovers;
	}
	public int getFouls() {
		return fouls;
	}
	public void setFouls(int fouls) {
		this.fouls = fouls;
	}
	public int getScores() {
		return Scores;
	}
	public void setScores(int scores) {
		Scores = scores;
	}
	public int getIsplayoff() {
		return isplayoff;
	}
	public void setIsplayoff(int isplayoff) {
		this.isplayoff = isplayoff;
	}
	public ArrayList<PlayerMatchDataVO> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<PlayerMatchDataVO> players) {
		this.players = players;
	}

	
}
