package ui.system;

import java.util.ArrayList;

import ui.frame.larger.LargerPanel;
import ui.frame.larger.LargerScrollPane;
import ui.frame.mainframe.MainFrame;
import vo.MatchVO;
import vo.PlayerVO;
import logic.AssociationData;
import logic.DataCollector;
import logic.MainController;
import logicservice.DataCollectorService;
import logicservice.associationDataService;
import logicservice.mainControllerService;
import logicservice.matchControllerService;
import logicservice.playerControllerService;
import logicservice.teamControllerService;

public class Controller {
	
	public static playerControllerService playerController;
	public static teamControllerService teamController;
	public static matchControllerService matchController;
	public static associationDataService associationController;
	public static DataCollectorService dataCollectorService;
	public static String currentPlayerName, currentTeamName;
	public static MatchVO currentMatch;
	public static String today;
	
	public static void start(){
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	}
	
	public static void init(){
		mainControllerService mainController = new MainController();
		mainController.init();
		playerController = mainController.getPlayerController();
		teamController = mainController.getTeamController();
		matchController = mainController.getMatchController();
		dataCollectorService = new DataCollector();
		associationController = new AssociationData();
		readAllMatch();
		setUpRank();
	}
	
	public static void reInit(){
		mainControllerService mainController = new MainController();
		mainController.init();
		playerController = null;
		playerController = mainController.getPlayerController();
		teamController = null;
		teamController = mainController.getTeamController();
		matchController = null;
		matchController = mainController.getMatchController();
		dataCollectorService = null;
		dataCollectorService = new DataCollector();
		associationController = null;
		associationController = new AssociationData();
		readAllMatch();
		setUpRank();
	}
	
	public static ArrayList<String> dateList;
	
	public static ArrayList<PlayerVO> today_Scores, today_Assists, today_rebounds, today_blocks, today_steals, today_FTP, today_3FTP, today_FP;
	public static ArrayList<PlayerVO> all_Scores, all_Assists, all_rebounds, all_blocks, all_steals, all_FTP, all_3FTP, all_FP;
	
	public static void setUpRank(){	
		today_Scores = Controller.dataCollectorService.getSomeDayPlayers_Score(today);
		today_Assists = Controller.dataCollectorService.getSomeDayPlayers_Assist(today);
		today_rebounds = Controller.dataCollectorService.getSomeDayPlayers_Rebound(today);
		today_blocks = Controller.dataCollectorService.getSomeDayPlayers_Block(today);	
		today_steals = Controller.dataCollectorService.getSomeDayPlayers_Steal(today);	
		today_FP = Controller.dataCollectorService.getSomeDayPlayers_FGP(today);
		today_3FTP = Controller.dataCollectorService.getSomeDayPlayers_3FGP(today);
		today_FTP = Controller.dataCollectorService.getSomeDayPlayers_FTGP(today);
		all_Scores = Controller.dataCollectorService.getSeasonHotPlayers_AverScore();
		all_Assists = Controller.dataCollectorService.getSeasonHotPlayers_AverAssist();
		all_rebounds = Controller.dataCollectorService.getSeasonHotPlayers_AverRebound();
		all_blocks = Controller.dataCollectorService.getSeasonHotPlayers_AverBlock();
		all_steals = Controller.dataCollectorService.getSeasonHotPlayers_AverSteal();
		all_FP = Controller.dataCollectorService.getSeasonHotPlayers_FGP();
		all_3FTP = Controller.dataCollectorService.getSeasonHotPlayers_3FGP();
		all_FTP = Controller.dataCollectorService.getSeasonHotPlayers_FTGP();
	}
	
	public static void readAllMatch(){
		dateList = Controller.matchController.getDatehavematches();
		today = Controller.dateList.get(dateList.size() - 1);
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
	
}
