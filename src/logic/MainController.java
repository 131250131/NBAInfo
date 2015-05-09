package logic;

import java.util.ArrayList;

import test.ParameterExplicate;
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
	
	
	public void updateAllInfo(){
		matchController.updateAll();
		System.out.println("11111");
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

	@Override
	public ArrayList<Object> getResult(ParameterExplicate parameter) {
		// TODO Auto-generated method stub
		//根据各种结果调用方法
		//下面是我写一个基本框架，你填一下然后加一下@阿超
		//对球员的操作
		if(parameter.getisPlayer()){
			//平均
			if(parameter.isAvarage()){
			      if(parameter.getMode().getField().equals("score")){
				          Play
			      }
			//秋员的得分、助攻、抢断、篮板等等最好全都加进去
		      }
			//总数据
			else{
				
			}
		}
		//对球队的操作,差不多模仿一下player写
		else{
			
		}
		return null;
	}
	
}
