package com.itwill3.dao.user.mapper;

import java.util.ArrayList;


import java.util.List;

import com.itwill3.dao.user.User;



public interface UserMapper {
	/*
	 * <insert id="insertUser" parameterType="User">
			insert into user2 values(#{userId},#{password},#{name},#{email})
	   </insert>
	 */
	public int insertUser(User user);
	
	/*
	 *  <select id="selectById" parameterType="string" resultType="User">
			select userId, password, name, email from user2 where userId=#{userId}
		</select>
	 */
	public User selectById(String userId);
	
	/*
	 *  <select id="selectAll" resultType="com.itwill.user.User">
			select * from user2
		</select>
	 */
	public List<User> selectAll();
	
	/*
	 *  <update id="updateUser" parameterType="User">
			update user2 set password=#{password}, name=#{name}, email=#{email} where userId = #{userId}
		</update>
	 */
	public int updateUser(User user);
	
	/*
	 *  <delete id="deleteUser" parameterType="string">
			delete user2 where userId=#{userId}
		</delete>
	 */
	public int deleteUser(String userId);
}
