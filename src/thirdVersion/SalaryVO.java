package thirdVersion;

public class SalaryVO {
	private String playerEnglishName;
	private String teamName;
	private String playerID;
	private double q1 = 0.0 ;//进攻能力
	private double q2 = 0.0 ;//防守能力
	private double realSalary = 0.0 ;//实际薪水
	private double testSalaty = 0.0 ;//我觉得他应该得到的薪水
	private double dif = 0.0;//两个薪水相减
	private double per = 0.0;
	private String position ;
	public String getPlayerEnglishName() {
		return playerEnglishName;
	}
	public void setPlayerEnglishName(String playerEnglishName) {
		this.playerEnglishName = playerEnglishName;
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String playerChineseName) {
		this.teamName = playerChineseName;
	}
	public String getPlayerID() {
		return playerID;
	}
	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}
	public double getQ1() {
		return q1;
	}
	public void setQ1(double q1) {
		this.q1 = q1;
	}
	public double getQ2() {
		return q2;
	}
	public void setQ2(double q2) {
		this.q2 = q2;
	}
	public double getRealSalary() {
		return realSalary;
	}
	public void setRealSalary(double realSalary) {
		this.realSalary = realSalary;
	}
	public double getTestSalaty() {
		return testSalaty;
	}
	public void setTestSalaty(double testSalaty) {
		this.testSalaty = testSalaty;
	}
	public double getPer() {
		return per;
	}
	public void setPer(double per) {
		this.per = per;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getDif() {
		return dif;
	}
	public void setDif(double dif) {
		this.dif = dif;
	}
	
	
}
