package logicservice;

import java.util.ArrayList;

import vo.PlayerVO;

public interface playerControllerService {
	public ArrayList<PlayerVO> getAllPlayerVO();//获得所有球员的所有信息;
	public PlayerVO findPlayerVO(String name);
	public ArrayList<PlayerVO> getSelectedPlayers(String position,String distribution,String infoType);//获得根据条件筛选的球员信息;
	public ArrayList<PlayerVO> getAdvancedPlayers(String condition);//获得进步最快球员信息;
}
