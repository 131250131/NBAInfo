package com.nba.ui;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JScrollPane{
	
	private static final long serialVersionUID = 1L;

	JTable table;
	DefaultTableModel model;
	/*以数据为参数构造表格*/
	public MyTable(String[] columnNames,Object[][] content){
		//TableSorter sorter = new TableSorter(new MyTableModel()); //ADDED THIS
		//JTable table = new JTable(sorter); //NEW
		//sorter.setTableHeader(table.getTableHeader()); //ADDED THIS
		initial(columnNames,content);//初始化
	}
	/*空表格构造*/
	public MyTable(){
		String[] temp={"未命名1","未命名2","未命名3"};
		initial(temp,new Object[][]{});//初始化
	}
	
	void initial(String[] columnNames,Object[][] content){//表格header和二维数组内容，object数组可以装载所有对象，包括基本类型
		//滚动板的初始化
		this.setOpaque(false);//设置透明
		this.getViewport().setOpaque(false);//设置透明
		this.setBorder(null);//无边框
		
		//用参数初始化model
		model = new DefaultTableModel(content, columnNames);
		table=new JTable(model);
		//表格的初始化 一些美化
		table.setOpaque(false);
		table.setSelectionForeground(Color.white);
        DefaultTableCellRenderer render1 = new DefaultTableCellRenderer();   
        render1.setOpaque(false); //将渲染器设置为透明  
        table.setDefaultRenderer(Object.class,render1);  
        table.setForeground(Color.white);
        table.setBorder(null);
        table.setShowVerticalLines(false);
        //将表格装载到滚动板上
        this.setViewportView(table);
        
	}
	/*设置表格及滚动面板位置*/
	public void setBounds(int x,int y,int width,int height){
		this.setBounds(x, y, width, height);
		table.setBounds(x, y, width, height);
	}
	/*更新表格数据*/
	public void update(String[] columnNames,Object[][] content){
		model.setDataVector(content, columnNames);
		table.updateUI();
	}
}
