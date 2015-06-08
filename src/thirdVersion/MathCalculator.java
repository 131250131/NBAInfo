package thirdVersion;

import java.util.ArrayList;

//这个类用来计算各种数据;
public class MathCalculator {
	//计算样本的平均数，可以作为总体期望的无偏估计
	public double getAverage(ArrayList<Double> tempList){
		   int n=tempList.size();
		   double total=0;
		   for(Double d:tempList){
			   total+=d;
		   }
		   return total/n;
	}
	
	/*
	 * 方差
	 * 标准差
	 * 
	 * */
}
