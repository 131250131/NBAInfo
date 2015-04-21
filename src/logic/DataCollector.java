package logic;

import java.util.ArrayList;

import vo.PlayerVO;
import vo.TeamVO;

/*
 * 	这个数据用来保存各种初始化的内容
 * 	这些属性都是该类所持有的数据
 * */

public class DataCollector {
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
	ArrayList<PlayerVO> seasonHotTeams_Score= new ArrayList<PlayerVO>();
	ArrayList<PlayerVO> seasonHotTeams_Rebound= new ArrayList<PlayerVO>();
	ArrayList<PlayerVO> seasonHotTeams_Assist= new ArrayList<PlayerVO>();
	ArrayList<PlayerVO> seasonHotTeams_Block= new ArrayList<PlayerVO>();
	ArrayList<PlayerVO> seasonHotTeams_Steal= new ArrayList<PlayerVO>();
	ArrayList<PlayerVO> seasonHotTeams_3FGP= new ArrayList<PlayerVO>();
	ArrayList<PlayerVO> seasonHotTeams_FGP= new ArrayList<PlayerVO>();
	ArrayList<PlayerVO> seasonHotTeams_FTGP= new ArrayList<PlayerVO>();
	
	//用来获取最新的赛季热点球员信息
	public ArrayList<ArrayList<PlayerVO>> updateSeasonHotPlayers(){
		 ArrayList<ArrayList<PlayerVO>> seasonHotPlayersList  = new ArrayList<ArrayList<PlayerVO>>();
		 //调用PlayerController里面的方法;
		 ArrayList<PlayerVO> newHotPlayers_Score =null;
		 ArrayList<PlayerVO> newHotPlayers_Rebound =null;
		 ArrayList<PlayerVO> newHotPlayers_Assist =null;
		 ArrayList<PlayerVO> newHotPlayers_Block =null;
		 ArrayList<PlayerVO> newHotPlayers_Steal =null;
		 ArrayList<PlayerVO> newHotPlayers_3FGP =null;
		 ArrayList<PlayerVO> newHotPlayers_FGP =null;
		 ArrayList<PlayerVO> newHotPlayers_FTGP =null;
		 seasonHotPlayersList.add(newHotPlayers_Score);
		 seasonHotPlayersList.add(newHotPlayers_Rebound);
		 seasonHotPlayersList.add(newHotPlayers_Assist);
		 seasonHotPlayersList.add(newHotPlayers_Block);
		 seasonHotPlayersList.add(newHotPlayers_Steal);
		 seasonHotPlayersList.add(newHotPlayers_3FGP);
		 seasonHotPlayersList.add(newHotPlayers_FGP);
		 seasonHotPlayersList.add(newHotPlayers_FTGP);
		 
		 return seasonHotPlayersList;
	}
	
	//用来获得最新的赛季热点球队信息
	public ArrayList<ArrayList<TeamVO>> updateSeasonHotTeams(){
		ArrayList<ArrayList<TeamVO>> seasonHotTeamsList = new ArrayList<ArrayList<TeamVO>>();
		 //调用MatchController里面的方法;
		 ArrayList<TeamVO> newHotPlayers_Score =null;
		 ArrayList<TeamVO> newHotPlayers_Rebound =null;
		 ArrayList<TeamVO> newHotPlayers_Assist =null;
		 ArrayList<TeamVO> newHotPlayers_Block =null;
		 ArrayList<TeamVO> newHotPlayers_Steal =null;
		 ArrayList<TeamVO> newHotPlayers_3FGP =null;
		 ArrayList<TeamVO> newHotPlayers_FGP =null;
		 ArrayList<TeamVO> newHotPlayers_FTGP =null;
		 seasonHotTeamsList.add(newHotPlayers_Score);
		 seasonHotTeamsList.add(newHotPlayers_Rebound);
		 seasonHotTeamsList.add(newHotPlayers_Assist);
		 seasonHotTeamsList.add(newHotPlayers_Block);
		 seasonHotTeamsList.add(newHotPlayers_Steal);
		 seasonHotTeamsList.add(newHotPlayers_3FGP);
		 seasonHotTeamsList.add(newHotPlayers_FGP);
		 seasonHotTeamsList.add(newHotPlayers_FTGP);
		
		 return seasonHotTeamsList;
	}
	
	//获取今天参与比赛的所有球员
	public ArrayList<PlayerVO> updateTodayAllPlayers(){
		ArrayList<PlayerVO> todayAllPlays = new ArrayList<PlayerVO>();
		
		return todayAllPlays;
	}
	
	//获取热点球员
	public ArrayList<PlayerVO> updateTodayHotPlayers(){
		
		return null;
	} 
	
		
}
