package ui.myUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
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

import ui.system.UIData;

public class MyTable extends JScrollPane implements MouseListener{
	
	Timer timer;
	
	private static final long serialVersionUID = 1L;

	private JSortTable table;
	private DefaultTableModel model;
	private String[] columnNames;//表头
	private Object[][] content;//表格内容
	int upLimit=0;
	int downLimit;
	int leftLimit=0;
	int rightLimit;
	String[] addSerialNum(String[] columnNames){
		String[] newColumnNames=new String[columnNames.length+1];
		newColumnNames[0]="序号";
		for(int i=0;i<columnNames.length;i++){
			newColumnNames[i+1]=columnNames[i];
		}
		return newColumnNames;
	}
	Object[][] addSerialNum(Object[][] content){
		int len=content.length;
		Object[][] newContent =new Object[len][content[0].length+1];
		for(int i=0;i<len;i++){
			newContent[i][0]=i+1;
			for(int j=0;j<content[0].length;j++){
				newContent[i][j+1]=content[i][j];
			}
		}
		return newContent;
		
	}
	public JTable getTable(){
		return table;
	}
	
	
//	TableColumn tableColumn;//用于编辑每一列的颜色
	DefaultTableCellRenderer render1;//表格渲染器
//	DefaultTableCellRenderer backGroundColor ;//单元格颜色渲染
	/*以数据为参数构造表格*/
	public MyTable(String[] columnNames,Object[][] content){
		initial(columnNames,content);//初始化
		
			
	}
	/*空表格构造*/
	public MyTable(){
		String[] temp={"姓名","位置","分钟","%","命中","出手","三分%"
				,"三分命中","三分出手","罚球%","罚球命中","罚球出手","+/-","进攻"
				,"防守","篮板","助攻","犯规","抢断","失误","盖帽","得分"};
		Object[][] data =new Object[1][22];

		initial(temp,data);//初始化
		this.setOpaque(false);
	}
   /*获取当前选中行的标识*/
	public String getSign(int num){
		int selectRow=table.getSelectedRow();
		System.out.println("选中行————————————"+selectRow);
		if(selectRow==-1){
			return (String)this.model.getValueAt(0, num);
		}
		String result=(String)this.model.getValueAt(selectRow, num);
		return result;
		
	}
	/*获取任意单元格数据*/
	public String getCell(int x,int y){
		return (String)this.model.getValueAt(x, y);
		
	}
	/*获取表格类*/
	public JTable getJTable(){
		return table;
	}
	@SuppressWarnings("serial")
	void initial( String[] columnNames, Object[][] content){//表格header和二维数组内容，object数组可以装载所有对象，包括基本类型
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
       // this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        
		//用参数初始化model
        if(!columnNames[0].equals("序号")&&!columnNames[0].equals("场均得分")&&!columnNames[0].equals("位置")){//如果没有序号列，自动添加序号列
        	content=addSerialNum(content);
        	columnNames=addSerialNum(columnNames);
        }
		model = new DefaultTableModel(content, columnNames);
		this.columnNames=columnNames;
		this.content=content;
		
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
		table.setFont(new Font("Arail", Font.PLAIN, (int) (17 * UIData.changeY)));//字体
		

		//table.setColumnSelectionAllowed(true); 
		table.setRowSelectionAllowed(true);
		
		//table.setc
		
		//表头
		JTableHeader head = table.getTableHeader();
		head.setBackground(new Color(0.25f, 0.35f, 0.45f, 0.4f));
		head.setForeground(Color.WHITE);
		//head.setPreferredSize(new Dimension(20, 30));
		head.setResizingAllowed(false);
//		head.addMouseListener (new MouseListenerOfHeader());
		//列宽
		if(!columnNames[0].equals("位置")){
			setWidth();
		}
		
		if(!columnNames[0].equals("场均得分")&&!columnNames[0].equals("位置")){
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//固定大小
		}
		
		table.setShowGrid(false);

		
		table.addMouseListener(this);
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
	   if(!columnNames[0].equals("序号")&&!columnNames[0].equals("场均得分")&&!columnNames[0].equals("位置")){//如果没有序号列，自动添加序号列
        	content=addSerialNum(content);
        	columnNames=addSerialNum(columnNames);
        }
		model.setDataVector(content, columnNames);
		setWidth();
		this.columnNames=columnNames;
		this.content=content;
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





	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(columnNames[1].equals("球员ID")){
			System.out.println(getSign(2));
		}
		
		else{
			System.out.println(getSign(1));
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public String[] getColumnNames() {
		return columnNames;
	}
	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}
	public Object[][] getContent() {
		return content;
	}
	public void setContent(Object[][] content) {
		this.content = content;
	}
	
	
}
