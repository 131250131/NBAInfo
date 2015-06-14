package ui.frame.player;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
  
public class BarChart {  
    ChartPanel frame1;  
    public  BarChart(){  
    	innitial();
    }  
    void innitial(){
    	String[] players={"詹姆斯","科比"};
    	String[] dataNames={"得分","助攻","盖帽","抢断","篮板"};
    	double[]  data1={40,40,50,20,10};
    	double[]  data2={40,50,30,50,10};
        CategoryDataset dataset = getDataSet(players,dataNames,data1,data2);  
        JFreeChart chart = ChartFactory.createBarChart3D(  
                             "球员能力对比", // 图表标题  
                            "数据", // 目录轴的显示标签  
                            "数据数值", // 数值轴的显示标签  
                            dataset, // 数据集  
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直  
                            true,           // 是否显示图例(对于简单的柱状图必须是false)  
                            false,          // 是否生成工具  
                            false           // 是否生成URL链接  
                            );  
          
        //从这里开始  
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象  
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表  
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题  
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题  
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状  
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));  
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));  
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
            
          //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题  
            
        frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame  
           
    }
    public void update(String[] players,String[] dataNames,double[] data1,double[] data2){
        CategoryDataset dataset = getDataSet(players,dataNames,data1,data2);  
        JFreeChart chart = ChartFactory.createBarChart3D(  
                             "球员能力对比", // 图表标题  
                            "数据", // 目录轴的显示标签  
                            "数据数值", // 数值轴的显示标签  
                            dataset, // 数据集  
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直  
                            true,           // 是否显示图例(对于简单的柱状图必须是false)  
                            false,          // 是否生成工具  
                            false           // 是否生成URL链接  
                            );  
          
        //从这里开始  
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象  
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表  
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题  
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题  
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状  
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));  
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));  
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
            
          //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题  
            
        frame1.setChart(chart);      
           
    }
    private static CategoryDataset getDataSet(String[] players,String[] dataNames,double[] data1,double[] data2) {  
       DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
       int size=dataNames.length;
       for(int i=0;i<size;i++){
    	   dataset.addValue(data1[i],players[0],dataNames[i]); 
       }
       for(int i=0;i<size;i++){
    	   dataset.addValue(data2[i],players[1],dataNames[i]); 
       }
       return dataset;  
   	}  
	public ChartPanel getChartPanel(){  
	    return frame1;  
	      
	}  
	public static void main(String args[]){  
	    JFrame frame=new JFrame("Java数据统计图");  
		frame.setLayout(new GridLayout(2,2,10,10));  
		frame.add(new BarChart().getChartPanel());           //添加柱形图  
//	    frame.add(new BarChart1().getChartPanel());          //添加柱形图的另一种效果  
//	    frame.add(new PieChart().getChartPanel());           //添加饼状图  
	//    frame.add(new TimeSeriesChart().getChartPanel());    //添加折线图  
	    frame.setBounds(50, 50, 800, 600);  
	    frame.setVisible(true);  
	}  
}  