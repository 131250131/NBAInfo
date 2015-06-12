package thirdVersion;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PlayerBasicInfoVO {
	
	//球员编号
	String playerID;
	//球员姓名
	String EnglishName;
	//球员位置
	String playerPosition;
	//球员身高
    String playerHeight;
	//球员体重
	String playerWeight;
	//球员生日
	String playerBirthDay;
	//球员出生地
	String playerBirthPlace;
	//球员毕业高中
	String playerHighSchool;
	//球员毕业大学
	String playerUniversity;
	//相似球员编号
	String similarPlayerID;
	String teamname;
	//球员中文名(没有则任然用英文名)
	String Chinesename;
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
    double AFouls=0;
    double AScores=0;
    
	public String getPlayerID() {
		return playerID;
	}

	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}

	public String getEnglishName() {
		return EnglishName;
	}

	public void setEnglishName(String playerName) {
		this. EnglishName = playerName;
	}

	public String getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}

	public String getPlayerHeight() {
		return playerHeight;
	}

	public void setPlayerHeight(String playerHeight) {
		this.playerHeight = playerHeight;
	}

	public String getPlayerWeight() {
		return playerWeight;
	}

	public void setPlayerWeight(String playerWeight) {
		this.playerWeight = playerWeight;
	}

	public String getPlayerBirthDay() {
		return playerBirthDay;
	}

	public void setPlayerBirthDay(String playerBirthDay) {
		this.playerBirthDay = playerBirthDay;
	}

	public String getPlayerBirthPlace() {
		return playerBirthPlace;
	}

	public void setPlayerBirthPlace(String playerBirthPlace) {
		this.playerBirthPlace = playerBirthPlace;
	}

	public String getPlayerHighSchool() {
		return playerHighSchool;
	}

	public void setPlayerHighSchool(String playerHighSchool) {
		this.playerHighSchool = playerHighSchool;
	}

	public String getPlayerUniversity() {
		return playerUniversity;
	}

	public void setPlayerUniversity(String playerUniversity) {
		this.playerUniversity = playerUniversity;
	}

	public String getSimilarPlayerID() {
		return similarPlayerID;
	}

	public void setSimilarPlayerID(String similarPlayerID) {
		this.similarPlayerID = similarPlayerID;
	}

	public ArrayList<PlayerBasicInfoVO> getvo(ResultSet s){
		ArrayList<PlayerBasicInfoVO> list = new ArrayList<PlayerBasicInfoVO>();
		return list;
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
		return AFouls;
	}

	public void setAFeals(double aFeals) {
		AFouls = aFeals;
	}

	public double getAScores() {
		return AScores;
	}

	public void setAScores(double aScores) {
		AScores = aScores;
	}

	public String getChinesename() {
		return Chinesename;
	}

	public void setChinesename(String chinesename) {
		Chinesename = chinesename;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

}
