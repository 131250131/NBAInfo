package com.nba.data;

public class Player implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
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
		double_double=0;
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
		playerTotalRebounds = playerTotalRebounds + totalRebounds;//
		playerAssists = playerAssists + assists;//
		playerSteals = playerSteals + steals;//
		playerBlocks = playerBlocks + blocks;//
		playerTurnovers = playerTurnovers + turnovers;
		playerFouls = playerFouls + fouls;
		playerScores = playerScores + scores;//
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
	
	public String getTeamShortName(){
		return teamShortName;
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
		int playerScores; 
		
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
	//73.球员两双场次 (*****要传*****)	
		int    double_double;
		public int getPlayerAttends(){
			return playerAttends;
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
		
		public double getPlayerPlayTime(){
			return (playerAttends==0)?0:(playerPlayTime / playerAttends) / 60;
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
		public int getdouble_double(){
			return double_double;
		}
//		
        public double getdata(String d){
        	   if(d.equals("两双")){
        		   return double_double;
        	   }
        	/*   if(d.equals("playerAttends")){
        		   return playerAttends;
        	   }
        	   if(d.equals("startTimes")){
        		   return startTimes;
        	   }
        	   if(d==DataType.playerAssists"))){
        		   return playerAssists;
        	   }
        	   if(d==DataType.playerFG")){
        		   return playerFG;
        	   }
        	   if(d==DataType.playerFGTry){
        		   return playerFGTry;
        	   }
        	   if(d==DataType.player3FG){
        		   return player3FG;
        	   }
        	   if(d==DataType.player3FGTry){
        		   return player3FGTry;
        	   }
        	   if(d==DataType.playerFTG){
        		   return playerFTG;
        	   }
        	   if(d==DataType.playerFTGTry){
        		   return playerFTGTry;
        	   }
        	   if(d==DataType.player3FG){
        		   return player3FG;
        	   }
        	   if(d==DataType.playerOffenceRebounds){
        		   return playerOffenceRebounds;
        	   }
        	   if(d==DataType.playerDeffenceRebounds){
        		   return playerDeffenceRebounds;
        	   }
        	   if(d==DataType.playerTotalRebounds){
        		   return playerTotalRebounds;
        	   }
        	   */
        	   if(d.equals("得分/篮板/助攻")){
        		   return getAver_playerScores()+getAver_playerTotalRebounds()+getAver_playerAssists();
        	   }
        	   /*
        	   if(d==DataType.playerBlocks){
        		   return playerBlocks;
        	   }
        	   if(d==DataType.playerTurnovers){
        		   return playerTurnovers;
        	   }
        	   if(d==DataType.playerFouls){
        		   return playerFouls;
        	   }
        	   if(d==DataType.playerScores){
        		   return playerScores;
        	   }
        	   if(d==DataType.player3FG){
        		   return player3FG;
        	   }
        	   */
        	   if(d.equals("助攻")){
        		   return getAver_playerAssists();
        	   }
        	   if(d.equals("分钟")){
        		   return getAver_playerPlayTime();
        	   }
        	   /*
        	   if(d==DataType.aver_playerFG){
        		   return getAver_playerFG();
        	   }
        	   if(d==DataType.aver_playerFGTry){
        		   return getAver_playerFGTry();
        	   }
        	   if(d==DataType.aver_player3FG){
        		   return getAver_player3FG();
        	   }
        	   if(d==DataType.aver_player3FGTry){
        		   return getAver_player3FGTry();
        	   }
        	   if(d==DataType.aver_playerFTG){
        		   return getAver_playerFTG();
        	   }
        	   if(d==DataType.aver_playerFTGTry){
        		   return getAver_playerFTGTry();
        	   }
        	   if(d==DataType.aver_playerFGTry){
        		   return getAver_playerFGTry();
        	   }
        	   if(d==DataType.aver_playerOffenceRebounds){
        		   return getAver_playerOffenceRebounds();
        	   }
        	   if(d==DataType.aver_playerDeffenceRebounds){
        		   return getAver_playerDeffenceRebounds();
        	   }
        	   */
        	   if(d.equals("篮板")){
        		   return getAver_playerTotalRebounds();
        	   }
        	   if(d.equals("抢断")){
        		   return getAver_playerSteals();
        	   }
        	   if(d.equals("盖帽")){
        		   return getAver_playerBlocks();
        	   }
        	   if(d.equals("失误")){
        		   return getAver_playerTurnovers();
        	   }
        	   if(d.equals("犯规")){
        		   return getAver_playerFouls();
        	   }
        	   if(d.equals("得分")){
        		   return getAver_playerScores();
        	   }
        	   if(d.equals("投篮")){
        		   return getPlayerFGP();
        	   }
        	   if(d.equals("三分")){
        		   return getPlayer3FGP();
        	   }
        	   if(d.equals("罚球")){
        		   return getPlayerFTGP();
        	   }
        	   if(d.equals("效率")){
        		   return getPlayerPER();
        	   }
        	   /*
        	   if(d==DataType.playerGmScER){
        		   return getPlayerGmScER();
        	   }
        	   if(d==DataType.playerTSP){
        		   return getPlayerTSP();
        	   }
        	   if(d==DataType.playerSER){
        		   return getPlayerSER();
        	   }
        	   if(d==DataType.RR){
        		   return getRR();
        	   }
        	   if(d==DataType.o_RR){
        		   return getO_RR();
        	   }
        	   if(d==DataType.d_RR){
        		   return getD_RR();
        	   }
        	   if(d==DataType.AR){
        		   return getAR();
        	   }
        	   if(d==DataType.SR){
        		   return getSR();
        	   }
        	   if(d==DataType.BR){
        		   return getBR();
        	   }
        	   if(d==DataType.TR){
        		   return getTR();
        	   }
        	   if(d==DataType.UR){
        		   return getUR();
        	   }
        	   */
        	   return 0;
        }
        
        public String getDivision(String teamName){
        		String result = new String();
        		switch(teamName){
        			case "SAS":result="西南区";break;
        			case "MEM":result="西南区";break;
        			case "HOU":result="西南区";break;
        			case "DAL":result="西南区";break;
        			case "NOL":result="西南区";break;
        			case "SAC":result="太平洋区";break;
        			case "PHX":result="太平洋区";break;
        			case "LAL":result="太平洋区";break;
        			case "GSW":result="太平洋区";break;
        			case "LAC":result="太平洋区";break;
        			case "MIN":result="西北区 ";break;
        			case "DEN":result="西北区 ";break;
        			case "UTH":result="西北区 ";break;
        			case "POR":result="西北区 ";break;
        			case "OTC":result="西北区 ";break;
        			case "MIA":result="东南区 ";break;
        			case "ORL":result="东南区 ";break;
        			case "ATL":result="东南区 ";break;
        			case "WAS":result="东南区 ";break;
        			case "CHA":result="东南区 ";break;
        			case "DET":result="中央区";break;
        			case "IND":result="中央区";break;
        			case "CLE":result="中央区";break;
        			case "CHI":result="中央区";break;
        			case "MIL":result="中央区";break;
        			case "NYN":result="大西洋区";break;
        			case "PHI":result="大西洋区";break;
        			case "CEL":result="大西洋区";break;
        			case "NJN":result="大西洋区";break;
        			case "TOR":result="大西洋区";break;	
        		}
        		return result;
        }

		public boolean getEast(String teamName) {
			boolean result = false;
    		switch(teamName){
    			case "SAS":result=false;break;
    			case "MEM":result=false;break;
    			case "HOU":result=false;break;
    			case "DAL":result=false;break;
    			case "NOL":result=false;break;
    			case "SAC":result=false;break;
    			case "PHX":result=false;break;
    			case "LAL":result=false;break;
    			case "GSW":result=false;break;
    			case "LAC":result=false;break;
    			case "MIN":result=false;break;
    			case "DEN":result=false;break;
    			case "UTH":result=false;break;
    			case "POR":result=false;break;
    			case "OTC":result=false;break;
    			case "MIA":result=true;break;
    			case "ORL":result=true;break;
    			case "ATL":result=true;break;
    			case "WAS":result=true;break;
    			case "CHA":result=true;break;
    			case "DET":result=true;break;
    			case "IND":result=true;break;
    			case "CLE":result=true;break;
    			case "CHI":result=true;break;
    			case "MIL":result=true;break;
    			case "NYN":result=true;break;
    			case "PHI":result=true;break;
    			case "CEL":result=true;break;
    			case "NJN":result=true;break;
    			case "TOR":result=true;break;	
    		}
    		return result;
		}
}
