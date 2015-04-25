package logic;

import java.sql.Date;
import java.util.ArrayList;

import po.MatchPO;
import data.matchdata.*;
import DataService.MatchDataService;
import logicservice.matchControllerService;
import vo.MatchVO;
import vo.TeamShortName;

//controller都运用了单体模式，每类Controller整个程序中只有一个 ;
public class MatchController implements matchControllerService{
		ArrayList<Match> allMatches = new ArrayList<Match>();
		ArrayList<Match> matchesOfTaday = new ArrayList<Match>();
		MatchDataService matchdata = new Matchdata();
		ArrayList<MatchPO> allMatchPO = new ArrayList<MatchPO>();
		ArrayList<MatchVO> allMatchVO = new ArrayList<MatchVO>();
		TeamController teamController = TeamController.getInstance();
		PlayerController playerController = PlayerController.getInstance();
		
		/*
		 * Controller在构造的时候就完成对data层数据的调用；
		 * 这样可以避免多次调用多次读取data层
		 * */
		
		private MatchController(){
			allMatchPO = this.matchdata.getAllMatch();
			this.processAllMatches();//处理完毕当前的数据;
		}
		
		//返回所有未经处理过的比赛信息;
		public ArrayList<MatchVO> getAllMatchVO(){
			MatchDataService matchdata = new Matchdata();
			ArrayList<MatchVO> allMatchVO = new ArrayList<MatchVO>();
//			for(MatchPO tempMatchPO: allMatchPO){
//				allMatchVO.add(this.match_VO2PO(tempMatchPO));
//			}
			return allMatchVO;
		}
		
		//对所有match进行处理;现在已处理完毕
		public void processAllMatches(){
			for(MatchPO matchpo:this.allMatchPO){
				Match tempMatch = new Match();
				tempMatch.creatmatch(matchpo);//match数据更新;
				this.allMatches.add(tempMatch);
				
				this.teamController.updateTeamInfo_Advanced(tempMatch.getLeftTeam(), tempMatch.getRightTeam());
				this.teamController.updateTeamInfo_Advanced(tempMatch.getRightTeam(), tempMatch.getLeftTeam());
				//team 更新完毕;
				
				for(Player tempPlayer: tempMatch.getleftplayers()){
					this.playerController.updataPlayersInfo_Advanced(tempPlayer,tempMatch.getLeftTeam());
				}
				for(Player tempPlayer: tempMatch.getrightplayers()){
					this.playerController.updataPlayersInfo_Advanced(tempPlayer,tempMatch.getRightTeam());
				}
				//这两个循环用来更新球员数据
			}
		}
		
		
		
		public MatchVO match_VO2PO(MatchPO po){
			Match match = new Match();
			match.creatmatch(po);
			MatchVO vo = new MatchVO();
			vo.creatMatchvo(match);
			return vo;
		}
		
		public ArrayList<MatchVO> getSomeMacthVO(Date date){
			ArrayList<MatchVO> someMatchVO = new ArrayList<MatchVO>();
			for(MatchVO matchvo : this.getAllMatchVO()){
				if(matchvo.getDate().equals(date)){
					someMatchVO.add(matchvo);
				}
			}
			return someMatchVO;
		}
		
		public ArrayList<MatchVO> getSomeMatchVO(String playerName){
			ArrayList<MatchVO> someMatchVO = new ArrayList<MatchVO>();			
//			PlayerController playerController = new PlayerController();
//			PlayerPO po = playerController.findPlayerPO(playerName);
//			ArrayList<MatchPO> allMatchPO = matchdata.getAllMatch();
//			for(int i:po.getAttendedMatches()){
//				//someMat
//			}
			return someMatchVO;
		}
		
		public ArrayList<MatchVO> getSomeMatchVO(TeamShortName teamShortName){
			return null;
		}

		@Override
		public Object[][] getTeamData(String team, int matchnum) {
			return new Match().getData(team, matchnum);
		}

		/*通过场次num找到match返回vo*/
		public MatchVO getMatch(int num) {
			return null;
		}
		
		
		
		
}
