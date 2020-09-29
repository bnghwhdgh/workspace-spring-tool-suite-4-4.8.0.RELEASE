package dao.address.third;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AddressDao3 {
	/************** DB접속정보 **************/
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@182.237.126.19:1521:XE";
	String user = "javapython6";
	String password = "javapython6";

	public int create(Address insertAddress) throws Exception {
		String insertSql ="insert into address values(address_no_seq.nextval,?,?,?,?)";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt=con.prepareStatement(insertSql);
		
		pstmt.setString(1, insertAddress.getId());
		pstmt.setString(2, insertAddress.getName());
		pstmt.setString(3, insertAddress.getPhone());
		pstmt.setString(4, insertAddress.getAddress());
		
		int insertRowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		
		return insertRowCount;
	
	}
	public int delete(int no) throws Exception {
		String deleteSql = "delete address where no=?";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt = con.prepareStatement(deleteSql);
		
		pstmt.setInt(1, no);
		int deleteRowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		
		return deleteRowCount;
	}
	public int update(Address updateAddress)  throws Exception{
		String updateSql = "update address set ?,?,?,? where no = ?";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt =con.prepareStatement(updateSql);
		
		pstmt.setString(1, updateAddress.getId());
		pstmt.setString(2, updateAddress.getName());
		pstmt.setString(3, updateAddress.getPhone());
		pstmt.setString(4, updateAddress.getAddress());
		pstmt.setInt(5, updateAddress.getNo());
		
		int updateRowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return updateRowCount;
	}

	public Address selectByNo(int fno) throws Exception {
		Address findAdd = null;
		String selectSql = "select * from address where no=?";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt =con.prepareStatement(selectSql);
		
		pstmt.setInt(1, fno);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			findAdd = new Address(
			rs.getInt("no"),
			rs.getString("id"),
			rs.getString("name"),
			rs.getString("phone"),
			rs.getString("address"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		return findAdd;
	}
	public ArrayList<Address> selectAll() throws Exception {
		ArrayList<Address> findAll = new ArrayList<Address>();
		String selectSql = "select * from address";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			findAll.add(new Address(rs.getInt("no"),
			rs.getString("id"),
			rs.getString("name"),
			rs.getString("phone"),
			rs.getString("address")));
		}
		rs.close();
		pstmt.close();
		con.close();
		return findAll;
	}
}
