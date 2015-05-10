package Utibility;

import java.util.ArrayList;
import java.util.Comparator;

import test.Sort;
import vo.PlayerVO;

public class playercomp implements  Comparator{
    private ArrayList<Sort> sort=new ArrayList<Sort>();
    private String aveg="aveg";
	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		PlayerVO pl1=(PlayerVO)arg0;
		PlayerVO pl2=(PlayerVO)arg1;
		
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
