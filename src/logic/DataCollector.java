package logic;

import java.util.ArrayList;

import logicservice.DataCollectorService;
import vo.PlayerVO;
import vo.TeamVO;

/*
 * 	这个数据用来保存各种初始化的内容
 * 	这些属性都是该类所持有的数据
 * 	这个类里面都是对已经处理过的VO进行筛;
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
	
	//用来更新最新的赛季热点球员信息
	public void updateSeasonHotPlayers(){
		
		 //调用PlayerController里面的update方法;
		 this.seasonHotPlayers_Score=null;
		 this.seasonHotPlayers_Rebound=null;
		 this.seasonHotPlayers_Assist =null;
		 this.seasonHotPlayers_Block =null;
		 this.seasonHotPlayers_Steal =null;
		 this.seasonHotPlayers_3FGP =null;
		 this.seasonHotPlayers_FGP =null;
		 this.seasonHotPlayers_FTGP =null;

	}
	
	//用来获得最新的赛季热点球队信息
	public ArrayList<ArrayList<PlayerVO>> getSeasonHotPlayers(){
		
		 ArrayList<ArrayList<PlayerVO>> seasonHotPlayersList  = new ArrayList<ArrayList<PlayerVO>>();
		 seasonHotPlayersList.add(this.seasonHotPlayers_Score);
		 seasonHotPlayersList.add(this.seasonHotPlayers_Rebound);
		 seasonHotPlayersList.add(this.seasonHotPlayers_Assist);
		 seasonHotPlayersList.add(this.seasonHotPlayers_Block);
		 seasonHotPlayersList.add(this.seasonHotPlayers_Steal);
		 seasonHotPlayersList.add(this.seasonHotPlayers_3FGP);
		 seasonHotPlayersList.add(this.seasonHotPlayers_FGP);
		 seasonHotPlayersList.add(this.seasonHotPlayers_FTGP);
		 
		 return seasonHotPlayersList;
	}
	
	//用来更新最新的赛季热点球队信息
	public void updateSeasonHotTeams(){

		 this.seasonHotTeams_Score =null;
		 this.seasonHotTeams_Rebound =null;
		 this.seasonHotTeams_Assist =null;
		 this.seasonHotTeams_Block =null;
		 this.seasonHotTeams_Steal =null;
		 this.seasonHotTeams_3FGP =null;
		 this.seasonHotTeams_FGP =null;
		 this.seasonHotTeams_FTGP =null;

		
	}
	
	//用来获得最新的赛季热点球队信息
	public ArrayList<ArrayList<TeamVO>> getSeasonHotTeams(){
		ArrayList<ArrayList<TeamVO>> seasonHotTeamsList = new ArrayList<ArrayList<TeamVO>>();

		 seasonHotTeamsList.add(this.seasonHotTeams_Score);
		 seasonHotTeamsList.add(this.seasonHotTeams_Rebound);
		 seasonHotTeamsList.add(this.seasonHotTeams_Assist);
		 seasonHotTeamsList.add(this.seasonHotTeams_Block);
		 seasonHotTeamsList.add(this.seasonHotTeams_Steal);
		 seasonHotTeamsList.add(this.seasonHotTeams_3FGP);
		 seasonHotTeamsList.add(this.seasonHotTeams_FGP);
		 seasonHotTeamsList.add(this.seasonHotTeams_FTGP);
		
		 return seasonHotTeamsList;
	}
	
	
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

	//还需要把TeamController和PlayerController完善一下;
		
}
