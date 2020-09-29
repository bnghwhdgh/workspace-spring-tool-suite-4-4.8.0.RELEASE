package statement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Properties;

public class StatementMain {

	public static void main(String[] args) throws Exception {
		Properties dbProperties = new Properties();
		dbProperties.load(StatementMain.class.getResourceAsStream("../basic/db.properties"));
		//  ./db.properties" => 현재 디렉토리
		// ../db.properties" => 상위 디렉토리 (bin) =>basic폴더 가려면 ../basic/ 이런식으로 쓸 것
		
		String driverClass =dbProperties.getProperty("driverClass");
		String url = dbProperties.getProperty("url");
		String user = dbProperties.getProperty("user");
		String password = dbProperties.getProperty("password");
		String selectSql = "select * from emp";
		
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		/*
		 * ResultSet의 행의 수를 제한
		 */
		stmt.setMaxRows(5);
		ResultSet rs = stmt.executeQuery(selectSql);

		while(rs.next()) {
			System.out.println(
		rs.getInt("EMPNO")+"\t"
		+rs.getString("ENAME")+"\t"
		+rs.getString("JOB")+"\t"
		+rs.getDouble("SAL"));
		}
		rs.close();
		
		String selectsql2 = "select * from emp order by sal desc";
		ResultSet rs2 = stmt.executeQuery(selectsql2);
		System.out.println("-----------------------sal desc---------------------");
		while(rs2.next()) {
			System.out.println(
					rs2.getInt("EMPNO")+"\t"
					+rs2.getString("ENAME")+"\t"
					+rs2.getString("JOB")+"\t"
					+rs2.getDouble("SAL"));
		}
		rs2.close();
		
		String insertSql = "insert into emp "
				+ "values(9999,'JAMES','MANAGER',NULL,"
				+ "to_date('2020/05/20','yyyy/mm/dd'),6000,null,30)";
		String updateSql = "update emp set sal=6789.89 where empno > 7369 and empno < 7600";
		String deleteSql = "delete emp where empno = 8888";
		try {
		int insertRowCount=stmt.executeUpdate(insertSql);
		System.out.println(insertRowCount+"행 insert");
		}catch(SQLIntegrityConstraintViolationException e){
			System.out.println("이미 존재하는 사번");
			e.printStackTrace();
		}
		int updateRowCount=stmt.executeUpdate(updateSql);
		System.out.println(updateRowCount+"행 update");
		int deleteRowCount=stmt.executeUpdate(deleteSql);
		System.out.println(deleteRowCount+"행 delete");
		
		/*
		 * 행의 수 제한을 제거하는 작업
		 */
		stmt.setMaxRows(0);
		ResultSet rs3 =stmt.executeQuery(selectsql2);
		while(rs3.next()) {
			System.out.println(
					rs3.getInt("EMPNO")+"\t"
					+rs3.getString("ENAME")+"\t"
					+rs3.getString("JOB")+"\t"
					+rs3.getDouble("SAL"));
		}
		
		
		rs3.close();
		stmt.close();
		con.close();
	}

}
