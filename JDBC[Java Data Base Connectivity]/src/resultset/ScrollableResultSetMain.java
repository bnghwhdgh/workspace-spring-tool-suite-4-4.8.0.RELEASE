package resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.common.ConnectionFactory;

public class ScrollableResultSetMain {

	public static void main(String[] args) throws Exception{
		String selectSql="select * from emp order by empno asc";
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt = 
				con.prepareStatement(selectSql,
						ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=pstmt.executeQuery();
		/*
		 * Cursor를 자유롭게움직일수있는 ResultSet생성
		 */
		System.out.println("-----------rs.next()-----------");
		while(rs.next()) {
			System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		}
		System.out.println("-----------rs.previous()-----------");
		while(rs.previous()) {
			System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		}
		System.out.println("-----------rs.first()-----------");
		rs.first();
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		System.out.println("-----------rs.last()-----------");
		rs.last();
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		int rowNo=rs.getRow();
		System.out.println("rowNo:"+rowNo);
		
		System.out.println("-----------rs.beforeFirst()-----------");
		rs.beforeFirst();
		// 결과 집합을 모두 소모했음
		rs.next();
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		System.out.println("-----------rs.beforeFirst()-----------");
		rs.afterLast();
		rs.previous();
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		rs.beforeFirst();
		if(rs.isBeforeFirst() || rs.isAfterLast()) {
			System.out.println("rs cursor 가 BeforeFirst or AfterLast에 위치해있네요!!");
		}
		
		System.out.println("-------------rs.absolute(row번호)---------");
		rs.absolute(10);
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		System.out.println("-------------rs.realtive(2)---------");
		rs.relative(2);
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		rs.relative(-2);
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		
		rs.close();
		
		
		
		
		
		
		
		
		
		
	}

}









