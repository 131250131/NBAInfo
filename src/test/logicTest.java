package test;

import java.util.ArrayList;


import data.matchdata.Matchdata;

import Utibility.JudgeUpdate;
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


         
//       JudgeUpdate j =new JudgeUpdate();
//       j.start();
//       
		ArrayList<PlayerVO> temp = playerController.getAllPlayerVO();
		for(PlayerVO vo : temp){
			System.out.println(vo.getPlayerName()+" "+vo.getUR()+vo.getPlayer3FG());
		}
		
		
      // JudgeUpdate j =new JudgeUpdate("data/data/matches");
       //j.run();
//		Controller controlelr = new Controller();
//		Controller.init();
//		Controller.setUpRank();
//		ArrayList<PlayerVO> temp = Controller.all_Scores;
//		for(PlayerVO vo : temp){
//		System.out.println(vo.getPlayerName()+" "+vo.getAver_playerScores());
//		}


//        ArrayList<TeamVO> t =teamController.getteamrank();
//        for(TeamVO tt:t){
//        	System.out.println(tt.getTeamName()+tt.getWinRate());
//        }
		
//	    JudgeUpdate h=new JudgeUpdate("data/data/matches");
	  //  h.run();
		/*
			if(mainController.hasUpdate()){
				mainController.updateAllInfo();
			}else{
				System.out.println(matchController.getAllMatchesNum()+"-----");
			}
		
*/ 
	
        

//		ArrayList<PlayerVO> temp = playerController.getSelectedPlayers("后卫", "西南区", "助攻");
//		for(PlayerVO vo : temp){
//			System.out.println(vo.getPlayerName()+" "+vo.getAver_playerScores()+" "+vo.getPlayerAssists());
//		}
//		System.out.println("hhh");
		
//		if(mainController.hasUpdate()){
//			mainController.updateAllInfo();
//		}
		
        

	}

		
	   


		

//		ArrayList<TeamVO> t=teamController.getSeasonAllTeamInfo();
//		for(TeamVO te:t){
//			System.out.println(te.getShortName()+" "+te.getWinRate());
//		}
		
////
//		ArrayList<TeamVO> list = dc.getSeasonHotTeams_Score();
//		for(TeamVO vo : list){
//			System.out.println(vo.getShortName()+ " "+vo.getTeamScores());
//		}
		
//		ArrayList<PlayerVO> p=dc.getSeasonHotPlayers_AverBlock();
//		for(PlayerVO pl:p){
//				System.out.println(pl.getPlayerName()+pl.getAver_playerBlocks());
//		}
		
//		ArrayList<PlayerVO> p=playerController.getPlayerbyChar('B');
//		for(PlayerVO pl:p){
//			//System.out.println(pl.getPlayerName());
//		}
//		
//		ArrayList<PlayerVO> pp=playerController.getPlayerbyChar('B');
//		for(PlayerVO pl:pp){
//			System.out.println(pl.getPlayerName());
//		}
		
//		for(PlayerVO pl:list){
//			System.out.println(pl.getTeamShortName()+" "+pl.getPlayerSteals()+ " "+pl.getPlayerAssists()+" "+pl.getPlayerGmScER()+" "+pl.getPlayerName()+"???");
//		}
//		System.out.println("??ttt??");
//		ArrayList<PlayerVO> o=playerController.getAllPlayerVO();
//		for(PlayerVO pl:o){
//
//			//System.out.println(pl.getPlayerGmScER());
//		}
//		/*
//		ArrayList<TeamVO> t=teamController.getSeasonAllTeamInfo();
//		for(TeamVO te:t){
//			System.out.println();
//		}
//		*/
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

		/*
		ArrayList<PlayerVO> temp = playerController.getSelectedPlayers("后卫", "西南区", "助攻");
		for(PlayerVO vo : temp){
			System.out.println(vo.getPlayerName()+" "+vo.getAver_playerScores()+" "+vo.getPlayerAssists());
		}
		System.out.println("hhh");
		*/

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
//		Controller controller = new Controller();
//		controller.init();
//		matchControllerService matchController = controller.matchController;
//		
//		ArrayList<MatchVO> list = matchController.getAllMatchVO();
//		MatchVO vo =list.get(0);
//		System.out.println(vo.getLeftTeam().getTeamScores()+vo.getLeftTeam().getShortName()
//				);
		
///	ArrayList<MatchVO> list = matchController.getAllMatchVO();
//		for(MatchVO vo : list){
//			System.out.println(vo.getLeftTeam().getShortName()+" "+vo.getLeftTeam().getTeamScores()+
//					vo.getRightTeam().getShortName()+" "+vo.getRightTeam().getTeamScores());
//		}
//		
//		//Kevin Durant
//		matchController.getMatchOfPlayer("Kevin Durant");
//		
//		DataCollectorService dc= new DataCollector();
//		ArrayList<PlayerVO> list = dc.getSeasonHotPlayers_Rebound();
//		for(PlayerVO pl:list){
//			System.out.println(pl.getPlayerName()+" "+pl.getPlayerTotalRebounds());
//		}
		

}

