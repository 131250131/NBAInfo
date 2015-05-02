package logic;

import java.util.ArrayList;
import java.util.Collections;

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
	//MatchController matchController = MatchController.getInstance();
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
	    createAllPlayerVO();
		return this.allPlayerVO;
	}
	
	public Player findPlayer(String playerName){
		createAllPlayerVO();
		Player player = null;
		for(Player temp : this.allPlayers){
			if(temp.getPlayerName().equals(playerName)){
				player = temp;
			}
		}
		return player;
	}
	
	/*调用playerreader，转换成vo返回给我*/
	public PlayerVO findPlayerVO(String name) {
		createAllPlayerVO();
		PlayerVO vo = null;
		for(PlayerVO tempvo : this.allPlayerVO){
			if(tempvo.getPlayerName().equals(name)){
				vo = tempvo;
			}
		}
		return vo;
	}
	
	//筛选功能;我还没写好;
	public ArrayList<PlayerVO> getSelectedPlayers(){
		return null;
	}
	
 	public ArrayList<PlayerVO> getSeasonHotPlayers_Score(){
		ArrayList<PlayerVO> tempList = new ArrayList<PlayerVO>();
		for(Player tempPlayer : this.allPlayers){
			tempPlayer.comparetype="得分";
		}
		Collections.sort(this.allPlayers);
		for(int i=0;i<50;i++){
			PlayerVO vo = new PlayerVO();
			vo.creatplayervo(this.allPlayers.get(i));
			tempList.add(vo);
		}
		
		return tempList;
	}
	
 	public ArrayList<PlayerVO> getSeasonHotPlayers_Rebound(){
		ArrayList<PlayerVO> tempList = new ArrayList<PlayerVO>();
		for(Player tempPlayer : this.allPlayers){
			tempPlayer.comparetype="篮板";
		}
		Collections.sort(this.allPlayers);
		for(int i=0;i<50;i++){
			PlayerVO vo = new PlayerVO();
			vo.creatplayervo(this.allPlayers.get(i));
			tempList.add(vo);
		}
		
		return tempList;
	}
 	
	public ArrayList<PlayerVO> getSeasonHotPlayers_Assist(){
		ArrayList<PlayerVO> tempList = new ArrayList<PlayerVO>();
		for(Player tempPlayer : this.allPlayers){
			tempPlayer.comparetype="助攻";
		}
		Collections.sort(this.allPlayers);
		for(int i=0;i<50;i++){
			PlayerVO vo = new PlayerVO();
			vo.creatplayervo(this.allPlayers.get(i));
			tempList.add(vo);
		}
		return tempList;
	} 
	
	public ArrayList<PlayerVO> getSeasonHotPlayers_Block(){
		ArrayList<PlayerVO> tempList = new ArrayList<PlayerVO>();
		for(Player tempPlayer : this.allPlayers){
			tempPlayer.comparetype="盖帽";
		}
		Collections.sort(this.allPlayers);
		for(int i=0;i<50;i++){
			PlayerVO vo = new PlayerVO();
			vo.creatplayervo(this.allPlayers.get(i));
			tempList.add(vo);
		}
		return tempList;
	}
	
	public ArrayList<PlayerVO> getSeasonHotPlayers_Steal(){
		ArrayList<PlayerVO> tempList = new ArrayList<PlayerVO>();
		for(Player tempPlayer : this.allPlayers){
			tempPlayer.comparetype="抢断";
		}
		Collections.sort(this.allPlayers);
		for(int i=0;i<50;i++){
			PlayerVO vo = new PlayerVO();
			vo.creatplayervo(this.allPlayers.get(i));
			tempList.add(vo);
		}
		return tempList;
	} 
	
	public ArrayList<PlayerVO> getSeasonHotPlayers_3FGP(){
		ArrayList<PlayerVO> tempList = new ArrayList<PlayerVO>();
		for(Player tempPlayer : this.allPlayers){
			tempPlayer.comparetype="三分";
		}
		Collections.sort(this.allPlayers);
		for(int i=0;i<50;i++){
			PlayerVO vo = new PlayerVO();
			vo.creatplayervo(this.allPlayers.get(i));
			tempList.add(vo);
		}
		return tempList;
	} 
	
	public ArrayList<PlayerVO> getSeasonHotPlayers_FGP(){
		ArrayList<PlayerVO> tempList = new ArrayList<PlayerVO>();
		for(Player tempPlayer : this.allPlayers){
			tempPlayer.comparetype="投篮";
		}
		Collections.sort(this.allPlayers);
		for(int i=0;i<50;i++){
			PlayerVO vo = new PlayerVO();
			vo.creatplayervo(this.allPlayers.get(i));
			tempList.add(vo);
		}
		return tempList;
	} 
	
	public ArrayList<PlayerVO> getSeasonHotPlayers_FTGP() {
		ArrayList<PlayerVO> tempList = new ArrayList<PlayerVO>();
		for(Player tempPlayer : this.allPlayers){
			tempPlayer.comparetype="罚球";
		}
		Collections.sort(this.allPlayers);
		for(int i=0;i<50;i++){
			PlayerVO vo = new PlayerVO();
			vo.creatplayervo(this.allPlayers.get(i));
			tempList.add(vo);
		}
		return tempList;
	} 
	@Override
	public ArrayList<PlayerVO> getAdvancedPlayers(String type) {
		// TODO Auto-generated method stub
		MatchController matchcontroller =MatchController.getInstance();
		ArrayList<PlayerPO> playerpos =pds.getallplayers();
		ArrayList<Player> players=new ArrayList<Player>();
		ArrayList<PlayerVO> playervos=new ArrayList<PlayerVO>();
		ArrayList<PlayerVO> result =new ArrayList<PlayerVO>();
		for(PlayerPO playerpo:playerpos){
			Player player =new Player();
			player.creatplayer(playerpo);
			players.add(player);
		}
		for(Player player:players){
			player.setAdvancedP(matchcontroller.playeradvcal(player.getPlayerName(), player.getAttendedMatches(), type));
			player.setcompare("进步率");
		}
		Collections.sort(players);
		for(Player player:players){
			PlayerVO playervo =new PlayerVO();
			playervo.creatplayervo(player);
			playervos.add(playervo);
		}
		result.add(playervos.get(0));
		result.add(playervos.get(1));
		result.add(playervos.get(2));
		result.add(playervos.get(3));
		result.add(playervos.get(4));
		return result;
	}


}
