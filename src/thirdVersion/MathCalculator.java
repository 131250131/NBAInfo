package thirdVersion;

import java.util.ArrayList;

//这个类用来计算各种数据;
public class MathCalculator {
	/*
	 * 计算样本的平均数，可以作为总体期望的无偏估计
	 */
	public static double getAverage(ArrayList<Double> tempList){
		try{
		   int n=tempList.size();
		   double total=0;
		   for(Double d:tempList){
			   total+=d;
		   }
		   return total/(double)n;
		}catch(Exception e){
			return 0.0;
		}
	}
	
	/*
	 * 计算样本的方差(由此可以得到标准差，这边除的就是n-1)
	 */
	public static double getVariance(ArrayList<Double> tempList){
		   try{
		   int n=tempList.size();
		   double average=getAverage(tempList);
		   double chahe=0;
		   for(Double d:tempList){
			   chahe+=Math.pow(d-average, 2);
		   }
		   return chahe/(double)n;
		   }catch(Exception e){
			   return 0.0;
		   }
	}
	
	
	/*
	 * 模拟标准正态分布,实现效率并不高,并且有些许误差，但应该可以应付这个程序,调用这个函数前最好先截取小数部分
	 * 通过一个不断求矩形的和来实现积分
	 * 测过可以
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
	 * 模拟得到正态分布的上分位数,测过可以
	 */
	static double NormDistributionQuantile(double p){
		double result=0;
		double[] b ={0.1570796288E1,   0.3706987906E-1,
	              -0.8364353589E-3, -0.2250947176E-3,
	                0.6841218299E-5,  0.5824238515E-5,
	              -0.1045274970E-5,  0.8360937017E-7,
	              -0.3231081277E-8,  0.3657763036E-10,
	                0.6936233982E-12};
		//b用于Toda近似公式的比较
	       if(p<0||p>1){
	    	   return Double.NaN;
	       }
	       else{
	    	   double alpha = 0;
	    	   if ((0 < p) && (p < 0.5)){
	    	     alpha = p;
	    	   }
	    	   else if ((0.5 < p) && (p < 1)){
	    	     alpha = 1 - p;
	    	   }
	    	   double y = -Math.log(4 * alpha * (1 - alpha));
	    	   double u = 0;
	    	   //下面采用Toda近似公式
	    	   for (int i = 0; i < b.length; i++)
	    	   {
	    	     u += b[i] * Math.pow(y, i);
	    	   }
	    	     u = Math.sqrt(y * u);
	    	     if ((0 < p) && (p < 0.5))
	    	       result = -u;
	    	     else if ((0.5 < p) && (p < 1))
	    	       result = u;
	    	     return -result;
	    	     
	       }
	}
	
	
	/*
	 * 用来测试的main方法
	 */
	public static void main(String[] args){
		System.out.println(NormDistributionQuantile(0.1814));
	}
	
	
}
