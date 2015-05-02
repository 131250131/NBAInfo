package logic;

import java.util.ArrayList;

import vo.MatchVO;
import logicservice.matchControllerService;
import logicservice.teamControllerService;

public class logicTest {
	public static void main(String args[]){
		TeamController teamController = TeamController.getInstance();
		for(Team team : teamController.allTeams){
			System.out.println(team.getTeamName()+" "+team.getShortName());
		}//基本信息验证;
		
		MatchController matchController = MatchController.getInstance();
		ArrayList<MatchVO> list = matchController.getAllMatchVO();
		
		
	}
}
