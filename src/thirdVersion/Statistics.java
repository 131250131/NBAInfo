package thirdVersion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Utibility.DataType;

//这是一个统计类，用来完成迭代三的统计部分的
public class Statistics {
	
	public double forcastData(String pID, DataType dtp){
		double result =0.0;
		ArrayList<Double> playerData = this.getDataList(pID, dtp);
		MathCalculator calculator = new MathCalculator();
		double aver = calculator.getAverage(playerData);
		double var = calculator.getVariance(playerData);
		//这边调用方法获得我的预测信息
		//这个预测有多准？
		//这个公式该怎么写
		//妈蛋我还真是不知道
		
		return result;
	}
	
	public double getForcastPercent(double forcast , DataType dtp){
		double result =0;
		//这边调用一个函数来获得可信度
		
		
		return result;
	}
	
	public ArrayList<Double> getDataList(String pID, DataType dtp){
		ArrayList<Double> result =  new ArrayList<Double>();
		String datatype = new String();
		switch(dtp){
			case Atime:datatype = "Atime" ;break;
			case FGP:datatype = "FGP" ;break;
			case AFGZ: datatype = "AFGZ" ;break;
			case AFG:datatype = "AFG" ;break;
			case SFGP:datatype = "SFGP"  ;break;
			case ASFGZ:datatype = "ASFGZ" ;break;
			case ASFG: datatype = "ASFG" ;break;
			case FTGP:datatype = "FTGP" ;break;
			case AFTGZ:datatype = "AFTGZ" ;break;
			case AFTG: datatype = "AFTG" ;break;
			case ARebounds:datatype = "ARebounds" ;break;
			case AORebounds: datatype = "AORebouns" ;break;
			case ADRebounds:datatype = "ADRebounds" ;break;
			case AAssists: datatype = "AAssists" ;break;
			case ASteals:datatype = "ASteals" ;break;
			case ABlocks: datatype = "ABlocks" ;break;
			case ATurnovers:datatype = "ATurnovers" ;break;
			case AFouls:datatype = "AFouls"  ;break;
			case AScores:datatype = "AScores" ;break;
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/nbadata?characterEncoding=utf-8", "root", "");
			String sql =  new String();
				sql = "SELECT "+"'"+datatype+"' FROM playerdatainfo WHERE id="+"'"+pID+"'";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				double temp = 0.0;
				while(rs.next()){
					temp=rs.getDouble(1);
					result.add(temp);
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	} 
	
	
	
}
