package logicservice;

import java.util.ArrayList;

import vo.TeamVO;

public interface teamControllerService {
		public ArrayList<TeamVO> getSeasonAllTeamInfo();//获取球队
		public ArrayList<TeamVO> getOneTeamInfo(String shortName);//获得某一队的具体信息
		
}
