package basic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class AddressInsertMain {

	public static void main(String[] args) throws Exception {
		
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javapython6";
		String password="javapython6";
		/*
		//설정파일로부터 db접속 정보 얻기
		Properties dbProperties = new Properties();
		dbProperties.load(JDBCFlowMain.class.getResourceAsStream("db.properties"));
		//  ./db.properties" => 현재 디렉토리
		// ../db.properties" => 상위 디렉토리
		
		String driverClass =dbProperties.getProperty("driverClass");
		String url = dbProperties.getProperty("url");
		String user = dbProperties.getProperty("user");
		String password = dbProperties.getProperty("password");
		*/
		
		String insertSql=
				"insert into address values(address_no_seq.nextval,'guard','김경호','123-4568','경기도 성남시')";
		/*
		 * 1. Driver Class loading
		 */
		Class.forName(driverClass)
;
		/*
		 * 2. Connection 생성
		 */
		
		Connection con =DriverManager.getConnection(url,user,password);
		/*
		 * 3. statement 생성
		 * 
		 */
		Statement stmt = con.createStatement();
		
		/*
		 * 4. statement를 사용해서 SQL전송(DML)
		 */
		/*
		<< java.sql.Satement >>
		public int executeUpdate(String sql) throws SQLException
			Executes the given SQL statement,
			which may be an INSERT, UPDATE, or DELETE statement 
			or an SQL statement that returns nothing, 
			such as an SQL DDL statement.
		 return:
		 	either (1) the row count for SQL Data Manipulation Language (DML) statements 
		 	or (2) 0 for SQL statements that return nothing	
			
		 */
		int rowCount = stmt.executeUpdate(insertSql);
		System.out.println(rowCount+"행 insert");
		
		stmt.close();
		con.close();
		
		
	}

}
