package logic;

import java.util.ArrayList;
import java.util.Collections;

import Utibility.playercomp;
import logicservice.playerControllerService;
import po.PlayerPO;
import test.Sort;
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
		this.allPlayers = new ArrayList<Player>();
		ArrayList<PlayerPO> allPlayersPO = pds.getallplayers();
		for(PlayerPO po : allPlayersPO){
			this.allPlayers.add(new Player(po));
		}
	}
	
	//对球员信息进一步更新;
	public void updataPlayersInfo_Advanced(Player player,Team myteam){
		for(Player tempplayer : this.allPlayers){
			if(tempplayer.getPlayerName().equals(player.getPlayerName())){
				//System.out.println("true");
				tempplayer.updatePlayer(player,myteam);
			}
		}
	}
	
	public void createAllPlayerVO(){
		this.allPlayerVO = new ArrayList<PlayerVO>();
		for(Player player : this.allPlayers){
			//System.out.println(player.getPlayerAssists());
			PlayerVO vo = new PlayerVO();
			//System.out.println("kk"+player.getPlayerPlayTime());
			vo.creatplayervo(player);
			//System.out.println(vo.getPlayerAssists());
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
	public ArrayList<PlayerVO> getSelectedPlayers(String position,String distribution,String infoType){
		ArrayList<PlayerVO> result = this.getAllPlayerVO();
		result = this.getSelectedPlayers_Distribution(result,distribution);
		result = this.getSelectedPlayers_Position(result,position);
		result = this.getSelectedPlayers_InfoType(result,infoType);
		return result;
	}
	
	public ArrayList<PlayerVO> getSelectedPlayers_Position(ArrayList<PlayerVO> list,String position){
		ArrayList<PlayerVO> result = new ArrayList<PlayerVO>();
		if(position==null){
			return list;
		}
		for(PlayerVO vo : list){
			if(vo.getPlayerPosition().equals(position)){
				result.add(vo);
			}
		}
		return result;
	}
	
	public ArrayList<PlayerVO> getSelectedPlayers_Distribution(ArrayList<PlayerVO> list,String distribution){
		ArrayList<PlayerVO> result = new ArrayList<PlayerVO>();
		if(distribution==null){
			return list;
		}
		if(!(distribution.equals("东部")||distribution.equals("西部"))){
			for(PlayerVO vo : list){
				if(vo.getPlayerDistribution().equals(distribution)){
					result.add(vo);
				}
			}
		}else{
			if(distribution.equals("东部")){
				for(PlayerVO vo : list){
					if(vo.getPlayerDistribution().equals("东南区")
							||vo.getPlayerDistribution().equals("中央区")
							||vo.getPlayerDistribution().equals("大西洋区")){
						result.add(vo);
					}
				}
			}else{
				for(PlayerVO vo : list){
					if(vo.getPlayerDistribution().equals("西南区")
							||vo.getPlayerDistribution().equals("太平洋区")
							||vo.getPlayerDistribution().equals("西北区")){
						result.add(vo);
					}
				}
			}
		}
		return result;
	}
	
	public ArrayList<PlayerVO> getSelectedPlayers_InfoType(ArrayList<PlayerVO> list,String infoType){
		ArrayList<PlayerVO> result = new ArrayList<PlayerVO>();
		for(PlayerVO vo :list){
			vo.setComparetype(infoType);
		}
		Collections.sort(list);
		for(int i=0;i<20;i++){
			result.add(list.get(i));
		}
		return result;
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
	

	public ArrayList<PlayerVO> getSeasonHotPlayers_GmScER() {
		ArrayList<PlayerVO> tempList = new ArrayList<PlayerVO>();
		for(Player tempPlayer : this.allPlayers){
			tempPlayer.comparetype="效率";
		}
		Collections.sort(this.allPlayers);
		for(int i=0;i<50;i++){
			PlayerVO vo = new PlayerVO();
			vo.creatplayervo(this.allPlayers.get(i));
			tempList.add(vo);
		}
		return tempList;
	}
	
	public ArrayList<PlayerVO> getAdvancedPlayers(String type) {
		createAllPlayerVO();
		MatchController matchcontroller =MatchController.getInstance();
		ArrayList<PlayerVO> playervos=new ArrayList<PlayerVO>();
		ArrayList<PlayerVO> result =new ArrayList<PlayerVO>();
		for(PlayerVO playervo:this.allPlayerVO){
			//System.out.println(matchcontroller.playeradvcal(player.getPlayerName(), player.getAttendedMatches(), type));
			playervo.setAdvancedP(matchcontroller.playeradvcal(playervo.getPlayerName(), playervo.getAttendedMatches(), type));
			playervo.setComparetype("进步率");
		}
	
		playervos=this.allPlayerVO;
		Collections.sort(playervos);
		result.add(playervos.get(0));
		result.add(playervos.get(1));
		result.add(playervos.get(2));
		result.add(playervos.get(3));
		result.add(playervos.get(4));
		return result;
	}

	public ArrayList<PlayerVO> getplayerbyteam(String teamname) {
		// TODO Auto-generated method stub
		ArrayList<PlayerVO> result =new ArrayList<PlayerVO>();
		for(PlayerVO p:this.allPlayerVO){
		   // System.out.println(p.getTeamShortName());
			if(p.getTeamShortName().equals(teamname)){
				result.add(p);
			}
		}
		return result;
	}
	
	public ArrayList<PlayerVO> getPlayerbyChar(char temp){
		PlayerController playerController = PlayerController.getInstance();
		ArrayList<PlayerVO> list =playerController.getAllPlayerVO();
		ArrayList<PlayerVO> result = new ArrayList<PlayerVO>();
		for(PlayerVO vo : list){
			char[] str = vo.getPlayerName().toCharArray();
			if(str[0]==temp){
				result.add(vo);
			}
		}
		return result;
	}

	public ArrayList<PlayerVO> getSeasonHotPlayers_AverAssist() {
		ArrayList<PlayerVO> tempList = new ArrayList<PlayerVO>();
		for(PlayerVO tempPlayerVO : this.allPlayerVO){
			tempPlayerVO.comparetype="平均助攻";
		}
		Collections.sort(this.allPlayerVO);
		for(int i=0;i<50;i++){
			tempList.add(this.allPlayerVO.get(i));
		}
		return tempList;
	}

	public ArrayList<PlayerVO> getSeasonHotPlayers_AverSteal() {
		ArrayList<PlayerVO> tempList = new ArrayList<PlayerVO>();
		for(PlayerVO tempPlayerVO : this.allPlayerVO){
			tempPlayerVO.comparetype="平均抢断";
		}
		Collections.sort(this.allPlayerVO);
		for(int i=0;i<50;i++){
			tempList.add(this.allPlayerVO.get(i));
		}
		return tempList;
	}

	public ArrayList<PlayerVO> getSeasonHotPlayers_AverBlock() {
		ArrayList<PlayerVO> tempList = new ArrayList<PlayerVO>();
		for(PlayerVO tempPlayerVO : this.allPlayerVO){
			tempPlayerVO.comparetype="平均盖帽";
		}
		Collections.sort(this.allPlayerVO);
		for(int i=0;i<50;i++){
			tempList.add(this.allPlayerVO.get(i));
		}
		return tempList;
	}

	public ArrayList<PlayerVO> getSeasonHotPlayers_AverRebound() {
		ArrayList<PlayerVO> tempList = new ArrayList<PlayerVO>();
		for(PlayerVO tempPlayerVO : this.allPlayerVO){
			tempPlayerVO.comparetype="平均篮板";
		}
		Collections.sort(this.allPlayerVO);
		for(int i=0;i<50;i++){
			tempList.add(this.allPlayerVO.get(i));
		}
		return tempList;
	}

	public ArrayList<PlayerVO> getSeasonHotPlayers_AverScore() {
		ArrayList<PlayerVO> tempList = new ArrayList<PlayerVO>();
		for(PlayerVO tempPlayerVO : this.allPlayerVO){
			tempPlayerVO.comparetype="平均得分";
		}
		Collections.sort(this.allPlayerVO);
		for(int i=0;i<50;i++){
			tempList.add(this.allPlayerVO.get(i));
		}
		return tempList;
	}
    public ArrayList<PlayerVO> multicomp(ArrayList<Sort> sort,String aveg,int n){
    	ArrayList<PlayerVO> result=new ArrayList<PlayerVO>();
    	playercomp comp =new playercomp();
    	comp.setSort(sort);
    	comp.setAveg(aveg);
    	Collections.sort(this.allPlayerVO, comp);
    	for(int i=0;i<n;i++){
    		result.add(this.allPlayerVO.get(i));
    	}
    	return result;
    }

}
