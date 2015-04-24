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
		PlayerPO playerpo=pds.find(name);
		try{
		Player player=new Player();
		player.creatplayer(playerpo);
		PlayerVO playervo=new PlayerVO();
		playervo.creatplayervo(player);
		return playervo;
		}
		catch(NullPointerException e){
			return new PlayerVO();
		}
		
	}
	@Override
	public ArrayList<PlayerVO> getAllPlayers() {
		ArrayList<PlayerVO> result =new ArrayList<PlayerVO>();
		ArrayList<PlayerPO> temp = pds.getallplayers();
		for(PlayerPO playerpo:temp){
			Player player =new Player();
			player.creatplayer(playerpo);
			PlayerVO playervo =new PlayerVO();
			playervo.creatplayervo(player);
			result.add(playervo);
		}
		return result;
	}

}
