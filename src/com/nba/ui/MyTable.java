package com.nba.ui;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class MyTable extends JScrollPane{
	
	private static final long serialVersionUID = 1L;

	JSortTable table;
	DefaultTableModel model;
	String[] columnNames;//表头
	int upLimit=0;
	int downLimit;
	int leftLimit=0;
	int rightLimit;
	
	
//	TableColumn tableColumn;//用于编辑每一列的颜色
	DefaultTableCellRenderer render1;//表格渲染器
//	DefaultTableCellRenderer backGroundColor ;//单元格颜色渲染
	/*以数据为参数构造表格*/
	public MyTable(String[] columnNames,Object[][] content){
		initial(columnNames,content);//初始化
	}
	/*空表格构造*/
	public MyTable(){
		
		String[] temp={"未命名1","未命名2","未命名3"};
		Object[][] data =
			{
			{"Apples", new Integer(5),"5.00"},
			         {"Oranges", new Integer(3),"6.00"},
			         {"Pears", new Integer(2),"4.00"},
			         {"Grapes", new Integer(3),"2.00"},
			         {"Grapes", new Integer(3),"2.00"},
			         {"Grapes", new Integer(3),"2.00"},
			         {"Grapes", new Integer(3),"2.00"},
			         {"Grapes", new Integer(3),"2.00"},
			         {"Grapes", new Integer(3),"2.00"},
			         {"Grapes", new Integer(3),"2.00"},
			         {"Grapes", new Integer(3),"2.00"},
			         {"Grapes", new Integer(3),"2.00"},
			         {"Grapes", new Integer(3),"2.00"}
			};

		initial(temp,data);//初始化
	}
	
	void initial(String[] columnNames,Object[][] content){//表格header和二维数组内容，object数组可以装载所有对象，包括基本类型
		this.columnNames=columnNames;
		this.downLimit=content.length-1;
		this.rightLimit=columnNames.length-1;
		//滚动板的初始化
		this.setOpaque(false);//设置透明
		this.getViewport().setOpaque(false);//设置透明
		this.setBorder(null);//无边框
		//设置右上角颜色
	    JLabel jb = new JLabel();
        jb.setBackground(new Color(0.1f, 0.19f, 0.54f));
        jb.setOpaque(true);
        this.setCorner(JScrollPane.UPPER_RIGHT_CORNER, jb);
	    //设置滚动条外观
//        this.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        
        
		//用参数初始化model
		model = new DefaultTableModel(content, columnNames);
		table = new JSortTable(model);
		
		
		//表格的初始化 一些美化
		table.setOpaque(false);
		table.setSelectionForeground(Color.black);//选中字体颜色
		table.setSelectionBackground(Color.yellow);
		table.setBackground(Color.BLACK);
		table.getTableHeader().setReorderingAllowed(false);//列不可移动
		
		render1= new DefaultTableCellRenderer();   
//        render1.setOpaque(false); //将渲染器设置为透明  
        render1.setHorizontalAlignment(JLabel.CENTER);//居中
        table.setDefaultRenderer(Object.class,render1);  
        
        table.setForeground(Color.white);
        table.setBorder(null);
		table.setFont(new Font("Arail", Font.PLAIN, 14));//字体
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//固定大小
		
		//表头
		JTableHeader head = table.getTableHeader();
		head.setBackground(new Color(0.1f, 0.19f, 0.54f));
		head.setForeground(Color.WHITE);
		head.setResizingAllowed(false);
		
 
//        //DefaultTableCellRenderer类可以绘制单元格的背景、字体颜色等功能   
//        backGroundColor= new DefaultTableCellRenderer();   
//        //绘制部门列的背景为黄色   
//        backGroundColor.setBackground(Color.yellow);   

        //将表格装载到滚动板上
        this.setViewportView(table);
        
	}
	/*设置表格及滚动面板位置*/
	public void mySetBounds(int x,int y,int width,int height){
		this.setBounds(x, y, width, height);
		this.table.setBounds(x, y, width, height);
	}
	/*更新表格数据*/
	public void update(String[] columnNames,Object[][] content){
		model.setDataVector(content, columnNames);
		table.updateUI();
	}
	/*检查越界并规范*/
	int avoidOverBoundary(int selectRow){
		int result=selectRow;
		if(selectRow<upLimit){
			selectRow=upLimit;
		}
		else if(selectRow<leftLimit){
			selectRow=leftLimit;
		}
		else if(selectRow>downLimit){
			selectRow=downLimit;
		}
		else if(selectRow>rightLimit){
			selectRow=rightLimit;
		}
		return result;
	}
	/*选中行向上移动*/
	public void upMove(){
		int selectRow=table.getSelectedRow();
		int nextRow=avoidOverBoundary(selectRow-1);
//		table.setRowSelectionInterval(nextRow,nextRow);
	}
	/*选中行向下移动*/
	public void downMove(){
		int selectRow=table.getSelectedRow();
		int nextRow=avoidOverBoundary(selectRow+1);
//		table.setRowSelectionInterval(nextRow,nextRow);
	}
	/*选中行向左移动*/
	public void leftMove(){
		int selectColumn=table.getSelectedColumn();
		int nextColumn=avoidOverBoundary(selectColumn-1);
//		table.setColumnSelectionInterval(nextColumn, nextColumn);
		//TableColumn主要作用可以对表格中的某一列的属性进行编辑   
//		TableColumn tableColumn = table.getColumn(columnNames[nextColumn]);
//        tableColumn.setCellRenderer(backGroundColor);  
		
	}
	/*选中行向右移动*/
	public void rightMove(){
		int selectColumn=table.getSelectedColumn();
		int nextColumn=avoidOverBoundary(selectColumn+1);
//		table.setColumnSelectionInterval(nextColumn, nextColumn);
		//TableColumn主要作用可以对表格中的某一列的属性进行编辑   
//		TableColumn tableColumn = table.getColumn(columnNames[nextColumn]);
//        tableColumn.setCellRenderer(backGroundColor);  
	}
	/*滚动条外观重写*/
	class CustomScrollBarUI extends BasicScrollBarUI{
		
		protected void configureScrollBarColors(){
			
		}
		protected JButton createDecreaseButton(int orientation){
			return decrButton;
			
		}
		protected JButton createIncreaseButton(int orientation){
			return decrButton;
			
		}
	}
	/*test*/
	public static void main(String[] args){
		JFrame testF=new JFrame();
		
		// 取得屏幕的宽度
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		// 取得屏幕的高度
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		//设置窗口大小
		testF.setSize(960, 600);
		//设置无边框
		testF.setUndecorated(true);
		// 设置窗体出现位置
		testF.setLocation((width - 960) / 2, (height - 600) / 2);
		// 将窗体的关闭方式设置为默认关闭后程序结束
		testF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置布局
		testF.setLayout(null);
		
		JPanel testJP=new JPanel();
		testJP.setLayout(null);
		testJP.setSize(960, 600);
		testJP.setBackground(Color.black);
		
		final MyTable testT=new MyTable();
		testT.setBounds(0, 0, 960, 200);
		
		
		testJP.add(testT);
		testF.add(testJP);
		
		//全局键盘监控
//		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
//		    public void eventDispatched(AWTEvent event) {
//		        if (((KeyEvent) event).getID() == KeyEvent.KEY_PRESSED) {
//		            //放入自己的键盘监听事件
//		        	if(((KeyEvent) event).getKeyCode()==KeyEvent.VK_UP){
//		    			testT.upMove();
//		    		}
//		    		else if(((KeyEvent) event).getKeyCode()==KeyEvent.VK_DOWN){
//		    			testT.downMove();
//		    		}
//		    		else if(((KeyEvent) event).getKeyCode()==KeyEvent.VK_LEFT){
//		    			testT.leftMove();
//		    		}
//		    		else if(((KeyEvent) event).getKeyCode()==KeyEvent.VK_RIGHT){
//		    			testT.rightMove();
//		    		}
//		        }
//		    }
//		}, AWTEvent.KEY_EVENT_MASK);

//		//给窗口加键盘监听
//		testT.addKeyListener(new KeyAdapter(){
//	    	public void keyPressed(KeyEvent e){    		
//	    		
//	      }
//	    });
		testF.setVisible(true);
	}
}