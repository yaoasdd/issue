package com.wyu.issue.service;

import com.wyu.issue.pojo.User;

public interface UserService {

	User userLogin(User user);

	void modifyUser(User user);
}
