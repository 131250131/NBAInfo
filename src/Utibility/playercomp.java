package Utibility;

import java.util.ArrayList;
import java.util.Comparator;

import test.Sort;
import vo.PlayerVO;

public class playercomp implements  Comparator<PlayerVO>{
    private ArrayList<Sort> sort=new ArrayList<Sort>();
    private String aveg="aveg";
	@Override
	public int compare(PlayerVO arg0, PlayerVO arg1) {
		// TODO Auto-generated method stub
		PlayerVO pl1=arg0;
		PlayerVO pl2=arg1;
		int i=0;
		int size=sort.size();
		while(i<size)
			if(sort.get(i).isAsc()){
				if(pl1.getplayerdata(sort.get(i).getField(), aveg).compareTo(pl2.getplayerdata(sort.get(i).getField(), aveg))!=0){
					return pl1.getplayerdata(sort.get(i).getField(), aveg).compareTo(pl2.getplayerdata(sort.get(i).getField(), aveg));
				}
				else{
					i++;
				}
			}
			else{
				if(pl2.getplayerdata(sort.get(i).getField(), aveg).compareTo(pl1.getplayerdata(sort.get(i).getField(), aveg))!=0){
					return pl2.getplayerdata(sort.get(i).getField(), aveg).compareTo(pl1.getplayerdata(sort.get(i).getField(), aveg));
				}
				else{
					i++;
				}
			}
		  return pl1.getPlayerName().compareTo(pl2.getPlayerName());
	}
	public ArrayList<Sort> getSort() {
		return sort;
	}
	public void setSort(ArrayList<Sort> sort) {
		this.sort = sort;
	}
	public String getAveg() {
		return aveg;
	}
	public void setAveg(String aveg) {
		this.aveg = aveg;
	}

}
