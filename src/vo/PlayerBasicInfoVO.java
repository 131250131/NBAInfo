package vo;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PlayerBasicInfoVO {
	//球员编号
	String playerID;
	//球员姓名
	String playerName;
	//球员位置
	String playerPosition;
	//球员身高
	double playerHeight;
	//球员体重
	int playerWeight;
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
	
	public String getPlayerID() {
		return playerID;
	}

	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}

	public double getPlayerHeight() {
		return playerHeight;
	}

	public void setPlayerHeight(double playerHeight) {
		this.playerHeight = playerHeight;
	}

	public int getPlayerWeight() {
		return playerWeight;
	}

	public void setPlayerWeight(int playerWeight) {
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

}
