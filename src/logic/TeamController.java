package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import Utibility.playercomp;
import Utibility.teamcomp;
import po.TeamPO;
import DataService.PlayerDataService;
import DataService.TeamDataService;
import data.playerdata.PlayerReader;
import data.teamdata.TeamReader;
import test.Sort;
import vo.MatchVO;
import vo.PlayerVO;
import vo.TeamVO;
import logicservice.teamControllerService;

public class TeamController implements teamControllerService{
	
	private static TeamController instance =null;
	
	public TeamDataService tds = new TeamReader();
	public ArrayList<Team> allTeams = new ArrayList<Team>();
	public ArrayList<TeamVO> allTeamVO = new ArrayList<TeamVO>();
	
	private TeamController(){
		this.updateTeamInfo_Basic();
	}
	
	public static TeamController getInstance(){
	      if( instance == null ){
	          instance  = new TeamController();
	       }
	      return instance ;
	}

	public void updateTeamInfo_Basic(){
		allTeams = new ArrayList<Team>();
		ArrayList<TeamPO> allTeamPO =  new ArrayList<TeamPO>();
		try {
			allTeamPO =tds.readTeamsBaiscInfo();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("读取球队基本数据出错");
		}
		for(TeamPO po : allTeamPO){
			this.allTeams.add(new Team(po));
		}
	}
	
	public static String getTeamDistribution(String teamShortName){
		String result = null;
    		switch(teamShortName){
    			case "SAS":result="西南区";break;
    			case "MEM":result="西南区";break;
    			case "HOU":result="西南区";break;
    			case "DAL":result="西南区";break;
    			case "NOP":result="西南区";break;
    			case "SAC":result="太平洋区";break;
    			case "PHX":result="太平洋区";break;
    			case "LAL":result="太平洋区";break;
    			case "GSW":result="太平洋区";break;
    			case "LAC":result="太平洋区";break;
    			case "MIN":result="西北区";break;
    			case "DEN":result="西北区";break;
    			case "UTA":result="西北区";break;
    			case "POR":result="西北区";break;
    			case "OKC":result="西北区";break;
    			case "MIA":result="东南区";break;
    			case "ORL":result="东南区";break;
    			case "ATL":result="东南区";break;
    			case "WAS":result="东南区";break;
    			case "CHA":result="东南区";break;
    			case "DET":result="中央区";break;
    			case "IND":result="中央区";break;
    			case "CLE":result="中央区";break;
    			case "CHI":result="中央区";break;
    			case "MIL":result="中央区";break;
    			case "NYK":result="大西洋区";break;
    			case "PHI":result="大西洋区";break;
    			case "BOS":result="大西洋区";break;
    			case "BKN":result="大西洋区";break;
    			case "TOR":result="大西洋区";break;	
    			default:result = "西南区";break;
    		}
		return result;
	}
	
	public void updateTeamInfo_Advanced(Team myTeam,Team oppoTeam,boolean isHome){
		for(Team team:this.allTeams){
			if(team.getShortName().equals(myTeam.getShortName())){
				//System.out.println("true");
				//System.out.println("p"+myTeam.getTeamAssists());
				team.updateTeamInfo(myTeam, oppoTeam,isHome);
			}
		}
	}
	
	public void createSeasonAllTeamInfo(){
		allTeamVO = new ArrayList<TeamVO>();
		for(Team team : this.allTeams){
			//System.out.println("pp"+team.getCompGames());
			this.allTeamVO.add(team.createTeamVO());
			//System.out.println("pp"+team.createTeamVO().getWinGames());
		}
	}
	
	public ArrayList<TeamVO> getSeasonAllTeamInfo() {

		return this.allTeamVO;
	}

	public TeamVO getOneTeamInfo(String shortName) {
		createSeasonAllTeamInfo();
		for(TeamVO vo : this.allTeamVO){
			if(vo.getShortName().equals(shortName)){
				return vo;
			}
		}
		return null;
	}

	//或缺热点球员的方法;
	
	public ArrayList<TeamVO> getSeasonHotTeams_Score(){
		ArrayList<TeamVO> result = new ArrayList<TeamVO>();
		for(TeamVO vo :  this.allTeamVO){
			vo.comparetype = "得分";
		}
		Collections.sort(this.allTeamVO); 
		for(int i=0;i<10;i++){
			result.add(this.allTeamVO.get(i));
		}
		return result;
	}
	
	public ArrayList<TeamVO> getSeasonHotTeams_Rebound(){
		ArrayList<TeamVO> result = new ArrayList<TeamVO>();
		for(TeamVO vo :  this.allTeamVO){
			vo.comparetype = "篮板";
		}
		Collections.sort(this.allTeamVO);
		for(int i=0;i<10;i++){
			result.add(this.allTeamVO.get(i));
		}
		return result;
	}
	
	public ArrayList<TeamVO> getSeasonHotTeams_Assist(){
		ArrayList<TeamVO> result = new ArrayList<TeamVO>();
		for(TeamVO vo :  this.allTeamVO){
			vo.comparetype = "助攻";
		}
		Collections.sort(this.allTeamVO);
		for(int i=0;i<10;i++){
			result.add(this.allTeamVO.get(i));
		}
		return result;
	}
	
	public ArrayList<TeamVO> getSeasonHotTeams_Block(){
		createSeasonAllTeamInfo();
		ArrayList<TeamVO> result = new ArrayList<TeamVO>();
		for(TeamVO vo :  this.allTeamVO){
			vo.comparetype = "盖帽";
		}
		Collections.sort(this.allTeamVO);
		for(int i=0;i<10;i++){
			result.add(this.allTeamVO.get(i));
		}
		return result;
	}
	
	public ArrayList<TeamVO> getSeasonHotTeams_Steal() {
		ArrayList<TeamVO> result = new ArrayList<TeamVO>();
		for(TeamVO vo :  this.allTeamVO){
			vo.comparetype = "抢断";
		}
		Collections.sort(this.allTeamVO);
		for(int i=0;i<10;i++){
			result.add(this.allTeamVO.get(i));
		}
		return result;
	}
	
	public ArrayList<TeamVO> getSeasonHotTeams_3FGP() {
		ArrayList<TeamVO> result = new ArrayList<TeamVO>();
		for(TeamVO vo :  this.allTeamVO){
			vo.comparetype = "3FGP";
		}
		Collections.sort(this.allTeamVO);
		for(int i=0;i<10;i++){
			result.add(this.allTeamVO.get(i));
		}
		return result;
	}
	
	public ArrayList<TeamVO> getSeasonHotTeams_FGP(){
		ArrayList<TeamVO> result = new ArrayList<TeamVO>();
		for(TeamVO vo :  this.allTeamVO){
			vo.comparetype = "FGP";
		}
		Collections.sort(this.allTeamVO);
		for(int i=0;i<10;i++){
			result.add(this.allTeamVO.get(i));
		}
		return result;
	}
	
	public ArrayList<TeamVO> getSeasonHotTeams_FTGP() {
		ArrayList<TeamVO> result = new ArrayList<TeamVO>();
		for(TeamVO vo :  this.allTeamVO){
			vo.comparetype = "FTGP";
		}
		Collections.sort(this.allTeamVO);
		for(int i=0;i<10;i++){
			result.add(this.allTeamVO.get(i));
		}
		return result;
	} 
	
	
	public ArrayList<MatchVO> getrecenttengames(String name){
		return null;
	}

	@Override
	public ArrayList<TeamVO> gethomeraterank() {
		// TODO Auto-generated method stub
		ArrayList<TeamVO> result =new ArrayList<TeamVO>();
		result=this.allTeamVO;
		for(TeamVO t:result){
			t.setComparetype("主场胜率");
		}
		Collections.sort(result);
		return result;
	}

	@Override
	public ArrayList<TeamVO> getguestraterank() {
		// TODO Auto-generated method stub
		ArrayList<TeamVO> result =new ArrayList<TeamVO>();
		result=this.allTeamVO;
		for(TeamVO t:result){
			t.setComparetype("客场胜率");
		}
		Collections.sort(result);
		return result;
	}

	@Override
	public ArrayList<TeamVO> getteamrank() {
		// TODO Auto-generated method stub
		ArrayList<TeamVO> result =this.allTeamVO;
		for(TeamVO g:result){
			g.setComparetype("胜率");
		}
		Collections.sort(result);
		return result;
	}

	@Override
	public ArrayList<TeamVO> getdongnanrank() {
		// TODO Auto-generated method stub
		ArrayList<TeamVO> result=new ArrayList<TeamVO>();
		for(TeamVO teamvo:this.allTeamVO){
			String dis=getTeamDistribution(teamvo.getShortName());
			//System.out.println(teamvo.getShortName());
			//System.out.println(dis);
			//System.out.println(dis+dis.equals("东南区"));
			if(dis.equals("东南区"))
			{
				//System.out.println("gg");
				teamvo.setComparetype("胜率");
				result.add(teamvo);
			}
		}
		//System.out.println(result.size());
		Collections.sort(result);
		return result;
	}

	@Override
	public ArrayList<TeamVO> getdaxiyangrank() {
		// TODO Auto-generated method stub
		ArrayList<TeamVO> result=new ArrayList<TeamVO>();
		for(TeamVO teamvo:this.allTeamVO){
			String dis=getTeamDistribution(teamvo.getShortName());
			if(dis.equals("大西洋区")){
				teamvo.setComparetype("胜率");
				result.add(teamvo);
			}
		}
		Collections.sort(result);
		return result;
	}

	@Override
	public ArrayList<TeamVO> getzhongburank() {
		// TODO Auto-generated method stub
		ArrayList<TeamVO> result=new ArrayList<TeamVO>();
		for(TeamVO teamvo:this.allTeamVO){
			String dis=getTeamDistribution(teamvo.getShortName());
			if(dis.equals("中央区")){
				teamvo.setComparetype("胜率");
				result.add(teamvo);
			}
		}
		Collections.sort(result);
		return result;
	}

	@Override
	public ArrayList<TeamVO> getxinanrank() {
		// TODO Auto-generated method stub
		ArrayList<TeamVO> result=new ArrayList<TeamVO>();
		for(TeamVO teamvo:this.allTeamVO){
			String dis=getTeamDistribution(teamvo.getShortName());
			if(dis.equals("西南区")){
				teamvo.setComparetype("胜率");
				result.add(teamvo);
			}
		}
		Collections.sort(result);
		return result;
	}

	@Override
	public ArrayList<TeamVO> getxibeirank() {
		// TODO Auto-generated method stub
		ArrayList<TeamVO> result=new ArrayList<TeamVO>();
		for(TeamVO teamvo:this.allTeamVO){
			String dis=getTeamDistribution(teamvo.getShortName());
			if(dis.equals("西北区")){
				teamvo.setComparetype("胜率");
				result.add(teamvo);
			}
		}
		Collections.sort(result);
		return result;
	}

	@Override
	public ArrayList<TeamVO> gettaipingyangrank() {
		// TODO Auto-generated method stub
		ArrayList<TeamVO> result=new ArrayList<TeamVO>();
		for(TeamVO teamvo:this.allTeamVO){
			String dis=getTeamDistribution(teamvo.getShortName());
			if(dis.equals("太平洋区")){
				teamvo.setComparetype("胜率");
				result.add(teamvo);
			}
		}
		Collections.sort(result);
		return result;
	}

	@Override
	public ArrayList<TeamVO> geteastrank() {
		// TODO Auto-generated method stub
		ArrayList<TeamVO> result=new ArrayList<TeamVO>();
		for(TeamVO teamvo:this.allTeamVO){
			String dis=getTeamDistribution(teamvo.getShortName());
			if(dis.equals("东南区")||dis.equals("中央区")||dis.equals("大西洋区")){
				teamvo.setComparetype("胜率");
				result.add(teamvo);
			}
		}
		Collections.sort(result);
		return result;
	}

	@Override
	public ArrayList<TeamVO> getwestrank() {
		// TODO Auto-generated method stub
				ArrayList<TeamVO> result=new ArrayList<TeamVO>();
				for(TeamVO teamvo:this.allTeamVO){
					String dis=getTeamDistribution(teamvo.getShortName());
					if(dis.equals("西南区")||dis.equals("西北区")||dis.equals("太平洋区")){
						teamvo.setComparetype("胜率");
						result.add(teamvo);
					}
				}
				Collections.sort(result);
				return result;
			}

	@Override
	public void setAllwinlose() {
		// TODO Auto-generated method stub
		ArrayList<TeamVO> west =this.getwestrank();
		ArrayList<TeamVO> east =this.geteastrank();
		
		west.get(0).setWinLose( ((double)west.get(0).getLosGames()-(double)west.get(0).getWinGames() )/2);
		east.get(0).setWinLose( ((double)east.get(0).getLosGames()-(double)east.get(0).getWinGames() )/2);
		double w=west.get(0).getWinLose();
		double e=east.get(0).getWinLose();
		for(TeamVO tv:west){
			tv.setWinLose( ((double)tv.getLosGames()-(double)tv.getWinGames() )/2 -w);
		}
		for(TeamVO tv:east){
			tv.setWinLose( ((double)tv.getLosGames()-(double)tv.getWinGames() )/2 -e);
		}
	}
	public ArrayList<TeamVO> multicomp(ArrayList<Sort> sort,String aveg,int n){
    	ArrayList<TeamVO> result=new ArrayList<TeamVO>();
    	teamcomp comp =new teamcomp();
    	comp.setSort(sort);
    	comp.setAveg(aveg);
    	Collections.sort(this.allTeamVO, comp);
    	for(int i=0;i<n;i++){
    		result.add(this.allTeamVO.get(i));
    	}
    	return result;
    }
	}

