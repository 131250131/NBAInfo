package com.main;

import java.util.ArrayList;
import java.util.Arrays;

public class SetOfSort {
	/*快速排序*/
	public void playerquickSort(ArrayList<Player> arr,int left,int right,DataType type){
		
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
	
	/*针对球队对象的快速排序*/
	
	public void teamquicksort(ArrayList<Team> arr,int left,int right,DataType type){
		/*
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
		*/
	}
	
	/*堆排序*/
	public double[] headSort(double[] sortArray)  
    {  
        for(int i=0;i<sortArray.length-1;i++)  
        {  
           buildMaxHeap(sortArray,sortArray.length-1-i);  
           swap(sortArray,0,sortArray.length-1-i);  
        }  
        return sortArray;  
    }  
    //交换两个数据的方法  
    public void swap(double[] data,int i,int j)  
    {  
        double temp = data[i];  
        data[i] = data[j];  
        data[j] = temp;  
    }  
    //建立大顶堆  
    public void buildMaxHeap(double[] data,int lastIndex)  
    {  
        //从lastIndex节点的父节点开始舰堆  
        for(int i=(lastIndex-1)/2;i>=0;i--)  
        {  
            //保存正在判断的节点  
            int k = i;  
            //这里为每个节点建立大顶堆,只要这个根节点还有子节点  
            while((2*k+1) <= lastIndex)  
            {  
                //假设左节点的值时最大的  
                int biggerIndex = 2*k+1;  
                //说明还有右节点是存在的  
                if(biggerIndex < lastIndex)  
                {  
                    //选出子节点中最大的值  
                    if(data[biggerIndex] < data[biggerIndex+1])  
                    {  
                        biggerIndex++;  
                    }  
                }  
                //将跟节点与子节点进行比较  
                if(data[k] < data[biggerIndex])  
                {  
                    swap(data,k,biggerIndex);  
                    k = biggerIndex;  
                }else  
                {  
                    break;  
                }  
            }  
        }  
    }   
	public static void main(String[] args) {
		ArrayList<Double> test=new ArrayList<Double>();
		Searcher searcher = new Searcher();
		
		for(ArrayList<Player> temp:searcher.getFinalPlayerList()){
//			System.out.println(temp.size());
			for(Player temp0:temp){
				test.add((double)temp0.playerScores);
			}
		}
//		test.add(0.0);
//		test.add(5.1);
//		test.add(3.1);
//		test.add(4.3);
//		test.add(0.1);
//		test.add(0.7);
//		test.add(7.8);
//		test.add(7.1);
		
		
		//SetOfSort ss=new SetOfSort();
		
		double[] test0=new double[test.size()];
		for(int i=0;i<test.size();i++){
			test0[i]=test.get(i);
		}
		double t1 = System.currentTimeMillis();
		Arrays.sort(test0);
	  //ss.playerquickSort(test,0,test.size()-1);
		double t2 = System.currentTimeMillis();
		
		double useTime=t2-t1;
		
		
	
		
//		for(double temp:test){
//			System.out.println(temp);
//		}
		
//		System.out.println(searcher.getFinalPlayerList().size());
		System.out.println("Using " + useTime + "ms");

		
	}
}
