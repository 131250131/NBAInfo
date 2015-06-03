package Utibility;

public enum DataType {
	/*
	 * 
	 * 2015/6/2
	 * A-平均     T-总和   H-最高  (因为3F不行，所以使用SF替代三分)Z代表命中，比如FGP FGZ FG分别代表投篮命中率，投篮命中次数和投篮出手次数
	 * 一个该类表示一个球员在一个赛季常规或者季后赛的数据统计
	 * time 上场时间
	 * rebounds 篮板
	 * orebounds 进攻篮板
	 * drebounds 防守篮板
	 * assists   助攻
	 * steals    抢断
	 * blocks    盖帽
	 * turnovers 失误
	 * feals     犯规
	 * scores    得分
	 * 上述数据前加A T H分别表示平均总和和赛季最高
	 * win       球员上场赢的比赛数目
	 * lose       球员上场输的比赛数目
	 */
        id,//球员编号 
        season,//赛季
        teamname,//teamname为总计时，表示该球员一个赛季在两个球队打过,并且这一条为在所有球队打过的比赛的总计
        attendmatches,
        First,//首发场数
    /*
     * Average
     */
         Atime,
         FGP,
         AFGZ ,//Z代表命中
         AFG ,
         SFGP ,
         ASFGZ ,
         ASFG ,
         FTGP ,
         AFTGZ ,
         AFTG ,
         ARebounds ,
         AORebouns ,
         ADRebounds ,
         AAssists ,
         ASteals ,
         ABlocks ,
         ATurnovers ,
         AFeals ,
         AScores ,
   
         Win ,
         Lose ,
    
    /*
     * Total
     */
         Ttime ,
         TFGZ ,
         TFG ,
         TSFGZ ,
         TSFG ,
         TFTGZ ,
         TFTG ,
         TRebounds ,
         TORebouns ,
         TDRebounds ,
         TAssists ,
         TSteals ,
         TBlocks ,
         TTurnovers ,
         TFeals ,
         TScores ,
    
    /*
     * Advanced data
     */
         RR ,//篮板率
         O_RR ,//进攻篮板率
         D_RR ,//防守篮板率
         AR ,//助攻率
         SR ,//抢断率
         BR ,//盖帽率
         TR ,//失误率
         UseRate ,//使用率(上场率)
         OR ,//进攻率
         DR ,//防守率
         WS ,//WS
         O_WS ,//进攻WS
         D_WS ,//防守WS
         PER ,//效率
         Dunk ,//扣篮个数
         TTPO ,//2/3+1(并不知道是什么)
         Blocked ,//被冒个数
         ShootDistance ,//投篮距离
    
         LXFGP ,//LX表示篮下
         LXFGZ ,
         LXFG ,
         LXFGRate ,//表示篮下投篮在所有投篮中比例，以下类推
    
         JJLFGP ,//JJ表示近距离
         JJLFGZ ,
         JJLFG ,
         JJLFGRate ,
    
         ZJLFGP ,//ZJL表示中距离
         ZJLFGZ ,
         ZJLFG ,
         ZJLFGRate ,
    
         YJLFGP ,//YJL表示远距离
         YJLFGZ ,
         YJLFG ,
         YJLFGRate ,
    
         RealShootRate ,//真实命中率
         S_RR ,//投篮效率
    
    /*
     * High data
     */
         Htime ,
         HFGP ,
         HFGZ ,//Z代表命中
         HFG ,
         HSFGP ,
         HSFGZ ,
         HSFG ,
         HFTGP ,
         HFTGZ ,
         HFTG ,
         HRebounds ,
         HORebouns ,
         HDRebounds ,
         HAssists ,
         HSteals ,
         HBlocks ,
         HTurnovers ,
         HFeals ,
         HScores ,
}
