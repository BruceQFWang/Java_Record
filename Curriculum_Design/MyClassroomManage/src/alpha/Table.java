package alpha;

import java.sql.*;
import java.util.Vector;  

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

public class Table extends AbstractTableModel{
	public static Vector rowData;  
	public static Vector columnNames;  
	public Table() {    
	}
	public Table(String value) {   
		select(value);    
	}
	public Table(Vector rowData,Vector columnNames) {   
		this.rowData=rowData;    
		this.columnNames=columnNames;   
	}
	
	public static Vector getdata(String value, String sqlselect){
		rowData = new Vector();
		if(value=="�û���Ϣ"){
			try{ 
				Class.forName("com.mysql.jdbc.Driver");
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom?"
						+ "useUnicode=true&characterEncoding=utf-8&useSSL=false","root","cyber");
				Statement st = connect.createStatement();
				ResultSet rs = st.executeQuery(sqlselect);
				while(rs.next())
				{
					Vector tem=new Vector();
					tem.add(rs.getInt(1));
					tem.add(rs.getString(2));      
					tem.add(rs.getString(3));      
					tem.add(rs.getString(4));      
					tem.add(rs.getString(5)); 
					 rowData.add(tem);					
				}
				rs.close();   st.close();  connect.close();
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			} 
			catch (ClassNotFoundException e1) 
			{
				e1.printStackTrace();
			} 
		}
		else if(value=="������Ϣ"){
			try{ 
				Class.forName("com.mysql.jdbc.Driver");
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom?"
						+ "useUnicode=true&characterEncoding=utf-8&useSSL=false","root","cyber");
				Statement st = connect.createStatement();
				ResultSet rs = st.executeQuery(sqlselect);
				while(rs.next())
				{
					Vector tem=new Vector();
					tem.add(rs.getInt(1));
					tem.add(rs.getString(2));      
					tem.add(rs.getString(3));      
					tem.add(rs.getString(4));      
					tem.add(rs.getString(5)); 
					tem.add(rs.getString(6)); 
					 rowData.add(tem);					
				}
				rs.close();   st.close();  connect.close();
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			} 
			catch (ClassNotFoundException e1) 
			{
				e1.printStackTrace();
			} 
		}
		
		return rowData;
	}
	
	//
	public static Vector select(String value)  {   
		rowData = new Vector();   
		columnNames = new Vector(); 
		columnNames.clear();
		String sqlselect = null;   
		if(value=="�û���Ϣ")   {    
			columnNames.add("�û����");    
			columnNames.add("�û�����");    
			columnNames.add("�û�����");    
			columnNames.add("�û�����");  
			columnNames.add("�û��ֻ�");
			//columnNames.add("Ȩ��");
			sqlselect="select * from user";
		}
		else if(value == "������Ϣ"){    
			columnNames.add("��������");    
			columnNames.add("���ұ��");    
			columnNames.add("��ѧ¥");    
			columnNames.add("��������");
			columnNames.add("״̬");
			columnNames.add("ʹ����");
			sqlselect="select * from rooms";    
		}
		//System.out.println(columnNames);
		rowData = getdata(value, sqlselect);
		return rowData;
	}	
	@Override   
	
	public String getColumnName(int arg0) {   
		return (String) columnNames.get(arg0);   
	}  
	@Override   
	//��size
	public int getColumnCount() {   
		return columnNames.size();   
	}  
	@Override   
	//��size
	public int getRowCount() {   
		return rowData.size();   
	}    
	@Override   
	//�ڼ��еڼ���
	public Object getValueAt(int rowIndex, int columnIndex) {   
		return ((Vector)rowData.get(rowIndex)).get(columnIndex);   
	} 

}



