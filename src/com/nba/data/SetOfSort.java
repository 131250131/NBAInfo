package com.nba.data;

import java.util.ArrayList;

public class SetOfSort {
	/*快速排序*/
		public void playerquickSort(ArrayList<Player> arr,int left,int right,String type){
			
			if(left>=right){
				return;
			}
			Player midplayer=arr.get(left);
			double mid=arr.get(left).getdata(type);//以第一个元素作为对比
			int low=left;//低位指针
			int hight=right;//高位指针
			while(low<hight){
				while(low<hight&&arr.get(hight).getdata(type)>=mid){//循环直到找到小于对比值的元素的坐标
					hight--;
				}
			if(low<hight){
					arr.set(low, arr.get(hight));
				}
				while(low<hight&&arr.get(low).getdata(type)<=mid){//循环直到找到大于对比值的元素的坐标
					low++;
				}
				if(low<hight){
					arr.set(hight, arr.get(low));
				}
			
			}
			
			//跳出以上循环时low=hight，因将中间值放到找到的位置
			arr.set(low, midplayer);
			
			//递归两边
			playerquickSort(arr,left,low-1,type);
			playerquickSort(arr,low+1,right,type);
		}
}
