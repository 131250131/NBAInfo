package logicservice;

import java.util.ArrayList;

import vo.PlayerVO;

public interface playerControllerService {
	public ArrayList<PlayerVO> getAllPlayerVO();//获得所有球员的所有信息;
	public PlayerVO findPlayerVO(String name);
	public ArrayList<PlayerVO> getSelectedPlayers(String position,String distribution,String infoType);//获得根据条件筛选的球员信息;
	public ArrayList<PlayerVO> getAdvancedPlayers(String condition);//获得进步最快球员信息;
	public ArrayList<PlayerVO> getSeasonHotPlayers_Score();
	public ArrayList<PlayerVO> getSeasonHotPlayers_Rebound();
	public ArrayList<PlayerVO> getSeasonHotPlayers_Assist();
	public ArrayList<PlayerVO> getSeasonHotPlayers_Block();
	public ArrayList<PlayerVO> getSeasonHotPlayers_Steal();
	public ArrayList<PlayerVO> getSeasonHotPlayers_3FGP();
	public ArrayList<PlayerVO> getSeasonHotPlayers_FGP();
	public ArrayList<PlayerVO> getSeasonHotPlayers_FTGP();
	public ArrayList<PlayerVO> getplayerbyteam(String teamname);
	public ArrayList<PlayerVO> getPlayerbyChar(char temp);

}
