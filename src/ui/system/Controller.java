package ui.system;

import logic.MainController;
import logic.MatchController;
import logic.PlayerController;
import logic.TeamController;

public class Controller {
	
	public static PlayerController playerController;
	public static TeamController teamController;
	public static MatchController matchController;
	
	public static void init(){
		MainController mainController = MainController.getInstance();
		mainController.init();
		playerController = mainController.getPlayerController();
		teamController = mainController.getTeamController();
		matchController = mainController.getMatchController();
	}

}
