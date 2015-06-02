package thirdVersion;

public class PlayerMatchDataVO {
	String matchID;
	String playerID;
	String playerName;
	String time;
	double FGP;
	int FGZ;
	int FG;
	double ThreeFGP;
	int ThreeFGZ;
	int ThreeFG;
	double FTGP;
	int FTGZ;
	int FTG;
	double realShootRate;
	int Rebounds;
	int ORebounds;
	int DRebounds;
	int assists;
	int steals;
	int blocks;
	int turnovers;
	int fouls;
	int Scores;
	boolean isFirst;//是否首发
	
	public String getMatchID() {
		return matchID;
	}
	public void setMatchID(String matchID) {
		this.matchID = matchID;
	}
	public String getPlayerID() {
		return playerID;
	}
	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	public boolean isFirst() {
		return isFirst;
	}
	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}
	
	
	
}
