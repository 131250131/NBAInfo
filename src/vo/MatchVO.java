package vo;

import java.util.ArrayList;

import po.PlayerPO;
import logic.Match;
import logic.Player;
import logic.Team;


public class MatchVO {
	int Num;//比赛场次的编号，从零开始，
	String season;
	String date;
	TeamVO leftTeam;
	TeamVO rightTeam;
	String winteamname="";
	String score;
	ArrayList<PlayerVO> leftplayerlist=new ArrayList<PlayerVO>();
	ArrayList<PlayerVO> rightplayerlist=new ArrayList<PlayerVO>();
	String detaildate="";
//每一节的具体得分；
	String scores1;
	String scores2;
	String scores3;
	String scores4;
	String extrascores;

	public ArrayList<PlayerVO> getLeftplayerlist() {
		return leftplayerlist;
	}
	public void setLeftplayerlist(ArrayList<PlayerVO> leftplayerlist) {
		this.leftplayerlist = leftplayerlist;
	}
	public ArrayList<PlayerVO> getRightplayerlist() {
		return rightplayerlist;
	}
	public void setRightplayerlist(ArrayList<PlayerVO> rightplayerlist) {
		this.rightplayerlist = rightplayerlist;
	}
	public String getExtrascores() {
		return extrascores;
	}
	public void setExtrascores(String extrascores) {
		this.extrascores = extrascores;
	}
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
	public void setScore(String score){
		this.score=score;
	}
	public void creatMatchvo(Match match){
	   Num=match.getNum();
 	   season=match.getSeason();
 	   date=match.getDate();
 	   TeamVO rteam=new TeamVO();
 	   TeamVO lteam=new TeamVO();
 	   rteam.creatteamvo(match.getRightTeam());
 	   lteam.creatteamvo(match.getLeftTeam());
 	   leftTeam=lteam;
 	   rightTeam=rteam;
 	   score=match.getScore();
 	   scores1=match.getScores1();
 	   scores2=match.getScores2();
 	   scores3=match.getScores3();
 	   scores4=match.getScores4();
 	   extrascores=match.getExtrascores();
 	   winteamname=match.getWinteamname();
 	   detaildate=match.getDetaildate();
 	   //System.out.println(detaildate);
 	   ArrayList<Player> lpl=match.getleftplayers();
 	   for(Player p:lpl){
 		   PlayerVO player=new PlayerVO();
 		   player.creatplayervo(p);
 		   leftplayerlist.add(player);
 	   }
 	   ArrayList<Player> rpl=match.getrightplayers();
 	   for(Player p:rpl){
 		   PlayerVO player=new PlayerVO();
 		   player.creatplayervo(p);
 		   rightplayerlist.add(player);
 	   }
	}
	public String getScore() {
		// TODO Auto-generated method stub
		return this.score;
	}
	public String getWinteamname() {
		return winteamname;
	}
	public void setWinteamname(String winteamname) {
		this.winteamname = winteamname;
	}
	public String getDetaildate() {
		return detaildate;
	}
	public void setDetaildate(String detaildate) {
		this.detaildate = detaildate;
	}
}
