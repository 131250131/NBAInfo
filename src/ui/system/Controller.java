package ui.system;

import ui.frame.larger.LargerPanel;
import ui.frame.larger.LargerScrollPane;
import logic.MainController;
import logicservice.mainControllerService;
import logicservice.matchControllerService;
import logicservice.playerControllerService;
import logicservice.teamControllerService;

public class Controller {
	
	public static playerControllerService playerController;
	public static teamControllerService teamController;
	public static matchControllerService matchController;
	
	public static String currentPlayerName;
	
	public static void init(){
		mainControllerService mainController = new MainController();
		mainController.init();
		playerController = mainController.getPlayerController();
		teamController = mainController.getTeamController();
		matchController = mainController.getMatchController();
	}
	
	public static void addPlayerPanel(String playerName){
		currentPlayerName = playerName;
		LargerPanel.addPlayerPanel.doClick();
		switch(UIData.currentStep){
		case 1:
			LargerScrollPane.turnto2.doClick();break;
		case 2:
			LargerScrollPane.turnto1.doClick();break;
		case 3:
			LargerScrollPane.turnto0.doClick();break;
		}	
	}

}
