package ui.frame.player;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
  
public class PieChart {  
    ChartPanel frame1;  
    public PieChart(){  
    	initialize();
    }  
    void initialize(){
    	 DefaultPieDataset data = getDataSet("篮板数",20,50);  
         JFreeChart chart = ChartFactory.createPieChart3D("球员贡献率",data,true,false,false);  
         //设置百分比  
         PiePlot pieplot = (PiePlot) chart.getPlot();  
         DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题  
         NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象  
         StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象  
         pieplot.setLabelGenerator(sp1);//设置饼图显示百分比  
       
         //没有数据的时候显示的内容  
         pieplot.setNoDataMessage("无数据显示");  
         pieplot.setCircular(false);  
         pieplot.setLabelGap(0.02D);  
       
         pieplot.setIgnoreNullValues(true);//设置不显示空值  
         pieplot.setIgnoreZeroValues(true);//设置不显示负值  
         chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
         PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象  
         piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码  
         chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));  
         frame1=new ChartPanel (chart,true);  
    }
    public void update(String dataType,double dataOfPlayer,double total){
    	 DefaultPieDataset data = getDataSet(dataType,dataOfPlayer,total);  
         JFreeChart chart = ChartFactory.createPieChart3D("球员"+dataType+"贡献率",data,true,false,false);  
         //设置百分比  
         PiePlot pieplot = (PiePlot) chart.getPlot();  
         DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题  
         NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象  
         StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象  
         pieplot.setLabelGenerator(sp1);//设置饼图显示百分比  
       
         //没有数据的时候显示的内容  
         pieplot.setNoDataMessage("无数据显示");  
         pieplot.setCircular(false);  
         pieplot.setLabelGap(0.02D);  
       
         pieplot.setIgnoreNullValues(true);//设置不显示空值  
         pieplot.setIgnoreZeroValues(true);//设置不显示负值  
         chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
         PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象  
         piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码  
         chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));  
         frame1.setChart(chart);  
    }
    private static DefaultPieDataset getDataSet(String dataType,double dataOfPlayer,double total) {  
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("该球员",dataOfPlayer);  
        dataset.setValue("其他球员",total-dataOfPlayer);  
        return dataset;  
    }
    public ChartPanel getChartPanel(){  
        return frame1;  
          
    }  
    class MouseListenerOfUpdate implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			//test update
			PieChart.this.update("sdfsdf", 90, 900);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
   	  
     }
}  