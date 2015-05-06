package logic;

import java.util.ArrayList;

import po.PlayerPO;

public class Player implements Comparable<Player>{

	static String comparetype="";
	private double advancedP=0;
	public Player(){
		
	}

	//初始化球员的方法
	public Player(String _playerName, String _playerNumber,String _playerPosition,
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
			
		playerAttends = 0;
		startTimes = 0;
		playerAssists = 0;
		playerPlayTime = 0;
		playerFG = 0;
		playerFGTry = 0; 
		player3FG = 0;
		player3FGTry = 0;
		playerFTG = 0;
		playerFTGTry = 0;
		playerOffenceRebounds = 0;
		playerDeffenceRebounds = 0;
		playerTotalRebounds = 0;
		playerSteals = 0;
		playerBlocks = 0;		
		playerTurnovers = 0;
		playerFouls = 0;
		playerScores = 0;
		teammatePlayTime = 0;
	    allTeamRebounds = 0;
		allEnemyRebounds = 0;
		o_allTeamRebounds = 0;
		o_allEnemyRebounds = 0;
		d_allTeamRebounds = 0;
		d_allEnemyRebounds = 0;
		allTeamFT = 0;
		allTeamShoots = 0;
		allEnemy2Shoots = 0;
		allTeamFTShoots = 0;
		allTeamTurnover = 0;
		allEnemyOffenceTimes = 0;
	}
	
	//这个方法用来根据基本信息初始化球员;
	public Player(PlayerPO po){
		//basic info
		playerName = po.getPlayerName();
		playerNumber = po.getPlayerNumber();
		position = po.getPosition();
		height = po.getHeight();
		weight = po.getWeight();
		playerBirth = po.getPlayerBirth();
		playerAge = po.getPlayerAge();
		exp = po.getExp();
		school = po.getSchool();
	    teamShortName="";
		playerAttends = 0;
		startTimes = 0;
		playerAssists = 0;
		playerPlayTime = 0;
		playerFG = 0;
		playerFGTry = 0; 
		player3FG = 0;
		player3FGTry = 0;
		playerFTG = 0;
		playerFTGTry = 0;
		playerOffenceRebounds = 0;
		playerDeffenceRebounds = 0;
		playerTotalRebounds = 0;
		playerSteals = 0;
		playerBlocks = 0;		
		playerTurnovers = 0;
		playerFouls = 0;
		playerScores = 0;
		teammatePlayTime = 0;
	    allTeamRebounds = 0;
		allEnemyRebounds = 0;
		o_allTeamRebounds = 0;
		o_allEnemyRebounds = 0;
		d_allTeamRebounds = 0;
		d_allEnemyRebounds = 0;
		allTeamFT = 0;
		allTeamShoots = 0;
		allEnemy2Shoots = 0;
		allTeamFTShoots = 0;
		allTeamTurnover = 0;
		allEnemyOffenceTimes = 0;
	}
	
	public void creatplayer(PlayerPO playerpo){
		playerName=playerpo.getPlayerName();
		playerNumber=playerpo.getPlayerNumber();
		position=playerpo.getPosition();
		height=playerpo.getHeight();
		weight=playerpo.getWeight();
		playerBirth=playerpo.getPlayerBirth();
		playerAge=playerpo.getPlayerAge();
		exp=playerpo.getExp();
		school=playerpo.getSchool();
		playerScores=playerpo.getScores();
		this.isStart=playerpo.isStart();
		playerAssists=playerpo.getPlayerAssists();
		playerPlayTime=playerpo.getPlayerPlayTime();
		playerFG=playerpo.getPlayerFG();
		playerFGTry=playerpo.getPlayerFGTry();
		player3FG=playerpo.getPlayer3FG();
		player3FGTry=playerpo.getPlayer3FGTry();
		playerFTG=playerpo.getPlayerFTG();
		playerFTGTry=playerpo.getPlayerFTGTry();
		playerOffenceRebounds=playerpo.getPlayerOffenceRebounds();
		playerDeffenceRebounds=playerpo.getPlayerDeffenceRebounds();
		playerTotalRebounds=playerpo.getPlayerTotalRebounds();
		playerSteals=playerpo.getPlayerSteals();
		playerBlocks=playerpo.getPlayerBlocks();
		playerTurnovers=playerpo.getPlayerTurnovers();
		playerFouls=playerpo.getPlayerFouls();
		teamShortName=playerpo.getTeamShortName();
		attendedMatches=playerpo.getAttendedMatches();
		advancedP=playerpo.getAdvancedP();
		playerPlayTime=playerpo.getPlayerPlayTime();
		
	}

	
	//在读取比赛时 更新球员数据的方法
	public void updatePlayer(int time, boolean isStart, int FG, int FGTry, int threeFG, int threeFGTry,
			int FTG, int FTGTry, int offenceRebounds, int deffenceRebounds, int totalRebounds,
			int assists, int steals, int blocks, int turnovers, int fouls, int scores, int _teammatePlayTime,
			int _allTeamRebounds, int _allEnemyRebounds, int _allTeamORebounds, int _allEnemyORebounds,
			int _allTeamDRebounds, int _allEnemyDRebounds, int _allTeamFT, int _allTeamShoots,
			int _allEnemy2Shoots, int _allTeamFTShoots, int _allTeamTurnover, double _allEnemyOffenceTimes){
		
		playerAttends++;
		playerPlayTime = playerPlayTime + time;
		
		//System.out.println(playerPlayTime);
		
		if(isStart){
			startTimes++;
		}
		
		playerFG = playerFG + FG;
		playerFGTry = playerFGTry + FGTry;
		player3FG = player3FG + threeFG;
		player3FGTry = player3FGTry + threeFGTry;
		playerFTG = playerFTG + FTG;
		playerFTGTry = playerFTGTry + FTGTry;
		playerOffenceRebounds = playerOffenceRebounds + offenceRebounds;
		playerDeffenceRebounds = playerDeffenceRebounds + deffenceRebounds;
		playerTotalRebounds = playerTotalRebounds + totalRebounds;
		playerAssists = playerAssists + assists;
		playerSteals = playerSteals + steals;
		playerBlocks = playerBlocks + blocks;
		playerTurnovers = playerTurnovers + turnovers;
		playerFouls = playerFouls + fouls;
		playerScores = playerScores + scores;
		teammatePlayTime = teammatePlayTime + _teammatePlayTime;
		allTeamRebounds = allTeamRebounds + _allTeamRebounds;
		allEnemyRebounds = allEnemyRebounds + _allEnemyRebounds;
		o_allTeamRebounds = o_allTeamRebounds + _allTeamORebounds;
		o_allEnemyRebounds = o_allEnemyRebounds + _allEnemyORebounds;
		d_allTeamRebounds = d_allTeamRebounds + _allTeamDRebounds;
		d_allEnemyRebounds = d_allEnemyRebounds + _allEnemyDRebounds;
		allTeamFT = allTeamFT + _allTeamFT;
		allTeamShoots = allTeamShoots + _allTeamShoots;
		allEnemy2Shoots = allEnemy2Shoots + _allEnemy2Shoots;
		allTeamFTShoots = allTeamFTShoots + _allTeamFTShoots;
		allTeamTurnover = allTeamTurnover + _allTeamTurnover;
		allEnemyOffenceTimes = allEnemyOffenceTimes + _allEnemyOffenceTimes;
		if(ifhasdouble(totalRebounds, assists, steals, scores, blocks))
			double_double++;	
	}
	
	//这个方法用于更新
	public void updatePlayer(Player player, Team myTeam ){
		playerAttends++;
		playerPlayTime = playerPlayTime + player.getPlayerPlayTime();
		
		//System.out.println("gg"+player.getPlayerPlayTime());
		
		//是否首发
		if(player.isStart==true){
			startTimes++;
		}
		teamShortName=player.getTeamShortName();
		attendedMatches.add(player.getAttendedMatches().get(0));
		playerFG = playerFG + player.getPlayerFG();
		playerFGTry = playerFGTry + player.getPlayerFGTry();
		player3FG = player3FG + player.getPlayer3FG();
		player3FGTry = player3FGTry + player.getPlayer3FGTry();
		playerFTG = playerFTG + player.getPlayerFTG();
		playerFTGTry = playerFTGTry + player.getPlayerFTGTry();
		playerOffenceRebounds = playerOffenceRebounds + player.getPlayerOffenceRebounds();
		playerDeffenceRebounds = playerDeffenceRebounds + player.getPlayerDeffenceRebounds();
		playerTotalRebounds = playerTotalRebounds + player.getPlayerTotalRebounds();
		playerAssists = playerAssists + player.getPlayerAssists();
		playerSteals = playerSteals + player.getPlayerSteals();
		playerBlocks = playerBlocks + player.getPlayerBlocks();
		playerTurnovers = playerTurnovers + player.getPlayerTurnovers();
		playerFouls = playerFouls + player.getPlayerFouls();
		playerScores = playerScores + player.getPlayerScores();
		
//		teammatePlayTime = teammatePlayTime + 48;//是以秒为单位吗?   有待商榷;
//这下面的几个看得我好迷醉。。。。
		allTeamRebounds = allTeamRebounds + myTeam.getTeamTotalRebounds();
		allEnemyRebounds = allEnemyRebounds + myTeam.getOppoTotalRebounds();
		o_allTeamRebounds = o_allTeamRebounds + myTeam.getTeamOffenceRebounds();
		o_allEnemyRebounds = o_allEnemyRebounds + myTeam.getOppoOffenceRebounds();
		d_allTeamRebounds = d_allTeamRebounds + myTeam.getTeamDeffenceRebounds();
		d_allEnemyRebounds = d_allEnemyRebounds + myTeam.getOppoDeffenceRebounds();
		allTeamFT = allTeamFT + myTeam.getTeamFG();
		allTeamShoots = allTeamShoots + myTeam.getTeamFGTry();
		allEnemy2Shoots = allEnemy2Shoots + myTeam.getOppoFG();
		allTeamFTShoots = allTeamFTShoots + myTeam.getTeamFTG();
		allTeamTurnover = allTeamTurnover + myTeam.getTeamTurnovers();
		allEnemyOffenceTimes = allEnemyOffenceTimes + myTeam.getOppoattackRounds();
		
		if(ifhasdouble(player.getPlayerTotalRebounds(), player.getPlayerAssists(), player.getPlayerSteals(), player.getPlayerScores(), player.getPlayerBlocks()))
			double_double++;	
	}
	
	public boolean ifhasdouble(int tr,int assists,int steals,int scores,int blocks ){
		int count=0;
		if(tr>=10){
			count++;
		}
		if(assists>=10){
			count++;
		}
		if(steals>=10){
			count++;
		}
		if(scores>=10){
			count++;
		}
		if(blocks>=10){
			count++;
		}
		if(count>=2){
			return true;
		}
		return false;
	}
	public String getSchool(){
		return school;
	}
	
	public String getPosition(){
		return position;
	}
	
	public String getPlayerName(){
		return playerName;
	}
	
	public String getPlayerNumber(){
		return playerNumber;
	}
	
	public int getPlayerScores(){
		return playerScores;
	}
	
	public int getPlayerFG(){
		return playerFG;
	}
	
	public int getPlayerTotalRebounds(){
		return playerTotalRebounds;
	}
	
	///////////////////////////////////////////////////////
	String teamShortName;
	
	public void updateTeamShortName(String _teamShortName){	
		teamShortName = _teamShortName;
	}
	
	
//	public String get
	
	//球员类， 用序列号进行保存
	
	//1.球员名称 （球员名称作为查找唯一标识）
		//格式类似：Anthony Tolliver
		String playerName;
	
	//2.球员号码
		String playerNumber;
		
	//3.球员位置
		//先发中锋C 先发前锋F 先发后卫G 
		String position;
		
	//4.球员高度
		//格式类似：6-0 (6尺0寸)
		String height;
		
	//5.球员体重
		//格式类似：161
		double weight;
	
	//6.球员生日
		//格式类似： JAN 14， 1985
		String playerBirth;
	
	//7.球员年龄
		int playerAge;
	
	//8.球员进入联盟时间
		int exp;
		
	//9.球员学校或国家
		String school;
	
//	//10.球员ID (*****要传*****) //没用的
//		int playerID;
		
		boolean isStart;
		
	//11.球员参赛场数 
		int playerAttends;
		
	//12.球员先发场数 (*****要传*****)
		int startTimes;
		
	//13.队员助攻数 (*****要传*****)
		int playerAssists;

	//14.队员上场时间(单位：秒) (*****要传*****)
		int playerPlayTime;	
		
	//15.队员投篮命中数 (*****要传*****)
		int playerFG; 
		
	//16.队员投篮出手数 (*****要传*****)
		int playerFGTry; 
			
	//17.队员三分命中数 (*****要传*****)
		int player3FG;
		
	//18.队员三分出手数 (*****要传*****)
		int player3FGTry;
		
	//19.队员罚球命中数 (*****要传*****)
		int playerFTG;
		
	//20.队员罚球出手数 (*****要传*****)
		int playerFTGTry; 
		
	//21.队员进攻篮板数 (*****要传*****)
		int playerOffenceRebounds;
			
	//22.队员防守篮板数 (*****要传*****)
		int playerDeffenceRebounds;
			
	//23.队员总篮板数 (*****要传*****)
		int playerTotalRebounds; 
		
	//24.队员抢断数 (*****要传*****)
		int playerSteals;
		
	//25.队员盖帽数 (*****要传*****)
		int playerBlocks;		
		
	//26.队员失误数 (*****要传*****)
		int playerTurnovers;
		
	//27.队员犯规数 (*****要传*****)
		int playerFouls;
		
	//28.队员总得分数 (*****要传*****)
		int playerScores=0; 
		
//	//29.队员平均助攻数
//		private double aver_playerAssists ;
//		
//	//30.队员平均在场时间
//		private double aver_playerPlayTime  ;
//		
//	//31.队员平均投篮命中数
//		private double aver_playerFG  ;
//		
//	//32.队员平均投篮出手数
//		private double aver_playerFGTry ;
//		
//	//33.队员平均三分命中数
//		private double aver_player3FG ;
//				
//	//34.队员平均三分出手数
//		private double aver_player3FGTry ;
//		
//	//35.队员平均罚球命中数
//		private double aver_playerFTG ;
//		
//	//36.队员平均罚球出手数
//		private double aver_playerFTGTry ;
//		
//	//37.队员平均进攻篮板数
//		private double aver_playerOffenceRebounds ;
//		
//	//38.队员平均防守篮板数
//		private double aver_playerDeffenceRebounds ;
//		
//	//39.队员平均总篮板数
//		private double aver_playerTotalRebounds ;
//		
//	//40.队员平均抢断数
//		private double aver_playerSteals ;
//		
//	//41.队员平均盖帽数
//		private double aver_playerBlocks ;
//		
//	//42.队员平均失误数
//		private double aver_playerTurnovers ;
//		
//	//43.队员平均犯规数
//		private double aver_playerFouls ;
//		
//	//44.队员平均得分
//		private double aver_playerScores ;
//		
//	//45.队员投篮命中率
//		private double playerFGP ;
//		
//	//46.队员三分命中率
//		private double player3FGP ;
//		
//	//47.队员罚球命中率	
//		private double playerFTGP ;
//		
//	//48.队员效率(PER)
//		private double playerPER ;
//		
//	//49.队员GmSc效率值
//		private double playerGmScER ;
//		
//	//50.队员真实命中率
//		private double playerTSP ;
//		
//	//51.队员投篮效率
//		private double playerSER ;
//		
//	//52.队员篮板率
//		private double RR;
//		
//	//53.进攻篮板率
//		private double o_RR;
//		
//	//54.防守篮板率
//		private double d_RR;
//		
//	//55.助攻率
//		private double AR;
//		
//	//56.抢断率
//		private double SR;
//		
//	//57.盖帽率
//		private double BR;
//		
//	//58.失误率
//		private double TR;
//		
//	//59.使用率
//		private double UR;
		
		
	//60.球员队友出场时间 (*****要传*****)
		int teammatePlayTime;
		
	//61.球员球队总篮板 (*****要传*****) 
		int allTeamRebounds;
		
	//62.球员对手总篮板 (*****要传*****)
		int allEnemyRebounds;
		
	//63.球员球队进攻篮板 (*****要传*****)
		int o_allTeamRebounds;
		
	//64.球员对手进攻篮板 (*****要传*****)
		int o_allEnemyRebounds;
		
	//65.球员球队防守篮板 (*****要传*****)
		int d_allTeamRebounds;
		
	//66.球员对手防守篮板 (*****要传*****)
		int d_allEnemyRebounds;
		
	//67.球员球队总进球数 (*****要传*****)
		int allTeamFT;
		
	//68.球员球队出手数 (*****要传*****)
		int allTeamShoots;
		
	//69.球队对手两分球出手数 (*****要传*****)
		int allEnemy2Shoots;
		
	//70.球队球员罚球次数 (*****要传*****)
		int allTeamFTShoots;
		
	//71.球队所有球员失误次数 (*****要传*****)
		int allTeamTurnover;
		
	//72.球队对手进攻次数 (*****要传*****)
		double allEnemyOffenceTimes;
		
		int    double_double;
		

		ArrayList<Integer> attendedMatches =new ArrayList<Integer>();
		public ArrayList<Integer> getAttendedMatches() {
			return attendedMatches;
		}
		public void addAttendedMatches(int num) {
			attendedMatches.add(num);
		}
		public int getPlayerAttends(){
			return (playerAttends==0)?1:playerAttends;
		}
		
		public int getPlayerStartTimes(){
			return startTimes;
		}
		
		public int getPlayerOffenceRebounds(){
			return playerOffenceRebounds;
		}
		
		public int getPlayerDeffenceRebounds(){
			return playerDeffenceRebounds;
		}
		
		public int getPlayerAssists() {
			return playerAssists;
		}
		
		public int getPlayerPlayTime(){
			return playerPlayTime;
		}
		
		public int getPlayerSteals() {
			return playerSteals;
		}

		public int getPlayerBlocks() {
			return playerBlocks;
		}
		
		public int getPlayerTurnovers() {
			return playerTurnovers;
		}

		public int getPlayerFouls() {
			return playerFouls;
		}
		
		
		public double getAver_playerAssists() {
			return (playerAttends==0)?0:playerAssists / playerAttends;
		}

		public double getAver_playerPlayTime() {
			return (playerAttends==0)?0:playerPlayTime / playerAttends;
		}

		public double getAver_playerFG() {
			return (playerAttends==0)?0:playerFG / playerAttends;
		}

		public double getAver_playerFGTry() {
			return (playerAttends==0)?0:playerFGTry / playerAttends;
		}

		public double getAver_player3FG() {
			return  (playerAttends==0)?0:player3FG / playerAttends;
		}

		public double getAver_player3FGTry() {
			return (playerAttends==0)?0:player3FGTry / playerAttends;
		}

		public double getAver_playerFTG() {
			return  (playerAttends==0)?0:playerFTG / playerAttends;
		}

		public double getAver_playerFTGTry() {
			return (playerAttends==0)?0:playerFTGTry / playerAttends;
		}

		public double getAver_playerOffenceRebounds() {
			return (playerAttends==0)?0:playerOffenceRebounds / playerAttends;
		}

		public double getAver_playerDeffenceRebounds() {
			return  (playerAttends==0)?0:playerDeffenceRebounds / playerAttends;
		}

		public double getAver_playerTotalRebounds() {
			return  (playerAttends==0)?0:playerTotalRebounds / playerAttends;
		}

		public double getAver_playerSteals() {
			return (playerAttends==0)?0:playerSteals / playerAttends;
		}

		public double getAver_playerBlocks() {
			return (playerAttends==0)?0:playerBlocks / playerAttends;
		}

		public double getAver_playerTurnovers() {
			return (playerAttends==0)?0:playerTurnovers / playerAttends;
		}

		public double getAver_playerFouls() {
			return (playerAttends==0)?0:playerFouls / playerAttends;
		}

		public double getAver_playerScores() {
			return (playerAttends==0)?0:playerScores / playerAttends;
		}

		public double getPlayerFGP() {
			if(playerFGTry == 0){
				return 0;
			}else{
				return Double.parseDouble(String.format("%.3f",(playerFG+0.0)/(playerFGTry+0.0)));
			}
		}

		public double getPlayer3FGP() {
			if (player3FGTry!= 0)
				return Double.parseDouble(String.format("%.3f",(player3FG+0.0)/(player3FGTry+0.0)));
			else
				return 0;
		}

		public double getPlayerFTGP() {
			return (playerFTGTry==0)?0:Double.parseDouble(String.format("%.3f",(playerFTG+0.0)/(playerFTGTry+0.0)));
		}

		public double getPlayerPER() {
			return (playerAttends==0)?0:((playerScores + playerTotalRebounds + playerAssists + playerSteals + playerBlocks) 
					- (playerFGTry - playerFG) - (playerFTGTry - playerFTG) - playerTurnovers) / playerAttends;
		}

		public double getPlayerGmScER() {
			return  (playerAttends==0)?0:
				Double.parseDouble(String.format("%.3f",(playerScores + 0.4 * playerFG - 0.7 * playerFGTry - 0.4 * (playerFTGTry - playerFTG)
					+ 0.7 * playerOffenceRebounds + 0.3 * playerDeffenceRebounds + playerSteals + 0.7 * playerAssists 
					+ 0.7 * playerBlocks - 0.4 * playerFouls - playerTurnovers) / playerAttends));
		}

		public double getPlayerTSP() {
			return (playerFGTry==0)?0:Double.parseDouble(String.format("%.3f", (playerScores + 0.0)/ (2 * ((playerFGTry+0.0) + 0.44 * (playerFTGTry+0.0)))));
		}

		public double getPlayerSER() {
			return (playerFGTry==0)?0: Double.parseDouble(String.format("%.3f",(((playerFG + 0.0) + 0.5 * (player3FG + 0.0)) / (playerFGTry + 0.0))));
		}

		public double getRR() {
			return (playerPlayTime==0)?0:
				Double.parseDouble(String.format("%.3f",(playerTotalRebounds + 0.0)*(((teammatePlayTime + 0.0)+(playerPlayTime + 0.0))/5)
				/(playerPlayTime + 0.0)/((allTeamRebounds + 0.0)+(allEnemyRebounds + 0.0))));
		}

		public double getO_RR() {
			return (playerPlayTime==0)?0:
				Double.parseDouble(String.format("%.3f",(playerOffenceRebounds + 0.0)*(((teammatePlayTime + 0.0)+(playerPlayTime + 0.0))/5)
				/(playerPlayTime + 0.0)/((o_allTeamRebounds + 0.0)+(o_allEnemyRebounds + 0.0))));
		}

		public double getD_RR() {
			return (playerPlayTime==0)?0:
				Double.parseDouble(String.format("%.3f",(playerDeffenceRebounds + 0.0)*(((teammatePlayTime + 0.0)+(playerPlayTime + 0.0))/5)
				/(playerPlayTime + 0.0)/((d_allTeamRebounds + 0.0)+(d_allEnemyRebounds + 0.0))));
		}

		public double getAR() {
			if((teammatePlayTime+playerPlayTime)/5 == 0  || playerPlayTime == 0){
				return 0;
			}else{
				double a = playerAssists;
				double b = (teammatePlayTime + playerPlayTime);
				double c = playerPlayTime;
				
				return Double.parseDouble(String.format("%.3f",
						playerAssists / (c / (b / 5) * allTeamFT - playerFG)                ));
				//return playerAssists / (playerPlayTime / (teammatePlayTime + playerPlayTime) / 5) * ( allTeamFT - playerFG );
			}
				
		}

		public double getSR() {
			return (playerPlayTime==0)?0:
				Double.parseDouble(String.format("%.3f",playerSteals*((teammatePlayTime+playerPlayTime)/5)/playerPlayTime/allEnemyOffenceTimes));
		}

		public double getBR() {
			return (playerPlayTime==0)?0:
				Double.parseDouble(String.format("%.3f",(playerBlocks + 0.0)*(((teammatePlayTime + 0.0)+(playerPlayTime + 0.0))
						/5)/(playerPlayTime + 0.0)/(allEnemy2Shoots + 0.0)));
		}

		public double getTR() {
			return (playerPlayTime==0)?0:
				Double.parseDouble(String.format("%.3f",playerTurnovers/(playerFGTry - player3FGTry + 0.44 * playerFTGTry+playerTurnovers)));
		}

		public double getUR() {
			return (playerPlayTime==0)?0:
				Double.parseDouble(String.format("%.3f",(playerFGTry+0.44*playerFTGTry+playerTurnovers)*
					(teammatePlayTime+playerPlayTime)/5/playerPlayTime/
					(allTeamShoots+0.44*allTeamFTShoots+allTeamTurnover)));
		}
//		
//        public double getdata(DataType d){
//        	   if(d==DataType.playerAttends){
//        		   return playerAttends;
//        	   }
//        	   if(d==DataType.startTimes){
//        		   return startTimes;
//        	   }
//        	   if(d==DataType.playerAssists){
//        		   return playerAssists;
//        	   }
//        	   if(d==DataType.playerFG){
//        		   return playerFG;
//        	   }
//        	   if(d==DataType.playerFGTry){
//        		   return playerFGTry;
//        	   }
//        	   if(d==DataType.player3FG){
//        		   return player3FG;
//        	   }
//        	   if(d==DataType.player3FGTry){
//        		   return player3FGTry;
//        	   }
//        	   if(d==DataType.playerFTG){
//        		   return playerFTG;
//        	   }
//        	   if(d==DataType.playerFTGTry){
//        		   return playerFTGTry;
//        	   }
//        	   if(d==DataType.player3FG){
//        		   return player3FG;
//        	   }
//        	   if(d==DataType.playerOffenceRebounds){
//        		   return playerOffenceRebounds;
//        	   }
//        	   if(d==DataType.playerDeffenceRebounds){
//        		   return playerDeffenceRebounds;
//        	   }
//        	   if(d==DataType.playerTotalRebounds){
//        		   return playerTotalRebounds;
//        	   }
//        	   if(d==DataType.playerSteals){
//        		   return playerSteals;
//        	   }
//        	   if(d==DataType.playerBlocks){
//        		   return playerBlocks;
//        	   }
//        	   if(d==DataType.playerTurnovers){
//        		   return playerTurnovers;
//        	   }
//        	   if(d==DataType.playerFouls){
//        		   return playerFouls;
//        	   }
//        	   if(d==DataType.playerScores){
//        		   return playerScores;
//        	   }
//        	   if(d==DataType.player3FG){
//        		   return player3FG;
//        	   }
//        	   if(d==DataType.aver_playerAssists){
//        		   return getAver_playerAssists();
//        	   }
//        	   if(d==DataType.aver_playerPlayTime){
//        		   return getAver_playerPlayTime();
//        	   }
//        	   if(d==DataType.aver_playerFG){
//        		   return getAver_playerFG();
//        	   }
//        	   if(d==DataType.aver_playerFGTry){
//        		   return getAver_playerFGTry();
//        	   }
//        	   if(d==DataType.aver_player3FG){
//        		   return getAver_player3FG();
//        	   }
//        	   if(d==DataType.aver_player3FGTry){
//        		   return getAver_player3FGTry();
//        	   }
//        	   if(d==DataType.aver_playerFTG){
//        		   return getAver_playerFTG();
//        	   }
//        	   if(d==DataType.aver_playerFTGTry){
//        		   return getAver_playerFTGTry();
//        	   }
//        	   if(d==DataType.aver_playerFGTry){
//        		   return getAver_playerFGTry();
//        	   }
//        	   if(d==DataType.aver_playerOffenceRebounds){
//        		   return getAver_playerOffenceRebounds();
//        	   }
//        	   if(d==DataType.aver_playerDeffenceRebounds){
//        		   return getAver_playerDeffenceRebounds();
//        	   }
//        	   if(d==DataType.aver_playerTotalRebounds){
//        		   return getAver_playerTotalRebounds();
//        	   }
//        	   if(d==DataType.aver_playerSteals){
//        		   return getAver_playerSteals();
//        	   }
//        	   if(d==DataType.aver_playerBlocks){
//        		   return getAver_playerBlocks();
//        	   }
//        	   if(d==DataType.aver_playerTurnovers){
//        		   return getAver_playerTurnovers();
//        	   }
//        	   if(d==DataType.aver_playerFouls){
//        		   return getAver_playerFouls();
//        	   }
//        	   if(d==DataType.aver_playerScores){
//        		   return getAver_playerScores();
//        	   }
//        	   if(d==DataType.playerFGP){
//        		   return getPlayerFGP();
//        	   }
//        	   if(d==DataType.player3FGP){
//        		   return getPlayer3FGP();
//        	   }
//        	   if(d==DataType.playerFTGP){
//        		   return getPlayerFTGP();
//        	   }
//        	   if(d==DataType.playerPER){
//        		   return getPlayerPER();
//        	   }
//        	   if(d==DataType.playerGmScER){
//        		   return getPlayerGmScER();
//        	   }
//        	   if(d==DataType.playerTSP){
//        		   return getPlayerTSP();
//        	   }
//        	   if(d==DataType.playerSER){
//        		   return getPlayerSER();
//        	   }
//        	   if(d==DataType.RR){
//        		   return getRR();
//        	   }
//        	   if(d==DataType.o_RR){
//        		   return getO_RR();
//        	   }
//        	   if(d==DataType.d_RR){
//        		   return getD_RR();
//        	   }
//        	   if(d==DataType.AR){
//        		   return getAR();
//        	   }
//        	   if(d==DataType.SR){
//        		   return getSR();
//        	   }
//        	   if(d==DataType.BR){
//        		   return getBR();
//        	   }
//        	   if(d==DataType.TR){
//        		   return getTR();
//        	   }
//        	   if(d==DataType.UR){
//        		   return getUR();
//        	   }
//        	   return 0;
//        }


		public String getHeight() {
			return height;
		}
		public double getWeight() {
			return weight;
		}
		public String getPlayerBirth() {
			return playerBirth;
		}
		public int getPlayerAge() {
			return playerAge;
		}
		public int getExp() {
			return exp;
		}
		public int getPlayerFGTry() {
			return playerFGTry;
		}
		public int getPlayer3FG() {
			return player3FG;
		}
		public int getPlayer3FGTry() {
			return player3FGTry;
		}
		public int getPlayerFTG() {
			return playerFTG;
		}
		public int getPlayerFTGTry() {
			return playerFTGTry;
		}
		public String getTeamShortName() {
			return teamShortName;
		}
        public int getdouble_double(){
        	return double_double;
        }
		@Override
		public int compareTo(Player o) {
			if(comparetype.equals("两双")){
				   if(double_double-o.getdouble_double()<0)
	     		       return 1;
				   if(double_double-o.getdouble_double()==0)
					   return 0;
				   return -1;
	     	   }
	     	
	     	   if(comparetype.equals("得分/篮板/助攻")){
	     		   if( (this.getPlayerScores()+this.getPlayerTotalRebounds()+this.getPlayerAssists() )-( o.getPlayerScores()+o.getPlayerTotalRebounds()+o.getPlayerAssists())<0)
	     		       return 1;
	     		  if( (this.getPlayerScores()+this.getPlayerTotalRebounds()+this.getPlayerAssists() )-( o.getPlayerScores()+o.getPlayerTotalRebounds()+o.getPlayerAssists())==0)
	     		   return 0;
	     	   }
	     	  
	     	   if(comparetype.equals("助攻")){
	     		   if( (this.getPlayerAssists()-o.getPlayerAssists() )<0)
	     		       return 1;
	     		  if( (this.getPlayerAssists()-o.getPlayerAssists() )==0)
	     			  return 0;
	     		   return -1;
	     	   }
	     	   if(comparetype.equals("分钟")){
	     		   if((this.getPlayerPlayTime()-o.getPlayerPlayTime())<0)
	     		       return 1;
	     		  if((this.getPlayerPlayTime()-o.getPlayerPlayTime())==0)
	     			  return 0;
	               return -1;
	     	   }
	     	  
	     	   if(comparetype.equals("篮板")){
	     		  if((this.getPlayerTotalRebounds()-o.getPlayerTotalRebounds())<0)
	    		       return 1;
	     		 if((this.getPlayerTotalRebounds()-o.getPlayerTotalRebounds())==0)
	     			 return 0;
	              return -1;
	     	   }
	     	   if(comparetype.equals("抢断")){
	     		  // System.out.println("ppp");
	     		  if((this.getPlayerSteals()-o.getPlayerSteals())<0)
	   		           return 1;
	     		  if((this.getPlayerSteals()-o.getPlayerSteals())==0)
	     			  return 0;
	    		  return -1;
	     	   }
	     	   if(comparetype.equals("盖帽")){
	     		  if((this.getPlayerBlocks()-o.getPlayerBlocks())<0)
	  		           return 1;
	     		 if((this.getPlayerBlocks()-o.getPlayerBlocks())==0)
	     			 return 0;
	   		      return -1;
	     	   }
	     	   if(comparetype.equals("失误")){
	     		  if((this.getPlayerTurnovers()-o.getPlayerTurnovers()<0))
	 		           return 1;
	     		 if((this.getPlayerTurnovers()-o.getPlayerTurnovers()==0))
	     			 return 0;
	  		      return -1;
	     	   }
	     	   if(comparetype.equals("犯规")){
	     		  if((this.getPlayerFouls()-o.getPlayerFouls()<0))
	    		           return 1;
	     		 if((this.getPlayerFouls()-o.getPlayerFouls()==0))
	     			 return 0;
	     		      return -1;
	     	   }
	     	   if(comparetype.equals("得分")){
	     		  if((this.getPlayerScores()-o.getPlayerScores()<0))
	   		           return 1;
	     		 if((this.getPlayerScores()-o.getPlayerScores()==0))
	     			 return 0;
	    		      return -1;
	     	   }
	     	   if(comparetype.equals("投篮")){
	     		  if((this.getPlayerFGP()-o.getPlayerFGP()<0))
	  		           return 1;
	     		 if((this.getPlayerFGP()-o.getPlayerFGP()==0))
	     			 return 0;
	   		      return -1;
	     	   }
	     	   if(comparetype.equals("三分")){
	     		  if((this.getPlayer3FGP()-o.getPlayer3FGP()<0))
	 		           return 1;
	     		 if((this.getPlayer3FGP()-o.getPlayer3FGP()==0))
	     			 return 0;
	  		      return -1;
	     	   }


                if(comparetype.equals("罚球")){
	     		  if((this.getPlayerFTGP()-o.getPlayerFTGP()<0))
			           return 1;
	     		  if((this.getPlayerFTGP()-o.getPlayerFTGP()==0))
	     			  return 0;
	 		      return -1;
	     	   }
	     	   if(comparetype.equals("效率")){
	     		  if((this.getPlayerPER()-o.getPlayerPER()<0))
			           return 1;
	     		 if((this.getPlayerPER()-o.getPlayerPER()==0))
	     			 return 0;
	 		      return -1;
	     	   }
	     	  if(comparetype.equals("进步率")){
	     		   if(this.getAdvancedP()-o.getAdvancedP()<0){
	     			   return 1;
	     		   }
	     		  if(this.getAdvancedP()-o.getAdvancedP()==0)
	     			  return 0;
	     		   return -1;	   
	     	   }
	     	 if(comparetype.equals("效率")){
	     		   if(this.getPlayerGmScER()-o.getPlayerGmScER()<0){
	     			   return 1;
	     		   }
	     		  if(this.getPlayerGmScER()-o.getPlayerGmScER()==0)
	     			  return 0;
	     		   return -1;	   
	     	   }
	     	if(comparetype.equals("平均篮板")){
	     		   if(this.getAver_playerTotalRebounds()-o.getAver_playerTotalRebounds()<0){
	     			   return 1;
	     		   }
	     		  if(this.getAver_playerTotalRebounds()-o.getAver_playerTotalRebounds()==0)
	     			  return 0;
	     		   return -1;	   
	     	   }
	     	if(comparetype.equals("平均助攻")){
	     		   if(this.getAver_playerAssists()-o.getAver_playerAssists()<0){
	     			   return 1;
	     		   }
	     		  if(this.getAver_playerAssists()-o.getAver_playerAssists()==0)
	     			  return 0;
	     		   return -1;	   
	     	   }
	     	if(comparetype.equals("平均抢断")){
	     		   if(this.getAver_playerSteals()-o.getAver_playerSteals()<0){
	     			   return 1;
	     		   }
	     		  if(this.getAver_playerSteals()-o.getAver_playerSteals()==0)
	     			  return 0;
	     		   return -1;	   
	     	   }
	     	if(comparetype.equals("平均得分")){
	     		   if(this.getAver_playerScores()-o.getAver_playerTotalRebounds()<0){
	     			   return 1;
	     		   }
	     		  if(this.getAver_playerScores()-o.getAver_playerTotalRebounds()==0)
	     			  return 0;
	     		   return -1;	   
	     	   }
	     	if(comparetype.equals("平均盖帽")){
	     		   if(this.getAver_playerBlocks()-o.getAver_playerBlocks()<0){
	     			   return 1;
	     		   }
	     		  if(this.getAver_playerBlocks()-o.getAver_playerBlocks()==0){
	     			 return 0;
	     		  }
	     			  
	     		   return -1;	   
	     	   }
				return 0;

		} 

        public double getaddate(String type) {
			if(type.equals("得分")){
				return playerScores;
			}
			if(type.equals("篮板")){
    			return playerTotalRebounds;
    		}
    		if(type.equals("助攻")){
    			return playerAssists;
    		}
    		if(type.equals("抢断")){
    			return playerSteals;
    		}
    		if(type.equals("盖帽")){
    			return playerBlocks;
    		}
    		if(type.equals("FGP")){
    			if(playerFGTry==0){
    				return 0;
    			}
    			return (double)playerFG/(double)playerFGTry;
    		}
    		if(type.equals("FTGP")){
    			if(playerFTGTry==0){
    				return 0;
    			}
    			return (double)playerFTG/(double)playerFTGTry;
    		}
    		if(type.equals("3FGP")){
    			if(player3FGTry==0){
    				return 0;
    			}
    			return (double)player3FG/(double)player3FGTry;
    		}
    		return 0;
		}

		public double getAdvancedP() {
			return advancedP;
		}

		public void setAdvancedP(double advancedP) {
			this.advancedP = advancedP;
		}

		public void setcompare(String string) {
			comparetype=string;
		}


}

