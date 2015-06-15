package ui.system;

import thirdVersion.MatchControllerThird;
import thirdVersion.PlayerControllerThird;
import thirdVersion.TeamControllerThird;
import thirdservice.matchControllerThirdService;
import thirdservice.playerControllerThirdService;
import thirdservice.teamControllerThirdService;
import ui.frame.larger.LargerPanel;
import ui.frame.larger.LargerScrollPane;
import ui.frame.mainframe.MainFrame;
import vo.MatchVO;

public class Controller {
	
	public static playerControllerThirdService playerController;
	public static teamControllerThirdService teamController;
	public static matchControllerThirdService matchController;
	public static String currentPlayerName, currentTeamName;
	public static MatchVO currentMatch;
	public static String today;
	
	public static void start(){
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	}
	
	public static void init(){
		playerController = new PlayerControllerThird();
		teamController = new TeamControllerThird();
		matchController = new MatchControllerThird();
	}
	
	public static void addMatchPanel(MatchVO match){
		currentMatch = match;
		LargerPanel.addMatchPanel.doClick();
		LargerScrollPane.turnto.doClick();
	}
	
	public static void addPlayerPanel(String playerName){
		currentPlayerName = playerName;
		LargerPanel.addPlayerPanel.doClick();
		LargerScrollPane.turnto.doClick();
		
	}
	
	public static void addTeamPanel(String teamShortName){		
		currentTeamName = teamShortName;
		LargerPanel.addTeamPanel.doClick();
		LargerScrollPane.turnto.doClick();		
	}
	
	public static void addLivePanel(){
		LargerPanel.addLivePanel.doClick();
		LargerScrollPane.turnto.doClick();	
	}
	
	public static void addOldTeam(){
		LargerPanel.addOldTeam.doClick();
		LargerScrollPane.turnto.doClick();	
	}
	
	public static void addTJ1(){
		LargerPanel.addTJ1.doClick();
		LargerScrollPane.turnto.doClick();	
	}
	
	public static void addTJ2(){
		LargerPanel.addTJ2.doClick();
		LargerScrollPane.turnto.doClick();	
	}
	
	public static void addTJ3(){
		LargerPanel.addTJ3.doClick();
		LargerScrollPane.turnto.doClick();	
	}
	
	public static void addTJ4(){
		LargerPanel.addTJ4.doClick();
		LargerScrollPane.turnto.doClick();	
	}
}
