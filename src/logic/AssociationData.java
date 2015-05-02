package logic;

import java.sql.Date;
import java.util.ArrayList;

public class AssociationData {
	//联盟数据;
	//所有有比赛的日期;
	ArrayList<Date> dateList = new ArrayList<Date>();
		
	//联盟球员平均数据;
	private double aver_playerAssists ;//队员平均助攻数
	private double aver_playerPlayTime  ;//	队员平均在场时间
	private double aver_playerFG  ;//队员平均投篮命中数
	private double aver_playerFGTry ;//队员平均投篮出手数
	private double aver_player3FG ;//队员平均三分命中数
	private double aver_player3FGTry ;//队员平均三分出手数
	private double aver_playerFTG ;//队员平均罚球命中数
	private double aver_playerFTGTry ;//队员平均罚球出手数
	private double aver_playerOffenceRebounds ;//队员平均进攻篮板数
	private double aver_playerDeffenceRebounds ;//队员平均防守篮板数
	private double aver_playerTotalRebounds ;//队员平均总篮板数
	private double aver_playerSteals ;//队员平均抢断数
	private double aver_playerBlocks ;//队员平均盖帽数
	private double aver_playerTurnovers ;//队员平均失误数
	private double aver_playerFouls ;//队员平均犯规数
	private double aver_playerScores ;//队员平均得分
	private double playerFGP ;//队员投篮命中率
	private double player3FGP ;//队员三分命中率
	private double playerFTGP ;//队员罚球命中率	
	private double playerPER ;//队员效率(PER)
	private double playerGmScER ;//队员GmSc效率值
	private double playerTSP ;//队员真实命中率
	private double playerSER ;//队员投篮效率
		
	//联盟球队平均数据;
	private double aver_teamAssists;	//球队场均助攻数
	private double aver_teamFG ;//球队场均投篮命中数
	private double aver_teamFGTry ;//球队场均投篮出手次数
	private double teamFGP;//球队投篮命中率
	private double aver_team3FG;//球队场均三分命中数
	private double aver_team3FGTry;//球队场均三分出手次数
	private double team3FGP; //球队三分命中率
	private double aver_teamFTG;//球队场均罚球命中数
	private double aver_teamFTGTry;//球队场均罚球出手数
	private double teamFTGP; //罚球命中率	
	private double aver_teamOffenceRebounds;//球队场均进攻篮板数
	private double aver_teamDeffenceRebounds;//球队场均防守篮板数
	private double aver_teamTotalRebounds;//球队场均总篮板
	private double aver_teamSteals;//球队场均抢断数
	private double aver_teamBlocks;//球队场均盖帽数
	private double aver_teamTurnovers;//球队场均失误
	private double aver_teamFouls;//球队场均犯规数
	private double aver_teamScores;//球队场均总得分数
	
	public void addDataList(Date date){
		int size = this.dateList.size();
		if(!(size==0)){
			Date lastDate = this.dateList.get(size-1);
			if(!date.equals(lastDate)){
				this.dateList.add(date);
			}
		}else{
			this.dateList.add(date);
		}
	}
	
	public void setDateList(ArrayList<Date> allDates){
		this.dateList=allDates;
	}
	
	public ArrayList<Date> getDateList() {
		return dateList;
	}		

	public double getAver_playerAssists() {
		return aver_playerAssists;
	}

	public void setAver_playerAssists(double aver_playerAssists) {
		this.aver_playerAssists = aver_playerAssists;
	}

	public double getAver_playerPlayTime() {
		return aver_playerPlayTime;
	}

	public void setAver_playerPlayTime(double aver_playerPlayTime) {
		this.aver_playerPlayTime = aver_playerPlayTime;
	}

	public double getAver_playerFG() {
		return aver_playerFG;
	}

	public void setAver_playerFG(double aver_playerFG) {
		this.aver_playerFG = aver_playerFG;
	}

	public double getAver_playerFGTry() {
		return aver_playerFGTry;
	}

	public void setAver_playerFGTry(double aver_playerFGTry) {
		this.aver_playerFGTry = aver_playerFGTry;
	}

	public double getAver_player3FG() {
		return aver_player3FG;
	}

	public void setAver_player3FG(double aver_player3FG) {
		this.aver_player3FG = aver_player3FG;
	}

	public double getAver_player3FGTry() {
		return aver_player3FGTry;
	}

	public void setAver_player3FGTry(double aver_player3FGTry) {
		this.aver_player3FGTry = aver_player3FGTry;
	}

	public double getAver_playerFTG() {
		return aver_playerFTG;
	}

	public void setAver_playerFTG(double aver_playerFTG) {
		this.aver_playerFTG = aver_playerFTG;
	}

	public double getAver_playerFTGTry() {
		return aver_playerFTGTry;
	}

	public void setAver_playerFTGTry(double aver_playerFTGTry) {
		this.aver_playerFTGTry = aver_playerFTGTry;
	}

	public double getAver_playerOffenceRebounds() {
		return aver_playerOffenceRebounds;
	}

	public void setAver_playerOffenceRebounds(double aver_playerOffenceRebounds) {
		this.aver_playerOffenceRebounds = aver_playerOffenceRebounds;
	}

	public double getAver_playerDeffenceRebounds() {
		return aver_playerDeffenceRebounds;
	}

	public void setAver_playerDeffenceRebounds(double aver_playerDeffenceRebounds) {
		this.aver_playerDeffenceRebounds = aver_playerDeffenceRebounds;
	}

	public double getAver_playerTotalRebounds() {
		return aver_playerTotalRebounds;
	}

	public void setAver_playerTotalRebounds(double aver_playerTotalRebounds) {
		this.aver_playerTotalRebounds = aver_playerTotalRebounds;
	}

	public double getAver_playerSteals() {
		return aver_playerSteals;
	}

	public void setAver_playerSteals(double aver_playerSteals) {
		this.aver_playerSteals = aver_playerSteals;
	}

	public double getAver_playerBlocks() {
		return aver_playerBlocks;
	}

	public void setAver_playerBlocks(double aver_playerBlocks) {
		this.aver_playerBlocks = aver_playerBlocks;
	}

	public double getAver_playerTurnovers() {
		return aver_playerTurnovers;
	}

	public void setAver_playerTurnovers(double aver_playerTurnovers) {
		this.aver_playerTurnovers = aver_playerTurnovers;
	}

	public double getAver_playerFouls() {
		return aver_playerFouls;
	}

	public void setAver_playerFouls(double aver_playerFouls) {
		this.aver_playerFouls = aver_playerFouls;
	}

	public double getAver_playerScores() {
		return aver_playerScores;
	}

	public void setAver_playerScores(double aver_playerScores) {
		this.aver_playerScores = aver_playerScores;
	}

	public double getPlayerFGP() {
		return playerFGP;
	}

	public void setPlayerFGP(double playerFGP) {
		this.playerFGP = playerFGP;
	}

	public double getPlayer3FGP() {
		return player3FGP;
	}

	public void setPlayer3FGP(double player3fgp) {
		player3FGP = player3fgp;
	}

	public double getPlayerFTGP() {
		return playerFTGP;
	}

	public void setPlayerFTGP(double playerFTGP) {
		this.playerFTGP = playerFTGP;
	}

	public double getPlayerPER() {
		return playerPER;
	}

	public void setPlayerPER(double playerPER) {
		this.playerPER = playerPER;
	}

	public double getPlayerGmScER() {
		return playerGmScER;
	}

	public void setPlayerGmScER(double playerGmScER) {
		this.playerGmScER = playerGmScER;
	}

	public double getPlayerTSP() {
		return playerTSP;
	}

	public void setPlayerTSP(double playerTSP) {
		this.playerTSP = playerTSP;
	}

	public double getPlayerSER() {
		return playerSER;
	}

	public void setPlayerSER(double playerSER) {
		this.playerSER = playerSER;
	}

	public double getAver_teamAssists() {
		return aver_teamAssists;
	}

	public void setAver_teamAssists(double aver_teamAssists) {
		this.aver_teamAssists = aver_teamAssists;
	}

	public double getAver_teamFG() {
		return aver_teamFG;
	}

	public void setAver_teamFG(double aver_teamFG) {
		this.aver_teamFG = aver_teamFG;
	}

	public double getAver_teamFGTry() {
		return aver_teamFGTry;
	}

	public void setAver_teamFGTry(double aver_teamFGTry) {
		this.aver_teamFGTry = aver_teamFGTry;
	}

	public double getTeamFGP() {
		return teamFGP;
	}

	public void setTeamFGP(double teamFGP) {
		this.teamFGP = teamFGP;
	}

	public double getAver_team3FG() {
		return aver_team3FG;
	}

	public void setAver_team3FG(double aver_team3FG) {
		this.aver_team3FG = aver_team3FG;
	}

	public double getAver_team3FGTry() {
		return aver_team3FGTry;
	}

	public void setAver_team3FGTry(double aver_team3FGTry) {
		this.aver_team3FGTry = aver_team3FGTry;
	}

	public double getTeam3FGP() {
		return team3FGP;
	}

	public void setTeam3FGP(double team3fgp) {
		team3FGP = team3fgp;
	}

	public double getAver_teamFTG() {
		return aver_teamFTG;
	}

	public void setAver_teamFTG(double aver_teamFTG) {
		this.aver_teamFTG = aver_teamFTG;
	}

	public double getAver_teamFTGTry() {
		return aver_teamFTGTry;
	}

	public void setAver_teamFTGTry(double aver_teamFTGTry) {
		this.aver_teamFTGTry = aver_teamFTGTry;
	}

	public double getTeamFTGP() {
		return teamFTGP;
	}

	public void setTeamFTGP(double teamFTGP) {
		this.teamFTGP = teamFTGP;
	}

	public double getAver_teamOffenceRebounds() {
		return aver_teamOffenceRebounds;
	}

	public void setAver_teamOffenceRebounds(double aver_teamOffenceRebounds) {
		this.aver_teamOffenceRebounds = aver_teamOffenceRebounds;
	}

	public double getAver_teamDeffenceRebounds() {
		return aver_teamDeffenceRebounds;
	}

	public void setAver_teamDeffenceRebounds(double aver_teamDeffenceRebounds) {
		this.aver_teamDeffenceRebounds = aver_teamDeffenceRebounds;
	}

	public double getAver_teamTotalRebounds() {
		return aver_teamTotalRebounds;
	}

	public void setAver_teamTotalRebounds(double aver_teamTotalRebounds) {
		this.aver_teamTotalRebounds = aver_teamTotalRebounds;
	}

	public double getAver_teamSteals() {
		return aver_teamSteals;
	}

	public void setAver_teamSteals(double aver_teamSteals) {
		this.aver_teamSteals = aver_teamSteals;
	}

	public double getAver_teamBlocks() {
		return aver_teamBlocks;
	}

	public void setAver_teamBlocks(double aver_teamBlocks) {
		this.aver_teamBlocks = aver_teamBlocks;
	}

	public double getAver_teamTurnovers() {
		return aver_teamTurnovers;
	}

	public void setAver_teamTurnovers(double aver_teamTurnovers) {
		this.aver_teamTurnovers = aver_teamTurnovers;
	}

	public double getAver_teamFouls() {
		return aver_teamFouls;
	}

	public void setAver_teamFouls(double aver_teamFouls) {
		this.aver_teamFouls = aver_teamFouls;
	}

	public double getAver_teamScores() {
		return aver_teamScores;
	}

	public void setAver_teamScores(double aver_teamScores) {
		this.aver_teamScores = aver_teamScores;
	}

	
		
	
		
}
