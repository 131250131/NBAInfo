package po;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class MatchPO implements Serializable {
		int Num;//比赛场次的编号，从零开始，
		String season;
		String date;
		TeamPO leftTeam;
		TeamPO rightTeam;
		String score;
		String winteamname="";
		ArrayList<PlayerPO> leftplayerlist=new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> rightplayerlist=new ArrayList<PlayerPO>();
	//每一节的具体得分；
		String scores1;
		String scores2;
		String scores3;
		String scores4;
		String extrascores;//用于记载加时数据
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
		public TeamPO getLeftTeam() {
			return leftTeam;
		}
		public String getScore(){
			return score;
		}
		public void setLeftTeam(TeamPO leftTeam) {
			this.leftTeam = leftTeam;
		}
		public TeamPO getRightTeam() {
			return rightTeam;
		}
		public void setRightTeam(TeamPO rightTeam) {
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
		public void addleftplayer(PlayerPO player){
			leftplayerlist.add(player);
		}
		public ArrayList<PlayerPO> getleftplayers(){
			return leftplayerlist;
		}
		public void addrightplayer(PlayerPO player){
			rightplayerlist.add(player);
		}
		public ArrayList<PlayerPO> getrightplayers(){
			return rightplayerlist;
		}
		public void setScore(String score){
			this.score=score;
		}
		public void setExtrascores(String extras){
			this.extrascores=extras;
		}
		public String getExtrascores(){
			return extrascores;
		}
/*
 * 我还有一个问题，加时的比分算不算在里面;
 * */
		public String getWinteamname() {
			return winteamname;
		}
		public void setWinteamname(String winteamname) {
			this.winteamname = winteamname;
		}
		
}
