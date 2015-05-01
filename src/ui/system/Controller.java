package ui.system;

import ui.frame.larger.LargerPanel;
import ui.frame.larger.LargerScrollPane;
import logic.MainController;
import logic.MatchController;
import logic.PlayerController;
import logic.TeamController;

public class Controller {
	
	public static PlayerController playerController;
	public static TeamController teamController;
	public static MatchController matchController;
	
	public static String currentPlayerName;
	
	public static void init(){
		MainController mainController = MainController.getInstance();
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
