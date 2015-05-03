package ui.system;

public class DataTransform {
	
	public static double transDoubleTopointXX(double num){
		return Double.parseDouble(String.format("%.2f", num));
	}
	
	public static String transDoubleTopointXXString(double num){
		return String.format("%.2f", num);
	}

}
