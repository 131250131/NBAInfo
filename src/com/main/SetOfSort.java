package com.main;

import java.util.ArrayList;
import java.util.Arrays;

public class SetOfSort {

	public void quickSort(ArrayList<Double> arr,int left,int right){
		
		if(left>=right){
			return;
		}
		double mid=arr.get(left);//以第一个元素作为对比
		int low=left;//低位指针
		int hight=right;//高位指针
		while(low<hight){
			while(low<hight&&arr.get(hight)>=mid){//循环直到找到小于对比值的元素的坐标
				hight--;
			}
			if(low<hight){
				arr.set(low, arr.get(hight));
			}
			while(low<hight&&arr.get(low)<=mid){//循环直到找到大于对比值的元素的坐标
				low++;
			}
			if(low<hight){
				arr.set(hight, arr.get(low));
			}
		
		}
		
		//跳出以上循环时low=hight，因将中间值放到找到的位置
		arr.set(low, mid);
		
		//递归两边
		quickSort(arr,left,low-1);
		quickSort(arr,low+1,right);
		
		
	}
	public static void main(String[] args) {
		ArrayList<Double> test=new ArrayList<Double>();
		test.add(0.0);
		test.add(5.1);
		test.add(3.1);
		test.add(4.3);
		test.add(0.1);
		test.add(0.7);
		test.add(7.8);
		test.add(7.1);
		
		
		SetOfSort ss=new SetOfSort();
		
		double[] test0=new double[8];
		for(int i=0;i<8;i++){
			test0[i]=test.get(i);
		}
		double t1 = System.currentTimeMillis();
//		Arrays.sort(test0);
		ss.quickSort(test, 0, 7);
		double t2 = System.currentTimeMillis();
		
		double useTime=t2-t1;
		System.out.println("Using " + useTime + "ms");

		
	
		
//		for(double temp:test){
//			System.out.println(temp);
//		}
		
		
	}
}
