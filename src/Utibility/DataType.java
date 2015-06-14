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
	 * 要进行推断统计的有27项
	 */
        attendmatches,//出场次数
        First,//首发场数
    /*
     * Average
     */
       
         Atime,//平均时间
         FGP,//命中率，要进行推断统计
         AFGZ ,//平均投篮命中数,要进行推断统计
         AFG ,//平均投篮出手数,要进行推断统计
         SFGP ,//三分命中率,要进行推断统计
         ASFGZ ,//平均三分命中数,要进行推断统计
         ASFG ,//平均三分出手数,要进行推断统计
         FTGP ,//平均罚球命中率,要进行推断统计
         AFTGZ ,//平均罚球命中数,要进行推断统计
         AFTG ,//平均罚球数,要进行推断统计
         ARebounds ,//平均篮板,要进行推断统计
         AORebounds ,//平均球场篮板,要进行推断统计
         ADRebounds ,//平均后场篮板,要进行推断统计
         AAssists ,//平均助攻,要进行推断统计
         ASteals ,//平均抢断,要进行推断统计
         ABlocks ,//平均盖帽,要进行推断统计
         ATurnovers ,//平均失误,要进行推断统计
         AFouls ,//平均犯规,要进行推断统计
         AScores ,//平均得分,要进行推断统计
   
         Win ,//参加比赛球队胜场
         Lose ,//参加比赛球队负场
    
    /*
     * Total
     */
         Ttime ,//总时间
         TFGZ ,//总投篮命中
         TFG ,//总投篮出手
         TSFGZ ,//总三分命中
         TSFG ,//总三分出手
         TFTGZ ,//总罚球命中
         TFTG ,//总罚球出手
         TRebounds ,//总篮板
         TORebouns ,//总前场板
         TDRebounds ,//总后场板
         TAssists ,//总助攻
         TSteals ,//总抢断
         TBlocks ,//总盖帽
         TTurnovers ,//总失误
         TFouls ,//总犯规
         TScores ,//总得分
    
    /*
     * Advanced data
     */
         RR ,//篮板率,要进行推断统计
         O_RR ,//进攻篮板率,要进行推断统计
         D_RR ,//防守篮板率,要进行推断统计
         AR ,//助攻率,要进行推断统计
         SR ,//抢断率,要进行推断统计
         BR ,//盖帽率,要进行推断统计
         TR ,//失误率,要进行推断统计
         UseRate ,//使用率(上场率)
         OR ,//进攻率,要进行推断统计
         DR ,//防守率,要进行推断统计
         WS ,//WS ，不需要
         O_WS ,//进攻WS，不需要
         D_WS ,//防守WS，不需要
         PER ,//效率,要进行推断统计
         Dunk ,//扣篮个数，不需要
         TTPO ,//2/3+1(并不知道是什么)，不需要
         Blocked ,//被冒个数，不需要
         ShootDistance ,//投篮距离
    
         LXFGP ,//篮下命中率
         LXFGZ ,//篮下命中数
         LXFG ,//篮下出手数
         LXFGRate ,//篮下出手比例
    
         JJLFGP ,//近距离投篮命中率
         JJLFGZ ,//近距离投篮命中数
         JJLFG ,//近距离投篮数
         JJLFGRate ,//近距离投篮比例
    
         ZJLFGP ,//中距离投篮命中率
         ZJLFGZ ,//中距离投篮命中数
         ZJLFG ,//中距离投篮出手数
         ZJLFGRate ,//中距离投篮比例
    
         YJLFGP ,//远距离投篮命中率
         YJLFGZ ,//远距离投篮命中数
         YJLFG ,//远距离投篮出手数
         YJLFGRate ,//远距离投篮比例
    
         RealShootRate ,//真实命中率
         S_RR ,//投篮效率
    
    /*
     * High data
     */
         Htime ,//最高出场时间
         HFGP ,//最高命中率
         HFGZ ,////最高命中数
         HFG ,//最高出手数
         HSFGP ,//最高三分命中率
         HSFGZ ,//最高三分命中
         HSFG ,//最高三分出手
         HFTGP ,//最高罚球命中率
         HFTGZ ,//最高罚球命中
         HFTG ,//最高罚球数
         HRebounds ,//最高篮板
         HORebouns ,//最高前场板
         HDRebounds ,//最高后场板
         HAssists ,//最高助攻
         HSteals ,//最高抢断
         HBlocks ,//最高篮板
         HTurnovers ,//最高失误
         HFouls ,//最高犯规
         HScores ,//最高得分
         salary,//年薪 单位是万美元 界面加一下吧 这边传给你前面的数字
}
