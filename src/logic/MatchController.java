package logic;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;

import po.MatchPO;
import data.matchdata.*;
import DataService.MatchDataService;
import logicservice.matchControllerService;
import vo.MatchVO;
import vo.PlayerVO;
import vo.TeamShortName;

//controller都运用了单体模式，每类Controller整个程序中只有一个 ;
public class MatchController implements matchControllerService{
		static ArrayList<Match> allMatches = new ArrayList<Match>();
		static ArrayList<Match> matchesOfTaday = new ArrayList<Match>();
		static MatchDataService matchdata = new Matchdata();
		static ArrayList<MatchPO> allMatchPO = new ArrayList<MatchPO>();
		static ArrayList<MatchVO> allMatchVO = new ArrayList<MatchVO>();
		TeamController teamController = TeamController.getInstance();
		PlayerController playerController = PlayerController.getInstance();
		
		/*
		 * Controller在构造的时候就完成对data层数据的调用；
		 * 这样可以避免多次调用多次读取data层
		 * */
		
		private static MatchController instance =null;
		
		private MatchController(){
			matchdata.readMatch();
			allMatchPO = this.matchdata.getAllMatch();
			//System.out.println(allMatchPO.get(0).getScore()+"111");
//			for(MatchPO matchpo:this.allMatchPO){
//				System.out.println(matchpo.getLeftTeam().getShortName()+" "+matchpo.getLeftTeam().getTeamScores()+
//						matchpo.getRightTeam().getShortName()+" "+matchpo.getRightTeam().getTeamScores());
//			}
			this.processAllMatches();//处理完毕当前的数据;
			this.createAllMatchVO();//获得所有比赛的vo;
			teamController.createSeasonAllTeamInfo();
			playerController.createAllPlayerVO();
		}
		
		public static MatchController getInstance(){
			if(instance == null){
				instance = new MatchController();
			}
			return instance;
		}
		
		public boolean hasUpdate(){
			return matchdata.Matchupdate();
		}
		
		public void updateAll(){
			playerController.updatePlayersInfo_Basic();
			teamController.updateTeamInfo_Basic();
			matchdata.readMatch();
			allMatchPO = this.matchdata.getAllMatch();
			this.processAllMatches();//处理完毕当前的数据;
			this.createAllMatchVO();//获得所有比赛的vo;
			teamController.createSeasonAllTeamInfo();
			playerController.createAllPlayerVO();
		}
		
		//返回所有未经处理过的比赛信息;
		public ArrayList<MatchVO> getAllMatchVO(){
			
			return this.allMatchVO;
		}
		
		public void createAllMatchVO(){
			for(Match match : this.allMatches){
				MatchVO vo = new MatchVO();
				vo.creatMatchvo(match);
				this.allMatchVO.add(vo);
			}
		}
		
		//对所有match进行处理;现在已处理完毕
		//这个方法调用结束之后，所有的球员球队match都已经搞定;
		public void processAllMatches(){
			for(MatchPO matchpo:this.allMatchPO){
				Match tempMatch = new Match();
				tempMatch.creatmatch(matchpo);//match数据更新;
				this.allMatches.add(tempMatch);
				
				//System.out.println(tempMatch.getNum());
				//System.out.println(tempMatch.getLeftTeam().getTeamFGTry());
				teamController.updateTeamInfo_Advanced(tempMatch.getLeftTeam(), tempMatch.getRightTeam(),false);
				teamController.updateTeamInfo_Advanced(tempMatch.getRightTeam(), tempMatch.getLeftTeam(),true);
				
				
				//team 更新完毕;
				for(Player tempPlayer: tempMatch.getleftplayers()){
					playerController.updataPlayersInfo_Advanced(tempPlayer,tempMatch.getLeftTeam());
					//System.out.println(tempPlayer.getPlayerPlayTime());
				}
				for(Player tempPlayer: tempMatch.getrightplayers()){
					playerController.updataPlayersInfo_Advanced(tempPlayer,tempMatch.getRightTeam());
				}
				//System.out.println(tempMatch.getNum());
				
				//这两个循环用来更新球员数据

			}
		}
		
		//根据具体日期来选择比赛;
		public ArrayList<MatchVO> getSomeMacthVO(String date){
			ArrayList<MatchVO> someMatchVO = new ArrayList<MatchVO>();
			for(MatchVO matchvo : this.getAllMatchVO()){
				if(matchvo.getDetaildate().equals(date)){
					someMatchVO.add(matchvo);
				}
			}
			return someMatchVO;
		}
		
		//此方法用来获得某个球员参与的所有比赛;
		//我有预感 在attendedMatches这边会出错......
		public ArrayList<MatchVO> getSomeMatchVO(String playerName){
			PlayerController playerController = PlayerController.getInstance();
			ArrayList<MatchVO> someMatchVO = new ArrayList<MatchVO>();			
			Player player = playerController.findPlayer(playerName);
			for(int i : player.getAttendedMatches()){
				someMatchVO.add(this.allMatchVO.get(i));
			}
			return someMatchVO;
		}
		
		//此方法用于获得某球队参与的所有比赛;
		public ArrayList<MatchVO> getSomeMatchVO(TeamShortName teamShortName){
			ArrayList<MatchVO> someMatchVO = new ArrayList<MatchVO>();	
			for(MatchVO vo : this.getAllMatchVO()){
				if(vo.getLeftTeam().getShortName().equals(teamShortName)||
				   vo.getRightTeam().getShortName().equals(teamShortName)){
					someMatchVO.add(vo);
				}
			}	
			return someMatchVO;
		}

		public Object[][] getTeamData(String team, int matchnum) {
			return new Match().getData(team, matchnum);
		}

		/*通过场次num找到match返回vo*/
		public MatchVO getMatch(int num) {
			createAllMatchVO();
			return this.allMatchVO.get(num);
			
		}
		
		
		
		public double playeradvcal(String name,ArrayList<Integer> attendedMatches,String type){
        	ArrayList<Match> resultmatch=new ArrayList<Match>();
        	//System.out.println(attendedMatches.size());
        	double form_total=0;
            double now_total=0;
        	double now_aveg=0;
        	double form_aveg=0;
        	int have=0;
        	
        	for(Integer i:attendedMatches){
        		for(MatchPO matchpo:allMatchPO){
        			if(i.equals(matchpo.getNum())){
        				Match match=new Match();
        				match.creatmatch(matchpo);
        				resultmatch.add(match);
        				break;
        			}
        		}
        		}
        	Collections.sort(resultmatch);
        	if(resultmatch.size()<=5){
        		return 0;
        	}
        	else{
        		//System.out.println("true"+resultmatch.size());
        		     
        			for(int i=0;i<5;i++){   
        				    have=0;
                			ArrayList<Player> l=resultmatch.get(i).getleftplayers();
                			ArrayList<Player> r=resultmatch.get(i).getrightplayers();
                			for(Player lp:l){
                				if(lp.getPlayerName().equals(name)){
                					now_total=now_total+lp.getaddate(type);
                					
                				    have=1;
                				    break;
                			}
                			}
                		    if(have==0){
                		    	for(Player rp:r){
                    				if(rp.getPlayerName().equals(name)){
                    					now_total=now_total+rp.getaddate(type);
                    					//System.out.println("true"+rp.getaddate(type));
                    				    break;
                    			}
                		    }
                		}
        			}
        			now_aveg=now_total/5;
        			//System.out.println("true"+now_aveg);
        			for(int j=5;j<resultmatch.size();j++){   
    				    have=0;
            			ArrayList<Player> lplayer=resultmatch.get(j).getleftplayers();
            			ArrayList<Player> rplayer=resultmatch.get(j).getrightplayers();
            			for(Player lp:lplayer){
            				if(lp.getPlayerName().equals(name)){
            				    form_total=form_total+lp.getaddate(type);
            				    have=1;
            				    break;
            			}
            			}
            		    if(have==0){
            		    	for(Player rp:rplayer){
                				if(rp.getPlayerName().equals(name)){
                					form_total=form_total+rp.getaddate(type);
                				    break;
                			}
            		    }
            		}
        		}
        			
        			form_aveg=form_total/(double)(resultmatch.size()-5);
        			//System.out.println("FALSE"+form_aveg);
        			if(form_aveg==0){
        				return 0;
        			}
        			//System.out.println("FALSE"+(now_aveg-form_aveg)/(form_aveg));
        			return (now_aveg-form_aveg)/(form_aveg);
        		}
        		
        		
        	
        	
        	
        	
        	}
        	

		public ArrayList<MatchVO> getMatchOfPlayer(String playerName) {
			ArrayList<MatchVO> list = new ArrayList<MatchVO>();
			PlayerVO vo = playerController.findPlayerVO(playerName);
			createAllMatchVO();
			ArrayList<Integer> numList = vo.getAttendedMatches();
			for(Integer i : numList){
				list.add(this.allMatchVO.get(i));
				System.out.println(i);
			}
			return list;
		}

		@Override
		public ArrayList<MatchVO> gettodaysmatch() {
			//该方法可能会用到
			// TODO Auto-generated method stub
			//ArrayList<MatchVO> matchvo =new ArrayList<MatchVO>();
			//Date today=new Date();
			return null;
		}

		@Override
		public ArrayList<String> getDatehavematches() {
			// TODO Auto-generated method stub
			ArrayList<String> havematches =new ArrayList<String>();
			for(MatchPO matchpo:this.allMatchPO){
				String ddate =matchpo.getDetaildate();
				if(!havematches.contains(ddate)){
					havematches.add(ddate);
				}
			}
			Collections.sort(havematches);
			return havematches;
		}

		@Override
		public int getAllMatchesNum() {
			return this.allMatches.size();
		}
			
}

		

