package ui.system;

import java.util.ArrayList;

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
		mainControllerService mainController = new MainController();
		mainController.init();
		playerController = new PlayerControllerThird();
		teamController = new TeamControllerThird();
		matchController = new MatchControllerThird();
		readAllMatch();
		setUpRank();
	}
	
//	public static void reInit(){
//		mainControllerService mainController = new MainController();
//		mainController.init();
//		playerController = mainController.getPlayerController();
//		teamController = mainController.getTeamController();
//		matchController = mainController.getMatchController();
//		dataCollectorService = new DataCollector();
//		associationController = new AssociationData();
//		clear();
//		readAllMatch();
//		setUpRank();
//	}
	
	public static ArrayList<String> dateList;
	
	public static ArrayList<PlayerVO> today_Scores, today_Assists, today_rebounds, today_blocks, today_steals, today_FTP, today_3FTP, today_FP;
	public static ArrayList<PlayerVO> all_Scores, all_Assists, all_rebounds, all_blocks, all_steals, all_FTP, all_3FTP, all_FP;
	
	public static void setUpRank(){	
//		today_Scores = Controller.playerController..getSomeDayPlayers_Score(today);
//		today_Assists = Controller.dataCollectorService.getSomeDayPlayers_Assist(today);
//		today_rebounds = Controller.dataCollectorService.getSomeDayPlayers_Rebound(today);
//		today_blocks = Controller.dataCollectorService.getSomeDayPlayers_Block(today);	
//		today_steals = Controller.dataCollectorService.getSomeDayPlayers_Steal(today);	
//		today_FP = Controller.dataCollectorService.getSomeDayPlayers_FGP(today);
//		today_3FTP = Controller.dataCollectorService.getSomeDayPlayers_3FGP(today);
//		today_FTP = Controller.dataCollectorService.getSomeDayPlayers_FTGP(today);
//		all_Scores = Controller.dataCollectorService.getSeasonHotPlayers_AverScore();
//		all_Assists = Controller.dataCollectorService.getSeasonHotPlayers_AverAssist();
//		all_rebounds = Controller.dataCollectorService.getSeasonHotPlayers_AverRebound();
//		all_blocks = Controller.dataCollectorService.getSeasonHotPlayers_AverBlock();
//		all_steals = Controller.dataCollectorService.getSeasonHotPlayers_AverSteal();
//		all_FP = Controller.dataCollectorService.getSeasonHotPlayers_FGP();
//		all_3FTP = Controller.dataCollectorService.getSeasonHotPlayers_3FGP();
//		all_FTP = Controller.dataCollectorService.getSeasonHotPlayers_FTGP();
	}
	
	public static void clear(){
		today_Scores.clear();
		today_Assists.clear();
		today_rebounds.clear();
		today_blocks.clear();
		today_steals.clear();	
		today_FP.clear();
		today_3FTP.clear();
		today_FTP.clear();
		all_Scores.clear();
		all_Assists.clear();
		all_rebounds.clear();
		all_blocks.clear();
		all_steals.clear();
		all_FP.clear();
		all_3FTP.clear();
		all_FTP.clear();
		dateList.clear();
	}
	
	public static void readAllMatch(){
		//dateList = Controller.matchController.getDatehavematches();
		//today = Controller.dateList.get(dateList.size() - 1);
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
	
}
