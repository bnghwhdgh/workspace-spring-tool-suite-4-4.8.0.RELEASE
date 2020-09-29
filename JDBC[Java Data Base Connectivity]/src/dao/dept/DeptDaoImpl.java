package dao.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.common.ConnectionFactory;

public class DeptDaoImpl implements DeptDao{

	@Override
	public void insert(Dept department) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DeptSQL.INSERT);
		
		pstmt.setInt(1, department.getDeptno());
		pstmt.setString(2, department.getDname());
		pstmt.setString(3, department.getLoc());
		
		pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
	}

	@Override
	public Dept selectByNo(int deptno) throws Exception {
		Dept sbn = null;
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DeptSQL.SELECTBYNO);
		
		pstmt.setInt(1, deptno);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			sbn = new Dept(rs.getInt("deptno"),
						   rs.getString("dname"),
						   rs.getNString("loc"));
		}
		
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return sbn;
	}

	@Override
	public ArrayList<Dept> selectByAll() throws Exception {
		ArrayList<Dept> sbns = new ArrayList<Dept>();
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DeptSQL.SELECTBYALL);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			sbns.add(new Dept(rs.getInt("deptno"),
						   rs.getString("dname"),
						   rs.getNString("loc")));
		}
		
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		
		return sbns;
	}

}
