package thirdservice;

import java.util.ArrayList;

import thirdVersion.PSpecificdata;
import thirdVersion.PlayerBasicInfoVO;
import thirdVersion.PlayerdatainfoVO;
import vo.PlayerVO;
import Utibility.DataType;

public interface playerControllerThirdService {
	public void initial();
    public ArrayList<PSpecificdata>  getnormalplayerdata(String pid,DataType t);
	public ArrayList<PSpecificdata>  getplayoffplayerdata(String pid,DataType t);
	public ArrayList<PlayerBasicInfoVO> VOinitial();
    public ArrayList<PlayerBasicInfoVO> getPlayersbyChar(char temp);
    public PlayerBasicInfoVO getPlayerbyname(String name);
    public PlayerVO getPlayervobyname(String name,String season);
    public PlayerVO getPlayervobyid(String name,String season);
    public ArrayList<PlayerVO> getSeasonHotPlayers(String Season,DataType type,boolean ipl);
    public ArrayList<PlayerVO> getSeasonKingPlayers(String Season,DataType type,boolean ipl);
    public ArrayList<PlayerVO> getplayerbyteam(String tname,String Season);
    public double[] getdataforpiechart(String pid,String seasons,DataType dtp);
    public String getEnglishName(String id);
    public ArrayList<String> getseasonbyname(String name);
    public ArrayList<String> getthesameeason(String id1,String id2);
}
