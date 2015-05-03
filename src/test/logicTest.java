package test;

import java.util.ArrayList;

import vo.PlayerVO;
import vo.TeamVO;
import logic.DataCollector;
import logic.MainController;
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
//		ArrayList<PlayerVO> p=playerController.getplayerbyteam("MIA");
//		for(PlayerVO pl:p){
//			System.out.println(pl.getTeamShortName());
//		}
//		
//		ArrayList<PlayerVO> temp = playerController.getSelectedPlayers("后卫", "西南区", "助攻");
//		for(PlayerVO vo : temp){
//			System.out.println(vo.getPlayerName()+" "+vo.getAver_playerScores()+" "+vo.getPlayer3FG());
//		}
//		System.out.println("hhh");
		
		
//		DataCollectorService dc= new DataCollector();
//		ArrayList<PlayerVO> list = dc.getSeasonHotPlayers_3FGP();
//		for(PlayerVO pl:list){
//			System.out.println(pl.getTeamShortName()+" "+pl.getPlayer3FGP()+" "+pl.getPlayerName());
//		}
		
//		ArrayList<PlayerVO> list = playerController.getAllPlayerVO();
//		for(PlayerVO pl:list){
//			System.out.println(pl.getPlayerName()+" "+pl.getPlayerFTG());
//		}
		PlayerVO vo = playerController.findPlayerVO("Andrew Bogut");
		System.out.println(vo.getPlayerName()+" "+vo.getPlayerFTG()+" "+vo.getPlayerScores()+" "
		+vo.getPlayerAttends()+" "+vo.getAver_playerFG());
	}
	
}
