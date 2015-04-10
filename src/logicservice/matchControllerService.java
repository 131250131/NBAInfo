package logicservice;

import java.sql.Date;
import java.util.ArrayList;

import vo.MatchVO;
import vo.TeamShortName;

public interface matchControllerService {
	public ArrayList<MatchVO> getAllMatchVO();
	public ArrayList<MatchVO> getSomeMacthVO(Date date);
	public ArrayList<MatchVO> getSomeMatchVO(String playerName);
	public ArrayList<MatchVO> getSomeMatchVO(TeamShortName teamShortName);
	
}
