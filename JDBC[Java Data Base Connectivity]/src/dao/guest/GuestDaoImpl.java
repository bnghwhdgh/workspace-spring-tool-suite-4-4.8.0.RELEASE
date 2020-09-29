package dao.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.common.ConnectionFactory;



public class GuestDaoImpl implements GuestDao{
	
	public GuestDaoImpl() throws Exception{
		
	}
	@Override
	public int insertGuest(Guest guest) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_INSERT);
		
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setString(2, guest.getGuest_date());
		pstmt.setString(3, guest.getGuest_email());
		pstmt.setString(4, guest.getGuest_homepage());
		pstmt.setString(5, guest.getGuest_title());
		pstmt.setString(6, guest.getGuest_content());
		
		int insertRowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		
		return insertRowCount;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		Guest findGuestByNo = null;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_NO);
		pstmt.setInt(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			findGuestByNo = new Guest(rs.getInt("guest_no"),
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
		return findGuestByNo;
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		
		ArrayList<Guest> findAll = new ArrayList<Guest>();
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			findAll.add(new Guest(rs.getInt("guest_no"),
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
		return findAll;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
