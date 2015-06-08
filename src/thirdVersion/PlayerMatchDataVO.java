package thirdVersion;

public class PlayerMatchDataVO {
	String matchID;
	String playerID;
	String playerName;
	double time;
	double FGP;
	double FGZ;
	double FG;
	double SFGP;
	double SFGZ;
	double SFG;
	double FTGP;
	double FTGZ;
	double FTG;
	double realShootRate;
	double Rebounds;
	double ORebounds;
	double DRebounds;
	double assists;
	double steals;
	double blocks;
	double turnovers;
	double fouls;
	double Scores;
	boolean isFirst;//是否首发
	
	
	
	private String Englishname;//仅仅用于直播查找(因为没有id)
	
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
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public double getFGP() {
		return FGP;
	}
	public void setFGP(double fGP) {
		FGP = fGP;
	}
	public double getFGZ() {
		return FGZ;
	}
	public void setFGZ(double fGZ) {
		FGZ = fGZ;
	}
	public double getFG() {
		return FG;
	}
	public void setFG(double fG) {
		FG = fG;
	}
	public double getSFGP() {
		return SFGP;
	}
	public void setSFGP(double threeFGP) {
		SFGP = threeFGP;
	}
	public double getSFGZ() {
		return SFGZ;
	}
	public void setSFGZ(double threeFGZ) {
		SFGZ = threeFGZ;
	}
	public double getSFG() {
		return SFG;
	}
	public void setSFG(double threeFG) {
		SFG = threeFG;
	}
	public double getFTGP() {
		return FTGP;
	}
	public void setFTGP(double fTGP) {
		FTGP = fTGP;
	}
	public double getFTGZ() {
		return FTGZ;
	}
	public void setFTGZ(double fTGZ) {
		FTGZ = fTGZ;
	}
	public double getFTG() {
		return FTG;
	}
	public void setFTG(double fTG) {
		FTG = fTG;
	}
	public double getRealShootRate() {
		return realShootRate;
	}
	public void setRealShootRate(double realShootRate) {
		this.realShootRate = realShootRate;
	}
	public double getRebounds() {
		return Rebounds;
	}
	public void setRebounds(double rebounds) {
		Rebounds = rebounds;
	}
	public double getORebounds() {
		return ORebounds;
	}
	public void setORebounds(double oRebounds) {
		ORebounds = oRebounds;
	}
	public double getDRebounds() {
		return DRebounds;
	}
	public void setDRebounds(double dRebounds) {
		DRebounds = dRebounds;
	}
	public double getAssists() {
		return assists;
	}
	public void setAssists(double assists) {
		this.assists = assists;
	}
	public double getSteals() {
		return steals;
	}
	public void setSteals(double steals) {
		this.steals = steals;
	}
	public double getBlocks() {
		return blocks;
	}
	public void setBlocks(double blocks) {
		this.blocks = blocks;
	}
	public double getTurnovers() {
		return turnovers;
	}
	public void setTurnovers(double turnovers) {
		this.turnovers = turnovers;
	}
	public double getFouls() {
		return fouls;
	}
	public void setFouls(double fouls) {
		this.fouls = fouls;
	}
	public double getScores() {
		return Scores;
	}
	public void setScores(double scores) {
		Scores = scores;
	}
	public boolean isFirst() {
		return isFirst;
	}
	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}
	public String getEnglishname() {
		return Englishname;
	}
	public void setEnglishname(String englishname) {
		Englishname = englishname;
	}
	
	
	
}
