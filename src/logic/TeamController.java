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
	
	TeamDataService tds = new TeamReader();
	ArrayList<Team> allTeams = new ArrayList<Team>();
	
	public TeamController(){
		this.updateTeamInfo_Basic();
	}
	
	public void updateTeamInfo_Basic(){
		ArrayList<TeamPO> allTeamPO =  new ArrayList<TeamPO>();
		for(TeamPO po : allTeamPO){
			this.allTeams.add(new Team(po));
		}
	}
	
	public void updateTeamInfo_Advanced(TeamPO po){
		
	}
	
	public ArrayList<TeamVO> getSeasonAllTeamInfo() {
		return null;
	}

	public ArrayList<TeamVO> getOneTeamInfo(String shortName) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
