package com.wyu.issue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wyu.issue.pojo.User;

@Mapper
public interface UserMapper {

	@Select("select LOGIN_ID,USER_NAME,USER_EMAIL,IS_CANCEL FROM user WHERE LOGIN_ID=#{loginId} AND USER_PASSWORD=#{userPassword}")
	User getUser(User user);

	@Update("update user SET USER_NAME=#{userName},USER_EMAIL=#{userEmail},USER_PASSWORD=#{userPassword} WHERE LOGIN_ID=#{loginId}")
	void updateUser(User user);

}
