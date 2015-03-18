package com.nba.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class MyTable extends JScrollPane{
	
	private static final long serialVersionUID = 1L;

	JSortTable table;
	DefaultTableModel model;
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
			};

		initial(temp,data);//初始化
	}
	
	void initial(String[] columnNames,Object[][] content){//表格header和二维数组内容，object数组可以装载所有对象，包括基本类型
		//滚动板的初始化
		this.setOpaque(false);//设置透明
		this.getViewport().setOpaque(false);//设置透明
		this.setBorder(null);//无边框
		
		//用参数初始化model
		model = new DefaultTableModel(content, columnNames);
		table = new JSortTable(model);
		
		
		//表格的初始化 一些美化
		table.setFont(new Font("Arail", Font.PLAIN, 14));
		table.setBackground(new Color(40, 42, 66));
		table.setForeground(Color.WHITE);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		
		JTableHeader head = table.getTableHeader();
		head.setBackground(new Color(0.1f, 0.19f, 0.54f));
		head.setForeground(Color.WHITE);
		head.setResizingAllowed(false);
		
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
}
