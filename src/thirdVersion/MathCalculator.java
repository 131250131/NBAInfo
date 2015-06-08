package thirdVersion;

import java.util.ArrayList;

//这个类用来计算各种数据;
public class MathCalculator {
	/*
	 * 计算样本的平均数，可以作为总体期望的无偏估计
	 */
	public double getAverage(ArrayList<Double> tempList){
		   int n=tempList.size();
		   double total=0;
		   for(Double d:tempList){
			   total+=d;
		   }
		   return total/(double)n;
	}
	
	/*
	 * 计算样本的方差(由此可以得到标准差，这边除的就是n-1)
	 */
	public double getVariance(ArrayList<Double> tempList){
		   int n=tempList.size();
		   double average=getAverage(tempList);
		   double chahe=0;
		   for(Double d:tempList){
			   chahe+=Math.pow(d-average, 2);
		   }
		   return chahe/(double)n;
	}
	
	
	
	
	/*
	 * 模拟标准正态分布,实现效率并不高,并且有些许误差，但应该可以应付这个程序,调用这个函数前最好先截取小数部分
	 * 通过一个不断求矩形的和来实现积分
	 */
	public static double fx(double x) {
		  return 1 / Math.sqrt(2 * Math.PI) * Math.pow(Math.E, -x * x / 2);//密度函数
		 }
	public static double  Normal_Distribution(double x) {
		  double result = 0;//
		  double start = -6;//起始开始加的位置
		  double step = 0.00001;//求和跨度,越小越精确,好像再小就会很慢
		  if (x < -4.9) {
		   return 0;
		  } else if (x > 4.9) {
		   return 1;
		  }
		  for (double i = start; i < x; i += step)
		   result += fx(i) * step;
		  return result;
		 }
	
	
	
	
	
	/*
	 * 用来测试的main方法
	 */
	public static void main(String[] args){
		System.out.println(Normal_Distribution(1.97));
	}
	
	
}
