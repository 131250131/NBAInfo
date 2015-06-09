package thirdVersion;

public class TeamVOThird {
	//球队中文名
	String teamChineseName;
	//球队英文名
	String teamEnglishName;
	//目前是否在联盟中
	boolean isNowTeam;
	String startSeason;
	String endSeason;
	
	public String getTeamChineseName() {
		return teamChineseName;
	}
	public void setTeamChineseName(String teamChineseName) {
		this.teamChineseName = teamChineseName;
	}
	public String getTeamEnglishName() {
		return teamEnglishName;
	}
	public void setTeamEnglishName(String teamEnglishName) {
		this.teamEnglishName = teamEnglishName;
	}
	public boolean isNowTeam() {
		return isNowTeam;
	}
	public void setNowTeam(boolean isNowTeam) {
		this.isNowTeam = isNowTeam;
	}
	public String getStartSeason() {
		return startSeason;
	}
	public void setStartSeason(String startSeason) {
		this.startSeason = startSeason;
	}
	public String getEndSeason() {
		return endSeason;
	}
	public void setEndSeason(String endSeason) {
		this.endSeason = endSeason;
	}
	
	
}
