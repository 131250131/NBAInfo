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
	ArrayList<PlayerVO> allPlayerVO = new ArrayList<PlayerVO>();
	
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
	
	//对球员信息进一步更新;
	public void updataPlayersInfo_Advanced(Player player,Team myteam){
		for(Player tempplayer : this.allPlayers){
			if(tempplayer.getPlayerName().equals(player.getPlayerName())){
				player.updatePlayer(tempplayer,myteam);
			}
		}
	}
	
	public void createAllPlayerVO(){
		for(Player player : this.allPlayers){
			PlayerVO vo = new PlayerVO();
			vo.creatplayervo(player);
			this.allPlayerVO.add(vo);
		}
	}
	
	public ArrayList<PlayerVO> getAllPlayerVO(){
		return this.allPlayerVO;
	}
	
	public Player findPlayer(String playerName){
		for(Player temp : this.allPlayers){
			if(temp.getPlayerName().equals(playerName)){
				return temp;
			}
		}
		return null;
	}

	
	/*调用playerreader，转换成vo返回给我*/
	public PlayerVO findPlayerVO(String name) {
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
	
	//筛选功能;我还没写好;
	public ArrayList<PlayerVO> getSelectedPlayers() {
		return null;
	}
	
	

}
