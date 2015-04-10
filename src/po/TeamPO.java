package po;

import java.io.Serializable;
import java.util.ArrayList;

public class TeamPO implements Serializable {
//super key 
	//球队全名 │ 缩写│ 所在地 │ 赛区│ 分区 │ 主场 │ 建立时间║
	
	//球队名称： 
		private String teamName;
	//球队缩写：
		private String shortName;
	//球队所在地
		private	String location;
	//赛区
		private	boolean isEast;
	//分区
		private	String division;
	//球馆名称
		private	String gymName;
	//建立时间
		private	int birthYear;
		
	//球队助攻数（*****需要更新*****）
		private int teamAssists;
	//球队投篮命中数（*****需要更新*****）
		private int teamFG ;
	//球队投篮出手次数（*****需要更新*****）
		private int teamFGTry ;
	//球队三分命中数（*****需要更新*****）
		private int team3FG ;
	//球队三分出手次数（*****需要更新*****）
		private int team3FGTry ;
	//球队球队罚球命中数（*****需要更新*****）
		private int teamFTG;
	//球队罚球出手数（*****需要更新*****）
		private int teamFTGTry;
	//球队进攻篮板数（*****需要更新*****）
		private int teamOffenceRebounds;
	//球队防守篮板数（*****需要更新*****）
		private int teamDeffenceRebounds;
	//球队总篮板数（*****需要更新*****）
		private int teamTotalRebounds;
	//球队抢断数（*****需要更新*****）
		private int teamSteals;
	//球队盖帽数（*****需要更新*****）
		private int teamBlocks;
	//球队失误数（*****需要更新*****）
		private int teamTurnovers;
	//球队犯规数（*****需要更新*****）
		private int teamFouls;
	//球队总得分数（*****需要更新*****）
		private int teamScores;
	//这场比赛，球队里的所有球员
		private ArrayList<PlayerPO> players = new ArrayList<PlayerPO>();
		
		public String getTeamName() {
			return teamName;
		}
		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}
		public String getShortName() {
			return shortName;
		}
		public void setShortName(String shortName) {
			this.shortName = shortName;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public boolean isEast() {
			return isEast;
		}
		public void setEast(boolean isEast) {
			this.isEast = isEast;
		}
		public String getDivision() {
			return division;
		}
		public void setDivision(String division) {
			this.division = division;
		}
		public String getGymName() {
			return gymName;
		}
		public void setGymName(String gymName) {
			this.gymName = gymName;
		}
		public int getBirthYear() {
			return birthYear;
		}
		public void setBirthYear(int birthYear) {
			this.birthYear = birthYear;
		}
		public int getTeamAssists() {
			return teamAssists;
		}
		public void setTeamAssists(int teamAssists) {
			this.teamAssists = teamAssists;
		}
		public int getTeamFG() {
			return teamFG;
		}
		public void setTeamFG(int teamFG) {
			this.teamFG = teamFG;
		}
		public int getTeamFGTry() {
			return teamFGTry;
		}
		public void setTeamFGTry(int teamFGTry) {
			this.teamFGTry = teamFGTry;
		}
		public int getTeam3FG() {
			return team3FG;
		}
		public void setTeam3FG(int team3fg) {
			team3FG = team3fg;
		}
		public int getTeam3FGTry() {
			return team3FGTry;
		}
		public void setTeam3FGTry(int team3fgTry) {
			team3FGTry = team3fgTry;
		}
		public int getTeamFTG() {
			return teamFTG;
		}
		public void setTeamFTG(int teamFTG) {
			this.teamFTG = teamFTG;
		}
		public int getTeamFTGTry() {
			return teamFTGTry;
		}
		public void setTeamFTGTry(int teamFTGTry) {
			this.teamFTGTry = teamFTGTry;
		}
		public int getTeamOffenceRebounds() {
			return teamOffenceRebounds;
		}
		public void setTeamOffenceRebounds(int teamOffenceRebounds) {
			this.teamOffenceRebounds = teamOffenceRebounds;
		}
		public int getTeamDeffenceRebounds() {
			return teamDeffenceRebounds;
		}
		public void setTeamDeffenceRebounds(int teamDeffenceRebounds) {
			this.teamDeffenceRebounds = teamDeffenceRebounds;
		}
		public int getTeamTotalRebounds() {
			return teamTotalRebounds;
		}
		public void setTeamTotalRebounds(int teamTotalRebounds) {
			this.teamTotalRebounds = teamTotalRebounds;
		}
		public int getTeamSteals() {
			return teamSteals;
		}
		public void setTeamSteals(int teamSteals) {
			this.teamSteals = teamSteals;
		}
		public int getTeamBlocks() {
			return teamBlocks;
		}
		public void setTeamBlocks(int teamBlocks) {
			this.teamBlocks = teamBlocks;
		}
		public int getTeamTurnovers() {
			return teamTurnovers;
		}
		public void setTeamTurnovers(int teamTurnovers) {
			this.teamTurnovers = teamTurnovers;
		}
		public int getTeamFouls() {
			return teamFouls;
		}
		public void setTeamFouls(int teamFouls) {
			this.teamFouls = teamFouls;
		}
		public int getTeamScores() {
			return teamScores;
		}
		public void setTeamScores(int teamScores) {
			this.teamScores = teamScores;
		}
		public ArrayList<PlayerPO> getPlayers() {
			return players;
		}
		public void setPlayers(ArrayList<PlayerPO> players) {
			this.players = players;
		}
		//读取球队信息txt时，调用的构造函数;
		public TeamPO(String _teamFullName, String _teamShortName, String _teamLocation
				, String _teamEastOrWest, String _teamDivision, 
				String _teamGym, String _teamBirth){
			this.setTeamName(_teamFullName);
			this.setShortName(_teamShortName);
			this.setLocation(_teamLocation);
			if(_teamEastOrWest.equals("E")){
				this.setEast(true);
			}else{
				this.setEast(false);
			}
			this.setDivision(_teamDivision);
			this.setGymName(_teamGym);
			this.setBirthYear(Integer.parseInt(_teamBirth));
		}
		
		//读取比赛信息txt时，用此构造函数来构造team对象，此处不涉及逻辑，只负责读取已有的信息;
		public TeamPO(){
			
		}
		
/*
 * 		 脑洞打开系列：
 *      分层结构会不会影响速度?多次调用对速度的影响?
 *      跨包调用会不会比不同类之间调用耗费的时间更多; 
 * */
}
