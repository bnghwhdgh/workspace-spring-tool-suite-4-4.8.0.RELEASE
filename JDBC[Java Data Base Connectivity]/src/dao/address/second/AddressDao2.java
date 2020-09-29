package dao.address.second;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressDao2 {

	
	String driverClass="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
	String user="javapython6";
	String password="javapython6";
	
	public void create(String id, String name, String phone, String address) throws Exception{
		String insertSql = "insert into address values(address_no_seq.nextval,?,?,?,?)";
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt=con.prepareStatement(insertSql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	public void update(String id, String name, String phone, String address, int no) throws Exception{
		
		String updateSql = "update address set id=?, name=?, phone=?, address=? where no=?";
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt=con.prepareStatement(updateSql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.setInt(5, no);
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
		
	}
	
	public void delete(int no) throws Exception{
		String deleteSql = "delete address where no=?";
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt=con.prepareStatement(deleteSql);
		
		pstmt.setInt(1, no);
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
		
		
	}
	
	public void selectByNo(int no) throws Exception{
		String selectSql="select no,id,name,phone,address from address where no=?";
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt=con.prepareStatement(selectSql);
		
		pstmt.setInt(1, no);
		ResultSet rs =pstmt.executeQuery();
		while(rs.next()) {
			
			String id = rs.getString("id");
			String name =rs.getString("name");
			String phone =rs.getString("phone");
			String address =rs.getString("address");
			System.out.println(no+"\t"+id+"\t"+name+"\t"+phone+"\t"+address);
		}
		rs.close();
		pstmt.close();
		con.close();
	}
	
	public void selectAll() throws Exception{
		String selectSql="select no,id,name,phone,address from address";
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt=con.prepareStatement(selectSql);
		
		
		ResultSet rs =pstmt.executeQuery();
		while(rs.next()) {
			int no =rs.getInt("no");
			String id = rs.getString("id");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no+"\t"+id+"\t"+name+"\t"+phone+"\t"+address);
		}
		rs.close();
		pstmt.close();
		con.close();
	}
}
