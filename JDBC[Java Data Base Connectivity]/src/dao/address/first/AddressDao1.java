package dao.address.first;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
Dao(Data Access Object)
 - Address들의 데이터를 저장하고있는 Address 테이블에
   CRUD(Create, Read, Update, Delete) 작업을 할수있는
   단위메쏘드를 가지고있는 클래스
 - AddressService객체의 요청(메쏘드호출)을 받아서 
   Data Access(DB)에 관련된 단위기능(CRUD)을
   수행하는 객체
 */


/*
 * executeQuery  => select 할 때 사용
 * executeUpdate => insert,update,delete 할 때 사용
 */


public class AddressDao1 {

	
//	public AddressDao1() throws Exception {
//		String driverClass="oracle.jdbc.OracleDriver";
//		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
//		String user="javapython6";
//		String password="javapython6";
//		
//		Class.forName(driverClass);
//		Connection con = DriverManager.getConnection(url,user,password);
//		Statement stmt =con.createStatement();
//	}
	
	
	public void create() throws Exception{
		
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javapython6";
		String password="javapython6";
		
		//1.JDBC드라이버에 구현 되어있는 처리기능 사용준비를 위한 메모리 준비작업
		Class.forName(driverClass);
		//2.데이터베이스 서버에 접속하여 연결하는 작업 =>DriverManager 클래스의 getConnection()메소드
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt =con.createStatement();
		String insertSql = 
				"insert into address values(address_no_seq.nextval,'gunman','레이너','999-5656','히페리온')";
		stmt.executeUpdate(insertSql);
		stmt.close();
		con.close();
		System.out.println("db1행 insert");
		
	}
	
	public void update() throws Exception{
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javapython6";
		String password="javapython6";
		
		//1.JDBC드라이버에 구현 되어있는 처리기능 사용준비를 위한 메모리 준비작업
		Class.forName(driverClass);
		//2.데이터베이스 서버에 접속하여 연결하는 작업 =>DriverManager 클래스의 getConnection()메소드
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt =con.createStatement();
		String updateSql=
				"update address set id='shotgun',name='레이너',phone='888-8888',address='히페리온' where no=11";
		stmt.executeUpdate(updateSql);
		stmt.close();
		con.close();
		System.out.println("db1행 update");
	}
	
	public void delete() throws Exception{
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javapython6";
		String password="javapython6";
		
		//1.JDBC드라이버에 구현 되어있는 처리기능 사용준비를 위한 메모리 준비작업
		Class.forName(driverClass);
		//2.데이터베이스 서버에 접속하여 연결하는 작업 =>DriverManager 클래스의 getConnection()메소드
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt =con.createStatement();
		
		String deleteSql = "delete address where no >= 11";
		stmt.executeUpdate(deleteSql);
		
		stmt.close();
		con.close();
		System.out.println("db1행 delete");
	}
	
	public void selectByNo() throws Exception{
		/**************DB접속정보**************/
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javapython6";
		String password="javapython6";
		
		String selectSql="select no,id,name,phone,address from address where no=3";
		
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stmt=con.createStatement();
		/*
		 << Statement >>
		 public ResultSet executeQuery(String sql) throws SQLException;
			Executes the given SQL statement, 
			which returns a single ResultSet object.

		Parameters:
			sql - an SQL statement to be sent to the database, 
			typically a static SQL SELECT statement
		Returns:
			a ResultSet object that contains the data produced by the given query;
			never null
		 */
		
		
		ResultSet rs=stmt.executeQuery(selectSql);
		
		/*
		<< ResultSet >>
		boolean next() throws SQLException
		 - Moves the cursor forward one row from its current position.
		 - A ResultSet cursor is initially positioned before the first row; 
		 	 the first call to the method next makes the first row the current row;
		 	 the second call makes the second row the current row, and so on.
		 - When a call to the next method returns false, 
		     the cursor is positioned after the last row.
		 */
		
		//rs.getInt("no");
		if(rs.next()) {
			/*
			  DB NUMBER			--> java int,double
			  DB VARCHAR2,CHAR	--> String
			  DB DATE           --> Date  
			 XXX var = rs.getXXX(컬럼이름);
			 */
			int no = rs.getInt("no");
			String id=rs.getString("id");
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String address=rs.getString("address");
			System.out.println(no+"\t"+id+"\t"+name+"\t"+phone+"\t"+address);
		}
		//rs.getInt("no");
		rs.close();
		stmt.close();
		con.close();
	}
	
	public void selectAll() throws Exception{
		/**************DB접속정보**************/
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javapython6";
		String password="javapython6";
		
		String selectSql = "select no,id,name,phone,address from address";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		
		/*
		 << Statement >>
		 public ResultSet executeQuery(String sql) throws SQLException;
			Executes the given SQL statement, 
			which returns a single ResultSet object.

		Parameters:
			sql - an SQL statement to be sent to the database, 
			typically a static SQL SELECT statement
		Returns:
			a ResultSet object that contains the data produced by the given query;
			never null
		 */
		
		
		ResultSet rs= stmt.executeQuery(selectSql);

		/*
		 * <<ResultSet>>
		 * boolean next() throws SQLExeption
		 */
		//rs.getInt("no");
		boolean isExist = rs.next();
		while(rs.next()) {
			//rs.getString("no");
			/*
			 * DB NUMBER        => java int, double
			 * DB VARCHAR2,CHAR => String
			 * DB Date          => Date
			 * XXX var(변수명) = rs.getXXX(컬럼이름);
			 */
			int no =rs.getInt("no");
			String id = rs.getString("id");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no+"\t"+id+"\t"+name+"\t"+phone+"\t"+address);
		}
		//rs.getInt("no");
		//실행 역순으로 종료
		rs.close();
		stmt.close();
		con.close();
	}
}
