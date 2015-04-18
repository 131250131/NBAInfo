package logic;

import java.sql.Date;
import java.util.ArrayList;

import logicservice.matchControllerService;
import vo.MatchVO;
import vo.TeamShortName;

public class MatchController implements matchControllerService{
		ArrayList<Match> allMatches = new ArrayList<Match>();
		ArrayList<Match> matchesOfTaday = new ArrayList<Match>();
		
		public ArrayList<MatchVO> getAllMatchVO(){
			return null;
		}
		
		public ArrayList<MatchVO> getSomeMacthVO(Date date){
			return null;
		}
		
		public ArrayList<MatchVO> getSomeMatchVO(String playerName){
			return null;
		}
		
		public ArrayList<MatchVO> getSomeMatchVO(TeamShortName teamShortName){
			return null;
		}

		@Override
		public Object[][] getTeamData(String team, int matchnum) {
			// TODO Auto-generated method stub
			return new Match().getData(team, matchnum);
		}

		/*通过场次num找到match返回vo*/
		@Override
		public MatchVO getMatch(int num) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
		
}
