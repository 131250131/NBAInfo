package test;

import java.util.ArrayList;

import vo.PlayerVO;
import vo.TeamVO;
import logic.MainController;
import logicservice.mainControllerService;
import logicservice.matchControllerService;
import logicservice.playerControllerService;
import logicservice.teamControllerService;

public class logicTest {
	public static void main(String args[]){
		playerControllerService playerController;
		teamControllerService teamController;
		matchControllerService matchController;
		
		mainControllerService mainController = new MainController();
		mainController.init();
		playerController = mainController.getPlayerController();
		teamController = mainController.getTeamController();
		matchController = mainController.getMatchController();
		/*
		ArrayList<TeamVO> t=teamController.getSeasonAllTeamInfo();
		for(TeamVO te:t){
			System.out.println();
		}
		*/
		/*
		ArrayList<PlayerVO> p=playerController.getSeasonHotPlayers_3FGP();
		for(PlayerVO pl:p){
			System.out.println(pl.getTeamShortName());
		}
		*/
		ArrayList<PlayerVO> p=playerController.getplayerbyteam("MIA");
		for(PlayerVO pl:p){
			System.out.println(pl.getTeamShortName());
		}
	}
	
}
