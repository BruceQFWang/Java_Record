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
		if(value=="用户信息"){
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
		else if(value=="教室信息"){
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
		if(value=="用户信息")   {    
			columnNames.add("用户编号");    
			columnNames.add("用户姓名");    
			columnNames.add("用户密码");    
			columnNames.add("用户邮箱");  
			columnNames.add("用户手机");
			//columnNames.add("权限");
			sqlselect="select * from user";
		}
		else if(value == "教室信息"){    
			columnNames.add("教室序列");    
			columnNames.add("教室编号");    
			columnNames.add("教学楼");    
			columnNames.add("教室容量");
			columnNames.add("状态");
			columnNames.add("使用人");
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
	//列size
	public int getColumnCount() {   
		return columnNames.size();   
	}  
	@Override   
	//行size
	public int getRowCount() {   
		return rowData.size();   
	}    
	@Override   
	//第几行第几列
	public Object getValueAt(int rowIndex, int columnIndex) {   
		return ((Vector)rowData.get(rowIndex)).get(columnIndex);   
	} 

}



