package com.wyu.issue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyu.issue.mapper.UserMapper;
import com.wyu.issue.pojo.User;
import com.wyu.issue.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userDao;

	@Override
	public User userLogin(User user) {
		// TODO Auto-generated method stub

		return userDao.getUser(user);
	}

	@Override
	public void modifyUser(User user) {
		// TODO Auto-generated method stub

		userDao.updateUser(user);
	}

}
