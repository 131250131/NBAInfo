package logic;

import java.util.ArrayList;

import logicservice.playerControllerService;
import po.PlayerPO;
import vo.PlayerVO;
import DataService.PlayerDataService;
import data.playerdata.PlayerReader;

public class PlayerController implements playerControllerService{

	//调用数据层接口
	PlayerDataService pds=new PlayerReader();
	@Override
	
	/*调用playerreader，转换成vo返回给我*/
	public PlayerVO find(String name) {
		PlayerPO player=pds.find(name);
		return null;
	}
	@Override
	public ArrayList<PlayerVO> getAllPlayers() {
		return null;
	}

}
