package thirdVersion;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PlayerdatainfoVO {
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
    boolean isplayoff=false;//是否是季候赛，是季后赛表示为1，不是为0 
    String name="";//球员名字
    public ArrayList<PlayerdatainfoVO> getvo(ResultSet s){
    	ArrayList<PlayerdatainfoVO> result=new ArrayList<PlayerdatainfoVO>();
    	return result;
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public double getAttendmatches() {
		return attendmatches;
	}
	public void setAttendmatches(double attendmatches) {
		this.attendmatches = attendmatches;
	}
	public double getFirst() {
		return First;
	}
	public void setFirst(double first) {
		First = first;
	}
	public double getAtime() {
		return Atime;
	}
	public void setAtime(double atime) {
		Atime = atime;
	}
	public double getFGP() {
		return FGP;
	}
	public void setFGP(double fGP) {
		FGP = fGP;
	}
	public double getAFGZ() {
		return AFGZ;
	}
	public void setAFGZ(double aFGZ) {
		AFGZ = aFGZ;
	}
	public double getAFG() {
		return AFG;
	}
	public void setAFG(double aFG) {
		AFG = aFG;
	}
	public double getSFGP() {
		return SFGP;
	}
	public void setSFGP(double sFGP) {
		SFGP = sFGP;
	}
	public double getASFGZ() {
		return ASFGZ;
	}
	public void setASFGZ(double aSFGZ) {
		ASFGZ = aSFGZ;
	}
	public double getASFG() {
		return ASFG;
	}
	public void setASFG(double aSFG) {
		ASFG = aSFG;
	}
	public double getFTGP() {
		return FTGP;
	}
	public void setFTGP(double fTGP) {
		FTGP = fTGP;
	}
	public double getAFTGZ() {
		return AFTGZ;
	}
	public void setAFTGZ(double aFTGZ) {
		AFTGZ = aFTGZ;
	}
	public double getAFTG() {
		return AFTG;
	}
	public void setAFTG(double aFTG) {
		AFTG = aFTG;
	}
	public double getARebounds() {
		return ARebounds;
	}
	public void setARebounds(double aRebounds) {
		ARebounds = aRebounds;
	}
	public double getAORebouns() {
		return AORebouns;
	}
	public void setAORebouns(double aORebouns) {
		AORebouns = aORebouns;
	}
	public double getADRebounds() {
		return ADRebounds;
	}
	public void setADRebounds(double aDRebounds) {
		ADRebounds = aDRebounds;
	}
	public double getAAssists() {
		return AAssists;
	}
	public void setAAssists(double aAssists) {
		AAssists = aAssists;
	}
	public double getASteals() {
		return ASteals;
	}
	public void setASteals(double aSteals) {
		ASteals = aSteals;
	}
	public double getABlocks() {
		return ABlocks;
	}
	public void setABlocks(double aBlocks) {
		ABlocks = aBlocks;
	}
	public double getATurnovers() {
		return ATurnovers;
	}
	public void setATurnovers(double aTurnovers) {
		ATurnovers = aTurnovers;
	}
	public double getAFeals() {
		return AFeals;
	}
	public void setAFeals(double aFeals) {
		AFeals = aFeals;
	}
	public double getAScores() {
		return AScores;
	}
	public void setAScores(double aScores) {
		AScores = aScores;
	}
	public double getWin() {
		return Win;
	}
	public void setWin(double win) {
		Win = win;
	}
	public double getLose() {
		return Lose;
	}
	public void setLose(double lose) {
		Lose = lose;
	}
	public double getTtime() {
		return Ttime;
	}
	public void setTtime(double ttime) {
		Ttime = ttime;
	}
	public double getTFGZ() {
		return TFGZ;
	}
	public void setTFGZ(double tFGZ) {
		TFGZ = tFGZ;
	}
	public double getTFG() {
		return TFG;
	}
	public void setTFG(double tFG) {
		TFG = tFG;
	}
	public double getTSFGZ() {
		return TSFGZ;
	}
	public void setTSFGZ(double tSFGZ) {
		TSFGZ = tSFGZ;
	}
	public double getTSFG() {
		return TSFG;
	}
	public void setTSFG(double tSFG) {
		TSFG = tSFG;
	}
	public double getTFTGZ() {
		return TFTGZ;
	}
	public void setTFTGZ(double tFTGZ) {
		TFTGZ = tFTGZ;
	}
	public double getTFTG() {
		return TFTG;
	}
	public void setTFTG(double tFTG) {
		TFTG = tFTG;
	}
	public double getTRebounds() {
		return TRebounds;
	}
	public void setTRebounds(double tRebounds) {
		TRebounds = tRebounds;
	}
	public double getTORebouns() {
		return TORebouns;
	}
	public void setTORebouns(double tORebouns) {
		TORebouns = tORebouns;
	}
	public double getTDRebounds() {
		return TDRebounds;
	}
	public void setTDRebounds(double tDRebounds) {
		TDRebounds = tDRebounds;
	}
	public double getTAssists() {
		return TAssists;
	}
	public void setTAssists(double tAssists) {
		TAssists = tAssists;
	}
	public double getTSteals() {
		return TSteals;
	}
	public void setTSteals(double tSteals) {
		TSteals = tSteals;
	}
	public double getTBlocks() {
		return TBlocks;
	}
	public void setTBlocks(double tBlocks) {
		TBlocks = tBlocks;
	}
	public double getTTurnovers() {
		return TTurnovers;
	}
	public void setTTurnovers(double tTurnovers) {
		TTurnovers = tTurnovers;
	}
	public double getTFeals() {
		return TFeals;
	}
	public void setTFeals(double tFeals) {
		TFeals = tFeals;
	}
	public double getTScores() {
		return TScores;
	}
	public void setTScores(double tScores) {
		TScores = tScores;
	}
	public double getRR() {
		return RR;
	}
	public void setRR(double rR) {
		RR = rR;
	}
	public double getO_RR() {
		return O_RR;
	}
	public void setO_RR(double o_RR) {
		O_RR = o_RR;
	}
	public double getD_RR() {
		return D_RR;
	}
	public void setD_RR(double d_RR) {
		D_RR = d_RR;
	}
	public double getAR() {
		return AR;
	}
	public void setAR(double aR) {
		AR = aR;
	}
	public double getSR() {
		return SR;
	}
	public void setSR(double sR) {
		SR = sR;
	}
	public double getBR() {
		return BR;
	}
	public void setBR(double bR) {
		BR = bR;
	}
	public double getTR() {
		return TR;
	}
	public void setTR(double tR) {
		TR = tR;
	}
	public double getUseRate() {
		return UseRate;
	}
	public void setUseRate(double useRate) {
		UseRate = useRate;
	}
	public double getOR() {
		return OR;
	}
	public void setOR(double oR) {
		OR = oR;
	}
	public double getDR() {
		return DR;
	}
	public void setDR(double dR) {
		DR = dR;
	}
	public double getWS() {
		return WS;
	}
	public void setWS(double wS) {
		WS = wS;
	}
	public double getO_WS() {
		return O_WS;
	}
	public void setO_WS(double o_WS) {
		O_WS = o_WS;
	}
	public double getD_WS() {
		return D_WS;
	}
	public void setD_WS(double d_WS) {
		D_WS = d_WS;
	}
	public double getPER() {
		return PER;
	}
	public void setPER(double pER) {
		PER = pER;
	}
	public double getDunk() {
		return Dunk;
	}
	public void setDunk(double dunk) {
		Dunk = dunk;
	}
	public double getTTPO() {
		return TTPO;
	}
	public void setTTPO(double tTPO) {
		TTPO = tTPO;
	}
	public double getBlocked() {
		return Blocked;
	}
	public void setBlocked(double blocked) {
		Blocked = blocked;
	}
	public double getShootDistance() {
		return ShootDistance;
	}
	public void setShootDistance(double shootDistance) {
		ShootDistance = shootDistance;
	}
	public double getLXFGP() {
		return LXFGP;
	}
	public void setLXFGP(double lXFGP) {
		LXFGP = lXFGP;
	}
	public double getLXFGZ() {
		return LXFGZ;
	}
	public void setLXFGZ(double lXFGZ) {
		LXFGZ = lXFGZ;
	}
	public double getLXFG() {
		return LXFG;
	}
	public void setLXFG(double lXFG) {
		LXFG = lXFG;
	}
	public double getLXFGRate() {
		return LXFGRate;
	}
	public void setLXFGRate(double lXFGRate) {
		LXFGRate = lXFGRate;
	}
	public double getJJLFGP() {
		return JJLFGP;
	}
	public void setJJLFGP(double jJLFGP) {
		JJLFGP = jJLFGP;
	}
	public double getJJLFGZ() {
		return JJLFGZ;
	}
	public void setJJLFGZ(double jJLFGZ) {
		JJLFGZ = jJLFGZ;
	}
	public double getJJLFG() {
		return JJLFG;
	}
	public void setJJLFG(double jJLFG) {
		JJLFG = jJLFG;
	}
	public double getJJLFGRate() {
		return JJLFGRate;
	}
	public void setJJLFGRate(double jJLFGRate) {
		JJLFGRate = jJLFGRate;
	}
	public double getZJLFGP() {
		return ZJLFGP;
	}
	public void setZJLFGP(double zJLFGP) {
		ZJLFGP = zJLFGP;
	}
	public double getZJLFGZ() {
		return ZJLFGZ;
	}
	public void setZJLFGZ(double zJLFGZ) {
		ZJLFGZ = zJLFGZ;
	}
	public double getZJLFG() {
		return ZJLFG;
	}
	public void setZJLFG(double zJLFG) {
		ZJLFG = zJLFG;
	}
	public double getZJLFGRate() {
		return ZJLFGRate;
	}
	public void setZJLFGRate(double zJLFGRate) {
		ZJLFGRate = zJLFGRate;
	}
	public double getYJLFGP() {
		return YJLFGP;
	}
	public void setYJLFGP(double yJLFGP) {
		YJLFGP = yJLFGP;
	}
	public double getYJLFGZ() {
		return YJLFGZ;
	}
	public void setYJLFGZ(double yJLFGZ) {
		YJLFGZ = yJLFGZ;
	}
	public double getYJLFG() {
		return YJLFG;
	}
	public void setYJLFG(double yJLFG) {
		YJLFG = yJLFG;
	}
	public double getYJLFGRate() {
		return YJLFGRate;
	}
	public void setYJLFGRate(double yJLFGRate) {
		YJLFGRate = yJLFGRate;
	}
	public double getRealShootRate() {
		return RealShootRate;
	}
	public void setRealShootRate(double realShootRate) {
		RealShootRate = realShootRate;
	}
	public double getS_RR() {
		return S_RR;
	}
	public void setS_RR(double s_RR) {
		S_RR = s_RR;
	}
	public double getHtime() {
		return Htime;
	}
	public void setHtime(double htime) {
		Htime = htime;
	}
	public double getHFGP() {
		return HFGP;
	}
	public void setHFGP(double hFGP) {
		HFGP = hFGP;
	}
	public double getHFGZ() {
		return HFGZ;
	}
	public void setHFGZ(double hFGZ) {
		HFGZ = hFGZ;
	}
	public double getHFG() {
		return HFG;
	}
	public void setHFG(double hFG) {
		HFG = hFG;
	}
	public double getHSFGP() {
		return HSFGP;
	}
	public void setHSFGP(double hSFGP) {
		HSFGP = hSFGP;
	}
	public double getHSFGZ() {
		return HSFGZ;
	}
	public void setHSFGZ(double hSFGZ) {
		HSFGZ = hSFGZ;
	}
	public double getHSFG() {
		return HSFG;
	}
	public void setHSFG(double hSFG) {
		HSFG = hSFG;
	}
	public double getHFTGP() {
		return HFTGP;
	}
	public void setHFTGP(double hFTGP) {
		HFTGP = hFTGP;
	}
	public double getHFTGZ() {
		return HFTGZ;
	}
	public void setHFTGZ(double hFTGZ) {
		HFTGZ = hFTGZ;
	}
	public double getHFTG() {
		return HFTG;
	}
	public void setHFTG(double hFTG) {
		HFTG = hFTG;
	}
	public double getHRebounds() {
		return HRebounds;
	}
	public void setHRebounds(double hRebounds) {
		HRebounds = hRebounds;
	}
	public double getHORebouns() {
		return HORebouns;
	}
	public void setHORebouns(double hORebouns) {
		HORebouns = hORebouns;
	}
	public double getHDRebounds() {
		return HDRebounds;
	}
	public void setHDRebounds(double hDRebounds) {
		HDRebounds = hDRebounds;
	}
	public double getHAssists() {
		return HAssists;
	}
	public void setHAssists(double hAssists) {
		HAssists = hAssists;
	}
	public double getHSteals() {
		return HSteals;
	}
	public void setHSteals(double hSteals) {
		HSteals = hSteals;
	}
	public double getHBlocks() {
		return HBlocks;
	}
	public void setHBlocks(double hBlocks) {
		HBlocks = hBlocks;
	}
	public double getHTurnovers() {
		return HTurnovers;
	}
	public void setHTurnovers(double hTurnovers) {
		HTurnovers = hTurnovers;
	}
	public double getHFeals() {
		return HFeals;
	}
	public void setHFeals(double hFeals) {
		HFeals = hFeals;
	}
	public double getHScores() {
		return HScores;
	}
	public void setHScores(double hScores) {
		HScores = hScores;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public boolean isIsplayoff() {
		return isplayoff;
	}
	public void setIsplayoff(boolean isplayoff) {
		this.isplayoff = isplayoff;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
