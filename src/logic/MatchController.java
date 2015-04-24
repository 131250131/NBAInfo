package logic;

import java.sql.Date;
import java.util.ArrayList;

import po.MatchPO;
import po.PlayerPO;
import data.matchdata.*;
import DataService.MatchDataService;
import logicservice.matchControllerService;
import vo.MatchVO;
import vo.TeamShortName;

public class MatchController implements matchControllerService{
		ArrayList<Match> allMatches = new ArrayList<Match>();
		ArrayList<Match> matchesOfTaday = new ArrayList<Match>();
		MatchDataService matchdata = new Matchdata();
		ArrayList<MatchPO> allMatchPO = new ArrayList<MatchPO>();
		
		/*
		 * Controller在构造的时候就完成对data层数据的调用；
		 * 这样可以避免多次调用多次读取data层
		 * */
		public MatchController(){
			allMatchPO = this.matchdata.getAllMatch();
		}
		
		//返回所有未经处理过的比赛信息;
		public ArrayList<MatchVO> getAllMatchVO(){
			MatchDataService matchdata = new Matchdata();
			ArrayList<MatchVO> allMatchVO = new ArrayList<MatchVO>();
			for(MatchPO tempMatchPO: allMatchPO){
				allMatchVO.add(this.match_VO2PO(tempMatchPO));
			}
			return allMatchVO;
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
			PlayerController playerController = new PlayerController();
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
		@Override
		public MatchVO getMatch(int num) {
			return null;
		}
		
		
		
		
}
