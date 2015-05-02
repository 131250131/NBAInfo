package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import po.TeamPO;
import DataService.PlayerDataService;
import DataService.TeamDataService;
import data.playerdata.PlayerReader;
import data.teamdata.TeamReader;
import vo.MatchVO;
import vo.TeamVO;
import logicservice.teamControllerService;

public class TeamController implements teamControllerService{
	
	private static TeamController instance =null;
	
	public TeamDataService tds = new TeamReader();
	public ArrayList<Team> allTeams = new ArrayList<Team>();
	public ArrayList<TeamVO> allTeamVO = new ArrayList<TeamVO>();
	
	private TeamController(){
		this.updateTeamInfo_Basic();
	}
	
	public static TeamController getInstance(){
	      if( instance == null ){
	          instance  = new TeamController();
	       }
	      return instance ;
	}

	public void updateTeamInfo_Basic(){
		ArrayList<TeamPO> allTeamPO =  new ArrayList<TeamPO>();
		try {
			allTeamPO =tds.readTeamsBaiscInfo();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("读取球队基本数据出错");
		}
		for(TeamPO po : allTeamPO){
			this.allTeams.add(new Team(po));
		}
	}
	
	
	public void updateTeamInfo_Advanced(Team myTeam,Team oppoTeam){
		for(Team team:this.allTeams){
			if(team.getShortName().equals(myTeam.getShortName())){
				//System.out.println("true");
				//System.out.println("p"+myTeam.getTeamAssists());
				team.updateTeamInfo(myTeam, oppoTeam);
			}
		}
	}
	
	public void createSeasonAllTeamInfo(){
		for(Team team : this.allTeams){
			this.allTeamVO.add(team.createTeamVO());
		}
	}
	
	public ArrayList<TeamVO> getSeasonAllTeamInfo() {
		createSeasonAllTeamInfo();
		return this.allTeamVO;
	}

	public TeamVO getOneTeamInfo(String shortName) {
		for(TeamVO vo : this.allTeamVO){
			if(vo.getShortName().equals(shortName)){
				return vo;
			}
		}
		return null;
	}

	//或缺热点球员的方法;
	
	public ArrayList<TeamVO> getSeasonHotTeams_Score(){
		ArrayList<TeamVO> result = new ArrayList<TeamVO>();
		for(TeamVO vo :  this.allTeamVO){
			vo.comparetype = "得分";
		}
		Collections.sort(this.allTeamVO);
		for(int i=0;i<50;i++){
			result.add(this.allTeamVO.get(i));
		}
		return result;
	}
	
	public ArrayList<TeamVO> getSeasonHotTeams_Rebound(){
		ArrayList<TeamVO> result = new ArrayList<TeamVO>();
		for(TeamVO vo :  this.allTeamVO){
			vo.comparetype = "篮板";
		}
		Collections.sort(this.allTeamVO);
		for(int i=0;i<50;i++){
			result.add(this.allTeamVO.get(i));
		}
		return result;
	}
	
	public ArrayList<TeamVO> getSeasonHotTeams_Assist(){
		ArrayList<TeamVO> result = new ArrayList<TeamVO>();
		for(TeamVO vo :  this.allTeamVO){
			vo.comparetype = "助攻";
		}
		Collections.sort(this.allTeamVO);
		for(int i=0;i<50;i++){
			result.add(this.allTeamVO.get(i));
		}
		return result;
	}
	
	public ArrayList<TeamVO> getSeasonHotTeams_Block(){
		ArrayList<TeamVO> result = new ArrayList<TeamVO>();
		for(TeamVO vo :  this.allTeamVO){
			vo.comparetype = "盖帽";
		}
		Collections.sort(this.allTeamVO);
		for(int i=0;i<50;i++){
			result.add(this.allTeamVO.get(i));
		}
		return result;
	}
	
	public ArrayList<TeamVO> getSeasonHotTeams_Steal() {
		ArrayList<TeamVO> result = new ArrayList<TeamVO>();
		for(TeamVO vo :  this.allTeamVO){
			vo.comparetype = "抢断";
		}
		Collections.sort(this.allTeamVO);
		for(int i=0;i<50;i++){
			result.add(this.allTeamVO.get(i));
		}
		return result;
	}
	
	public ArrayList<TeamVO> getSeasonHotTeams_3FGP() {
		ArrayList<TeamVO> result = new ArrayList<TeamVO>();
		for(TeamVO vo :  this.allTeamVO){
			vo.comparetype = "3FGP";
		}
		Collections.sort(this.allTeamVO);
		for(int i=0;i<50;i++){
			result.add(this.allTeamVO.get(i));
		}
		return result;
	}
	
	public ArrayList<TeamVO> getSeasonHotTeams_FGP(){
		ArrayList<TeamVO> result = new ArrayList<TeamVO>();
		for(TeamVO vo :  this.allTeamVO){
			vo.comparetype = "FGP";
		}
		Collections.sort(this.allTeamVO);
		for(int i=0;i<50;i++){
			result.add(this.allTeamVO.get(i));
		}
		return result;
	}
	
	public ArrayList<TeamVO> getSeasonHotTeams_FTGP() {
		ArrayList<TeamVO> result = new ArrayList<TeamVO>();
		for(TeamVO vo :  this.allTeamVO){
			vo.comparetype = "FTGP";
		}
		Collections.sort(this.allTeamVO);
		for(int i=0;i<50;i++){
			result.add(this.allTeamVO.get(i));
		}
		return result;
	} 
	
	
	public ArrayList<MatchVO> getrecenttengames(String name){
		return null;
	}
}
