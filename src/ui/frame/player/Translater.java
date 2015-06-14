package ui.frame.player;

import Utibility.DataType;

public class Translater {
 
	private String[] dataName={"出场次数","首发场数","平均时间","命中率","平均投篮命中数",
			"平均投篮出手数","三分命中率","平均三分命中数","平均三分出手数",
			"平均罚球命中率","平均罚球命中数","平均罚球数","平均篮板","平均前场篮板","平均后场篮板",
			"平均助攻","平均抢断","平均盖帽","平均失误","平均犯规","平均得分","参加比赛球队胜场","参加比赛球队负场",
			"总时间","总投篮命中","总投篮出手","总三分命中","总三分出手","总罚球命中","总罚球出手"
			,"总篮板","总前场板","总后场板","总助攻","总抢断","总盖帽","总失误","总犯规",
			"总得分","篮板率","进攻篮板率","防守篮板率","助攻率","抢断率","盖帽率"
			,"失误率","使用率(上场率)","进攻率","防守率","效率","投篮距离","篮下命中率","篮下命中数"
			,"篮下出手数","篮下出手比例","近距离投篮命中率","近距离投篮命中数","近距离投篮数","近距离投篮比例","中距离投篮命中率","中距离投篮命中数"
			,"中距离投篮出手数","中距离投篮比例","远距离投篮命中率","远距离投篮命中数","远距离投篮出手数","远距离投篮比例","真实命中率","投篮效率"
			,"最高出场时间","最高命中率","最高命中数","最高出手数","最高三分命中率","最高三分命中","最高三分出手","最高罚球命中率"
			,"最高罚球命中","最高罚球数","最高篮板","最高前场板","最高后场板","最高助攻","最高抢断","最高篮板"
			,"最高失误","最高犯规","最高得分","年薪（万元）"};
	private DataType[] dataType={ 
			DataType.attendmatches,//出场次数
			DataType.First,//首发场数
			DataType.Atime,//平均时间
			DataType. FGP,//命中率
			DataType.AFGZ ,//平均投篮命中数
			DataType.AFG ,//平均投篮出手数
			DataType.SFGP ,//三分命中率
			DataType.ASFGZ ,//平均三分命中数
			DataType.ASFG ,//平均三分出手数
			DataType.FTGP ,//平均罚球命中率
			DataType.AFTGZ ,//平均罚球命中数
			DataType.AFTG ,//平均罚球数
			DataType.ARebounds ,//平均篮板
			DataType.AORebouns ,//平均球场篮板
			DataType.ADRebounds ,//平均后场篮板
			DataType.AAssists ,//平均助攻
			DataType.ASteals ,//平均抢断
			DataType.ABlocks ,//平均盖帽
			DataType.ATurnovers ,//平均失误
			DataType.AFouls ,//平均犯规
			DataType.AScores ,//平均得分
	       
			DataType.Win ,//参加比赛球队胜场
			DataType.Lose ,//参加比赛球队负场
	        
	        /*
	         * Total
	         */
			DataType.Ttime ,//总时间
			DataType.TFGZ ,//总投篮命中
			DataType.TFG ,//总投篮出手
			DataType.TSFGZ ,//总三分命中
			DataType.TSFG ,//总三分出手
			DataType.TFTGZ ,//总罚球命中
			DataType.TFTG ,//总罚球出手
			DataType.TRebounds ,//总篮板
			DataType.TORebouns ,//总前场板
			DataType.TDRebounds ,//总后场板
			DataType.TAssists ,//总助攻
			DataType.TSteals ,//总抢断
			DataType.TBlocks ,//总盖帽
			DataType.TTurnovers ,//总失误
			DataType.TFouls ,//总犯规
			DataType.TScores ,//总得分
	        
	        /*
	         * Advanced data
	         */
			DataType.RR ,//篮板率
			DataType.O_RR ,//进攻篮板率
			DataType.D_RR ,//防守篮板率
			DataType.AR ,//助攻率
			DataType. SR ,//抢断率
			DataType.BR ,//盖帽率
			DataType.TR ,//失误率
			DataType.UseRate ,//使用率(上场率)
			DataType.OR ,//进攻率
			DataType.DR ,//防守率
			DataType.PER ,//效率
			DataType.ShootDistance ,//投篮距离
	        
			DataType.LXFGP ,//篮下命中率
			DataType.LXFGZ ,//篮下命中数
			DataType.LXFG ,//篮下出手数
			DataType.LXFGRate ,//篮下出手比例
	        
			DataType.JJLFGP ,//近距离投篮命中率
			DataType.JJLFGZ ,//近距离投篮命中数
			DataType.JJLFG ,//近距离投篮数
			DataType.JJLFGRate ,//近距离投篮比例
	        
			DataType.ZJLFGP ,//中距离投篮命中率
			DataType.ZJLFGZ ,//中距离投篮命中数
			DataType.ZJLFG ,//中距离投篮出手数
			DataType.ZJLFGRate ,//中距离投篮比例
	        
			DataType.YJLFGP ,//远距离投篮命中率
			DataType.YJLFGZ ,//远距离投篮命中数
			DataType.YJLFG ,//远距离投篮出手数
			DataType.YJLFGRate ,//远距离投篮比例
	        
			DataType.RealShootRate ,//真实命中率
			DataType.S_RR ,//投篮效率
	        
	        /*
	         * High data
	         */
			DataType.Htime ,//最高出场时间
			DataType. HFGP ,//最高命中率
			DataType. HFGZ ,////最高命中数
			DataType.HFG ,//最高出手数
			DataType.HSFGP ,//最高三分命中率
			DataType.HSFGZ ,//最高三分命中
			DataType.HSFG ,//最高三分出手
			DataType.HFTGP ,//最高罚球命中率
			DataType.HFTGZ ,//最高罚球命中
			DataType.HFTG ,//最高罚球数
			DataType.HRebounds ,//最高篮板
			DataType. HORebouns ,//最高前场板
			DataType.HDRebounds ,//最高后场板
			DataType.HAssists ,//最高助攻
			DataType.HSteals ,//最高抢断
			DataType.HBlocks ,//最高篮板
			DataType.HTurnovers ,//最高失误
			DataType.HFouls ,//最高犯规
			DataType.HScores ,//最高得分
			DataType.salary//年薪 单位是万美元 界面加一下吧 这边传给你前面的数字
	             };
	public Translater(){
		
	}
	/*转换成枚举类*/
	public DataType translate(String s){
		for(int i=0 ;i<dataName.length;i++){
			if(s.equals(dataName[i])){
				return dataType[i];
			}
		}
		return null;
	}
}
