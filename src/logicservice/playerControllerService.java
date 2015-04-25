package logicservice;

import java.util.ArrayList;

import vo.PlayerVO;

public interface playerControllerService {
	public ArrayList<PlayerVO> getAllPlayers();//获得所有球员的所有信息;
	public PlayerVO find(String name);
	public ArrayList<PlayerVO> getSelectedPlayers();//获得根据条件筛选的球员信息;
	
	
}
