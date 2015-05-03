package ui.system;

public class DataTransform {
	
	public static double transDoubleTopointXX(double num){
		return Double.parseDouble(String.format("%.2f", num));
	}
	
	public static String transDoubleTopointXXString(double num){
		return String.format("%.2f", num);
	}
	
	public static String getNBAEYEScore(double num){
		double returnValue = 60;
		returnValue = returnValue + num / 2 * 3;
		
		if(returnValue > 80){
			returnValue = 80 + (returnValue - 80) * 0.8;
		}
		
		if(returnValue > 90){
			returnValue = 90 + (returnValue - 90) * 0.8;
		}
		
		if(returnValue >= 100){
			returnValue = 99;
		}
		return String.format("%.1f", returnValue);
	}

}
