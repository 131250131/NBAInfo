package ui.frame.player;
  
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
  
public class TimeSeriesChart {  
    private ChartPanel frame1;  
    public TimeSeriesChart(){  
    	innitial();
    }   
    public void innitial(){
    	 XYDataset xydataset = createDataset();  
         JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("球员个人能力演变折线图(示例)", "赛季", "数据值",xydataset, true, true, true);  
         XYPlot xyplot = (XYPlot) jfreechart.getPlot();  
         DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();  
         dateaxis.setDateFormatOverride(new SimpleDateFormat("yyyy")); 
         jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));  
         jfreechart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
         dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题  
         dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题  
         ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状  
         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));  
         frame1=new ChartPanel(null);  
         frame1.setChart(jfreechart);
    }
    public void update(String dataType,int[] years1,double[] data1,int[] years2,double[] data2){
    	 XYDataset xydataset = createDatasetForNBA(dataType,years1,data1,years2,data2);  
         JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("球员个人能力演变折线图", "赛季", dataType,xydataset, true, true, true);  
         XYPlot xyplot = (XYPlot) jfreechart.getPlot();  
         DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();  
         dateaxis.setDateFormatOverride(new SimpleDateFormat("yyyy"));  
         jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));  
         jfreechart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
         dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题  
         dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题  
         ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状  
         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));  
    	 frame1.setChart(jfreechart);
//    	 frame1.updateUI();
    }
    private static XYDataset createDatasetForNBA(String dataType,int[] years1,double[] data1,int[] year2,double[] data2){
    	TimeSeries timeseries = new TimeSeries("常规赛", org.jfree.data.time.Year.class); 
    	TimeSeries timeseries2 = new TimeSeries("季后赛", org.jfree.data.time.Year.class);
    	TimeSeriesCollection timeseriescollection = new TimeSeriesCollection(); 
    	if(years1.length==1){
    		timeseries.addOrUpdate(new Year(years1[0]),data1[0]);
    		timeseries.addOrUpdate(new Year(years1[0]+1),data1[0]);
    	}
    	else{
    		for(int i=0;i<years1.length;i++){
        		timeseries.addOrUpdate(new Year(years1[i]),data1[i]);
        	}
    	}
    	if(year2.length==1){
    		timeseries2.addOrUpdate(new Year(year2[0]),data2[0]);
    		timeseries2.addOrUpdate(new Year(year2[0]+1),data2[0]);
    	}
    	else{
    		for(int i=0;i<year2.length;i++){
        		timeseries2.addOrUpdate(new Year(year2[i]),data2[i]);
        	}
    	}
    	
    	timeseriescollection.addSeries(timeseries); 
        timeseriescollection.addSeries(timeseries2);  
    	return timeseriescollection;
    	
    }
     private static XYDataset createDataset() {  //这个数据集有点多，但都不难理解  
            TimeSeries timeseries = new TimeSeries("得分",  
                    org.jfree.data.time.Year.class);  
            timeseries.add(new Year(2001), 181.80000000000001D);  
            timeseries.add(new Year(2002), 167.30000000000001D);  
            timeseries.add(new Year(2003), 153.80000000000001D);  
            timeseries.add(new Year(2004), 167.59999999999999D);  
            timeseries.add(new Year(2005), 158.80000000000001D);  
            timeseries.add(new Year(2006), 148.30000000000001D);  
            timeseries.add(new Year(2007), 153.90000000000001D);  
            timeseries.add(new Year(2008), 142.69999999999999D);  
            timeseries.add(new Year(2009), 123.2D);  
            timeseries.add(new Year(2010), 131.80000000000001D);  
            timeseries.add(new Year(2011), 139.59999999999999D);  
//            timeseries.add(new Month(1, 2002), 142.90000000000001D);  
//            timeseries.add(new Month(2, 2002), 138.69999999999999D);  
//            timeseries.add(new Month(3, 2002), 137.30000000000001D);  
//            timeseries.add(new Month(4, 2002), 143.90000000000001D);  
//            timeseries.add(new Month(5, 2002), 139.80000000000001D);  
//            timeseries.add(new Month(6, 2002), 137D);  
//            timeseries.add(new Month(7, 2002), 132.80000000000001D);  
            TimeSeries timeseries1 = new TimeSeries("篮板",  
                    org.jfree.data.time.Year.class);  
            timeseries1.add(new Year(2001), 129.59999999999999D);  
            timeseries1.add(new Year(2002), 123.2D);  
            timeseries1.add(new Year(2003), 117.2D);  
            timeseries1.add(new Year(2004), 124.09999999999999D);  
            timeseries1.add(new Year(2005), 122.59999999999999D);  
            timeseries1.add(new Year(2006), 119.2D);  
            timeseries1.add(new Year(2007), 116.5D);  
            timeseries1.add(new Year(2008), 112.7D);  
            timeseries1.add(new Year(2009), 101.5D);  
            timeseries1.add(new Year(2010), 106.09999999999999D);  
            timeseries1.add(new Year(2011), 110.3D);  
//            timeseries1.add(new Month(1, 2002), 111.7D);  
//            timeseries1.add(new Month(2, 2002), 111D);  
//            timeseries1.add(new Month(3, 2002), 109.59999999999999D);  
//            timeseries1.add(new Month(4, 2002), 113.2D);  
//            timeseries1.add(new Month(5, 2002), 111.59999999999999D);  
//            timeseries1.add(new Month(6, 2002), 108.8D);  
//            timeseries1.add(new Month(7, 2002), 101.59999999999999D);  
            TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();  
            timeseriescollection.addSeries(timeseries);  
            timeseriescollection.addSeries(timeseries1);  
            return timeseriescollection;  
        }  
      public ChartPanel getChartPanel(){  
            return frame1;  
              
        }
 
      public static void main(String[] args) {  
  	    JFrame frame=new JFrame("Java数据统计图");  
  	    frame.setLayout(null);  
//  	    frame.add(new BarChart().getChartPanel());           //添加柱形图  
//  	    frame.add(new BarChart1().getChartPanel());          //添加柱形图的另一种效果  
//  	    frame.add(new PieChart().getChartPanel());           //添加饼状图
  	    PieChart chartest=new PieChart();
  	    ChartPanel test=chartest.getChartPanel();
  	  	test.setBounds(0, 100, 800, 300);
  	    frame.add(test);    //添加折线图  
  	    frame.addMouseListener(chartest.new MouseListenerOfUpdate());
  	    frame.setBounds(50, 50, 800, 600);  
  	    frame.setVisible(true);  
  	}  
}  

