package thirdVersion;

import java.util.ArrayList;

public class MatchVO {
	String matchID;
	String date;//比赛日期.time
	String leftTeamName;
	String rightTeamName;
	String firstScore;
	String secondScore;
	String thirdScore;
	String forthScore;
	String exttaScore;
	String totalScore;
	int isplayoff;
	String season;
	ArrayList<PlayerMatchDataVO> pdate=new ArrayList<PlayerMatchDataVO>();
	ArrayList<TeamMatchDataVO> tdate=new ArrayList<TeamMatchDataVO>();
	public String getMatchID() {
		return matchID;
	}
	
	public void setMatchID(String matchID) {
		this.matchID = matchID;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getLeftTeamName() {
		return leftTeamName;
	}
	
	public void setLeftTeamName(String leftTeamName) {
		this.leftTeamName = leftTeamName;
	}
	
	public String getRightTeamName() {
		return rightTeamName;
	}
	
	public void setRightTeamName(String rightTeamName) {
		this.rightTeamName = rightTeamName;
	}
	
	public String getFirstScore() {
		return firstScore;
	}
	
	public void setFirstScore(String firstScore) {
		this.firstScore = firstScore;
	}
	
	public String getSecondScore() {
		return secondScore;
	}
	
	public void setSecondScore(String secondScore) {
		this.secondScore = secondScore;
	}
	
	public String getThirdScore() {
		return thirdScore;
	}
	
	public void setThirdScore(String thirdScore) {
		this.thirdScore = thirdScore;
	}
	
	public String getForthScore() {
		return forthScore;
	}
	
	public void setForthScore(String forthScore) {
		this.forthScore = forthScore;
	}
	
	public String getExttaScore() {
		return exttaScore;
	}
	public void setExttaScore(String exttaScore) {
		this.exttaScore = exttaScore;
	}
	
	public String getTotalScore() {
		return totalScore;
	}
	
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}

	public ArrayList<PlayerMatchDataVO> getPdate() {
		return pdate;
	}

	public void addPdate(PlayerMatchDataVO pdate) {
		this.pdate.add(pdate);
	}

	public ArrayList<TeamMatchDataVO> getTdate() {
		return tdate;
	}

	public void addTdate(TeamMatchDataVO tdate) {
		this.tdate.add(tdate);
	}

	public int getIsplayoff() {
		return isplayoff;
	}

	public void setIsplayoff(int isplayoff) {
		this.isplayoff = isplayoff;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public void setPdate(ArrayList<PlayerMatchDataVO> pdate) {
		this.pdate = pdate;
	}

	public void setTdate(ArrayList<TeamMatchDataVO> tdate) {
		this.tdate = tdate;
	}
	
	
	
}
