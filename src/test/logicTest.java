package test;

import java.util.ArrayList;

import ui.system.Controller;
import vo.MatchVO;
import vo.PlayerVO;
import vo.TeamVO;
import logic.DataCollector;
import logic.MainController;
import logic.PlayerController;
import logic.TeamController;
import logicservice.DataCollectorService;
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
		
		DataCollectorService dc= new DataCollector();

		
//		ArrayList<PlayerVO> list = dc.getSomeDayPlayers_Assist("2014-04-16");
//		for(PlayerVO vo : list){
//			System.out.println(vo.getPlayerName()+" "+vo.getPlayerAssists());
//		}
//		System.out.println("-----------------------------------");
//
//		ArrayList<PlayerVO> list2 = dc.getSomeDayPlayers_Steal("2014-04-16");
//		for(PlayerVO vo : list2){
//			System.out.println(vo.getPlayerName()+" "+vo.getPlayerSteals());
//		}
		

		ArrayList<PlayerVO> list2 = dc.getSeasonHotPlayers_AverAssist();
		for(PlayerVO vo : list2){
			System.out.println(vo.getPlayerName()+" "+vo.getAver_playerAssists());
		}
		System.out.println("-----------------------------------");
		ArrayList<PlayerVO> list = dc.getSeasonHotPlayers_AverRebound();
		for(PlayerVO vo : list){
			System.out.println(vo.getPlayerName()+" "+vo.getAver_playerTotalRebounds());
		}
		
		
        }
}
