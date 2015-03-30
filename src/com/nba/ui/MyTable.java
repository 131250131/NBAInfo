package com.nba.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MyTable extends JScrollPane{
	
	Timer timer;
	
	private static final long serialVersionUID = 1L;

	JSortTable table;
	DefaultTableModel model;
	String[] columnNames;//表头
	int upLimit=0;
	int downLimit;
	int leftLimit=0;
	int rightLimit;
	
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == timer){
//				
//		 	if(table.getSelectedRowCount() == 1){
//		 		
//		 		int x = table.getSelectedRow();
//		 		int y = table.getSelectedColumn();
//		 		
//		 		System.out.println( x + ";" + y);
//		 		
//		 		table.addRowSelectionInterval(x, x);
//		 		table.addColumnSelectionInterval(y, y);  
//		 	}
//	 	}
//	 }
	
	public JTable getTable(){
		return table;
	}
	
	
//	TableColumn tableColumn;//用于编辑每一列的颜色
	DefaultTableCellRenderer render1;//表格渲染器
//	DefaultTableCellRenderer backGroundColor ;//单元格颜色渲染
	/*以数据为参数构造表格*/
	public MyTable(String[] columnNames,Object[][] content){
		initial(columnNames,content);//初始化
		
//		timer = new Timer(10, this);
//		timer.start();
			
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
		this.setOpaque(false);
	}
	
	@SuppressWarnings("serial")
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
        jb.setBackground(new Color(31,41,65));
        jb.setOpaque(true);
        this.setCorner(JScrollPane.UPPER_RIGHT_CORNER, jb);
	    //设置滚动条外观
     //   this.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        
        this.getVerticalScrollBar().setOpaque(false);
        //this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
        this.getHorizontalScrollBar().setOpaque(false);
        this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        
		//用参数初始化model
		model = new DefaultTableModel(content, columnNames);
		
		table = new JSortTable(model){
			public boolean isCellEditable(int row, int column){
                       return false;
                       }//表格不允许被编辑
            };
			
		
		
		//表格的初始化 一些美化
		table.setOpaque(false);
		table.setSelectionForeground(new Color(0, 0, 0, 0.999f));//选中字体颜色
		table.setSelectionBackground(new Color(1, 1, 1, 0.9f));
		//table.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
		table.getTableHeader().setReorderingAllowed(false);//列不可移动 
        
        table.setForeground(Color.white);
        table.setBorder(null);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 17));//字体
		
		
		//table.setColumnSelectionAllowed(true); 
		table.setRowSelectionAllowed(true);
		
		//table.setc
		
		//表头
		JTableHeader head = table.getTableHeader();
		head.setBackground(new Color(0.25f, 0.35f, 0.45f, 0.4f));
		head.setForeground(Color.WHITE);
		//head.setPreferredSize(new Dimension(20, 30));
		head.setResizingAllowed(false);
		//列宽
		setWidth();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//固定大小
		
		table.setShowGrid(false);

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
		setWidth();
		table.updateUI();
	}
	// 取得列幅的最大值
	public int getPreferredWidthForCloumn(JTable table,int icol){
	
	    TableColumnModel tcl = table.getColumnModel();
	    TableColumn col = tcl.getColumn(icol);
	    int c = col.getModelIndex(),width = 0,maxw = 0;
	
	    for(int r=0;r<table.getRowCount();++r){
	
	      TableCellRenderer renderer = table.getCellRenderer(r,c);
	      Component comp = renderer.getTableCellRendererComponent(table,table.getValueAt(r,c),false,false,r,c);
	      width = comp.getPreferredSize().width;
	      maxw = width > maxw?width:maxw;
	    }
	    return maxw;
	}
    public void setWidth(){
        for(int i= 0; i<table.getColumnCount(); i++){
            int with = this.getPreferredWidthForCloumn(table,i) + 10;
            with = 100 > with ? 100 : with;
            table.getColumnModel().getColumn(i).setPreferredWidth(with + 10);
          }
        table.setRowHeight(28);
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
//	public static void main(String[] args){
//		JFrame testF=new JFrame();
//		
//		// 取得屏幕的宽度
//		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
//		// 取得屏幕的高度
//		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
//		//设置窗口大小
//		testF.setSize(960, 600);
//		//设置无边框
//		testF.setUndecorated(true);
//		// 设置窗体出现位置
//		testF.setLocation((width - 960) / 2, (height - 600) / 2);
//		// 将窗体的关闭方式设置为默认关闭后程序结束
//		testF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//设置布局
//		testF.setLayout(null);
//		
//		JPanel testJP=new JPanel();
//		testJP.setLayout(null);
//		testJP.setSize(960, 600);
//		testJP.setBackground(Color.black);
//		
//		final MyTable testT=new MyTable();
//		testT.setBounds(0, 0, 960, 200);
//		
//		
//		testJP.add(testT);
//		testF.add(testJP);
//		
//		//全局键盘监控
////		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
////		    public void eventDispatched(AWTEvent event) {
////		        if (((KeyEvent) event).getID() == KeyEvent.KEY_PRESSED) {
////		            //放入自己的键盘监听事件
////		        	if(((KeyEvent) event).getKeyCode()==KeyEvent.VK_UP){
////		    			testT.upMove();
////		    		}
////		    		else if(((KeyEvent) event).getKeyCode()==KeyEvent.VK_DOWN){
////		    			testT.downMove();
////		    		}
////		    		else if(((KeyEvent) event).getKeyCode()==KeyEvent.VK_LEFT){
////		    			testT.leftMove();
////		    		}
////		    		else if(((KeyEvent) event).getKeyCode()==KeyEvent.VK_RIGHT){
////		    			testT.rightMove();
////		    		}
////		        }
////		    }
////		}, AWTEvent.KEY_EVENT_MASK);
//
////		//给窗口加键盘监听
////		testT.addKeyListener(new KeyAdapter(){
////	    	public void keyPressed(KeyEvent e){    		
////	    		
////	      }
////	    });
//		testF.setVisible(true);
//	}
	
	
	
}
