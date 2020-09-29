package com.itwill.guest.mapper;

import java.util.List;

import com.itwill.guest.Guest;

public interface GuestMapper {
	/*
	<select id="selectByNo" parameterType= "_int" resultType="com.itwill.guest.Guest">
		select guest_no, guest_name, guest_date, guest_email, 
		guest_homepage, guest_title, guest_content
		from guest
		where guest_no=#{guest_no}
	</select>
	 */
	public Guest selectByNo(int guest_no);
	
	
	/*
	 <select id="selectAll" resultType="com.itwill.guest.Guest">
		select guest_no, guest_name, guest_date, guest_email, 
		guest_homepage, guest_title, guest_content
		from guest
	 </select>
	 */
	public List<Guest> selectAll();
}
