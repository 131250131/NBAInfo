package logic;

import java.util.ArrayList;

import po.TeamPO;
import DataService.PlayerDataService;
import DataService.TeamDataService;
import data.playerdata.PlayerReader;
import data.teamdata.TeamReader;
import vo.TeamVO;
import logicservice.teamControllerService;

public class TeamController implements teamControllerService{
	
	private static TeamController instance =null;
	
	TeamDataService tds = new TeamReader();
	ArrayList<Team> allTeams = new ArrayList<Team>();
	ArrayList<TeamVO> allTeamVO = new ArrayList<TeamVO>();
	
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
		for(TeamPO po : allTeamPO){
			this.allTeams.add(new Team(po));
		}
	}
	
	public void updateTeamInfo_Advanced(Team myTeam,Team oppoTeam){
		for(Team team:this.allTeams){
			if(team.getShortName().equals(myTeam.getShortName())){
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

	
}
