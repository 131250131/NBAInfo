package logic;

import logicservice.mainControllerService;

/*
 * 这个类主要是用来初始化，以及是用来初试化其他的子Controller，以及对所有的VO进行生成;
 * 这样ui层调用的时候就不会出现问题;
 * 构造阶段，测试单个功能时，先调用下MainController的getInstance;
 * 最终版本里，ui层只要调用一次就行;
 * */

public class MainController implements mainControllerService{
	
	PlayerController playerController;
	TeamController teamController;
	MatchController matchController;
	
	public MainController(){
		
	}
	
	public void init(){
		playerController = PlayerController.getInstance();
		teamController = TeamController.getInstance();
		matchController = MatchController.getInstance();
	}
	
	public boolean hasUpdate(){
		return matchController.hasUpdate();
	}
	
	public void updateAllInfo(){
		matchController.updateAll();
	}
	
	public PlayerController getPlayerController(){
		return playerController;
	}
	
	public TeamController getTeamController(){
		return teamController;
	}
	
	public MatchController getMatchController(){
		return matchController;
	}
	
}
