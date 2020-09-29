package com.itwill.guest;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class GuestDaoImpl implements GuestDao{
	
	public GuestDaoImpl() throws Exception{
		
	}
	@Override
	public int insertGuest(Guest guest) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_INSERT);
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setString(2, guest.getGuest_email());
		pstmt.setString(3, guest.getGuest_homepage());
		pstmt.setString(4, guest.getGuest_title());
		pstmt.setString(5, guest.getGuest_content());
		int insertRow = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return insertRow;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		Guest findG = null;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_NO);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			findG= new Guest(rs.getInt("guest_no"),
			rs.getString("guest_name"),
			rs.getString("guest_date"),
			rs.getString("guest_email"),
			rs.getString("guest_homepage"),
			rs.getString("guest_title"),
			rs.getString("guest_content"));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return findG;
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		ArrayList<Guest> guestList = new ArrayList<Guest>();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			guestList.add(new Guest(
					rs.getInt("guest_no"), 
					rs.getString("guest_name"), 
					rs.getString("guest_date"), 
					rs.getString("guest_email"), 
					rs.getString("guest_homepage"), 
					rs.getString("guest_title"), 
					rs.getString("guest_content")));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return guestList;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_UPDATE);
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setString(2, guest.getGuest_email());
		pstmt.setString(3, guest.getGuest_homepage());
		pstmt.setString(4, guest.getGuest_title());
		pstmt.setString(5, guest.getGuest_content());
		pstmt.setInt(6, guest.getGuest_no());
		int updateRow = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return updateRow;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_DELETE);
		pstmt.setInt(1, no);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}

}
