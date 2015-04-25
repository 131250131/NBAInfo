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
	ArrayList<Player> allPlayers = new ArrayList<Player>();
	
	private static PlayerController instance =null;
	
	//构造函数，完成对球员数据的更新
	private PlayerController(){
		this.updatePlayersInfo_Basic();
	}
	
	public static PlayerController getInstance() {
	      if( instance == null ){
	          instance  = new PlayerController();
	       }
	      return instance ;
	}
	
	//这个功能是用来获取球员的基本信息
	public void updatePlayersInfo_Basic(){
		ArrayList<PlayerPO> allPlayersPO = pds.getallplayers();
		for(PlayerPO po : allPlayersPO){
			this.allPlayers.add(new Player(po));
		}
	}
	
	//如何对球员的进一步信息进行更新?这是个问题;
	public void updataPlayersInfo_Advanced(Player player,Team myteam){
		for(Player tempplayer : this.allPlayers){
			player.updatePlayer(tempplayer,myteam);
		}
	}
	
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
	
	public ArrayList<PlayerVO> getSelectedPlayers() {
		return null;
	}
	
	

}
