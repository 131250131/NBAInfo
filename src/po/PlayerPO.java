package po;

public class PlayerPO{
//基本信息
		
	//1.球员名称 （球员名称作为查找唯一标识）
	//格式类似：Anthony Tolliver
	private String playerName;

	//2.球员号码
	private String playerNumber;
	
	//3.球员位置
	//先发中锋C 先发前锋F 先发后卫G 
	private String position;
	
	//4.球员高度
	//格式类似：6-0 (6尺0寸)
	private String height;
	
	//5.球员体重
	//格式类似：161
	private double weight;

	//6.球员生日
	//格式类似： JAN 14， 1985
	private String playerBirth;

	//7.球员年龄
	private int playerAge;

	//8.球员进入联盟时间
	private int exp;
	
	//9.球员学校或国家
	private String school;

	
//读取球员基本信息txt时，调用的构造函数;
	public PlayerPO(String _playerName, String _playerNumber,String _playerPosition,
			String _playerHeight, String _playerWeight, String _playerBirth, 
			String _playerAge, String _playerExp, String _playerSchool){
		playerName = _playerName;
		playerNumber = _playerNumber;
		position = _playerPosition;
		height = _playerHeight;
		if(_playerWeight != null)
			weight = Double.parseDouble(_playerWeight);
		
		playerBirth = _playerBirth;
		
		if(_playerAge != null)
			playerAge = Integer.parseInt(_playerAge);
		
		if(_playerExp != null)
			if(_playerExp.equals("R")){
				exp = 0;
			}else{
				exp = Integer.parseInt(_playerExp);
			}
		
		school = _playerSchool;
	
	}
//	public String get
	
//在读具体的比赛txt时，一个球员所表现出来的数据，不处理，只保存;
	
		
	//13.队员助攻数 (*****要传*****)
		private int playerAssists;

	//14.队员上场时间(单位：秒) (*****要传*****)
		private int playerPlayTime;	
		
	//15.队员投篮命中数 (*****要传*****)
		private int playerFG; 
		
	//16.队员投篮出手数 (*****要传*****)
		private int playerFGTry; 
			
	//17.队员三分命中数 (*****要传*****)
		private int player3FG;
		
	//18.队员三分出手数 (*****要传*****)
		private int player3FGTry;
		
	//19.队员罚球命中数 (*****要传*****)
		private int playerFTG;
		
	//20.队员罚球出手数 (*****要传*****)
		private int playerFTGTry; 
		
	//21.队员进攻篮板数 (*****要传*****)
		private int playerOffenceRebounds;
			
	//22.队员防守篮板数 (*****要传*****)
		private int playerDeffenceRebounds;
			
	//23.队员总篮板数 (*****要传*****)
		private int playerTotalRebounds; 
		
	//24.队员抢断数 (*****要传*****)
		private int playerSteals;
		
	//25.队员盖帽数 (*****要传*****)
		private int playerBlocks;		
		
	//26.队员失误数 (*****要传*****)
		private int playerTurnovers;
		
	//27.队员犯规数 (*****要传*****)
		private int playerFouls;
	//这场比赛时，球员所在的球队
		private String teamShortName;
	
	//此int列表用于保存该球员参加过哪些场次的比赛
	int[] attendedMatches = new int[85];
	
	//在读取比赛时 更新球员数据的方法
	public void updatePlayer(int time, int FG, int FGTry, int threeFG, int threeFGTry,
			int FTG, int FTGTry, int offenceRebounds, int deffenceRebounds, int totalRebounds,
			int assists, int steals, int blocks, int turnovers, int fouls, int scores, int _teammatePlayTime){
		
		this.setPlayerPlayTime(time);
		this.setPlayerFG(FG); 
		this.setPlayerFGTry(FGTry);
		this.setPlayer3FG(threeFG);
		this.setPlayer3FGTry(threeFGTry);
		this.setPlayerFTG(FTG);
		this.setPlayerFTGTry(FTGTry);
		this.setPlayerOffenceRebounds(offenceRebounds);
		this.setPlayerDeffenceRebounds(deffenceRebounds);
		this.setPlayerTotalRebounds(totalRebounds);
		this.setPlayerAssists(assists);
		this.setPlayerSteals(steals);
		this.setPlayerBlocks(blocks);
		this.setPlayerTurnovers(turnovers);
		this.setPlayerFouls(fouls);

	}
	
		public void updateTeamShortName(String _teamShortName){	
			teamShortName = _teamShortName;
		}
	
		public String getTeamShortName() {
			return teamShortName;
		}

		public void setTeamShortName(String teamShortName) {
			this.teamShortName = teamShortName;
		}

		public String getPlayerName() {
			return playerName;
		}

		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}

		public String getPlayerNumber() {
			return playerNumber;
		}

		public void setPlayerNumber(String playerNumber) {
			this.playerNumber = playerNumber;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public String getHeight() {
			return height;
		}

		public void setHeight(String height) {
			this.height = height;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		public String getPlayerBirth() {
			return playerBirth;
		}

		public void setPlayerBirth(String playerBirth) {
			this.playerBirth = playerBirth;
		}

		public int getPlayerAge() {
			return playerAge;
		}

		public void setPlayerAge(int playerAge) {
			this.playerAge = playerAge;
		}

		public int getExp() {
			return exp;
		}

		public void setExp(int exp) {
			this.exp = exp;
		}

		public String getSchool() {
			return school;
		}

		public void setSchool(String school) {
			this.school = school;
		}

		public int getPlayerAssists() {
			return playerAssists;
		}

		public void setPlayerAssists(int playerAssists) {
			this.playerAssists = playerAssists;
		}

		public int getPlayerPlayTime() {
			return playerPlayTime;
		}

		public void setPlayerPlayTime(int playerPlayTime) {
			this.playerPlayTime = playerPlayTime;
		}

		public int getPlayerFG() {
			return playerFG;
		}

		public void setPlayerFG(int playerFG) {
			this.playerFG = playerFG;
		}

		public int getPlayerFGTry() {
			return playerFGTry;
		}

		public void setPlayerFGTry(int playerFGTry) {
			this.playerFGTry = playerFGTry;
		}

		public int getPlayer3FG() {
			return player3FG;
		}

		public void setPlayer3FG(int player3fg) {
			player3FG = player3fg;
		}

		public int getPlayer3FGTry() {
			return player3FGTry;
		}

		public void setPlayer3FGTry(int player3fgTry) {
			player3FGTry = player3fgTry;
		}

		public int getPlayerFTG() {
			return playerFTG;
		}

		public void setPlayerFTG(int playerFTG) {
			this.playerFTG = playerFTG;
		}

		public int getPlayerFTGTry() {
			return playerFTGTry;
		}

		public void setPlayerFTGTry(int playerFTGTry) {
			this.playerFTGTry = playerFTGTry;
		}

		public int getPlayerOffenceRebounds() {
			return playerOffenceRebounds;
		}

		public void setPlayerOffenceRebounds(int playerOffenceRebounds) {
			this.playerOffenceRebounds = playerOffenceRebounds;
		}

		public int getPlayerDeffenceRebounds() {
			return playerDeffenceRebounds;
		}

		public void setPlayerDeffenceRebounds(int playerDeffenceRebounds) {
			this.playerDeffenceRebounds = playerDeffenceRebounds;
		}

		public int getPlayerTotalRebounds() {
			return playerTotalRebounds;
		}

		public void setPlayerTotalRebounds(int playerTotalRebounds) {
			this.playerTotalRebounds = playerTotalRebounds;
		}

		public int getPlayerSteals() {
			return playerSteals;
		}

		public void setPlayerSteals(int playerSteals) {
			this.playerSteals = playerSteals;
		}

		public int getPlayerBlocks() {
			return playerBlocks;
		}

		public void setPlayerBlocks(int playerBlocks) {
			this.playerBlocks = playerBlocks;
		}

		public int getPlayerTurnovers() {
			return playerTurnovers;
		}

		public void setPlayerTurnovers(int playerTurnovers) {
			this.playerTurnovers = playerTurnovers;
		}

		public int getPlayerFouls() {
			return playerFouls;
		}

		public void setPlayerFouls(int playerFouls) {
			this.playerFouls = playerFouls;
		}


}

