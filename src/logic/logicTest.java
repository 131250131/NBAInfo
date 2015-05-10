package logic;

import java.util.ArrayList;
import java.util.Collections;

import Utibility.playercomp;
import test.Sort;
import vo.MatchVO;
import vo.PlayerVO;
import logicservice.matchControllerService;
import logicservice.teamControllerService;

public class logicTest {
	public static void main(String args[]){
	   MainController m=new MainController();
	   m.init();
	   //System.out.println("pp");
	   PlayerController pl=PlayerController.getInstance();
	   TeamController   cl=TeamController.getInstance();
	   ArrayList<PlayerVO> p=new ArrayList<PlayerVO>();
	   ArrayList<Sort> s=new ArrayList<Sort>();
	   Sort ss=new Sort();
	 //  Sort sss=new Sort();
	   ss.setField("assistEfficient");
	   ss.setAsc(false);
	  // sss.setAsc(false);
	   //sss.setField("point");
	   s.add(ss);
	  // s.add(sss);
	   playercomp plc=new playercomp();
	   plc.setSort(s);
	   plc.setAveg("aveg");
	   p=pl.getAllPlayerVO();
	   Collections.sort(p,plc);
	   for(PlayerVO pll:p){
		   System.out.println(pll.getPlayerName()+"gg"+pll.getBR());
	   }
}
}
