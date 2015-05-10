package Utibility;

import java.util.ArrayList;
import java.util.Comparator;

import test.Sort;
import vo.TeamVO;

public class teamcomp implements Comparator<TeamVO> {
	private ArrayList<Sort> sort=new ArrayList<Sort>();
    private String aveg="aveg";
	@Override
	public int compare(TeamVO o1, TeamVO o2) {
		// TODO Auto-generated method stub
		TeamVO pl1=o1;
		TeamVO pl2=o2;
		int i=0;
		int size=sort.size();
		while(i<size)
			if(sort.get(i).isAsc()){
				if(pl1.getteamdate(sort.get(i).getField(), aveg).compareTo(pl2.getteamdate(sort.get(i).getField(), aveg))!=0){
					return pl1.getteamdate(sort.get(i).getField(), aveg).compareTo(pl2.getteamdate(sort.get(i).getField(), aveg));
				}
				else{
					i++;
				}
			}
			else{
				if(pl2.getteamdate(sort.get(i).getField(), aveg).compareTo(pl1.getteamdate(sort.get(i).getField(), aveg))!=0){
					return pl2.getteamdate(sort.get(i).getField(), aveg).compareTo(pl1.getteamdate(sort.get(i).getField(), aveg));
				}
				else{
					i++;
				}
			}
		return 0;
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
