package com.nba.ui;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

@SuppressWarnings("serial")
public class JSortTable extends JTable {
	
	
	public static void makeFace(JTable myTable) {

        try
        {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer()
            {
              public Component getTableCellRendererComponent(JTable table,
                  Object value, boolean isSelected, boolean hasFocus,
                  int row, int column)
              {
                if(row % 2 == 0)
                  setBackground(new Color(0.1f, 0.1f, 0.1f, 0.6f)); //设置奇数行底色
                else if(row % 2 == 1)
                  setBackground(new Color(0.5f, 0.5f, 0.5f, 0.6f));  //设置偶数行底色
                return super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column); }
            };
              
            tcr.setHorizontalAlignment(JLabel.CENTER);//居中
            myTable.setDefaultRenderer(Object.class,tcr); 
            
                for(int i = 0; i < myTable.getColumnCount(); i++) {
                	myTable.getColumn(myTable.getColumnName(i)).setCellRenderer(tcr);
          }
        }
        catch (Exception ex)
        {
          ex.printStackTrace();
        }
	}

    public JSortTable() {
        super();       
        new SortTableModelListener(this);
    }

    public JSortTable(TableModel dm, TableColumnModel cm) {
        super(dm, cm);
        new SortTableModelListener(this);
    }

    public JSortTable(int numRows, int numColumns) {
        super(numRows, numColumns);
        new SortTableModelListener(this);
    }

    public JSortTable(final Object[][] rowData, final Object[] columnNames) {
        super(rowData, columnNames);
        new SortTableModelListener(this);
    }

    public JSortTable(TableModel dm) {
        super(dm);
        new SortTableModelListener(this);
    }
}


class SortTableModelListener extends MouseAdapter implements TableModelListener {
    private JTable table = null;
    private boolean isASC = true;
    private int sortColumn = -1; // Which column is sorted...
   // private final Icon upIcon = new ImageIcon("data/ui/image/loading/up.png");
   // private final Icon downIcon = new ImageIcon("data/ui/image/loading/down.png");

    public SortTableModelListener(JTable table) {
        this.table = table;
        table.getModel().addTableModelListener(this);
        table.getTableHeader().addMouseListener(this);
        setHeadRenderer();
    }

    public void tableChanged(TableModelEvent e) {
        sort();
    }

    public void mouseClicked(MouseEvent e) {
        int column = table.columnAtPoint(e.getPoint());
        column = table.convertColumnIndexToModel(column);
        if (column == sortColumn) {
            isASC = !isASC;
        } else {
            sortColumn = column;
            isASC = true;
        }

        sort();
    }

    private void sort() {
        if (sortColumn == -1) return;

        int count = table.getRowCount();
        if (count == 0) return;
        System.out.println("sort...");
        Row rows[] = new Row[count];
        for (int row = 0; row < count; row++) {
            rows[row] = new Row(row, table.getValueAt(row, sortColumn));
        }

        Arrays.sort(rows);
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        Vector v = model.getDataVector();
        Vector data = new Vector();
        for (int row = 0; row < count; row++) {
            data.add(v.get(rows[row].getRowIndex()));
        }
        model.removeTableModelListener(this);
        v.clear();
        v.addAll(data);
        model.fireTableDataChanged();
        model.addTableModelListener(this);
    }


    private void setHeadRenderer() {
        DefaultTableCellRenderer renderer = new SortTableCellRenderer();
        renderer.setHorizontalAlignment(0);
        renderer.setHorizontalTextPosition(2);
        table.getTableHeader().setDefaultRenderer(renderer);
    }

    class SortTableCellRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (table != null) {
                JTableHeader jtableheader = table.getTableHeader();
                if (jtableheader != null) {
                    setForeground(jtableheader.getForeground());
                    setBackground(jtableheader.getBackground());
                    setFont(jtableheader.getFont());
                }
            }
            setText(value != null ? value.toString() : "");
            if (column == sortColumn) {
                //setIcon(isASC ? upIcon : downIcon);
            } else {
                setIcon(null);
            }

            setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            return this;
        }
    }

    class Row implements Comparable {
        private int rowIndex = -1;
        private Object object = null;

        Row(int index, Object object) {
            this.rowIndex = index;
            this.object = object;
        }

        public int getRowIndex() {
            return rowIndex;
        }

        public void setRowIndex(int rowIndex) {
            this.rowIndex = rowIndex;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        public int compareTo(Object o) {
            Row row = (Row) o;
            Object obj1 = object;
            Object obj2 = row.getObject();
            if (isASC) {
                if (!(obj1 instanceof Comparable)) {
                    return -1;
                }
                if (!(obj2 instanceof Comparable)) {
                    return 1;
                } else {
                    return ((Comparable) obj1).compareTo((Comparable) obj2);
                }
            }
            if (!(obj1 instanceof Comparable)) {
                return 1;
            }
            if (!(obj2 instanceof Comparable)) {
                return -1;
            } else {
                return ((Comparable) obj2).compareTo((Comparable) obj1);
            }

        }
    }

}



