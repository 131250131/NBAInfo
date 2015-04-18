package vo;

import java.util.ArrayList;



public class MatchVO {
	int Num;//比赛场次的编号，从零开始，
	String season;
	String date;
	TeamVO leftTeam;
	TeamVO rightTeam;
	String score;
	ArrayList<PlayerVO> playerlist=new ArrayList<PlayerVO>();
//每一节的具体得分；
	String scores1;
	String scores2;
	String scores3;
	String scores4;
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public TeamVO getLeftTeam() {
		return leftTeam;
	}
	public void setLeftTeam(TeamVO leftTeam) {
		this.leftTeam = leftTeam;
	}
	public TeamVO getRightTeam() {
		return rightTeam;
	}
	public void setRightTeam(TeamVO rightTeam) {
		this.rightTeam = rightTeam;
	}
	public String getScores1() {
		return scores1;
	}
	public void setScores1(String scores1) {
		this.scores1 = scores1;
	}
	public String getScores2() {
		return scores2;
	}
	public void setScores2(String scores2) {
		this.scores2 = scores2;
	}
	public String getScores3() {
		return scores3;
	}
	public void setScores3(String scores3) {
		this.scores3 = scores3;
	}
	public String getScores4() {
		return scores4;
	}
	public void setScores4(String scores4) {
		this.scores4 = scores4;
	}
	public void addplayer(PlayerVO player){
		playerlist.add(player);
	}
	public void setScore(String score){
		this.score=score;
	}
	public String getScore(){
		return this.score;
	}
}
