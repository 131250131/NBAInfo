package logic;

import java.util.ArrayList;
import java.util.Collections;

import Utibility.playercomp;
import Utibility.teamcomp;
import test.Filter;
import test.ParameterExplicate;
import test.Sort;
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
		ArrayList<Sort> sort=parameter.getSortList();
	    ArrayList<Filter> filter = parameter.getFilterList();
		int n=parameter.getNumber();
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
			    if(parameter.getMode().getMode().equals("hot")){
			    	for(PlayerVO vo : pr){
			    		result.add(vo.getPLayerHOTInfo(parameter.getMode().getField()));
			    	}
			    }if(parameter.getMode().getMode().equals("king")){
			    	for(PlayerVO vo : pr){
			    		result.add(vo.getPlayerKingInfo(parameter.getMode().getField()));
			    	}
			    }
			    
			    

			    
			    
		      }
			//总数据
			else{
				 switch(parameter.getMode().getMode()){
				 case "all":{
			    		pr = playerController.getAllPlayerVO();
			    		if(parameter.isHigh()){
			    			if(sort.size()!=0){
			    				playercomp pl=new playercomp();
			    				pl.setSort(sort);
			    				pl.setAveg("total");
			    				Collections.sort(pr,pl);
			    			}//有排序
			    			if(filter.size()!=0){
			    				pr = playerController.getAllPlayerVO();
			    				for(int i=0;i<filter.size();i++){
			    					Filter temp = filter.get(i);
			    					switch(temp.getFilterName()){
			    					case "position":pr=playerController.getSelectedPlayers_Position(pr, temp.getFilterValue()); break;
			    					case "league":pr=playerController.getSelectedPlayers_Distribution(pr, temp.getFilterValue());break;
			    					case "age":pr=playerController.getSelectedPlayers_Age(pr, temp.getRange());break;
			    					}
			    				}
			    				
			    				//筛选操作。。。阿超你来弄一下
			    				//筛选写完了。
			    			}//有筛选
			    			if(n>pr.size()){
			    				for(int i=0;i<pr.size();i++){
			    					result.add(pr.get(i).getPlayerHighInfo("total"));
			    				}
			    			}
			    			else{
			    				for(int i=0;i<n;i++){
			    					result.add(pr.get(i).getPlayerHighInfo("total"));
			    				}
			    			}
			    			return result;
			    		}
			    		else{
			    			if(sort.size()!=0){
			    				playercomp pl=new playercomp();
			    				pl.setSort(sort);
			    				pl.setAveg("total");
			    				Collections.sort(pr,pl);
			    			}//有排序
			    			if(filter.size()!=0){
			    				pr = playerController.getAllPlayerVO();
			    				for(int i=0;i<filter.size();i++){
			    					Filter temp = filter.get(i);
			    					switch(temp.getFilterName()){
			    					case "position":pr=playerController.getSelectedPlayers_Position(pr, temp.getFilterValue()); break;
			    					case "league":pr=playerController.getSelectedPlayers_Distribution(pr, temp.getFilterValue());break;
			    					case "age":pr=playerController.getSelectedPlayers_Age(pr, temp.getRange());break;
			    					}
			    				}
			    			}//有筛选
			    			if(n>pr.size()){
			    				for(int i=0;i<pr.size();i++){
			    					result.add(pr.get(i).getPlayerNormalInfo("total"));
			    				}
			    			}
			    			else{
			    				for(int i=0;i<n;i++){
			    					result.add(pr.get(i).getPlayerNormalInfo("total"));
			    				}
			    			}
			    			return result;
			    		}
				 }
				 case "hot":{
			    		switch(parameter.getMode().getField()){
			    			case "score" :{
			    				if(parameter.getMode().isDaily()){
			    					pr = dc.getSomeDayPlayers_Score(date);
			    				}else{
			    					pr = dc.getSeasonHotPlayers_Score();
			    				}
			    			}break;
			    			case "assist" :{
			    				if(parameter.getMode().isDaily()){
			    					pr = dc.getSomeDayPlayers_Assist(date);
			    				}else{
			    					pr = dc.getSeasonHotPlayers_Assist();
			    				}
			    			}break;
			    			case "rebound" :{
			    				if(parameter.getMode().isDaily()){
			    					pr = dc.getSomeDayPlayers_Rebound(date);
			    				}else{
			    					pr = dc.getSeasonHotPlayers_Rebound();
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
				if(parameter.getMode().getMode().equals("hot")){
				    for(PlayerVO vo : pr){
				    	result.add(vo.getPLayerHOTInfo(parameter.getMode().getField()));
				    }
				}if(parameter.getMode().getMode().equals("king")){
				    for(PlayerVO vo : pr){
				    	result.add(vo.getPlayerKingInfo(parameter.getMode().getField()));
				    }
				}
			}	
		}
		//对球队的操作,差不多模仿一下player写
		else{
			if(parameter.isAvarage()){
			    switch(parameter.getMode().getMode()){
			    	case "all":{
			    		tr = teamController.allTeamVO;
			    	}break;
			    	case "hot":{
			    		switch(parameter.getMode().getField()){
			    			case "score" :{tr=teamController.getSeasonHotTeams_AverScore();}break;
			    			case "assist" :{tr=teamController.getSeasonHotTeams_AverAssist();}break;
			    			case "rebound" :{tr=teamController.getSeasonHotTeams_AverRebound();}break;
			    			case"blockShot":{tr=teamController.getSeasonHotTeams_AverBlock();}break;
			    			case"steal":{tr=teamController.getSeasonHotTeams_AverSteal();}break;
			    			case"foul":{tr=teamController.getSeasonHotTeams_AverFouls();}break;
			    			case"fault":{tr=teamController.getSeasonHotTeams_AverTurnovers();}break;
			    			case"shot":{tr=teamController.getSeasonHotTeams_FGP();}break;
			    			case"three":{tr=teamController.getSeasonHotTeams_3FGP();}break;
			    			case"penalty":{tr=teamController.getSeasonHotTeams_FTGP();}break;
			    			case"defendRebound":{tr=teamController.getSeasonHotTeams_AverDeffenceRebound();}break;
			    			case"offendRebound":{tr=teamController.getSeasonHotTeams_AverOffenceRebound();}break;
			    		}
			    	}break;
			    }
			    if(parameter.getMode().getMode().equals("hot")){
			    	for(TeamVO vo :tr){
			    		result.add(vo.getTeamHotInfo(parameter.getMode().getField(),"aveg"));
			    	}
			    }
		      }
			//总数据
			else{
				 switch(parameter.getMode().getMode()){
				 case "all":{
			    		pr = playerController.getAllPlayerVO();
			    		if(parameter.isHigh()){
			    			if(sort.size()!=0){
			    				teamcomp tl=new teamcomp();
			    				tl.setSort(sort);
			    				tl.setAveg("total");
			    				Collections.sort(tr,tl);
			    			}//有排序
			    			if(n>tr.size()){
			    				for(int i=0;i<tr.size();i++){
			    					result.add(tr.get(i).getTeamHighInfo("total"));
			    				}
			    			}
			    			else{
			    				for(int i=0;i<n;i++){
			    					result.add(tr.get(i).getTeamHighInfo("total"));
			    				}
			    			}
			    			return result;
			    		}
			    		else{
			    			if(sort.size()!=0){
			    				teamcomp tl=new teamcomp();
			    				tl.setSort(sort);
			    				tl.setAveg("total");
			    				Collections.sort(tr,tl);
			    			}//有排序
			    			if(n>pr.size()){
			    				for(int i=0;i<tr.size();i++){
			    					result.add(tr.get(i).getTeamNormalInfo("total"));
			    				}
			    			}
			    			else{
			    				for(int i=0;i<n;i++){
			    					result.add(tr.get(i).getTeamNormalInfo("total"));
			    				}
			    			}
			    			return result;
			    		}
				 }
				 case "hot":{
			    		switch(parameter.getMode().getField()){
			    			case "score" :{tr=teamController.getSeasonHotTeams_Score();}break;
			    			case "assist" :{tr=teamController.getSeasonHotTeams_Assist();}break;
		    				case "rebound" :{tr=teamController.getSeasonHotTeams_Rebound();}break;
		    				case"blockShot":{tr=teamController.getSeasonHotTeams_Block();}break;
		    				case"steal":{tr=teamController.getSeasonHotTeams_Steal();}break;
		    				case"foul":{tr=teamController.getSeasonHotTeams_Fouls();}break;
		    				case"fault":{tr=teamController.getSeasonHotTeams_Turnovers();}break;
		    				case"shot":{tr=teamController.getSeasonHotTeams_FGP();}break;
		    				case"three":{tr=teamController.getSeasonHotTeams_3FGP();}break;
		    				case"penalty":{tr=teamController.getSeasonHotTeams_FTGP();}break;
		    				case"defendRebound":{tr=teamController.getSeasonHotTeams_DeffenceRebound();}break;
		    				case"offendRebound":{tr=teamController.getSeasonHotTeams_OffenceRebound();}break;
			    		}
			    	}break;
			    }
				 if(parameter.getMode().getMode().equals("hot")){
				    	for(TeamVO vo :tr){
				    		result.add(vo.getTeamHotInfo(parameter.getMode().getField(),"total"));//这边是tota还是all?
				    	}
				 }
			}
			
			
			
		
		}
		return result;
	}
	
}
