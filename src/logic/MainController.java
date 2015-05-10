package logic;

import java.util.ArrayList;

import test.ParameterExplicate;
import vo.PlayerVO;
import vo.TeamVO;
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
		//注意在转换类型的时候，如果是总数据，参数option就为"all",如果是平均就为"aveg"
		//对球员的操作
		ArrayList<PlayerVO> pr = new ArrayList<PlayerVO>();
		ArrayList<TeamVO> tr = new ArrayList<TeamVO>();
		ArrayList<Object> result = new ArrayList<Object>(); 
		String date = new String();//日期需要解决;
		DataCollector dc = new DataCollector();
		if(parameter.getisPlayer()){
			//平均
			if(parameter.isAvarage()){
			    switch(parameter.getMode().getMode()){
			    	case "all":{
			    		pr = playerController.getAllPlayerVO();
			    	}break;
			    	case "hot":{
			    		switch(parameter.getMode().getField()){
			    			case "score" :{
			    				if(parameter.getMode().isDaily()){
			    					pr = dc.getSomeDayPlayers_Score(date);
			    				}else{
			    					pr = dc.getSeasonHotPlayers_AverScore();
			    				}
			    			}break;
			    			case "assist" :{
			    				if(parameter.getMode().isDaily()){
			    					pr = dc.getSomeDayPlayers_Assist(date);
			    				}else{
			    					pr = dc.getSeasonHotPlayers_AverAssist();
			    				}
			    			}break;
			    			case "rebound" :{
			    				if(parameter.getMode().isDaily()){
			    					pr = dc.getSomeDayPlayers_Rebound(date);
			    				}else{
			    					pr = dc.getSeasonHotPlayers_AverRebound();
			    				}
			    			}break;
			    		}
			    	}break;
			    	case "king":{
			    		switch(parameter.getMode().getField()){
		    			case "score" :{
		    				if(parameter.getMode().isDaily()){
		    					pr.add(dc.getSomeDayPlayers_Score(date).get(0));
		    				}else{
		    					pr.add(dc.getSeasonHotPlayers_AverScore().get(0));
		    				}
		    			}break;
		    			case "assist" :{
		    				if(parameter.getMode().isDaily()){
		    					pr.add(dc.getSomeDayPlayers_Assist(date).get(0));
		    				}else{
		    					pr.add(dc.getSeasonHotPlayers_AverAssist().get(0));
		    				}
		    			}break;
		    			case "rebound" :{
		    				if(parameter.getMode().isDaily()){
		    					pr.add(dc.getSomeDayPlayers_Rebound(date).get(0));
		    				}else{
		    					pr.add(dc.getSeasonHotPlayers_AverRebound().get(0));
		    				}
		    			}break;
		    		}
			    	}break;
			    }
		      }
			//总数据
			else{
				 switch(parameter.getMode().getMode()){
			    	case "all":{
			    		pr = playerController.getAllPlayerVO();
			    	}break;
			    	case "king":{
			    		switch(parameter.getMode().getField()){
		    			case "score" :{
		    				if(parameter.getMode().isDaily()){
		    					pr.add(dc.getSomeDayPlayers_Score(date).get(0));
		    				}else{
		    					pr.add(dc.getSeasonHotPlayers_Score().get(0));
		    				}
		    			}break;
		    			case "assist" :{
		    				if(parameter.getMode().isDaily()){
		    					pr.add(dc.getSomeDayPlayers_Assist(date).get(0));
		    				}else{
		    					pr.add(dc.getSeasonHotPlayers_Assist().get(0));
		    				}
		    			}break;
		    			case "rebound" :{
		    				if(parameter.getMode().isDaily()){
		    					pr.add(dc.getSomeDayPlayers_Rebound(date).get(0));
		    				}else{
		    					pr.add(dc.getSeasonHotPlayers_Rebound().get(0));
		    				}
		    			}break;
		    		}
			    	}break;
			    }
			}
			//pr转result
			
		}
		//对球队的操作,差不多模仿一下player写
		else{
			
			
			
			for(TeamVO vo : tr){
				result.add(vo);
			}
		}
		return result;
	}
	
}
