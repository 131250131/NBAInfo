package test;

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
		
		
		
		
	}
	
}
