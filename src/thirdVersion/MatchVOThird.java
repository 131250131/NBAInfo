package thirdVersion;

import java.util.ArrayList;

public class MatchVOThird {
	String matchID;
	String date;//比赛日期.time
	String leftTeamName;
	String rightTeamName;
	String firstScore;
	String secondScore;
	String thirdScore;
	String forthScore;
	String extraScore;
	String totalScore;
	int isplayoff;
	String season;
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
	
	public String getExtraScore() {
		return extraScore;
	}
	public void setExtraScore(String extraScore) {
		this.extraScore = extraScore;
	}
	
	public String getTotalScore() {
		return totalScore;
	}
	
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
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

	
	public void setTdate(ArrayList<TeamMatchDataVO> tdate) {
		this.tdate = tdate;
	}
	
	public void addExtraScore(String s){
		String[] news=s.split("-");
		String[] olds=s.split("-");
		double left=Double.parseDouble(news[0]);
		double right=Double.parseDouble(news[1]);
		double oleft=Double.parseDouble(olds[0]);
		double oright=Double.parseDouble(olds[1]);
		extraScore=String.valueOf(left+oleft)+"-"+String.valueOf(right+oright);
	}
	
	
}
