package logic;

import java.util.ArrayList;

import po.MatchPO;
import po.PlayerPO;
import po.TeamPO;
import vo.MatchVO;
import DataService.MatchDataService;

import data.matchdata.*;


public class Match {
	int Num;//比赛场次的编号，从零开始，
	String season;
	String date;
	Team leftTeam;
	Team rightTeam;
	String score;
	ArrayList<Player> leftplayerlist=new ArrayList<Player>();
	ArrayList<Player> rightplayerlist=new ArrayList<Player>();
//每一节的具体得分；
	String scores1;
	String scores2;
	String scores3;
	String scores4;
	String extrascores;
	public Match(int number ,String season,String date,Team leftTeam,Team rightTeam,String score,
			ArrayList<Player> leftplayerlist,ArrayList<Player> rightplayerlist,String scores1,String scores2,
			String scores3,String scores4,String extrascores){
		this.Num=number;
		this.season=season;
		this.date=date;
		this.leftTeam=leftTeam;
		this.rightTeam=rightTeam;
		this.score=score;
		this.leftplayerlist=leftplayerlist;
		this.rightplayerlist=rightplayerlist;
		this.scores1=scores1;
		this.scores2=scores2;
		this.scores3=scores3;
		this.scores4=scores4;
		this.extrascores=extrascores;
	}
	
	public Match() {
	}
	
	public void setExtrascores(String extras){
		this.extrascores=extras;
	}
	public String getExtrascores(){
		return extrascores;
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
	public Team getLeftTeam() {
		return leftTeam;
	}
	public void setLeftTeam(Team leftTeam) {
		this.leftTeam = leftTeam;
	}
	public Team getRightTeam() {
		return rightTeam;
	}
	public void setRightTeam(Team rightTeam) {
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
	public void addleftplayer(Player player){
		leftplayerlist.add(player);
	}
	public ArrayList<Player> getleftplayers(){
		return leftplayerlist;
	}
	public void addrightplayer(Player player){
		rightplayerlist.add(player);
	}
	public ArrayList<Player> getrightplayers(){
		return rightplayerlist;
	}
	public void setScore(String score){
		this.score=score;
	}
    public void creatmatch(MatchPO matchpo){
    	   Num=matchpo.getNum();
    	   season=matchpo.getSeason();
    	   date=matchpo.getDate();
    	   Team rteam=new Team();
    	   Team lteam=new Team();
    	   rteam.creatteam(matchpo.getRightTeam());
    	   lteam.creatteam(matchpo.getLeftTeam());
    	   leftTeam=lteam;
    	   rightTeam=rteam;
    	   score=matchpo.getScore();
    	   scores1=matchpo.getScores1();
    	   scores2=matchpo.getScores2();
    	   scores3=matchpo.getScores3();
    	   scores4=matchpo.getScores4();
    	   extrascores=matchpo.getExtrascores();
    	   ArrayList<PlayerPO> lpl=matchpo.getleftplayers();
    	   for(PlayerPO p:lpl){
    		   Player player=new Player();
    		   player.creatplayer(p);
    		   leftplayerlist.add(player);
    	   }
    	   ArrayList<PlayerPO> rpl=matchpo.getrightplayers();
    	   for(PlayerPO p:rpl){
    		   Player player=new Player();
    		   player.creatplayer(p);
    		   rightplayerlist.add(player);
    	   }
    }
 
public Object[][] getData(String team,int matchnum){
        Matchdata mr=new Matchdata();
        MatchPO match =mr.getMatchbynum(matchnum);
        ArrayList<PlayerPO> playerList =new ArrayList<PlayerPO>();
        if(match!=null){
		if(team.equals("right")){
			playerList = match.getrightplayers();
		}
		else if(team.equals("left")){
			playerList =match.getleftplayers();
		}
		Object[][] data = new Object[playerList.size()][14];//这一行有点问题
		int index = 0;
			int size = playerList.size();	
			for(int j = 0; j < size; j++){
				PlayerPO tempPlayerpo = playerList.get(j);
				Player tempPlayer=new Player();
				tempPlayer.creatplayer(tempPlayerpo);
				data[index][0] = tempPlayer.getPlayerName();
				data[index][1] = tempPlayer.getTeamShortName();//所属球队
				//data[index][2] = tempPlayer.getPlayerAttends();
				//data[index][3] = tempPlayer.getPlayerStartTimes();
				data[index][2] = tempPlayer.getPlayerTotalRebounds();
				data[index][3] = tempPlayer.getPlayerOffenceRebounds();
				data[index][4] = tempPlayer.getPlayerDeffenceRebounds();
				data[index][5] = tempPlayer.getPlayerAssists();
				data[index][6] = tempPlayer.getPlayerPlayTime();
				data[index][7] = tempPlayer.getPlayerFG();
				data[index][8] = tempPlayer.getPlayer3FG();
				data[index][9] = tempPlayer.getPlayerFTG();
				data[index][10] = tempPlayer.getPlayerSteals();
				data[index][11] = tempPlayer.getPlayerBlocks();
				data[index][12] = tempPlayer.getPlayerTurnovers();
				data[index][13] = tempPlayer.getPlayerFouls();
				//data[index][16] = tempPlayer.getPlayerScores();
				//data[index][17] = tempPlayer.getPlayerPER();
				//data[index][18] = tempPlayer.getPlayerGmScER();
				//data[index][19] = tempPlayer.getPlayerTSP();
				//data[index][20] = tempPlayer.getPlayerSER();
				//data[index][21] = tempPlayer.getRR();
				//data[index][22] = tempPlayer.getO_RR();
				//data[index][23] = tempPlayer.getD_RR();
				//data[index][24] = tempPlayer.getAR();
				//data[index][25] = tempPlayer.getSR();
				//data[index][26] = tempPlayer.getBR();
				//data[index][27] = tempPlayer.getTR();
				//data[index][28] = tempPlayer.getUR();
				//data[index][29] = tempPlayer.getdouble_double();
				index++;
			}
		
		return data;
        }
        else{
        	return null;
        }
}
public String getScore() {
	
	return score;
}
}
