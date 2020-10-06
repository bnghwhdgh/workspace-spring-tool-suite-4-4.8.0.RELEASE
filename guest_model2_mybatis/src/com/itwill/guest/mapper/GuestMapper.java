package com.itwill.guest.mapper;

import java.util.List;

import com.itwill.guest.Guest;

public interface GuestMapper {
	
	/*
	 <insert id="insertGuest" parameterType="com.itwill.guest.Guest">
		<selectKey order="BEFORE" keyProperty="guest_no" resultType="int">
			select guest_no_seq.nextval from dual
		</selectKey>
	
	insert into guest
	values (#{guest_no},#{guest_name},sysdate,#{guest_email},
	#{guest_homepage},#{guest_title},#{guest_content})
	</insert>
	 */
	public int insertGuest(Guest guest);
	
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
	
	/*
	 <update id="updateGuest" parameterType="com.itwill.guest.Guest">
		update guest set guest_name=#{guest_name},guest_email=#{guest_email},guest_homepage=#{guest_homepage},
		guest_title=#{guest_title},guest_content=#{guest_content} where guest_no=#{guest_no}
	</update>
	 */
	public int updateGuest(Guest guest);
	
	/*
	 <delete id="deleteGuest" parameterType="_int">
		delete guest where guest_no = #{guest_no}
	</delete>
	 */
	public int deleteGuest(int guest_no);
}
