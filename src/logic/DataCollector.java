package logic;

import java.util.ArrayList;
import java.util.Collections;

import logicservice.DataCollectorService;
import vo.PlayerVO;
import vo.TeamVO;

/*
 * 	这个数据用来保存各种初始化的内容
 * 	这些属性都是该类所持有的数据
 * 	这个类里面都是对已经处理过的VO进行筛;
 * */

/*
 * 进度说明:
 * 球员的赛季热点信息已经写完;
 * 还缺 球队的赛季热点信息，还缺今日球队，今日球员;
 * */

public class DataCollector implements DataCollectorService{
	/*赛季热点球员：依据筛选条件（筛选条件包括但不仅限于以 下几个方面：场均得分，场均篮板，场均助攻，场均盖帽， 场均抢断，三分命中率，投篮命中率，罚球命中率等）*/
	
	ArrayList<PlayerVO> seasonHotPlayers_Score= new ArrayList<PlayerVO>();
	ArrayList<PlayerVO> seasonHotPlayers_Rebound= new ArrayList<PlayerVO>();
	ArrayList<PlayerVO> seasonHotPlayers_Assist= new ArrayList<PlayerVO>();
	ArrayList<PlayerVO> seasonHotPlayers_Block= new ArrayList<PlayerVO>();
	ArrayList<PlayerVO> seasonHotPlayers_Steal= new ArrayList<PlayerVO>();
	ArrayList<PlayerVO> seasonHotPlayers_3FGP= new ArrayList<PlayerVO>();
	ArrayList<PlayerVO> seasonHotPlayers_FGP= new ArrayList<PlayerVO>();
	ArrayList<PlayerVO> seasonHotPlayers_FTGP= new ArrayList<PlayerVO>();
	
	/*赛季热点球队： 依据筛选条件（筛选条件包括但不仅限于以 下几个方面：场均得分，场均篮板，场均助攻，场均盖帽， 场均抢断，三分命中率，投篮命中率，罚球命中率等）*/
	ArrayList<TeamVO> seasonHotTeams_Score= new ArrayList<TeamVO>();
	ArrayList<TeamVO> seasonHotTeams_Rebound= new ArrayList<TeamVO>();
	ArrayList<TeamVO> seasonHotTeams_Assist= new ArrayList<TeamVO>();
	ArrayList<TeamVO> seasonHotTeams_Block= new ArrayList<TeamVO>();
	ArrayList<TeamVO> seasonHotTeams_Steal= new ArrayList<TeamVO>();
	ArrayList<TeamVO> seasonHotTeams_3FGP= new ArrayList<TeamVO>();
	ArrayList<TeamVO> seasonHotTeams_FGP= new ArrayList<TeamVO>();
	ArrayList<TeamVO> seasonHotTeams_FTGP= new ArrayList<TeamVO>();
	
	ArrayList<PlayerVO> todayAllPlayers = new ArrayList<PlayerVO>();
	ArrayList<PlayerVO> todayHotPlayers = new ArrayList<PlayerVO>();
	
//	//用来更新最新的赛季热点球员信息
//	public void updateSeasonHotPlayers(){
//		
//		 //调用PlayerController里面的update方法;
//		 this.seasonHotPlayers_Score=null;
//		 this.seasonHotPlayers_Rebound=null;
//		 this.seasonHotPlayers_Assist =null;
//		 this.seasonHotPlayers_Block =null;
//		 this.seasonHotPlayers_Steal =null;
//		 this.seasonHotPlayers_3FGP =null;
//		 this.seasonHotPlayers_FGP =null;
//		 this.seasonHotPlayers_FTGP =null;
//
//	}
//	
//	//用来获得最新的赛季热点球队信息
//	public ArrayList<ArrayList<PlayerVO>> getSeasonHotPlayers(){
//		
//		 ArrayList<ArrayList<PlayerVO>> seasonHotPlayersList  = new ArrayList<ArrayList<PlayerVO>>();
//		 seasonHotPlayersList.add(this.seasonHotPlayers_Score);
//		 seasonHotPlayersList.add(this.seasonHotPlayers_Rebound);
//		 seasonHotPlayersList.add(this.seasonHotPlayers_Assist);
//		 seasonHotPlayersList.add(this.seasonHotPlayers_Block);
//		 seasonHotPlayersList.add(this.seasonHotPlayers_Steal);
//		 seasonHotPlayersList.add(this.seasonHotPlayers_3FGP);
//		 seasonHotPlayersList.add(this.seasonHotPlayers_FGP);
//		 seasonHotPlayersList.add(this.seasonHotPlayers_FTGP);
//		 
//		 return seasonHotPlayersList;
//	}
//	
//	//用来更新最新的赛季热点球队信息
//	public void updateSeasonHotTeams(){
//
//		 this.seasonHotTeams_Score =null;
//		 this.seasonHotTeams_Rebound =null;
//		 this.seasonHotTeams_Assist =null;
//		 this.seasonHotTeams_Block =null;
//		 this.seasonHotTeams_Steal =null;
//		 this.seasonHotTeams_3FGP =null;
//		 this.seasonHotTeams_FGP =null;
//		 this.seasonHotTeams_FTGP =null;
//
//		
//	}
//	
//	//用来获得最新的赛季热点球队信息
//	public ArrayList<ArrayList<TeamVO>> getSeasonHotTeams(){
//		ArrayList<ArrayList<TeamVO>> seasonHotTeamsList = new ArrayList<ArrayList<TeamVO>>();
//
//		 seasonHotTeamsList.add(this.seasonHotTeams_Score);
//		 seasonHotTeamsList.add(this.seasonHotTeams_Rebound);
//		 seasonHotTeamsList.add(this.seasonHotTeams_Assist);
//		 seasonHotTeamsList.add(this.seasonHotTeams_Block);
//		 seasonHotTeamsList.add(this.seasonHotTeams_Steal);
//		 seasonHotTeamsList.add(this.seasonHotTeams_3FGP);
//		 seasonHotTeamsList.add(this.seasonHotTeams_FGP);
//		 seasonHotTeamsList.add(this.seasonHotTeams_FTGP);
//		
//		 return seasonHotTeamsList;
//	}
	
	
	
	
	//更新今天参与比赛的所有球员
	public void updateTodayAllPlayers(){
		//调用
		this.todayAllPlayers = null;
	}
	
	//更新今天的热点球员
	public void updateTodayHotPlayers(){
		this.todayHotPlayers = null;
	}

	//获得今天参与比赛的所有球员
	public ArrayList<PlayerVO> getTodayAllPlayers() {
		
		return todayAllPlayers;
	}

	//获得今天的热点球员
	public ArrayList<PlayerVO> getTodayHotPlayers() {
		return todayHotPlayers;
	}
	
	//获得赛季热点球员或球队的套路:
	//用Controller获得所有球员/球队list;
	//用一个通用的排序算法获得排序完毕的数据;
	//返回一个ArrayList;
	//套路很一致;思路很清晰;
	public ArrayList<PlayerVO> getSeasonHotPlayers_Score() {
		PlayerController playerController = PlayerController.getInstance();
		seasonHotPlayers_Score = playerController.getSeasonHotPlayers_Score();
		return seasonHotPlayers_Score;
	}

	public void setSeasonHotPlayers_Score(ArrayList<PlayerVO> seasonHotPlayers_Score) {
		PlayerController playerController = PlayerController.getInstance();
//		ArrayList<PlayerVO> allPlayerVO = playerController.getAllPlayerVO();
	
		this.seasonHotPlayers_Score = seasonHotPlayers_Score;
	}

	public ArrayList<PlayerVO> getSeasonHotPlayers_Rebound() {
		PlayerController playerController = PlayerController.getInstance();
		this.seasonHotPlayers_Rebound = playerController.getSeasonHotPlayers_Rebound();
		return seasonHotPlayers_Rebound;
	}

	public void setSeasonHotPlayers_Rebound(
			ArrayList<PlayerVO> seasonHotPlayers_Rebound) {
		this.seasonHotPlayers_Rebound = seasonHotPlayers_Rebound;
	}

	public ArrayList<PlayerVO> getSeasonHotPlayers_Assist() {
		PlayerController playerController = PlayerController.getInstance();
		this.seasonHotPlayers_Assist = playerController.getSeasonHotPlayers_Assist();
		return seasonHotPlayers_Assist;
	}

	public void setSeasonHotPlayers_Assist(
			ArrayList<PlayerVO> seasonHotPlayers_Assist) {
		this.seasonHotPlayers_Assist = seasonHotPlayers_Assist;
	}

	public ArrayList<PlayerVO> getSeasonHotPlayers_Block() {
		PlayerController playerController = PlayerController.getInstance();
		this.seasonHotPlayers_Block = playerController.getSeasonHotPlayers_Block();
		return seasonHotPlayers_Block;
	}

	public void setSeasonHotPlayers_Block(ArrayList<PlayerVO> seasonHotPlayers_Block) {
		this.seasonHotPlayers_Block = seasonHotPlayers_Block;
	}

	public ArrayList<PlayerVO> getSeasonHotPlayers_Steal() {
		PlayerController playerController = PlayerController.getInstance();
		this.seasonHotPlayers_Steal = playerController.getSeasonHotPlayers_Steal();
		return seasonHotPlayers_Steal;
	}

	public void setSeasonHotPlayers_Steal(ArrayList<PlayerVO> seasonHotPlayers_Steal) {
		this.seasonHotPlayers_Steal = seasonHotPlayers_Steal;
	}

	public ArrayList<PlayerVO> getSeasonHotPlayers_3FGP() {
		PlayerController playerController = PlayerController.getInstance();
		this.seasonHotPlayers_3FGP = playerController.getSeasonHotPlayers_3FGP();
		return seasonHotPlayers_3FGP;
	}

	public void setSeasonHotPlayers_3FGP(ArrayList<PlayerVO> seasonHotPlayers_3FGP) {
		this.seasonHotPlayers_3FGP = seasonHotPlayers_3FGP;
	}

	public ArrayList<PlayerVO> getSeasonHotPlayers_FGP() {
		PlayerController playerController = PlayerController.getInstance();
		this.seasonHotPlayers_FGP = playerController.getSeasonHotPlayers_FGP();
		return seasonHotPlayers_FGP;
	}

	public void setSeasonHotPlayers_FGP(ArrayList<PlayerVO> seasonHotPlayers_FGP) {
		this.seasonHotPlayers_FGP = seasonHotPlayers_FGP;
	}

	public ArrayList<PlayerVO> getSeasonHotPlayers_FTGP() {
		PlayerController playerController = PlayerController.getInstance();
		this.seasonHotPlayers_FTGP = playerController.getSeasonHotPlayers_FTGP();
		return seasonHotPlayers_FTGP;
	}

	public void setSeasonHotPlayers_FTGP(ArrayList<PlayerVO> seasonHotPlayers_FTGP) {
		this.seasonHotPlayers_FTGP = seasonHotPlayers_FTGP;
	}

	public ArrayList<TeamVO> getSeasonHotTeams_Score() {
		TeamController teamController = TeamController.getInstance();
		this.seasonHotTeams_Score = teamController.getSeasonHotTeams_Score();
		return seasonHotTeams_Score;
	}

	public void setSeasonHotTeams_Score(ArrayList<TeamVO> seasonHotTeams_Score) {
		this.seasonHotTeams_Score = seasonHotTeams_Score;
	}

	public ArrayList<TeamVO> getSeasonHotTeams_Rebound() {
		TeamController teamController = TeamController.getInstance();
		this.seasonHotTeams_Rebound = teamController.getSeasonHotTeams_Rebound();
		return seasonHotTeams_Rebound;
	}

	public void setSeasonHotTeams_Rebound(ArrayList<TeamVO> seasonHotTeams_Rebound) {
		this.seasonHotTeams_Rebound = seasonHotTeams_Rebound;
	}

	public ArrayList<TeamVO> getSeasonHotTeams_Assist() {
		TeamController teamController = TeamController.getInstance();
		this.seasonHotTeams_Assist = teamController.getSeasonHotTeams_Assist();
		return seasonHotTeams_Assist;
	}

	public void setSeasonHotTeams_Assist(ArrayList<TeamVO> seasonHotTeams_Assist) {
		this.seasonHotTeams_Assist = seasonHotTeams_Assist;
	}

	public ArrayList<TeamVO> getSeasonHotTeams_Block() {
		TeamController teamController = TeamController.getInstance();
		this.seasonHotTeams_Block = teamController.getSeasonHotTeams_Block();
		return seasonHotTeams_Block;
	}

	public void setSeasonHotTeams_Block(ArrayList<TeamVO> seasonHotTeams_Block) {
		this.seasonHotTeams_Block = seasonHotTeams_Block;
	}

	public ArrayList<TeamVO> getSeasonHotTeams_Steal() {
		TeamController teamController = TeamController.getInstance();
		this.seasonHotTeams_Steal = teamController.getSeasonHotTeams_Steal();
		return seasonHotTeams_Steal;
	}

	public void setSeasonHotTeams_Steal(ArrayList<TeamVO> seasonHotTeams_Steal) {
		this.seasonHotTeams_Steal = seasonHotTeams_Steal;
	}

	public ArrayList<TeamVO> getSeasonHotTeams_3FGP() {
		TeamController teamController = TeamController.getInstance();
		this.seasonHotTeams_3FGP = teamController.getSeasonHotTeams_3FGP();
		return seasonHotTeams_3FGP;
	}

	public void setSeasonHotTeams_3FGP(ArrayList<TeamVO> seasonHotTeams_3FGP) {
		this.seasonHotTeams_3FGP = seasonHotTeams_3FGP;
	}

	public ArrayList<TeamVO> getSeasonHotTeams_FGP() {
		TeamController teamController = TeamController.getInstance();
		this.seasonHotTeams_FGP = teamController.getSeasonHotTeams_FGP();
		return seasonHotTeams_FGP;
	}

	public void setSeasonHotTeams_FGP(ArrayList<TeamVO> seasonHotTeams_FGP) {
		this.seasonHotTeams_FGP = seasonHotTeams_FGP;
	}

	public ArrayList<TeamVO> getSeasonHotTeams_FTGP() {
		TeamController teamController = TeamController.getInstance();
		this.seasonHotTeams_FTGP = teamController.getSeasonHotTeams_FTGP();
		return seasonHotTeams_FTGP;
	}

	public void setSeasonHotTeams_FTGP(ArrayList<TeamVO> seasonHotTeams_FTGP) {
		this.seasonHotTeams_FTGP = seasonHotTeams_FTGP;
	}

	public void setTodayAllPlayers(ArrayList<PlayerVO> todayAllPlayers) {
		this.todayAllPlayers = todayAllPlayers;
	}

	public void setTodayHotPlayers(ArrayList<PlayerVO> todayHotPlayers) {
		this.todayHotPlayers = todayHotPlayers;
	}

	//还需要把TeamController和PlayerController完善一下;
		
	
	
}
