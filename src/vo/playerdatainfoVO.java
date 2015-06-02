package vo;

import java.sql.ResultSet;
import java.util.ArrayList;

public class playerdatainfoVO {
	/*
	 * 
	 * 2015/6/2
	 * A-平均     T-总和   H-最高  因为3F不行，所以使用SF替代
	 * 一个该类表示一个球员在一个赛季常规或者季后赛的数据统计
	 */
    String id="";//球员编号 
    String season="";//赛季
    String teamname="";//teamname为总计时，表示该球员一个赛季在两个球队打过
    double attendmatches=0;
    double First=0;
    /*
     * Average
     */
    double Atime=0;
    double FGP=0;
    double AFGZ=0;//Z代表命中
    double AFG=0;
    double SFGP=0;
    double ASFGZ=0;
    double ASFG=0;
    double FTGP=0;
    double AFTGZ=0;
    double AFTG=0;
    double ARebounds=0;
    double AORebouns=0;
    double ADRebounds=0;
    double AAssists=0;
    double ASteals=0;
    double ABlocks=0;
    double ATurnovers=0;
    double AFeals=0;
    double AScores=0;
    
    double Win=0;
    double Lose=0;
    
    /*
     * Total
     */
    double Ttime=0;
    double TFGZ=0;
    double TFG=0;
    double TSFGZ=0;
    double TSFG=0;
    double TFTGZ=0;
    double TFTG=0;
    double TRebounds=0;
    double TORebouns=0;
    double TDRebounds=0;
    double TAssists=0;
    double TSteals=0;
    double TBlocks=0;
    double TTurnovers=0;
    double TFeals=0;
    double TScores=0;
    
    /*
     * Advanced data
     */
    double RR=0;//篮板率
    double O_RR=0;//进攻篮板率
    double D_RR=0;//防守篮板率
    double AR=0;//助攻率
    double SR=0;//抢断率
    double BR=0;//盖帽率
    double TR=0;//失误率
    double UseRate=0;//使用率(上场率)
    double OR=0;//进攻率
    double DR=0;//防守率
    double WS=0;//WS
    double O_WS=0;//进攻WS
    double D_WS=0;//防守WS
    double PER=0;//效率
    double Dunk=0;//扣篮个数
    double TTPO=0;//2/3+1(并不知道是什么)
    double Blocked=0;//被冒个数
    double ShootDistance=0;//投篮距离
    
    double LXFGP=0;//LX表示篮下
    double LXFGZ=0;
    double LXFG=0;
    double LXFGRate=0;//表示篮下投篮在所有投篮中比例，以下类推
    
    double JJLFGP=0;//JJ表示近距离
    double JJLFGZ=0;
    double JJLFG=0;
    double JJLFGRate=0;
    
    double ZJLFGP=0;//ZJL表示中距离
    double ZJLFGZ=0;
    double ZJLFG=0;
    double ZJLFGRate=0;
    
    double YJLFGP=0;//YJL表示远距离
    double YJLFGZ=0;
    double YJLFG=0;
    double YJLFGRate=0;
    
    double RealShootRate=0;//真实命中率
    double S_RR=0;//投篮效率
    
    /*
     * High data
     */
    double Htime=0;
    double HFGP=0;
    double HFGZ=0;//Z代表命中
    double HFG=0;
    double HSFGP=0;
    double HSFGZ=0;
    double HSFG=0;
    double HFTGP=0;
    double HFTGZ=0;
    double HFTG=0;
    double HRebounds=0;
    double HORebouns=0;
    double HDRebounds=0;
    double HAssists=0;
    double HSteals=0;
    double HBlocks=0;
    double HTurnovers=0;
    double HFeals=0;
    double HScores=0;
    
    String salary="";//薪水，带单位，所以用String
    int isplayoff=0;//是否是季候赛，是季后赛表示为1，不是为0 
    String name="";//球员名字
    public ArrayList<playerdatainfoVO> getvo(ResultSet s){
    	ArrayList<playerdatainfoVO> result=new ArrayList<playerdatainfoVO>();
    	return result;
    }
}
