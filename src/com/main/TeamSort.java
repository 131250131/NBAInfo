package com.main;

import java.util.ArrayList;

public class TeamSort {
	 private ArrayList<Team> target =new ArrayList<Team>();
     private SetOfSort sos=new SetOfSort();
public TeamSort(ArrayList<Team> p){
     target=p;
}
public void setTarget(ArrayList<Team> p){
     target=p;
}
public ArrayList<Team> setTarget(){
     return target;
}
public void sort(DataType type){
   int length=target.size()-1;
   sos.teamquicksort(target, 0, length, type);
}
}
