package po;

import java.io.Serializable;
import java.util.ArrayList;

import vo.win_lose;

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
		
		private double winLose;//胜负场;
		
		private win_lose home;//主场输赢的次数;
		private win_lose guest;//客场输赢的次数;
		
		private win_lose recent10;
		private win_lose recent10_Home;
		private win_lose recent10_Guest;
		
		private boolean lianxu_win;
		private boolean lianxu_win_Home;
		private boolean lianxu_win_Guest;
		private int lianxu;
		private int lianxu_Home;
		private int lianxu_Guest;
		private int longestWin;
		private int longestLose;
		
		private win_lose lessThan3Points;//3分之内胜负场
		private win_lose moreThan10Points;//10分以上胜负关系
		
		private win_lose myTeamMoreThan100;//本队得分上100时的胜负关系
		private win_lose oppoTeamMoreThan100;//对手得分上100时的胜负关系
		
		private win_lose oppoIsStrong;//对手胜率50%时的胜负关系
		
		private win_lose MoreFGP;//命中率领先
		private win_lose MoreRebounds;//篮板领先
		private win_lose LessTurnovers;//更少失误时的胜负关系
		
		private win_lose banchanglingxian;//半场领先
		private win_lose banchangluohou;//半场落后
		private win_lose sanjielinxian;//第三节领先
		private win_lose sanjieluohou;//第三节落后
	//这场比赛，球队里的所有球员
		private ArrayList<PlayerPO> players = new ArrayList<PlayerPO>();
		private ArrayList<Integer> attendmatches =new ArrayList<Integer>();
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
		public boolean getisEast() {
			// TODO Auto-generated method stub
			return isEast;
		}
		public ArrayList<Integer> getAttendmatches() {
			return attendmatches;
		}
		public void addAttendmatches(int matchnum) {
			attendmatches.add(matchnum);
		}
		public void setAttendmatches(int matchnum) {
			attendmatches.add(matchnum);
		}
		public double getWinLose() {
			return winLose;
		}
		public void setWinLose(double winLose) {
			this.winLose = winLose;
		}
		public win_lose getRecent10() {
			return recent10;
		}
		public void setRecent10(win_lose recent10) {
			this.recent10 = recent10;
		}
		public win_lose getRecent10_Home() {
			return recent10_Home;
		}
		public void setRecent10_Home(win_lose recent10_Home) {
			this.recent10_Home = recent10_Home;
		}
		public win_lose getRecent10_Guest() {
			return recent10_Guest;
		}
		public void setRecent10_Guest(win_lose recent10_Guest) {
			this.recent10_Guest = recent10_Guest;
		}
		public boolean isLianxu_win() {
			return lianxu_win;
		}
		public void setLianxu_win(boolean lianxu_win) {
			this.lianxu_win = lianxu_win;
		}
		public boolean isLianxu_win_Home() {
			return lianxu_win_Home;
		}
		public void setLianxu_win_Home(boolean lianxu_win_Home) {
			this.lianxu_win_Home = lianxu_win_Home;
		}
		public boolean isLianxu_win_Guest() {
			return lianxu_win_Guest;
		}
		public void setLianxu_win_Guest(boolean lianxu_win_Guest) {
			this.lianxu_win_Guest = lianxu_win_Guest;
		}
		public int getLianxu() {
			return lianxu;
		}
		public void setLianxu(int lianxu) {
			this.lianxu = lianxu;
		}
		public int getLianxu_Home() {
			return lianxu_Home;
		}
		public void setLianxu_Home(int lianxu_Home) {
			this.lianxu_Home = lianxu_Home;
		}
		public int getLianxu_Guest() {
			return lianxu_Guest;
		}
		public void setLianxu_Guest(int lianxu_Guest) {
			this.lianxu_Guest = lianxu_Guest;
		}
		public int getLongestWin() {
			return longestWin;
		}
		public void setLongestWin(int longestWin) {
			this.longestWin = longestWin;
		}
		public int getLongestLose() {
			return longestLose;
		}
		public void setLongestLose(int longestLose) {
			this.longestLose = longestLose;
		}
		public win_lose getMoreThan10Points() {
			return moreThan10Points;
		}
		public void addwinMoreThan10Points() {
			this.moreThan10Points.addWin();
		}
		public void addloseMoreThan10Points() {
			this.moreThan10Points.addLose();
		}
		public win_lose getMyTeamMoreThan100() {
			return myTeamMoreThan100;
		}
		public void addwinMyTeamMoreThan100() {
			this.myTeamMoreThan100.addWin();
		}
		public void addloseMyTeamMoreThan100() {
			this.myTeamMoreThan100.addLose();
		}
		public win_lose getOppoTeamMoreThan100() {
			return oppoTeamMoreThan100;
		}
		public void setOppoTeamMoreThan100(win_lose oppoTeamMoreThan100) {
			this.oppoTeamMoreThan100 = oppoTeamMoreThan100;
		}
		public win_lose getOppoIsStrong() {
			return oppoIsStrong;
		}
		public void setOppoIsStrong(win_lose oppoIsStrong) {
			this.oppoIsStrong = oppoIsStrong;
		}
		public win_lose getMoreFGP() {
			return MoreFGP;
		}
		public void addwinMoreFGP() {
			MoreFGP.addWin();
		}
		public void addloseMoreFGP() {
			MoreFGP.addLose();
		}
		public win_lose getMoreRebounds() {
			return MoreRebounds;
		}
		public void addwinMoreRebounds() {
			MoreRebounds.addWin();;
		}
		public void addloseMoreRebounds() {
			MoreRebounds.addLose();;
		}
		public win_lose getLessTurnovers() {
			return LessTurnovers;
		}
		public void addwinLessTurnovers() {
			LessTurnovers.addWin();;
		}
		public void addloseLessTurnovers() {
			LessTurnovers.addLose();;
		}
		public win_lose getSanjielinxian() {
			return sanjielinxian;
		}
		public void setSanjielinxian(win_lose sanjielinxian) {
			this.sanjielinxian = sanjielinxian;
		}
		public win_lose getSanjieluohou() {
			return sanjieluohou;
		}
		public void setSanjieluohou(win_lose sanjieluohou) {
			this.sanjieluohou = sanjieluohou;
		}
		public win_lose getLessThan3Points() {
			return lessThan3Points;
		}
		public void addwintLessThan3Points() {
			this.lessThan3Points.addWin();
		}
		public void addlosetLessThan3Points() {
			this.lessThan3Points.addLose();
		}
		public win_lose getBanchanglingxian() {
			return banchanglingxian;
		}
		public void setBanchanglingxian(win_lose banchanglingxian) {
			this.banchanglingxian = banchanglingxian;
		}
		public win_lose getBanchangluohou() {
			return banchangluohou;
		}
		public void setBanchangluohou(win_lose banchangluohou) {
			this.banchangluohou = banchangluohou;
		}
		public win_lose getHome() {
			return home;
		}
		public void setHome(win_lose home) {
			this.home = home;
		}
		public win_lose getGuest() {
			return guest;
		}
		public void setGuest(win_lose guest) {
			this.guest = guest;
		}
		public void addwinOppoTeamMoreThan100() {
			this.oppoTeamMoreThan100.addWin();
		}
		public void addloseOppoTeamMoreThan100() {
			this.oppoTeamMoreThan100.addLose();
		}
/*
 * 		 脑洞打开系列：
 *      分层结构会不会影响速度?多次调用对速度的影响?
 *      跨包调用会不会比不同类之间调用耗费的时间更多; 
 * */
}
