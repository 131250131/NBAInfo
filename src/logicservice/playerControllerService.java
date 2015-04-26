package logicservice;

import java.util.ArrayList;

import vo.PlayerVO;

public interface playerControllerService {
	public ArrayList<PlayerVO> getAllPlayerVO();//获得所有球员的所有信息;
	public PlayerVO findPlayerVO(String name);
	public ArrayList<PlayerVO> getSelectedPlayers();//获得根据条件筛选的球员信息;
	
	
}
