package com.main;

import java.util.ArrayList;

public class PlayerSort {
         private ArrayList<Player> target =new ArrayList<Player>();
         private SetOfSort sos=new SetOfSort();
public PlayerSort(ArrayList<Player> p){
	     target=p;
}
public void setTarget(ArrayList<Player> p){
	     target=p;
}
public ArrayList<Player> setTarget(){
         return target;
}
public void sort(DataType type){
	   int length=target.size()-1;
	   sos.playerquickSort(target, 0, length, type);
}
}
