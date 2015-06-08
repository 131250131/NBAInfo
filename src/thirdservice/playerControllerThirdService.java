package thirdservice;

import java.util.ArrayList;

import thirdVersion.PSpecificdata;
import thirdVersion.PlayerBasicInfoVO;
import thirdVersion.PlayerdatainfoVO;
import Utibility.DataType;

public interface playerControllerThirdService {
	public void initial();
    public ArrayList<PSpecificdata>  getnormalplayerdata(String pid,DataType t);
	public ArrayList<PSpecificdata>  getplayoffplayerdata(String pid,DataType t);
	public ArrayList<PlayerBasicInfoVO> VOinitial();
    public ArrayList<PlayerBasicInfoVO> getPlayersbyChar(char temp);
    public PlayerBasicInfoVO getPlayerbyname(String name);
    public ArrayList<PlayerdatainfoVO> getSeasonHotPlayers(String Season,DataType type,boolean ipl);
    public ArrayList<PlayerdatainfoVO> getSeasonKingPlayers(String Season,DataType type,boolean ipl);
    public ArrayList<PlayerdatainfoVO> getplayerbyteam(String tname,String Season);
    public double[] getdataforpiechart(String pid,String seasons,DataType dtp);
    
    
}
