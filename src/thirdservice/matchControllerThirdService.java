package thirdservice;

import java.util.ArrayList;

import thirdVersion.MatchVOThird;
import vo.MatchVO;

public interface matchControllerThirdService {
	public ArrayList<MatchVO> getmatchbydate(String date);
	public ArrayList<String> getMatchdatesbySeaon(String season);//注意这个Season是1989-1990格式的;	
}
