package com.itwill.common;
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class BasicDataSourceExample {
	public static void main(String[] args) throws Exception {
		
		//아파치에 의존적인 코드
		//톰캣내에 있는 XML에 나중에 기술될 코드이다.
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:javapython6/javapython6@182.237.126.19:1521:XE");
		
		//이게 쓰이는 코드
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		DataSource dataSource = (DataSource) ds;
		conn = dataSource.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from emp");
		while (rs.next()) {
			System.out.println(rs.getInt("empno") + " " + rs.getString("ename") + " " + rs.getString("job"));
		}
		//DataSource 의 커넥션을 반드시 닫아줘야 한다.
		conn.close();

	}

}
